package com.iquantex.common.cds.web.service.impl;

import com.iquantex.common.cds.web.service.IdGeneratorService;
import com.iquantex.common.cds.web.util.DateUtil;
import java.util.UUID;
import org.springframework.stereotype.Service;

/** @Author wangpb @Date 2020/11/2 @Description id生成器 */
@Service
public class IdGeneratorServiceImpl implements IdGeneratorService {

  private static int LENGTH = 8;

  @Override
  public String nextId() {
    return UUID.randomUUID().toString().replaceAll("-", "");
  }

  @Override
  public synchronized String nextId(Long tradeDate) {
    String idKey = "";
    String date = DateUtil.formatFromTimestamp(DateUtil.PATTERN_B, tradeDate);
    idKey = idKey + date;
    String id = "";
    id = idKey;
    return id;
  }
}
