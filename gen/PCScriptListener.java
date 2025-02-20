// Generated from /Users/lopo/work/bigger/workspace/dsl/src/main/resources/PCScript.g4 by ANTLR 4.12.0
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PCScriptParser}.
 */
public interface PCScriptListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PCScriptParser#root}.
	 * @param ctx the parse tree
	 */
	void enterRoot(PCScriptParser.RootContext ctx);
	/**
	 * Exit a parse tree produced by {@link PCScriptParser#root}.
	 * @param ctx the parse tree
	 */
	void exitRoot(PCScriptParser.RootContext ctx);
	/**
	 * Enter a parse tree produced by {@link PCScriptParser#operator_token}.
	 * @param ctx the parse tree
	 */
	void enterOperator_token(PCScriptParser.Operator_tokenContext ctx);
	/**
	 * Exit a parse tree produced by {@link PCScriptParser#operator_token}.
	 * @param ctx the parse tree
	 */
	void exitOperator_token(PCScriptParser.Operator_tokenContext ctx);
	/**
	 * Enter a parse tree produced by {@link PCScriptParser#nested_express}.
	 * @param ctx the parse tree
	 */
	void enterNested_express(PCScriptParser.Nested_expressContext ctx);
	/**
	 * Exit a parse tree produced by {@link PCScriptParser#nested_express}.
	 * @param ctx the parse tree
	 */
	void exitNested_express(PCScriptParser.Nested_expressContext ctx);
	/**
	 * Enter a parse tree produced by {@link PCScriptParser#simple_express}.
	 * @param ctx the parse tree
	 */
	void enterSimple_express(PCScriptParser.Simple_expressContext ctx);
	/**
	 * Exit a parse tree produced by {@link PCScriptParser#simple_express}.
	 * @param ctx the parse tree
	 */
	void exitSimple_express(PCScriptParser.Simple_expressContext ctx);
	/**
	 * Enter a parse tree produced by {@link PCScriptParser#param_name}.
	 * @param ctx the parse tree
	 */
	void enterParam_name(PCScriptParser.Param_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link PCScriptParser#param_name}.
	 * @param ctx the parse tree
	 */
	void exitParam_name(PCScriptParser.Param_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link PCScriptParser#method}.
	 * @param ctx the parse tree
	 */
	void enterMethod(PCScriptParser.MethodContext ctx);
	/**
	 * Exit a parse tree produced by {@link PCScriptParser#method}.
	 * @param ctx the parse tree
	 */
	void exitMethod(PCScriptParser.MethodContext ctx);
	/**
	 * Enter a parse tree produced by {@link PCScriptParser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumber(PCScriptParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link PCScriptParser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumber(PCScriptParser.NumberContext ctx);
}