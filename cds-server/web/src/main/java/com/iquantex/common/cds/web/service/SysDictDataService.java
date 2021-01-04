package com.iquantex.common.cds.web.service;

import com.iquantex.common.cds.web.bean.dict.DictDataBean;
import com.iquantex.common.cds.web.dto.AddDictDataDTO;
import com.iquantex.common.cds.web.dto.UpdateDictDataDTO;
import com.iquantex.common.cds.web.dto.UpdateDictDataDefDTO;

import java.util.List;

public interface SysDictDataService {

    void addDictData(AddDictDataDTO inParam);

    void updateDictData(String dictKey, UpdateDictDataDTO inParam);

    void deleteDictData(String dictKey);

    void deleteDictDataDef(long id);

    void updateDictDataDef(Integer id, UpdateDictDataDefDTO inParam);

    List<DictDataBean> selectForDownload(String appId);
}