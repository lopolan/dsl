package cn.yematech.dsl.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <h1> Entity</h1>
 *
 * <pre>
 *
 * </pre>
 *
 * @author lopo
 * @date 2021/12/9 11:09 上午
 **/
public class Entity extends Content implements CommentAble, AnnotationAble,FieldsAble {

  private String comment;
  private String name;
  private List<Annotation> annotations;
  private List<EntityField> fields;
  private String parent;
  private Boolean hasJson;
  private String fullServiceClassName;
  private String fullMapperClassName;
  private String fullRepositoryClassName;
  private String serviceClassName;
  private String mapperClassName;
  private String repositoryClassName;
  private String pathName;
  private String className;
  private String fullClassName;
  private Environment environment;

  public String getParent() {
    return parent;
  }

  public Entity setParent(String parent) {
    this.parent = parent;
    return this;
  }

  public List<String> getAnnotationNames() {
    return Optional.ofNullable(getAnnotations()).map(annotations1 ->
      annotations1.stream().map(Annotation::getAnnotationName).collect(Collectors.toList())
    ).orElse(Collections.emptyList());
  }

  public List<EntityField> getFields() {
    return fields;
  }

  public Entity setFields(List<EntityField> fields) {
    this.fields = fields;
    return this;
  }

  public String getName() {
    return name;
  }

  public Entity setName(String name) {
    this.name = name;
    return this;
  }

  @Override
  public String getComment() {
    return comment;
  }

  public Entity setComment(String comment) {
    this.comment = comment;
    return this;
  }

  @Override
  public List<Annotation> getAnnotations() {
    return annotations;
  }

  public Entity setAnnotations(List<Annotation> annotations) {
    this.annotations = annotations;
    return this;
  }

  public Boolean getHasJson() {
    return hasJson;
  }

  public Entity setHasJson(Boolean hasJson) {
    this.hasJson = hasJson;
    return this;
  }

  public String getClassName() {
    return className;
  }

  public Entity setClassName(String className) {
    this.className = className;
    return this;
  }

  public String getFullClassName() {
    return fullClassName;
  }

  public Entity setFullClassName(String fullClassName) {
    this.fullClassName = fullClassName;
    return this;
  }

  public String getFullServiceClassName() {
    return fullServiceClassName;
  }

  public Entity setFullServiceClassName(String fullServiceClassName) {
    this.fullServiceClassName = fullServiceClassName;
    return this;
  }

  public String getFullMapperClassName() {
    return fullMapperClassName;
  }

  public Entity setFullMapperClassName(String fullMapperClassName) {
    this.fullMapperClassName = fullMapperClassName;
    return this;
  }

  public String getFullRepositoryClassName() {
    return fullRepositoryClassName;
  }

  public Entity setFullRepositoryClassName(String fullRepositoryClassName) {
    this.fullRepositoryClassName = fullRepositoryClassName;
    return this;
  }

  public String getServiceClassName() {
    return serviceClassName;
  }

  public Entity setServiceClassName(String serviceClassName) {
    this.serviceClassName = serviceClassName;
    return this;
  }

  public String getMapperClassName() {
    return mapperClassName;
  }

  public Entity setMapperClassName(String mapperClassName) {
    this.mapperClassName = mapperClassName;
    return this;
  }

  public String getRepositoryClassName() {
    return repositoryClassName;
  }

  public Entity setRepositoryClassName(String repositoryClassName) {
    this.repositoryClassName = repositoryClassName;
    return this;
  }

  public String getPathName() {
    return pathName;
  }

  public Entity setPathName(String pathName) {
    this.pathName = pathName;
    return this;
  }
  public Set<EntityField> getAllEffectiveField(){
    if(Objects.isNull(parent) || "".equals(parent)){
      return new TreeSet<>(getFields());
    }
    Set<EntityField> fields = new HashSet<>();
    FieldsAble parentInstance = environment.getFieldsAbleRef().get(parent);
    fields.addAll(getFields());
    fields.addAll(parentInstance.getFields());
    return fields;
  }
  public Set<String> getAllEffectiveFieldFullNames(){
    return allFieldFullNames(getAllEffectiveField());
  }
  public Set<String> getAllFieldFullNames() {
    List<EntityField> fields = getFields();
    return allFieldFullNames(fields);
  }

  private Set<String> allFieldFullNames(Collection<EntityField> fields) {
    return fields.stream().flatMap(entityField ->
      Stream.of(entityField.getTypeFullName(),entityField.getFullCollectionTypeName())
    ).filter(Objects::nonNull).filter(e->!e.startsWith("java.lang.")).distinct().collect(Collectors.toSet());
  }

  public void init(Environment environment) {
    this.environment = environment;
    String basePackage = environment.getBasePackage();
    String className = name.substring(0, 1).toUpperCase() + name.substring(1);
    environment.fieldsAbleRef.put(className,this);
    setName(name.substring(0, 1).toLowerCase() + name.substring(1));
    this.setClassName(className);
    String fullClassName =
        basePackage + "." + environment.getDoPackage() + "." + className;
    this.setFullClassName(fullClassName);
    String fullServiceClassName =
        basePackage + "." + environment.getServicePackage() + "." + className
            + "Service";
    this.setFullServiceClassName(fullServiceClassName);
    String fullMapperClassName =
        basePackage + "." + environment.getMapstructPackage() + "." + className
            + "Mapper";
    this.setFullMapperClassName(fullMapperClassName);
    String fullRepositoryClassName =
        environment.getBasePackage() + "." + environment.getRepositoryPackage() + "." + className
            + "Repository";
    this.setFullRepositoryClassName(fullRepositoryClassName);
    String serviceClassName = name + "Service";
    this.setServiceClassName(serviceClassName);
    environment.typeFullNameRef.put(serviceClassName,fullServiceClassName);
    String mapperClassName = name + "Mapper";
    this.setMapperClassName(mapperClassName);
    environment.typeFullNameRef.put(mapperClassName,fullMapperClassName);
    String repositoryClassName = name + "Repository";
    this.setRepositoryClassName(repositoryClassName);
    environment.typeFullNameRef.put(repositoryClassName,fullRepositoryClassName);

    environment.typeFullNameRef.put(className,fullClassName);
    Boolean hasJson = getFields().stream()
        .anyMatch(entityField -> "Json".equals(entityField.getValue()));
    setHasJson(hasJson);
    this.setPathName( getName().replaceAll("[A-Z]", "/$0").toLowerCase());
  }
  public String getLineName(){
    return getName().replaceAll("[A-Z]", "_$0").toLowerCase();
  }
}
