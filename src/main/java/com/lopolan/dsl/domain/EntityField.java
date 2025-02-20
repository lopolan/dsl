package com.lopolan.dsl.domain;

import java.util.List;

/**
 * <h1> EntityField</h1>
 *
 * <pre>
 *
 * </pre>
 *
 * @author lopo
 * @date 2021/12/9 11:00 上午
 **/
public class EntityField extends Field implements CommentAble,AnnotationAble{
  private String comment;
  private List<Annotation> annotations;
  private String collectionType;
  private Environment environment;
  private FieldTypeEnums fieldTypeEnums;

  public EntityField(String name, String value) {
    super(name, value);
  }

  public void init(Environment environment){
    this.environment = environment;
    if(collectionType == null || "".equals(collectionType)){
      this.fieldTypeEnums = FieldTypeEnums.findByText(getValue());
    }
  }

  public FieldTypeEnums getFieldTypeEnums() {
    return fieldTypeEnums;
  }

  public String getCollectionType() {
    return collectionType;
  }

  public EntityField setCollectionType(String collectionType) {
    this.collectionType = collectionType;
    return this;
  }

  @Override
  public String getComment() {
    return comment;
  }

  @Override
  public List<Annotation> getAnnotations() {
    return annotations;
  }

  public EntityField setAnnotations(List<Annotation> annotations) {
    this.annotations = annotations;
    return this;
  }

  public EntityField setComment(String comment) {
    this.comment = comment;
    return this;
  }

  public String getTypeName() {
    if(collectionType == null || "".equals(collectionType)){
      return getValue();
    }
    return collectionType+"<"+getValue()+">";
  }

  public String getTypeFullName(){
    return environment.getTypeFullNameRef().get(getValue());
  }
  public String getFullCollectionTypeName(){
    if(getCollectionType() == null){
      return null;
    }
    return environment.getTypeFullNameRef().get(getCollectionType());
  }
  public String getClassName(){
    return getName().substring(0,1).toUpperCase()+getName().substring(1);
  }
  public String getLineName(){
    return getName().replaceAll("[A-Z]", "_$0").toLowerCase();
  }
}
