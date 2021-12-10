package cn.yematech.dsl.domain;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
public class Abstract extends Content implements CommentAble, AnnotationAble,FieldsAble {

  private String comment;
  private String name;
  private List<Annotation> annotations;
  private List<EntityField> fields;
  private String className;
  private String fullClassName;
  private Environment environment;

  public String getClassName() {
    return className;
  }

  public Abstract setClassName(String className) {
    this.className = className;
    return this;
  }
  public Set<String> getAllFieldFullNames() {
    return getFields().stream().flatMap(entityField ->
        Stream.of(entityField.getTypeFullName(),entityField.getFullCollectionTypeName())
    ).filter(Objects::nonNull).filter(e->!e.startsWith("java.lang.")).distinct().collect(Collectors.toSet());
  }
  public String getFullClassName() {
    return fullClassName;
  }

  public Abstract setFullClassName(String fullClassName) {
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
    environment.fieldsAbleRef.put(className,this);
  }

  @Override
  public String getComment() {
    return comment;
  }

  public Abstract setComment(String comment) {
    this.comment = comment;
    return this;
  }

  public String getName() {
    return name;
  }

  public Abstract setName(String name) {
    this.name = name;
    return this;
  }

  @Override
  public List<Annotation> getAnnotations() {
    return annotations;
  }

  public Abstract setAnnotations(List<Annotation> annotations) {
    this.annotations = annotations;
    return this;
  }

  public List<EntityField> getFields() {
    return fields;
  }

  public Abstract setFields(List<EntityField> fields) {
    this.fields = fields;
    return this;
  }
}
