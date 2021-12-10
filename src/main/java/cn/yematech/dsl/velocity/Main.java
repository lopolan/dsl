package cn.yematech.dsl.velocity;

import cn.yematech.dsl.bridge.G4ToDomain;
import cn.yematech.dsl.domain.Project;
import cn.yematech.dsl.g4.DSLLexer;
import cn.yematech.dsl.g4.DSLParser;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.time.LocalDate;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

/**
 * <h1> Main</h1>
 *
 * <pre>
 *
 * </pre>
 *
 * @author lopo
 * @date 2021/12/9 2:13 下午
 **/
public class Main {

  public static void main(String[] args) throws IOException {
    VelocityEngine velocityEngine = new VelocityEngine();
    velocityEngine.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
    velocityEngine
        .setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
    velocityEngine.init();
    Template template = velocityEngine.getTemplate(
        "velocity/{application-name}/{application-name}-api/src/main/java/{basePackage}/api/dto/{entity}DTO.java.vm");
    VelocityContext ctx = new VelocityContext();
    String sql = "//用户项目\n"
        + "@NotOnly\n"
        + "project base-user{\n"
        + "\tabstract AbstractEntity{\n"
        + "\t\tid String\n"
        + "\t\tdate LocalDate\n"
        + "\t}\n"
        + "\tenum Gender{\n"
        + "\t\tMan\n"
        + "\t\tMale\n"
        + "\t}\n"
        + "\tentity User extends AbstractEntity{\n"
        + "\t\tgender String\n"
        + "\t\tgender1 List<String>\n"
        + "\t}\n"
        + "}";
    ANTLRInputStream input = null;  //将输入转成antlr的input流
    input = new ANTLRInputStream(new StringReader(sql));
    DSLLexer lexer = new DSLLexer(input);  //词法分析
    CommonTokenStream tokens = new CommonTokenStream(lexer);  //转成token流
    DSLParser parser = new DSLParser(tokens); // 语法分析
    DSLParser.RootContext tree = parser.root();  //获取某一个规则树，这里获取的是最外层的规则，也可以通过sql()获取sql规则树......
    System.out.println(tree.toStringTree(parser)); //打印规则数
    Project project = G4ToDomain.toProject(tree);
    System.out.println(project);
    project.init();
    ctx.put("basePackage", project.getEnvironment().getBasePackage());
    ctx.put("date", LocalDate.now().toString());
    ctx.put("abstract",project.getAbstracts().get(0));
    ctx.put("entity",project.getEntities().get(0));
    ctx.put("environment", project.getEnvironment());
    StringWriter sw = new StringWriter();

    template.merge(ctx, sw);

    System.out.println(sw.toString());

  }

}
