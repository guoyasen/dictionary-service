package com.iquantex.common.cds.web.service.impl;

import com.iquantex.common.cds.web.dao.model.DictEntityPO;
import com.iquantex.common.cds.web.errorcode.CdsDictJsErrorCode;
import com.iquantex.common.cds.web.exception.AppException;
import com.iquantex.common.cds.web.service.DictService;
import com.iquantex.common.cds.web.tools.generator.DictGenerator;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/** Created by leo on 2017/6/8. */
@Slf4j
@Service
public class DictServiceImpl implements DictService {

  private static final Logger LOG = LoggerFactory.getLogger(DictServiceImpl.class);

  @Autowired private DictGenerator generator;

  @Override
  public String getContent(String appId, boolean isBlack) {

    try {
      log.info("传入的appIds为：" + appId);
      List<DictEntityPO> list = generator.listEntity(appId);
      return generator.getContent(list, isBlack);
    } catch (Exception e) {
      throw new AppException(CdsDictJsErrorCode.CDSDICTJS0001);
    }
  }
}
