package com.iquantex.common.cds.web.service.impl;

import com.iquantex.common.cds.web.bean.dict.DictJSEntity;
import com.iquantex.common.cds.web.errorcode.CdsDictJsErrorCode;
import com.iquantex.common.cds.web.exception.AppException;
import com.iquantex.common.cds.web.service.DictJsService;
import com.iquantex.common.cds.web.tools.generator.DictJSGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;

/**
 * Created by leo on 2017/6/8.
 */
@Service
public class DictJsServiceImpl implements DictJsService {

    private static final Logger LOG = LoggerFactory.getLogger(DictJsServiceImpl.class);

    @Override
    public String getContent(String appId, boolean isBlack) {

        try {
            DictJSGenerator generator = new DictJSGenerator();
            List<DictJSEntity> list = generator.listEntity(appId);
            return generator.getContent(list, isBlack);
        } catch (Exception e) {
            throw new AppException(CdsDictJsErrorCode.CDSDICTJS0001);
        }
    }
}
