package com.iquantex.common.cds.web.exception;

import com.iquantex.common.cds.web.errorcode.CdsSysErrorCode;
import com.iquantex.portal.web.api.Response;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一异常处理
 *
 * @author lan
 * @description: 示例
 * @date 2020-12-16
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

  /**
   * 返回的Map对象会被@ResponseBody注解转换为JSON数据返回
   *
   * @return
   */
  @ExceptionHandler(Exception.class)
  @ResponseBody
  public Response handleException(HttpServletRequest request, Exception e) {
    StringBuffer url = request.getRequestURL();
    String method = request.getMethod();
    log.error("handle method<{}> url<{}> exception", method, url, e);

    AppException exception;
    if (e instanceof AppException) {
      exception = (AppException) e;
    } else {
      if (e instanceof MethodArgumentNotValidException) {
        StringBuilder sb = new StringBuilder();
        List<ObjectError> errors =
            ((MethodArgumentNotValidException) e).getBindingResult().getAllErrors();
        for (ObjectError error : errors) {
          sb.append(error.getDefaultMessage());
          sb.append(";");
        }
        exception = new AppException(CdsSysErrorCode.CDSSYS0001, sb.toString());
      } else {
        exception = new AppException(CdsSysErrorCode.CDSSYS0000, e);
      }
    }
    return new Response(
        Response.CODE_FAIL, null, exception.getMessage(), exception.getErrorCode().getCode());
  }
}
