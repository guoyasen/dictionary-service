package com.iquantex.common.cds.web.errorcode;

/**
 * Person模块的错误码集合
 *
 * @author lan
 * @description: 示例
 * @date 2020-12-16
 */
public enum CdsDictJsErrorCode implements ErrorCode {
  // 获取字典JS内容失败
  CDSDICTJS0001("获取字典JS内容失败"),
  // 没有所属应用字典
  CDSDICTJS0002("没有所属应用为【%s】的字典值");

  private String remark;

  CdsDictJsErrorCode(String remark) {
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
