package cn.yematech.dsl.bridge;

import cn.yematech.dsl.domain.Abstract;
import cn.yematech.dsl.domain.Annotation;
import cn.yematech.dsl.domain.AnnotationField;
import cn.yematech.dsl.domain.Config;
import cn.yematech.dsl.domain.Entity;
import cn.yematech.dsl.domain.EntityField;
import cn.yematech.dsl.domain.Enum;
import cn.yematech.dsl.domain.Field;
import cn.yematech.dsl.domain.Project;
import cn.yematech.dsl.g4.DSLParser;
import cn.yematech.dsl.g4.DSLParser.AnnotationContext;
import cn.yematech.dsl.g4.DSLParser.AnnotationFieldContext;
import cn.yematech.dsl.g4.DSLParser.AnnotationNameContext;
import cn.yematech.dsl.g4.DSLParser.AnnotationValueContext;
import cn.yematech.dsl.g4.DSLParser.CollectionTypeContext;
import cn.yematech.dsl.g4.DSLParser.ConfigContext;
import cn.yematech.dsl.g4.DSLParser.ConfigItemContext;
import cn.yematech.dsl.g4.DSLParser.ConfigKeyContext;
import cn.yematech.dsl.g4.DSLParser.ConfigValueContext;
import cn.yematech.dsl.g4.DSLParser.DtoContext;
import cn.yematech.dsl.g4.DSLParser.EntityContext;
import cn.yematech.dsl.g4.DSLParser.EntityNameContext;
import cn.yematech.dsl.g4.DSLParser.EnumsContext;
import cn.yematech.dsl.g4.DSLParser.FieldContext;
import cn.yematech.dsl.g4.DSLParser.FieldNameContext;
import cn.yematech.dsl.g4.DSLParser.FieldTypeContext;
import cn.yematech.dsl.g4.DSLParser.ProjectContext;
import cn.yematech.dsl.g4.DSLParser.ProjectNameContext;
import cn.yematech.dsl.g4.DSLParser.RemarkContentContext;
import cn.yematech.dsl.g4.DSLParser.RemarkContext;
import cn.yematech.dsl.g4.DSLParser.RootContext;
import cn.yematech.dsl.g4.DSLParser.SimpleTypeContext;
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
      return context instanceof RootContext;
    }

    @Override
    public Project parse(ParseTree context) {
      RootContext rootContext = (RootContext) context;
      if (rootContext.getChildCount() != 1) {
        throw new IllegalArgumentException("解析失败");
      }
      ParseTree project = rootContext.getChild(0);
      if (!(project instanceof ProjectContext)) {
        throw new IllegalArgumentException("无法找到项目节点");
      }
      return G4ToDomain.<Project>fetchBridge(context.getChild(0)).parse(context.getChild(0));
    }
  }

  static class ProjectBridge implements Bridge<Project> {

    public Boolean support(ParseTree context) {
      return context instanceof ProjectContext;
    }

    @Override
    public Project parse(ParseTree context) {
      ProjectContext projectContext = (ProjectContext) context;
      Project project = new Project();
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
      return context instanceof EntityContext;
    }

    @Override
    public Entity parse(ParseTree context) {
      EntityContext entityContext = (EntityContext) context;
      Entity entity = new Entity();
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
      return context instanceof EnumsContext;
    }

    @Override
    public Enum parse(ParseTree context) {
      EnumsContext entityContext = (EnumsContext) context;
      Enum entity = new Enum();
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
      return context instanceof DtoContext;
    }

    @Override
    public Abstract parse(ParseTree context) {
      DtoContext entityContext = (DtoContext) context;
      Abstract entity = new Abstract();
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
      return context instanceof ConfigContext;
    }

    @Override
    public Config parse(ParseTree context) {
      ConfigContext configContext = (ConfigContext) context;
      Config config = new Config();
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
      return context instanceof ConfigItemContext;
    }

    @Override
    public Field parse(ParseTree context) {
      ConfigItemContext configContext = (ConfigItemContext) context;
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
      return context instanceof FieldContext;
    }

    @Override
    public EntityField parse(ParseTree context) {
      FieldContext configContext = (FieldContext) context;

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
      return context instanceof ProjectNameContext;
    }

    @Override
    public String parse(ParseTree context) {
      ProjectNameContext configContext = (ProjectNameContext) context;
      return configContext.getText();
    }
  }

  static class EntityNameBridge implements Bridge<String> {

    public Boolean support(ParseTree context) {
      return context instanceof EntityNameContext;
    }

    @Override
    public String parse(ParseTree context) {
      EntityNameContext configContext = (EntityNameContext) context;
      return G4ToDomain.<String>fetchBridge(configContext.ID())
          .parse(configContext.ID());
    }
  }

  static class FieldNameBridge implements Bridge<String> {

    public Boolean support(ParseTree context) {
      return context instanceof FieldNameContext;
    }

    @Override
    public String parse(ParseTree context) {
      FieldNameContext configContext = (FieldNameContext) context;
      return configContext.getText();
    }
  }
  static class SimpleTypeBridge implements Bridge<String> {

    public Boolean support(ParseTree context) {
      return context instanceof SimpleTypeContext;
    }

    @Override
    public String parse(ParseTree context) {
      SimpleTypeContext configContext = (SimpleTypeContext) context;
      return configContext.getText();
    }
  }
  static class CollectionTypeBridge implements Bridge<String> {

    public Boolean support(ParseTree context) {
      return context instanceof CollectionTypeContext;
    }

    @Override
    public String parse(ParseTree context) {
      CollectionTypeContext configContext = (CollectionTypeContext) context;
      return configContext.getText();
    }
  }
  static class ConfigKeyBridge implements Bridge<String> {

    public Boolean support(ParseTree context) {
      return context instanceof ConfigKeyContext;
    }

    @Override
    public String parse(ParseTree context) {
      ConfigKeyContext configContext = (ConfigKeyContext) context;
      return configContext.getText();
    }
  }

  static class ConfigValueBridge implements Bridge<String> {

    public Boolean support(ParseTree context) {
      return context instanceof ConfigValueContext;
    }

    @Override
    public String parse(ParseTree context) {
      ConfigValueContext configContext = (ConfigValueContext) context;
      return context.getText();
    }
  }

  static class AnnotationNameBridge implements Bridge<String> {

    public Boolean support(ParseTree context) {
      return context instanceof AnnotationNameContext;
    }

    @Override
    public String parse(ParseTree context) {
      AnnotationNameContext configContext = (AnnotationNameContext) context;
      return configContext.getText();
    }
  }

  static class AnnotationFieldBridge implements Bridge<String> {

    public Boolean support(ParseTree context) {
      return context instanceof AnnotationFieldContext;
    }

    @Override
    public String parse(ParseTree context) {
      AnnotationFieldContext configContext = (AnnotationFieldContext) context;
      return configContext.getText();
    }
  }

  static class AnnotationValueBridge implements Bridge<String> {

    public Boolean support(ParseTree context) {
      return context instanceof AnnotationValueContext;
    }

    @Override
    public String parse(ParseTree context) {
      AnnotationValueContext configContext = (AnnotationValueContext) context;
      return configContext.getText();
    }
  }

  static class FieldTypeBridge implements Bridge<String> {

    public Boolean support(ParseTree context) {
      return context instanceof FieldTypeContext;
    }

    @Override
    public String parse(ParseTree context) {
      FieldTypeContext configContext = (FieldTypeContext) context;
      return configContext.getText();
    }
  }

  static class AnnotationBridge implements Bridge<Annotation> {

    public Boolean support(ParseTree context) {
      return context instanceof AnnotationContext;
    }

    @Override
    public Annotation parse(ParseTree context) {
      AnnotationContext configContext = (AnnotationContext) context;
      Annotation annotation = new Annotation();
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
      return context instanceof RemarkContext;
    }

    @Override
    public String parse(ParseTree context) {
      RemarkContext configContext = (RemarkContext) context;
      return G4ToDomain.<String>fetchBridge(configContext.remarkContent())
          .parse(configContext.remarkContent());
    }
  }

  static class RemarkContentBridge implements Bridge<String> {

    public Boolean support(ParseTree context) {
      return context instanceof RemarkContentContext;
    }

    @Override
    public String parse(ParseTree context) {
      RemarkContentContext configContext = (RemarkContentContext) context;
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
