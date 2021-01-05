package com.iquantex.common.cds.web.dao.model;

/**
 * @author gys
 * @date 2020/12/30
 */
public class FieldByDictKeyPO {
  private String value;
  private String name;
  private boolean string;

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public boolean isString() {
    return string;
  }

  public void setString(boolean string) {
    this.string = string;
  }
}
