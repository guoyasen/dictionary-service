package com.iquantex.common.cds.web.transfer;

import com.iquantex.common.cds.web.dao.model.SysDictData;
import com.iquantex.common.cds.web.dto.DictDataOutDTO;
import com.iquantex.portal.web.api.PageOutDTO;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;

/**
 * @author lan
 * @description: TODO
 * @date 2020-12-16
 */
public class DictTransfer {

  public static PageOutDTO<DictDataOutDTO> toDictOutDTOPage(PageOutDTO<SysDictData> dictPage) {
    PageOutDTO<DictDataOutDTO> dictOutDTOPage = new PageOutDTO<>();
    dictOutDTOPage.setTotalRecord(dictPage.getTotalRecord());
    dictOutDTOPage.setList(new ArrayList<>());
    if (CollectionUtils.isEmpty(dictPage.getList())) {
      return dictOutDTOPage;
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
                dictOutDTOPage.getList().add(outDTO);
            });
    return dictOutDTOPage;
  }
}
