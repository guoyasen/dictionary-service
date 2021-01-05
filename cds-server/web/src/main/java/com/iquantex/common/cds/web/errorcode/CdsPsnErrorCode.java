package com.iquantex.common.cds.web.errorcode;

/**
 * Person模块的错误码集合
 *
 * @author lan
 * @description: 示例
 * @date 2020-12-16
 */
public enum CdsPsnErrorCode implements ErrorCode {
  // 人员已存在
  CDSPSN0001("人员%s已存在"),
  // 人员不存在
  CDSPSN0002("人员%s不存在");

  private String remark;

  CdsPsnErrorCode(String remark) {
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
