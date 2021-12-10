package cn.yematech.dsl.domain;

import java.util.List;

/**
 * <h1> Abstract</h1>
 *
 * <pre>
 *
 * </pre>
 *
 * @author lopo
 * @date 2021/12/9 5:53 下午
 **/
public class Enum extends Content implements CommentAble, AnnotationAble {

  private String comment;
  private String name;
  private List<Annotation> annotations;
  private List<String> fields;

  private String className;
  private String fullClassName;
  private Environment environment;

  public String getClassName() {
    return className;
  }

  public Enum setClassName(String className) {
    this.className = className;
    return this;
  }

  public String getFullClassName() {
    return fullClassName;
  }

  public Enum setFullClassName(String fullClassName) {
    this.fullClassName = fullClassName;
    return this;
  }

  public void init(Environment environment) {
    this.environment = environment;
    String basePackage = environment.getBasePackage();
    String className = name.substring(0, 1).toUpperCase() + name.substring(1);
    this.setClassName(className);
    String fullClassName =
        basePackage + "." + environment.getDoPackage() + "." + className;
    this.setFullClassName(fullClassName);
    environment.typeFullNameRef.put(className,fullClassName);
  }

  @Override
  public String getComment() {
    return comment;
  }

  public Enum setComment(String comment) {
    this.comment = comment;
    return this;
  }

  public String getName() {
    return name;
  }

  public Enum setName(String name) {
    this.name = name;
    return this;
  }

  @Override
  public List<Annotation> getAnnotations() {
    return annotations;
  }

  public Enum setAnnotations(List<Annotation> annotations) {
    this.annotations = annotations;
    return this;
  }

  public List<String> getFields() {
    return fields;
  }

  public Enum setFields(List<String> fields) {
    this.fields = fields;
    return this;
  }
}
