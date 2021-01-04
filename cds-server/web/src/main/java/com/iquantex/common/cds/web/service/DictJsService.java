package com.iquantex.common.cds.web.service;

/** Created by leo on 2017/6/8. */
public interface DictJsService {
  /**
   * 获取js内容
   *
   * @return
   */
  String getContent(String appId, boolean isBlack);
}
