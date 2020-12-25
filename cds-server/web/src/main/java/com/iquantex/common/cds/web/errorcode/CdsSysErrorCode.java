package com.iquantex.common.cds.web.errorcode;

/**
 * 系统处理模块的错误码集合
 *
 * @author lan
 * @description: 示例
 * @date 2020-12-16
 */
public enum CdsSysErrorCode implements ErrorCode {
  CDSSYS0000("系统未知异常"), //
  CDSSYS0001("入参校验不通过: %s");

  private String remark;

  CdsSysErrorCode(String remark) {
    this.remark = remark;
  }

  @Override
  public String getMsg(Object[] args) {
    return getCode() + ":" + String.format(remark, args);
  }

  @Override
  public String getCode() {
    return this.name();
  }
}
