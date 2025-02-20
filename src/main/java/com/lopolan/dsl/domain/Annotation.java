package com.lopolan.dsl.domain;

import java.util.List;

/**
 * <h1> Annotation</h1>
 *
 * <pre>
 *
 * </pre>
 *
 * @author lopo
 * @date 2021/12/9 10:11 上午
 **/
public class Annotation extends Content{
  private String annotationName;
  List<AnnotationField> fields;

  public String getAnnotationName() {
    return annotationName;
  }

  public Annotation setAnnotationName(String annotationName) {
    this.annotationName = annotationName;
    return this;
  }

  public List<AnnotationField> getFields() {
    return fields;
  }

  public Annotation setFields(List<AnnotationField> fields) {
    this.fields = fields;
    return this;
  }
}
