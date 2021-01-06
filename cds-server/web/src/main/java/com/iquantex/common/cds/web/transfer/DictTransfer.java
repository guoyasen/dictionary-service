package com.iquantex.common.cds.web.transfer;

import com.iquantex.common.cds.web.dao.model.SysDictData;
import com.iquantex.common.cds.web.dto.DictDataOutDTO;
import com.iquantex.portal.web.api.PageOutDTO;
import java.util.ArrayList;
import org.springframework.util.CollectionUtils;

/**
 * @author lan
 * @description: TODO
 * @date 2020-12-16
 */
public class DictTransfer {

  public static PageOutDTO<DictDataOutDTO> toDictOutResult(PageOutDTO<SysDictData> dictPage) {
    PageOutDTO<DictDataOutDTO> dictOutDtoPage = new PageOutDTO<>();
    dictOutDtoPage.setTotalRecord(dictPage.getTotalRecord());
    dictOutDtoPage.setList(new ArrayList<>());
    if (CollectionUtils.isEmpty(dictPage.getList())) {
      return dictOutDtoPage;
    }
    dictPage
        .getList()
        .forEach(
            dict -> {
              DictDataOutDTO outDTO = new DictDataOutDTO();
              outDTO.setId(dict.getId());
              outDTO.setDictKey(dict.getDictKey());
              outDTO.setAppId(dict.getAppId());
              outDTO.setCreateTime(dict.getCreateTime());
              outDTO.setCreatorId(dict.getCreatorId());
              outDTO.setDictName(dict.getDictName());
              outDTO.setDictValueType(dict.getDictValueType());
              outDTO.setModifierId(dict.getModifierId());
              outDTO.setModifyTime(dict.getModifyTime());
              outDTO.setRemark(dict.getRemark());
              dictOutDtoPage.getList().add(outDTO);
            });
    return dictOutDtoPage;
  }
}
