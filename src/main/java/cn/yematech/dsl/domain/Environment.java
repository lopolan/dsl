package cn.yematech.dsl.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/**
 * <h1> DefaultConfig</h1>
 *
 * <pre>
 *
 * </pre>
 *
 * @author lopo
 * @date 2021/12/9 11:14 上午
 **/
public class Environment {
  Map<String,String> typeFullNameRef = new HashMap<>();
  Map<String,FieldsAble> fieldsAbleRef = new HashMap<>();
  private Project project;

  public Environment(Project project) {
    this.project = project;
    basePackage = String.format("cn.yematech.%s", String.join(".",project.getProjectName().split("-|_")));
    Stream.of(FieldTypeEnums.values()).forEach(fieldTypeEnums -> typeFullNameRef.put(fieldTypeEnums.getaClass().getSimpleName(),fieldTypeEnums.getaClass().getName()));
  }

  private String basePackage ;
  private String doPackage;
  private String servicePackage;
  private String repositoryPackage;
  private String mapstructPackage;

  public Project getProject() {
    return project;
  }

  public String getBasePackage() {
    return basePackage;
  }

  public Environment setBasePackage(String basePackage) {
    this.basePackage = basePackage;
    return this;
  }

  public Map<String, FieldsAble> getFieldsAbleRef() {
    return fieldsAbleRef;
  }

  public String getDoPackage() {
    return doPackage;
  }

  public Environment setDoPackage(String doPackage) {
    this.doPackage = doPackage;
    return this;
  }

  public String getServicePackage() {
    return servicePackage;
  }

  public Environment setServicePackage(String servicePackage) {
    this.servicePackage = servicePackage;
    return this;
  }

  public String getRepositoryPackage() {
    return repositoryPackage;
  }

  public Environment setRepositoryPackage(String repositoryPackage) {
    this.repositoryPackage = repositoryPackage;
    return this;
  }

  public Map<String, String> getTypeFullNameRef() {
    return typeFullNameRef;
  }

  public String getMapstructPackage() {
    return mapstructPackage;
  }

  public Environment setMapstructPackage(String mapstructPackage) {
    this.mapstructPackage = mapstructPackage;
    return this;
  }
}
