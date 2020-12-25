package com.iquantex.common.cds.web.exception;

import com.iquantex.common.cds.web.errorcode.ErrorCode;

/**
 * 存放模块为SYS的错误码集合, SYS中主要为系统处理异常错误码
 *
 * @author lan
 * @description: 示例
 * @date 2020-12-16
 */
public class AppException extends RuntimeException {

  private ErrorCode code;

  public AppException(ErrorCode code, Object... args) {
    super(code.getMsg(args));
    this.code = code;
  }

  public AppException(Exception e, ErrorCode code, Object... args) {
    super(code.getMsg(args) + "," + e.getMessage(), e);
    this.code = code;
  }

  public ErrorCode getErrorCode() {
    return code;
  }
}
