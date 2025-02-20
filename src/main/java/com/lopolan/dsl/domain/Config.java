package com.lopolan.dsl.domain;

import java.util.List;

/**
 * <h1> Config.java.vm</h1>
 *
 * <pre>
 *
 * </pre>
 *
 * @author lopo
 * @date 2021/12/9 11:11 上午
 **/
public class Config extends Content{
  private List<Field> fields;

  public List<Field> getFields() {
    return fields;
  }

  public Config setFields(List<Field> fields) {
    this.fields = fields;
    return this;
  }
}
