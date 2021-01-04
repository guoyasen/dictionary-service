package com.iquantex.common.cds.web.errorcode;

/**
 * Person模块的错误码集合
 *
 * @author lan
 * @description: 示例
 * @date 2020-12-16
 */
public enum CdsDictErrorCode implements ErrorCode {
  CDSDICT0001("数据字典【%s】已存在"),
  CDSDICT0002("数据字典【%s】，值【%s】重复，添加失败"),
  CDSDICT0003("数据字典不存在"),
  CDSDICT0004("数据字典【%s】子项不存在"),
  CDSDICT0005("数据字典值【%s】已存在"),
  CDSDICT0006("有且只有一个字典子项，删除失败，可以将字典dict_key:%s整体删除"),
  CDSDICT0007("删除失败！"),
  CDSDICT0008("数据字典值不存在"),
  CDSDICT0009("至少添加一个字典子项");

  private String remark;

  CdsDictErrorCode(String remark) {
    this.remark = remark;
  }

  @Override
  public String getMsg(Object... args) {
    return getCode() + ":" + String.format(remark, args);
  }

  @Override
  public String getCode() {
    return this.name();
  }
}
