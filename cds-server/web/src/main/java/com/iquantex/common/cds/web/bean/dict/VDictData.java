package com.iquantex.common.cds.web.bean.dict;

/**
 * @author gys
 * @date 2020/12/30
 */
public class VDictData {
  private String dictKey;
  private String value;
  private String name;
  private String enName;
  private String dictValueType;
  private String remark;
  private String appId;

  public String getDictKey() {
    return dictKey;
  }

  public void setDictKey(String dictKey) {
    this.dictKey = dictKey;
  }

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

  public String getEnName() {
    return enName;
  }

  public void setEnName(String enName) {
    this.enName = enName;
  }

  public String getDictValueType() {
    return dictValueType;
  }

  public void setDictValueType(String dictValueType) {
    this.dictValueType = dictValueType;
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  public String getAppId() {
    return appId;
  }

  public void setAppId(String appId) {
    this.appId = appId;
  }
}
