package com.iquantex.common.cds.web.transfer;

import com.iquantex.common.cds.web.dao.model.SysDictData;
import com.iquantex.common.cds.web.dao.model.SysDictDataDef;
import com.iquantex.common.cds.web.dto.DictDataDefOutDTO;
import com.iquantex.common.cds.web.dto.DictDataOutDTO;
import com.iquantex.portal.web.api.PageOutDTO;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;

/**
 * @author lan
 * @description: TODO
 * @date 2020-12-16
 */
public class DictDefTransfer {

  public static PageOutDTO<DictDataDefOutDTO> toDictDefOutDTOPage(PageOutDTO<SysDictDataDef> dictDefPage) {
    PageOutDTO<DictDataDefOutDTO> dictOutDefDTOPage = new PageOutDTO<>();
    dictOutDefDTOPage.setTotalRecord(dictDefPage.getTotalRecord());
    dictOutDefDTOPage.setList(new ArrayList<>());
    if (CollectionUtils.isEmpty(dictDefPage.getList())) {
      return dictOutDefDTOPage;
    }
    dictDefPage
        .getList()
        .forEach(
            dict -> {
                DictDataDefOutDTO outDTO = new DictDataDefOutDTO();
                outDTO.setSysDictDataId(dict.getSysDictDataId());
                outDTO.setEnName(dict.getEnName());
                outDTO.setId(dict.getId());
                outDTO.setName(dict.getName());
                outDTO.setEnName(dict.getEnName());
                outDTO.setValue(dict.getValue());
                dictOutDefDTOPage.getList().add(outDTO);
            });
    return dictOutDefDTOPage;
  }
}
