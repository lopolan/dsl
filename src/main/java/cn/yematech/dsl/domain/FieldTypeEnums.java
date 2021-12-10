package cn.yematech.dsl.domain;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Stream;

/**
 * <h1> FieldTypeEnums</h1>
 *
 * <pre>
 *
 * </pre>
 *
 * @author lopo
 * @date 2021/12/9 4:47 下午
 **/
public enum FieldTypeEnums {
  Integer("Integer", Integer.class,"IntegerFilter","buildRangeSpecification"),

  Long("Long", Long.class,"LongFilter","buildRangeSpecification"),

  String("String", String.class,"StringFilter","buildStringSpecification"),

  BigDecimal("BigDecimal", BigDecimal.class,"BigDecimalFilter","buildRangeSpecification"),

  Json("Json", Object.class,null,null),

  LocalDate("LocalDate", LocalDate.class,"LocalDateFilter","buildRangeSpecification"),

  LocalDateTime("LocalDateTime", LocalDateTime.class,"LocalDateTimeFilter","buildRangeSpecification"),

  LocalTime("LocalTime", LocalTime.class,"LocalTimeFilter","buildRangeSpecification"),

  ZonedDateTime("ZonedDateTime", ZonedDateTime.class,"ZonedDateTimeFilter","buildRangeSpecification"),

  Instant("Instant", Instant.class,"InstantFilter","buildRangeSpecification"),

  Text("Text", String.class,null,null),
  List("List", java.util.List.class,null,null),
  Map("Map", java.util.List.class,null,null),
  ;
  private String text;
  private Class aClass;
  private String filter;
  private String buildContent;

  public java.lang.String getText() {
    return text;
  }

  public Class getaClass() {
    return aClass;
  }

  FieldTypeEnums(java.lang.String text, Class aClass, java.lang.String filter,
      java.lang.String buildContent) {
    this.text = text;
    this.aClass = aClass;
    this.filter = filter;
    this.buildContent = buildContent;
  }

  public java.lang.String getBuildContent() {
    return buildContent;
  }

  public java.lang.String getFilter() {
    return filter;
  }

  public static FieldTypeEnums findByText(String text){
    return Stream.of(values()).filter(e->e.text.equals(text)).findAny().orElse(null);
  }
}
