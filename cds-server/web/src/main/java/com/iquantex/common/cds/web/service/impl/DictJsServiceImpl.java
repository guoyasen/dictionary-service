package com.iquantex.common.cds.web.service.impl;

import com.iquantex.common.cds.web.dao.model.DictEntityPO;
import com.iquantex.common.cds.web.errorcode.CdsDictJsErrorCode;
import com.iquantex.common.cds.web.exception.AppException;
import com.iquantex.common.cds.web.service.DictJsService;
import com.iquantex.common.cds.web.tools.generator.DictGenerator;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/** Created by leo on 2017/6/8. */
@Service
public class DictJsServiceImpl implements DictJsService {

  private static final Logger LOG = LoggerFactory.getLogger(DictJsServiceImpl.class);

  @Override
  public String getContent(String appId, boolean isBlack) {

    try {
      DictGenerator generator = new DictGenerator();
      List<DictEntityPO> list = generator.listEntity(appId);
      return generator.getContent(list, isBlack);
    } catch (Exception e) {
      throw new AppException(CdsDictJsErrorCode.CDSDICTJS0001);
    }
  }
}
