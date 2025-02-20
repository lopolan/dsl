package com.lopolan.dsl.g4;// Generated from /Users/lopo/bigger/workspace/dsl/src/main/resources/DSL.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link DSLParser}.
 */
public interface DSLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link DSLParser#root}.
	 * @param ctx the parse tree
	 */
	void enterRoot(DSLParser.RootContext ctx);
	/**
	 * Exit a parse tree produced by {@link DSLParser#root}.
	 * @param ctx the parse tree
	 */
	void exitRoot(DSLParser.RootContext ctx);
	/**
	 * Enter a parse tree produced by {@link DSLParser#project}.
	 * @param ctx the parse tree
	 */
	void enterProject(DSLParser.ProjectContext ctx);
	/**
	 * Exit a parse tree produced by {@link DSLParser#project}.
	 * @param ctx the parse tree
	 */
	void exitProject(DSLParser.ProjectContext ctx);
	/**
	 * Enter a parse tree produced by {@link DSLParser#entity}.
	 * @param ctx the parse tree
	 */
	void enterEntity(DSLParser.EntityContext ctx);
	/**
	 * Exit a parse tree produced by {@link DSLParser#entity}.
	 * @param ctx the parse tree
	 */
	void exitEntity(DSLParser.EntityContext ctx);
	/**
	 * Enter a parse tree produced by {@link DSLParser#dto}.
	 * @param ctx the parse tree
	 */
	void enterDto(DSLParser.DtoContext ctx);
	/**
	 * Exit a parse tree produced by {@link DSLParser#dto}.
	 * @param ctx the parse tree
	 */
	void exitDto(DSLParser.DtoContext ctx);
	/**
	 * Enter a parse tree produced by {@link DSLParser#enums}.
	 * @param ctx the parse tree
	 */
	void enterEnums(DSLParser.EnumsContext ctx);
	/**
	 * Exit a parse tree produced by {@link DSLParser#enums}.
	 * @param ctx the parse tree
	 */
	void exitEnums(DSLParser.EnumsContext ctx);
	/**
	 * Enter a parse tree produced by {@link DSLParser#config}.
	 * @param ctx the parse tree
	 */
	void enterConfig(DSLParser.ConfigContext ctx);
	/**
	 * Exit a parse tree produced by {@link DSLParser#config}.
	 * @param ctx the parse tree
	 */
	void exitConfig(DSLParser.ConfigContext ctx);
	/**
	 * Enter a parse tree produced by {@link DSLParser#configItem}.
	 * @param ctx the parse tree
	 */
	void enterConfigItem(DSLParser.ConfigItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link DSLParser#configItem}.
	 * @param ctx the parse tree
	 */
	void exitConfigItem(DSLParser.ConfigItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link DSLParser#field}.
	 * @param ctx the parse tree
	 */
	void enterField(DSLParser.FieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link DSLParser#field}.
	 * @param ctx the parse tree
	 */
	void exitField(DSLParser.FieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link DSLParser#projectName}.
	 * @param ctx the parse tree
	 */
	void enterProjectName(DSLParser.ProjectNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link DSLParser#projectName}.
	 * @param ctx the parse tree
	 */
	void exitProjectName(DSLParser.ProjectNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link DSLParser#entityName}.
	 * @param ctx the parse tree
	 */
	void enterEntityName(DSLParser.EntityNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link DSLParser#entityName}.
	 * @param ctx the parse tree
	 */
	void exitEntityName(DSLParser.EntityNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link DSLParser#fieldName}.
	 * @param ctx the parse tree
	 */
	void enterFieldName(DSLParser.FieldNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link DSLParser#fieldName}.
	 * @param ctx the parse tree
	 */
	void exitFieldName(DSLParser.FieldNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link DSLParser#configKey}.
	 * @param ctx the parse tree
	 */
	void enterConfigKey(DSLParser.ConfigKeyContext ctx);
	/**
	 * Exit a parse tree produced by {@link DSLParser#configKey}.
	 * @param ctx the parse tree
	 */
	void exitConfigKey(DSLParser.ConfigKeyContext ctx);
	/**
	 * Enter a parse tree produced by {@link DSLParser#configValue}.
	 * @param ctx the parse tree
	 */
	void enterConfigValue(DSLParser.ConfigValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link DSLParser#configValue}.
	 * @param ctx the parse tree
	 */
	void exitConfigValue(DSLParser.ConfigValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link DSLParser#fieldType}.
	 * @param ctx the parse tree
	 */
	void enterFieldType(DSLParser.FieldTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link DSLParser#fieldType}.
	 * @param ctx the parse tree
	 */
	void exitFieldType(DSLParser.FieldTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link DSLParser#collectionType}.
	 * @param ctx the parse tree
	 */
	void enterCollectionType(DSLParser.CollectionTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link DSLParser#collectionType}.
	 * @param ctx the parse tree
	 */
	void exitCollectionType(DSLParser.CollectionTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link DSLParser#simpleType}.
	 * @param ctx the parse tree
	 */
	void enterSimpleType(DSLParser.SimpleTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link DSLParser#simpleType}.
	 * @param ctx the parse tree
	 */
	void exitSimpleType(DSLParser.SimpleTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link DSLParser#annotation}.
	 * @param ctx the parse tree
	 */
	void enterAnnotation(DSLParser.AnnotationContext ctx);
	/**
	 * Exit a parse tree produced by {@link DSLParser#annotation}.
	 * @param ctx the parse tree
	 */
	void exitAnnotation(DSLParser.AnnotationContext ctx);
	/**
	 * Enter a parse tree produced by {@link DSLParser#annotationName}.
	 * @param ctx the parse tree
	 */
	void enterAnnotationName(DSLParser.AnnotationNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link DSLParser#annotationName}.
	 * @param ctx the parse tree
	 */
	void exitAnnotationName(DSLParser.AnnotationNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link DSLParser#annotationField}.
	 * @param ctx the parse tree
	 */
	void enterAnnotationField(DSLParser.AnnotationFieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link DSLParser#annotationField}.
	 * @param ctx the parse tree
	 */
	void exitAnnotationField(DSLParser.AnnotationFieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link DSLParser#annotationValue}.
	 * @param ctx the parse tree
	 */
	void enterAnnotationValue(DSLParser.AnnotationValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link DSLParser#annotationValue}.
	 * @param ctx the parse tree
	 */
	void exitAnnotationValue(DSLParser.AnnotationValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link DSLParser#remark}.
	 * @param ctx the parse tree
	 */
	void enterRemark(DSLParser.RemarkContext ctx);
	/**
	 * Exit a parse tree produced by {@link DSLParser#remark}.
	 * @param ctx the parse tree
	 */
	void exitRemark(DSLParser.RemarkContext ctx);
	/**
	 * Enter a parse tree produced by {@link DSLParser#remarkContent}.
	 * @param ctx the parse tree
	 */
	void enterRemarkContent(DSLParser.RemarkContentContext ctx);
	/**
	 * Exit a parse tree produced by {@link DSLParser#remarkContent}.
	 * @param ctx the parse tree
	 */
	void exitRemarkContent(DSLParser.RemarkContentContext ctx);
}
