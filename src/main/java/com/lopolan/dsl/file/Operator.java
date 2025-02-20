package com.lopolan.dsl.file;

import com.lopolan.dsl.bridge.G4ToDomain;
import com.lopolan.dsl.domain.Environment;
import com.lopolan.dsl.domain.Project;
import com.lopolan.dsl.g4.DSLLexer;
import com.lopolan.dsl.g4.DSLParser;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.net.URL;
import java.time.LocalDate;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

/**
 * <h1> Operator</h1>
 *
 * <pre>
 *
 * </pre>
 *
 * @author lopo
 * @date 2021/12/10 1:49 下午
 **/
public class Operator {

  public static void main(String[] args) throws IOException {
    String sql = "//水利水电造价-杠杆\n"
        + "project heaver{\n"
        + "  config{\n"
        + "    basePackage:cn.yematech.heaver\n"
        + "   projectName: heaver\n"
        + "  }\n"
        + "  //定额\n"
        + "  entity Quota{\n"
        + "    name String\n"
        + "    code String \n"
        + "    unit String\n"
        + "  }\n"
        + "  //词\n"
        + "  entity Word{\n"
        + "    text String \n"
        + "  }\n"
        + "  entity QuotaWord{\n"
        + "    refId String \n"
        + "    wordId String\n"
        + "    degree BigDecimal\n"
        + "  }  \n"
        + "}";
    ANTLRInputStream input = null;  //将输入转成antlr的input流
    input = new ANTLRInputStream(new StringReader(sql));
    DSLLexer lexer = new DSLLexer(input);  //词法分析
    CommonTokenStream     tokens = new CommonTokenStream(lexer);  //转成token流
    DSLParser             parser = new DSLParser(tokens); // 语法分析
    DSLParser.RootContext tree   = parser.root();  //获取某一个规则树，这里获取的是最外层的规则，也可以通过sql()获取sql规则树......
    System.out.println(tree.toStringTree(parser)); //打印规则数
    Project project = G4ToDomain.toProject(tree);
    System.out.println(project);
    project.init();
    URL velocity = Operator.class.getResource("/");
    doOperator(
        velocity.getPath() + File.separator + "neo" + File.separator + "{application-name}",
//        File.separator + "tmp" + File.separator + project.getProjectName()
        "gen"
        , project);
  }

  public static void doOperator(String baseFilePath, String tagetFilePath, Project project)
      throws IOException {
    VelocityEngine velocityEngine = new VelocityEngine();
    velocityEngine.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
    velocityEngine.setProperty(RuntimeConstants.RESOURCE_LOADER, "file");
    velocityEngine.setProperty("file.resource.loader.path", "/");
    velocityEngine
        .setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
    velocityEngine.init();
    VelocityContext ctx = new VelocityContext();
    Environment environment = project.getEnvironment();
    ctx.put("project", project);
    ctx.put("environment", environment);
    ctx.put("date", LocalDate.now().toString());
    ctx.put("basePackage", environment.getBasePackage());
    ctx.put("application-name", project.getProjectName());

    File workSpace = new File(baseFilePath);
    File target = new File(tagetFilePath);
    if (target.exists()) {
      deletefile(target);
    }
    doInternal(workSpace, target, project, velocityEngine, ctx);
  }

  public static void doInternal(File workSpace, File target, Project project,
      VelocityEngine velocityEngine, VelocityContext ctx) throws IOException {

    if (workSpace.isDirectory()) {
      onDir(workSpace, target, project, velocityEngine, ctx);
    } else {
//      target = new File(target.getAbsolutePath() + File.separator + workSpace.getName().replaceAll("\\.vm",""));
      onFile(workSpace, target, project, velocityEngine, ctx);
    }
  }

  private static void onFile(File workSpace, File target, Project project,
      VelocityEngine velocityEngine, VelocityContext ctx) throws IOException {
    String fileName = workSpace.getName().replaceAll("\\.vm","");
    String key = "";
    if (fileName.contains("{") && fileName.contains("{")) {
      key = fileName.substring(fileName.indexOf("{") + 1, fileName.indexOf("}"));
    }
    switch (key) {
      case "enum":
        project.getEnums().forEach(anEnum -> {
          try {
            ctx.put("enum", anEnum.getClassName());
            Object value = getContent(ctx, fileName);
            String fullName = fileName.substring(0, fileName.indexOf("{")) + value + fileName
                .substring(fileName.indexOf("}") + 1);
            File act = new File(target.getAbsolutePath() + File.separator + fullName);
            ctx.put("enum", anEnum);
            write(workSpace, act, velocityEngine, ctx);
          } catch (IOException e) {
            throw new RuntimeException("", e);
          }
        });
        break;
      case "entity":
        project.getEntities().forEach(anEnum -> {
          try {
            ctx.put("entity", anEnum.getClassName());
            Object value = getContent(ctx, fileName);
            String fullName = fileName.substring(0, fileName.indexOf("{")) + value + fileName
                .substring(fileName.indexOf("}") + 1);
            File act = new File(target.getAbsolutePath() + File.separator + fullName);
            ctx.put("entity", anEnum);
            write(workSpace, act, velocityEngine, ctx);
          } catch (IOException e) {
            throw new RuntimeException("", e);
          }
        });
        break;
      case "abstract":
        project.getAbstracts().forEach(anEnum -> {
          try {
            ctx.put("abstract", anEnum.getClassName());
            Object value = getContent(ctx, fileName);
            String fullName = fileName.substring(0, fileName.indexOf("{")) + value + fileName
                .substring(fileName.indexOf("}") + 1);
            File act = new File(target.getAbsolutePath() + File.separator + fullName);
            ctx.put("abstract", anEnum);
            write(workSpace, act, velocityEngine, ctx);
          } catch (IOException e) {
            throw new RuntimeException("", e);
          }
        });
        break;
      default:
        File act = new File(target.getAbsolutePath() + File.separator + fileName);
        write(workSpace, act, velocityEngine, ctx);
    }

  }

  private static void write(File workSpace, File target, VelocityEngine velocityEngine,
      VelocityContext ctx) throws IOException {
    if(!target.exists()){
      target.createNewFile();
    }
    FileWriter fileWriter = new FileWriter(target);
    Template template = velocityEngine.getTemplate(workSpace.getCanonicalPath(), "UTF-8");
    template.merge(ctx, fileWriter);
    fileWriter.flush();
    fileWriter.close();
  }

  private static void onDir(File workSpace, File target, Project project,
      VelocityEngine velocityEngine, VelocityContext ctx) throws IOException {
    String fileName = workSpace.getName();
    if (fileName.contains("{") && fileName.contains("{")) {
      Object value = getContent(ctx, fileName);
      String fullName = fileName.substring(0, fileName.indexOf("{")) + value + fileName
          .substring(fileName.indexOf("}") + 1);
      String path = fullName.replaceAll("\\.", File.separator);
      target = new File(target.getAbsolutePath() + File.separator + path);
      target.mkdirs();
    }else {
      target = new File(target.getAbsolutePath() + File.separator + fileName);
      target.mkdirs();
    }
    for (File u : workSpace.listFiles()) {
//      target = new File(target.getAbsolutePath() + File.separator + u.getName());
      doInternal(u, target, project, velocityEngine, ctx);
    }
  }

  private static Object getContent(VelocityContext ctx, String fileName) {
    String key = fileName.substring(fileName.indexOf("{") + 1, fileName.indexOf("}"));
    Object value = ctx.get(key);
    if (!(value instanceof String)) {
      throw new IllegalArgumentException("名称错误");
    }
    return value;
  }

  private static void deletefile(File file) {
    try {
      // 当且仅当此抽象路径名表示的文件存在且 是一个目录时，返回 true
      if (!file.isDirectory()) {
        file.delete();
      } else if (file.isDirectory()) {
        String[] filelist = file.list();
        for (int i = 0; i < filelist.length; i++) {
          File delfile = new File(file.getAbsoluteFile() + File.separator + filelist[i]);
          if (!delfile.isDirectory()) {
            delfile.delete();
            System.out
                .println(delfile.getAbsolutePath() + "删除文件成功");
          } else if (delfile.isDirectory()) {
            deletefile(new File(file.getAbsolutePath() + File.separator + filelist[i]));
          }
        }
        System.out.println(file.getAbsolutePath() + "删除成功");
        file.delete();
      }
    } catch (Exception e) {
      throw new RuntimeException("`", e);
    }
  }
}
