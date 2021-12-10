package cn.yematech.dsl.domain;

/**
 * <h1> Content</h1>
 *
 * <pre>
 *
 * </pre>
 *
 * @author lopo
 * @date 2021/12/9 12:41 下午
 **/
public abstract class Content {
  private String text;

  public String getText() {
    return text;
  }

  public Content setText(String text) {
    this.text = text;
    return this;
  }

  @Override
  public String toString() {
    return text;
  }
}
