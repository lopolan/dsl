package com.lopolan.dsl;

import com.lopolan.dsl.bridge.G4ToDomain;
import com.lopolan.dsl.domain.Project;
import com.lopolan.dsl.g4.DSLLexer;
import com.lopolan.dsl.g4.DSLParser;
import java.io.IOException;
import java.io.StringReader;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

/**
 * <h1> Main</h1>
 *
 * <pre>
 *
 * </pre>
 *
 * @author lopo
 * @date 2021/12/8 5:04 下午
 **/
public class Main {

  public static void main(String[] args) {
    String sql = "//DDDD\n"
        + "@NotEmpty\n"
        + "project User{\n"
        + "  //dsf\n"
        + "  entity BaseUser{\n"
        + "    Integer:lsam\n"
        + "    Integer:lsamss\n"
        + "    Integer:lsamssdd\n"
        + "  }\n"
        + "}";
    ANTLRInputStream input = null;  //将输入转成antlr的input流
    try {
      input = new ANTLRInputStream(new StringReader(sql));
      DSLLexer lexer = new DSLLexer(input);  //词法分析
      CommonTokenStream tokens = new CommonTokenStream(lexer);  //转成token流
      DSLParser parser = new DSLParser(tokens); // 语法分析
      DSLParser.RootContext tree = parser.root();  //获取某一个规则树，这里获取的是最外层的规则，也可以通过sql()获取sql规则树......
      System.out.println(tree.toStringTree(parser)); //打印规则数
      Project project = G4ToDomain.toProject(tree);
      System.out.println(project);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
