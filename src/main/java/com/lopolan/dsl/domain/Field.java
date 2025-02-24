package com.lopolan.dsl.domain;

/**
 * <h1> Field</h1>
 *
 * <pre>
 *
 * </pre>
 *
 * @author lopo
 * @date 2021/12/9 10:45 上午
 **/
public class Field extends Content implements Comparable<Field>{
  private String name;
  private String value;

  public Field(String name, String value) {
    this.name = name;
    this.value = value;
  }

  public String getName() {
    return name;
  }

  public Field setName(String name) {
    this.name = name;
    return this;
  }

  public String getValue() {
    return value;
  }

  public Field setValue(String value) {
    this.value = value;
    return this;
  }

  @Override
  public int compareTo(Field o) {
    return getName().compareTo(o.getName()) | getValue().compareTo(o.getValue());
  }
}
