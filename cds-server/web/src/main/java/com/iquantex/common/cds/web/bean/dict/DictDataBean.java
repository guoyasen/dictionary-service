package com.iquantex.common.cds.web.bean.dict;

/**
 * @author gys
 * @date 2020/12/30
 */
public class DictDataBean {

  private String dictKey;
  private String value;
  private String name;
  private String enName;
  private Integer dictValueType;
  private String remark;
  private String appId;
  private String dictName;

  public DictDataBean() {}

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

  public String getDictKey() {
    return dictKey;
  }

  public void setDictKey(String dictKey) {
    this.dictKey = dictKey;
  }

  public String getEnName() {
    return enName;
  }

  public void setEnName(String enName) {
    this.enName = enName;
  }

  public Integer getDictValueType() {
    return dictValueType;
  }

  public void setDictValueType(Integer dictValueType) {
    this.dictValueType = dictValueType;
  }

  public String getRemark() {
    return this.remark;
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

  public String getDictName() {
    return dictName;
  }

  public void setDictName(String dictName) {
    this.dictName = dictName;
  }
}
