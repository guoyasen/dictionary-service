package com.iquantex.common.cds.web.bean.dict;

/**
 * @author gys
 * @date 2020/12/30
 */
public class JSField {
  private String identifier;
  private String value;
  private String annotation;
  private boolean string;

  public JSField() {}

  public String getIdentifier() {
    return this.identifier;
  }

  public void setIdentifier(String identifier) {
    this.identifier = identifier;
  }

  public String getValue() {
    return this.value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public String getAnnotation() {
    return this.annotation;
  }

  public void setAnnotation(String annotation) {
    this.annotation = annotation;
  }

  public boolean isString() {
    return this.string;
  }

  public void setString(boolean string) {
    this.string = string;
  }
}
