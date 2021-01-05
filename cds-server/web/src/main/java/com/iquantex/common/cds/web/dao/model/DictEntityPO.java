package com.iquantex.common.cds.web.dao.model;

import java.util.List;

/**
 * @author gys
 * @date 2020/12/30
 */
public class DictEntityPO {
  private String comment;
  private List<FieldPO> fieldPOs;
  private String appIdAndDictKey;
  private List<FieldByDictKeyPO> fieldByDictKeys;

  public DictEntityPO() {}

  public String getComment() {
    return this.comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public List<FieldPO> getFieldPOs() {
    return this.fieldPOs;
  }

  public void setFieldPOs(List<FieldPO> fieldPOs) {
    this.fieldPOs = fieldPOs;
  }

  public String getAppIdAndDictKey() {
    return appIdAndDictKey;
  }

  public void setAppIdAndDictKey(String appIdAndDictKey) {
    this.appIdAndDictKey = appIdAndDictKey;
  }

  public List<FieldByDictKeyPO> getFieldByDictKeys() {
    return fieldByDictKeys;
  }

  public void setFieldByDictKeys(List<FieldByDictKeyPO> fieldByDictKeys) {
    this.fieldByDictKeys = fieldByDictKeys;
  }
}
