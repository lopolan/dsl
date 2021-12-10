package cn.yematech.dsl.domain;

import java.util.List;

/**
 * <h1> Project</h1>
 *
 * <pre>
 *
 * </pre>
 *
 * @author lopo
 * @date 2021/12/9 10:09 上午
 **/
public class Project extends Content implements AnnotationAble,CommentAble{
  private String projectName;
  private String comment;
  private Config config;
  private List<Annotation> annotations;
  private List<Entity> entities;
  private List<Abstract> abstracts;
  private List<Enum> enums;
  private Environment environment;

  public void init(){
    environment = new Environment(this);
    entities.forEach(entity -> entity.init(environment));
    abstracts.forEach(entity -> entity.init(environment));
    enums.forEach(entity -> entity.init(environment));
    entities.stream().flatMap(entity -> entity.getFields().stream()).forEach(entity -> entity.init(environment));
    abstracts.stream().flatMap(entity -> entity.getFields().stream()).forEach(entity -> entity.init(environment));
  }

  public List<Abstract> getAbstracts() {
    return abstracts;
  }

  public Project setAbstracts(List<Abstract> abstracts) {
    this.abstracts = abstracts;
    return this;
  }

  public Environment getEnvironment() {
    return environment;
  }

  public List<Enum> getEnums() {
    return enums;
  }

  public Project setEnums(List<Enum> enums) {
    this.enums = enums;
    return this;
  }

  public Project setEnvironment(Environment environment) {
    this.environment = environment;
    return this;
  }

  public Config getConfig() {
    return config;
  }

  public Project setConfig(Config config) {
    this.config = config;
    return this;
  }

  public String getProjectName() {
    return projectName;
  }

  public Project setProjectName(String projectName) {
    this.projectName = projectName;
    return this;
  }

  @Override
  public String getComment() {
    return comment;
  }

  public Project setComment(String comment) {
    this.comment = comment;
    return this;
  }

  @Override
  public List<Annotation> getAnnotations() {
    return annotations;
  }

  public Project setAnnotations(List<Annotation> annotations) {
    this.annotations = annotations;
    return this;
  }

  public List<Entity> getEntities() {
    return entities;
  }

  public Project setEntities(List<Entity> entities) {
    this.entities = entities;
    return this;
  }
}
