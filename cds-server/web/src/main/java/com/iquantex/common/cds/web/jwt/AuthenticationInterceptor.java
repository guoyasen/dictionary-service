package com.iquantex.common.cds.web.jwt;

import com.iquantex.common.cds.web.dao.model.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/** @Author wangpb @Date 2021/1/7 @Description */
@Slf4j
public class AuthenticationInterceptor extends HandlerInterceptorAdapter {

  private final String USER_NAME = "user_name";

  private final String REQUEST_ID = "request-id";

  @Override
  public boolean preHandle(
      HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object)
      throws Exception {
    String loginName = httpServletRequest.getHeader(USER_NAME);
    if (StringUtils.isNotBlank(loginName)) {
      // 查询表BOI_USER中看是或否可以查询到账户信息，如果可以查询到账户信息将userCode放到Session中
      User user = new User();
      user.setName(loginName);
      SysUserSession.initUser(user);

    } else {
      log.error("---------->未获取到USER_NAME");
    }
    String requestId = httpServletRequest.getHeader(REQUEST_ID);
    if (StringUtils.isNotBlank(requestId)) {
      //            log.info("---------->REQUEST_ID:" + requestId);
      SysUserSession.initRequestId(requestId);
    } else {
      //            log.info("---------->未获取到REQUEST_ID");
    }
    return true;
  }
}
