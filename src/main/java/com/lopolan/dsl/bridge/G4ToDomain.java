package com.lopolan.dsl.bridge;

import com.lopolan.dsl.domain.Abstract;
import com.lopolan.dsl.domain.Annotation;
import com.lopolan.dsl.domain.AnnotationField;
import com.lopolan.dsl.domain.Config;
import com.lopolan.dsl.domain.Entity;
import com.lopolan.dsl.domain.EntityField;
import com.lopolan.dsl.domain.Enum;
import com.lopolan.dsl.domain.Field;
import com.lopolan.dsl.domain.Project;
import com.lopolan.dsl.g4.DSLParser;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

/**
 * <h1> G4ToDomain</h1>
 *
 * <pre>
 *
 * </pre>
 *
 * @author lopo
 * @date 2021/12/9 11:41 上午
 **/
public class G4ToDomain {

  protected static List<Bridge> bridges = new ArrayList<>();

  public static Project toProject(DSLParser.RootContext rootContext) {
    return G4ToDomain.<Project>fetchBridge(rootContext).parse(rootContext);
  }

  public static <T> Bridge<T> fetchBridge(ParseTree context) {
    if (context == null) {
      return new Bridge<T>() {
        @Override
        public Boolean support(ParseTree context) {
          return true;
        }

        @Override
        public T parse(ParseTree context) {
          return null;
        }
      };
    }
    return bridges.stream().filter(bridge -> bridge.support(context)).findAny().orElseThrow(() ->
        new IllegalArgumentException("没有匹配的解释器")
    );
  }

  interface Bridge<T> {

    Boolean support(ParseTree context);

    T parse(ParseTree context);
  }

  static class RootBridge implements Bridge<Project> {

    public Boolean support(ParseTree context) {
      return context instanceof DSLParser.RootContext;
    }

    @Override
    public Project parse(ParseTree context) {
      DSLParser.RootContext rootContext = (DSLParser.RootContext) context;
      if (rootContext.getChildCount() != 1) {
        throw new IllegalArgumentException("解析失败");
      }
      ParseTree project = rootContext.getChild(0);
      if (!(project instanceof DSLParser.ProjectContext)) {
        throw new IllegalArgumentException("无法找到项目节点");
      }
      return G4ToDomain.<Project>fetchBridge(context.getChild(0)).parse(context.getChild(0));
    }
  }

  static class ProjectBridge implements Bridge<Project> {

    public Boolean support(ParseTree context) {
      return context instanceof DSLParser.ProjectContext;
    }

    @Override
    public Project parse(ParseTree context) {
      DSLParser.ProjectContext projectContext = (DSLParser.ProjectContext) context;
      Project                  project        = new Project();
      project.setText(projectContext.getText());
      project.setProjectName(
          G4ToDomain.<String>fetchBridge(projectContext.projectName())
              .parse(projectContext.projectName())
      );
      project.setComment(
          G4ToDomain.<String>fetchBridge(projectContext.remark()).parse(projectContext.remark())
      );
      project.setAnnotations(
          projectContext.annotation().stream()
              .map(annotation -> G4ToDomain.<Annotation>fetchBridge(annotation).parse(annotation))
              .collect(Collectors.toList())
      );
      project.setEnums(
          projectContext.enums().stream()
              .map(annotation -> G4ToDomain.<Enum>fetchBridge(annotation).parse(annotation))
              .collect(Collectors.toList())
      );
      project.setEntities(
          projectContext.entity().stream()
              .map(entity -> G4ToDomain.<Entity>fetchBridge(entity).parse(entity))
              .collect(Collectors.toList())
      );
      project.setAbstracts(
          projectContext.dto().stream()
              .map(entity -> G4ToDomain.<Abstract>fetchBridge(entity).parse(entity))
              .collect(Collectors.toList())
      );
      if(projectContext.config() != null && !projectContext.config().isEmpty()){
        project.setConfig(
            G4ToDomain.<Config>fetchBridge(projectContext.config().get(0)).parse(projectContext.config().get(0))
        );
      }

      return project;
    }
  }

  static class EntityBridge implements Bridge<Entity> {

    public Boolean support(ParseTree context) {
      return context instanceof DSLParser.EntityContext;
    }

    @Override
    public Entity parse(ParseTree context) {
      DSLParser.EntityContext entityContext = (DSLParser.EntityContext) context;
      Entity                  entity        = new Entity();
      entity.setText(entityContext.getText());
      entity.setName(
          G4ToDomain.<String>fetchBridge(entityContext.entityName()).parse(entityContext.entityName())
      );
      entity.setComment(
          G4ToDomain.<String>fetchBridge(entityContext.remark()).parse(entityContext.remark())
      );
      entity.setParent(
          G4ToDomain.<String>fetchBridge(entityContext.fieldName()).parse(entityContext.fieldName())
      );
      entity.setAnnotations(
          entityContext.annotation().stream()
              .map(annotation -> G4ToDomain.<Annotation>fetchBridge(annotation).parse(annotation))
              .collect(Collectors.toList())
      );
      entity.setFields(
          entityContext.field().stream()
              .map(annotation -> G4ToDomain.<EntityField>fetchBridge(annotation).parse(annotation))
              .collect(Collectors.toList())
      );
      return entity;
    }
  }
  static class EnumBridge implements Bridge<Enum> {

    public Boolean support(ParseTree context) {
      return context instanceof DSLParser.EnumsContext;
    }

    @Override
    public Enum parse(ParseTree context) {
      DSLParser.EnumsContext entityContext = (DSLParser.EnumsContext) context;
      Enum                   entity        = new Enum();
      entity.setText(entityContext.getText());
      entity.setName(
          G4ToDomain.<String>fetchBridge(entityContext.entityName()).parse(entityContext.entityName())
      );
      entity.setComment(
          G4ToDomain.<String>fetchBridge(entityContext.remark()).parse(entityContext.remark())
      );
      entity.setAnnotations(
          entityContext.annotation().stream()
              .map(annotation -> G4ToDomain.<Annotation>fetchBridge(annotation).parse(annotation))
              .collect(Collectors.toList())
      );
      entity.setFields(
          entityContext.fieldName().stream()
              .map(annotation -> G4ToDomain.<String>fetchBridge(annotation).parse(annotation))
              .collect(Collectors.toList())
      );
      return entity;
    }
  }
  static class AbstractBridge implements Bridge<Abstract> {

    public Boolean support(ParseTree context) {
      return context instanceof DSLParser.DtoContext;
    }

    @Override
    public Abstract parse(ParseTree context) {
      DSLParser.DtoContext entityContext = (DSLParser.DtoContext) context;
      Abstract             entity        = new Abstract();
      entity.setText(entityContext.getText());
      entity.setName(
          G4ToDomain.<String>fetchBridge(entityContext.entityName()).parse(entityContext.entityName())
      );
      entity.setComment(
          G4ToDomain.<String>fetchBridge(entityContext.remark()).parse(entityContext.remark())
      );
      entity.setAnnotations(
          entityContext.annotation().stream()
              .map(annotation -> G4ToDomain.<Annotation>fetchBridge(annotation).parse(annotation))
              .collect(Collectors.toList())
      );
      entity.setFields(
          entityContext.field().stream()
              .map(annotation -> G4ToDomain.<EntityField>fetchBridge(annotation).parse(annotation))
              .collect(Collectors.toList())
      );
      return entity;
    }
  }
  static class ConfigBridge implements Bridge<Config> {

    public Boolean support(ParseTree context) {
      return context instanceof DSLParser.ConfigContext;
    }

    @Override
    public Config parse(ParseTree context) {
      DSLParser.ConfigContext configContext = (DSLParser.ConfigContext) context;
      Config                  config        = new Config();
      config.setText(configContext.getText());
      config.setFields(
          configContext.configItem().stream()
              .map(annotation -> G4ToDomain.<Field>fetchBridge(annotation).parse(annotation))
              .collect(Collectors.toList())
      );
      return config;
    }
  }

  static class ConfigItemBridge implements Bridge<Field> {

    public Boolean support(ParseTree context) {
      return context instanceof DSLParser.ConfigItemContext;
    }

    @Override
    public Field parse(ParseTree context) {
      DSLParser.ConfigItemContext configContext = (DSLParser.ConfigItemContext) context;
      String key = G4ToDomain.<String>fetchBridge(configContext.configKey())
          .parse(configContext.configKey());
      String value = G4ToDomain.<String>fetchBridge(configContext.configValue())
          .parse(configContext.configValue());
      Field config = new Field(key, value);
      config.setText(configContext.getText());
      return config;
    }
  }

  static class FieldBridge implements Bridge<EntityField> {

    public Boolean support(ParseTree context) {
      return context instanceof DSLParser.FieldContext;
    }

    @Override
    public EntityField parse(ParseTree context) {
      DSLParser.FieldContext configContext = (DSLParser.FieldContext) context;

      String key = G4ToDomain.<String>fetchBridge(configContext.fieldName())
          .parse(configContext.fieldName());
      String value = G4ToDomain.<String>fetchBridge(configContext.fieldType().simpleType())
          .parse(configContext.fieldType().simpleType());
      EntityField config = new EntityField(key, value);
      String collection = G4ToDomain.<String>fetchBridge(configContext.fieldType().collectionType())
          .parse(configContext.fieldType().collectionType());
      config.setCollectionType(collection);
      config.setText(configContext.getText());
      config.setAnnotations(
          configContext.annotation().stream()
              .map(annotation -> G4ToDomain.<Annotation>fetchBridge(annotation).parse(annotation))
              .collect(Collectors.toList())
      );
      config.setComment(
          G4ToDomain.<String>fetchBridge(configContext.remark())
              .parse(configContext.remark())
      );
      return config;
    }
  }

  static class ProjectNameBridge implements Bridge<String> {

    public Boolean support(ParseTree context) {
      return context instanceof DSLParser.ProjectNameContext;
    }

    @Override
    public String parse(ParseTree context) {
      DSLParser.ProjectNameContext configContext = (DSLParser.ProjectNameContext) context;
      return configContext.getText();
    }
  }

  static class EntityNameBridge implements Bridge<String> {

    public Boolean support(ParseTree context) {
      return context instanceof DSLParser.EntityNameContext;
    }

    @Override
    public String parse(ParseTree context) {
      DSLParser.EntityNameContext configContext = (DSLParser.EntityNameContext) context;
      return G4ToDomain.<String>fetchBridge(configContext.ID())
          .parse(configContext.ID());
    }
  }

  static class FieldNameBridge implements Bridge<String> {

    public Boolean support(ParseTree context) {
      return context instanceof DSLParser.FieldNameContext;
    }

    @Override
    public String parse(ParseTree context) {
      DSLParser.FieldNameContext configContext = (DSLParser.FieldNameContext) context;
      return configContext.getText();
    }
  }
  static class SimpleTypeBridge implements Bridge<String> {

    public Boolean support(ParseTree context) {
      return context instanceof DSLParser.SimpleTypeContext;
    }

    @Override
    public String parse(ParseTree context) {
      DSLParser.SimpleTypeContext configContext = (DSLParser.SimpleTypeContext) context;
      return configContext.getText();
    }
  }
  static class CollectionTypeBridge implements Bridge<String> {

    public Boolean support(ParseTree context) {
      return context instanceof DSLParser.CollectionTypeContext;
    }

    @Override
    public String parse(ParseTree context) {
      DSLParser.CollectionTypeContext configContext = (DSLParser.CollectionTypeContext) context;
      return configContext.getText();
    }
  }
  static class ConfigKeyBridge implements Bridge<String> {

    public Boolean support(ParseTree context) {
      return context instanceof DSLParser.ConfigKeyContext;
    }

    @Override
    public String parse(ParseTree context) {
      DSLParser.ConfigKeyContext configContext = (DSLParser.ConfigKeyContext) context;
      return configContext.getText();
    }
  }

  static class ConfigValueBridge implements Bridge<String> {

    public Boolean support(ParseTree context) {
      return context instanceof DSLParser.ConfigValueContext;
    }

    @Override
    public String parse(ParseTree context) {
      DSLParser.ConfigValueContext configContext = (DSLParser.ConfigValueContext) context;
      return context.getText();
    }
  }

  static class AnnotationNameBridge implements Bridge<String> {

    public Boolean support(ParseTree context) {
      return context instanceof DSLParser.AnnotationNameContext;
    }

    @Override
    public String parse(ParseTree context) {
      DSLParser.AnnotationNameContext configContext = (DSLParser.AnnotationNameContext) context;
      return configContext.getText();
    }
  }

  static class AnnotationFieldBridge implements Bridge<String> {

    public Boolean support(ParseTree context) {
      return context instanceof DSLParser.AnnotationFieldContext;
    }

    @Override
    public String parse(ParseTree context) {
      DSLParser.AnnotationFieldContext configContext = (DSLParser.AnnotationFieldContext) context;
      return configContext.getText();
    }
  }

  static class AnnotationValueBridge implements Bridge<String> {

    public Boolean support(ParseTree context) {
      return context instanceof DSLParser.AnnotationValueContext;
    }

    @Override
    public String parse(ParseTree context) {
      DSLParser.AnnotationValueContext configContext = (DSLParser.AnnotationValueContext) context;
      return configContext.getText();
    }
  }

  static class FieldTypeBridge implements Bridge<String> {

    public Boolean support(ParseTree context) {
      return context instanceof DSLParser.FieldTypeContext;
    }

    @Override
    public String parse(ParseTree context) {
      DSLParser.FieldTypeContext configContext = (DSLParser.FieldTypeContext) context;
      return configContext.getText();
    }
  }

  static class AnnotationBridge implements Bridge<Annotation> {

    public Boolean support(ParseTree context) {
      return context instanceof DSLParser.AnnotationContext;
    }

    @Override
    public Annotation parse(ParseTree context) {
      DSLParser.AnnotationContext configContext = (DSLParser.AnnotationContext) context;
      Annotation                  annotation    = new Annotation();
      annotation.setText(configContext.getText());
      annotation.setAnnotationName(
          G4ToDomain.<String>fetchBridge(configContext.annotationName())
              .parse(configContext.annotationName())
      );
      annotation.setFields(
          configContext.annotationField().stream().map(annotationFieldContext ->
              G4ToDomain.<AnnotationField>fetchBridge(annotationFieldContext)
                  .parse(annotationFieldContext)
          ).collect(Collectors.toList())
      );
      return annotation;
    }
  }

  static class RemarkBridge implements Bridge<String> {

    public Boolean support(ParseTree context) {
      return context instanceof DSLParser.RemarkContext;
    }

    @Override
    public String parse(ParseTree context) {
      DSLParser.RemarkContext configContext = (DSLParser.RemarkContext) context;
      return G4ToDomain.<String>fetchBridge(configContext.remarkContent())
          .parse(configContext.remarkContent());
    }
  }

  static class RemarkContentBridge implements Bridge<String> {

    public Boolean support(ParseTree context) {
      return context instanceof DSLParser.RemarkContentContext;
    }

    @Override
    public String parse(ParseTree context) {
      DSLParser.RemarkContentContext configContext = (DSLParser.RemarkContentContext) context;
      return configContext.getText();
    }
  }

  static class TerminalNodeBridge implements Bridge<String> {

    @Override
    public Boolean support(ParseTree context) {
      return context instanceof TerminalNode;
    }

    @Override
    public String parse(ParseTree context) {
      TerminalNode terminalNode = (TerminalNode) context;
      return terminalNode.getText();
    }
  }

  static {
    bridges.add(new RootBridge());
    bridges.add(new ProjectBridge());
    bridges.add(new EntityBridge());
    bridges.add(new ConfigBridge());
    bridges.add(new ConfigItemBridge());
    bridges.add(new FieldBridge());
    bridges.add(new ProjectNameBridge());
    bridges.add(new EntityNameBridge());
    bridges.add(new FieldNameBridge());
    bridges.add(new ConfigKeyBridge());
    bridges.add(new ConfigValueBridge());
    bridges.add(new AnnotationNameBridge());
    bridges.add(new AnnotationFieldBridge());
    bridges.add(new AnnotationValueBridge());
    bridges.add(new FieldTypeBridge());
    bridges.add(new AnnotationBridge());
    bridges.add(new RemarkBridge());
    bridges.add(new RemarkContentBridge());
    bridges.add(new TerminalNodeBridge());
    bridges.add(new SimpleTypeBridge());
    bridges.add(new CollectionTypeBridge());
    bridges.add(new AbstractBridge());
    bridges.add(new EnumBridge());
  }
}
