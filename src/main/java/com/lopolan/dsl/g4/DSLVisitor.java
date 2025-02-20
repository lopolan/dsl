package com.lopolan.dsl.g4;// Generated from /Users/lopo/bigger/workspace/dsl/src/main/resources/DSL.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link DSLParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface DSLVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link DSLParser#root}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRoot(DSLParser.RootContext ctx);
	/**
	 * Visit a parse tree produced by {@link DSLParser#project}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProject(DSLParser.ProjectContext ctx);
	/**
	 * Visit a parse tree produced by {@link DSLParser#entity}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEntity(DSLParser.EntityContext ctx);
	/**
	 * Visit a parse tree produced by {@link DSLParser#dto}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDto(DSLParser.DtoContext ctx);
	/**
	 * Visit a parse tree produced by {@link DSLParser#enums}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnums(DSLParser.EnumsContext ctx);
	/**
	 * Visit a parse tree produced by {@link DSLParser#config}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConfig(DSLParser.ConfigContext ctx);
	/**
	 * Visit a parse tree produced by {@link DSLParser#configItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConfigItem(DSLParser.ConfigItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link DSLParser#field}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitField(DSLParser.FieldContext ctx);
	/**
	 * Visit a parse tree produced by {@link DSLParser#projectName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProjectName(DSLParser.ProjectNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link DSLParser#entityName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEntityName(DSLParser.EntityNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link DSLParser#fieldName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldName(DSLParser.FieldNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link DSLParser#configKey}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConfigKey(DSLParser.ConfigKeyContext ctx);
	/**
	 * Visit a parse tree produced by {@link DSLParser#configValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConfigValue(DSLParser.ConfigValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link DSLParser#fieldType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldType(DSLParser.FieldTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link DSLParser#collectionType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCollectionType(DSLParser.CollectionTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link DSLParser#simpleType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleType(DSLParser.SimpleTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link DSLParser#annotation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnotation(DSLParser.AnnotationContext ctx);
	/**
	 * Visit a parse tree produced by {@link DSLParser#annotationName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnotationName(DSLParser.AnnotationNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link DSLParser#annotationField}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnotationField(DSLParser.AnnotationFieldContext ctx);
	/**
	 * Visit a parse tree produced by {@link DSLParser#annotationValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnotationValue(DSLParser.AnnotationValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link DSLParser#remark}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRemark(DSLParser.RemarkContext ctx);
	/**
	 * Visit a parse tree produced by {@link DSLParser#remarkContent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRemarkContent(DSLParser.RemarkContentContext ctx);
}
