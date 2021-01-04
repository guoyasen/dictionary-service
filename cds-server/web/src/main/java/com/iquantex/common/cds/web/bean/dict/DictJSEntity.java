package com.iquantex.common.cds.web.bean.dict;

import java.util.List;

/**
 * @author gys
 * @date 2020/12/30
 */
public class DictJSEntity {
  private String comment;
  private List<JSField> fields;
  private String appIdAndDictKey;
  private List<JSFieldByDictKey> jsFieldByDictKeys;

  public DictJSEntity() {}

  public String getComment() {
    return this.comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public List<JSField> getFields() {
    return this.fields;
  }

  public void setFields(List<JSField> fields) {
    this.fields = fields;
  }

  public String getAppIdAndDictKey() {
    return appIdAndDictKey;
  }

  public void setAppIdAndDictKey(String appIdAndDictKey) {
    this.appIdAndDictKey = appIdAndDictKey;
  }

  public List<JSFieldByDictKey> getJsFieldByDictKeys() {
    return jsFieldByDictKeys;
  }

  public void setJsFieldByDictKeys(List<JSFieldByDictKey> jsFieldByDictKeys) {
    this.jsFieldByDictKeys = jsFieldByDictKeys;
  }
}
