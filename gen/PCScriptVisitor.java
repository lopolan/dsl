// Generated from /Users/lopo/work/bigger/workspace/dsl/src/main/resources/PCScript.g4 by ANTLR 4.12.0
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link PCScriptParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface PCScriptVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link PCScriptParser#root}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRoot(PCScriptParser.RootContext ctx);
	/**
	 * Visit a parse tree produced by {@link PCScriptParser#operator_token}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperator_token(PCScriptParser.Operator_tokenContext ctx);
	/**
	 * Visit a parse tree produced by {@link PCScriptParser#nested_express}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNested_express(PCScriptParser.Nested_expressContext ctx);
	/**
	 * Visit a parse tree produced by {@link PCScriptParser#simple_express}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimple_express(PCScriptParser.Simple_expressContext ctx);
	/**
	 * Visit a parse tree produced by {@link PCScriptParser#param_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam_name(PCScriptParser.Param_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link PCScriptParser#method}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethod(PCScriptParser.MethodContext ctx);
	/**
	 * Visit a parse tree produced by {@link PCScriptParser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(PCScriptParser.NumberContext ctx);
}