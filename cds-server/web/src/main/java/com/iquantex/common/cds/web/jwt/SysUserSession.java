package com.iquantex.common.cds.web.jwt;

import com.iquantex.common.cds.web.dao.model.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** @author @创建时间 2020/9/20 @描述 */
public class SysUserSession {
  // 声明
  private static ThreadLocal<SysUserSession> local = new ThreadLocal<SysUserSession>();
  private HttpServletRequest request;
  private HttpServletResponse response;
  private String requestId;
  private User user;

  /**
   * 赋值
   *
   * @param session
   */
  public static void set(SysUserSession session) {
    local.set(session);
  }

  /**
   * 设置user
   *
   * @param user
   */
  public static void initUser(User user) {
    SysUserSession session = get();
    session.setUser(user);
  }

  /**
   * 设置reuestId
   *
   * @param requestId
   */
  public static void initRequestId(String requestId) {
    SysUserSession session = get();
    session.setRequestId(requestId);
  }

  /**
   * 取值
   *
   * @return
   */
  public static SysUserSession get() {
    SysUserSession session = local.get();
    if (null == session) {
      session = new SysUserSession();
      local.set(session);
    }
    return session;
  }

  /** 移除 */
  public static void remove() {
    local.remove();
  }

  public HttpServletRequest getRequest() {
    return request;
  }

  public void setRequest(HttpServletRequest request) {
    this.request = request;
  }

  public HttpServletResponse getResponse() {
    return response;
  }

  public void setResponse(HttpServletResponse response) {
    this.response = response;
  }

  public String getRequestId() {
    return requestId;
  }

  public void setRequestId(String requestId) {
    this.requestId = requestId;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }
}
