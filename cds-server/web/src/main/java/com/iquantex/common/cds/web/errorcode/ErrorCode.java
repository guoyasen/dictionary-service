package com.iquantex.common.cds.web.errorcode;

/**
 * 错误码规范： 用于基于此接口实现错误码类，例子: CDSSYS0000, 命名规范如下： 三位应用名(三位大写字母） + 三位模块名(大写字母加数字) + 4为模块内错误码(数字)
 *
 * @author lan
 * @description: 示例
 * @date 2020-12-16
 */
public interface ErrorCode {
  String getMsg(Object... args);

  String getCode();
}
