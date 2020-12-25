package com.iquantex.common.cds.web.util;

import java.util.Optional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * 获取请求上下文工具类
 *
 * @author yanliang
 * @date 12/18/2020 6:22 PM
 */
public class ContextUtils {

  public static String getUser() {
    Optional<String> user =
        Optional.ofNullable(
            ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getRequest()
                .getHeader("user_name"));
    return user.orElse("anonymous");
  }
}
