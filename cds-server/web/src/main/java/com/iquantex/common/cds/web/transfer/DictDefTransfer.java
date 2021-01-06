package com.iquantex.common.cds.web.transfer;

import com.iquantex.common.cds.web.dao.model.SysDictDataDef;
import com.iquantex.common.cds.web.dto.DictDataDefOutDTO;
import com.iquantex.portal.web.api.PageOutDTO;
import java.util.ArrayList;
import org.springframework.util.CollectionUtils;

/**
 * @author lan
 * @description: TODO
 * @date 2020-12-16
 */
public class DictDefTransfer {

  public static PageOutDTO<DictDataDefOutDTO> toDictDefOutResult(
      PageOutDTO<SysDictDataDef> dictDefPage) {
    PageOutDTO<DictDataDefOutDTO> dictOutDefDtoPage = new PageOutDTO<>();
    dictOutDefDtoPage.setTotalRecord(dictDefPage.getTotalRecord());
    dictOutDefDtoPage.setList(new ArrayList<>());
    if (CollectionUtils.isEmpty(dictDefPage.getList())) {
      return dictOutDefDtoPage;
    }
    dictDefPage
        .getList()
        .forEach(
            dict -> {
              DictDataDefOutDTO outDTO = new DictDataDefOutDTO();
              outDTO.setDictId(dict.getDictId());
              outDTO.setEnName(dict.getEnName());
              outDTO.setId(dict.getId());
              outDTO.setName(dict.getName());
              outDTO.setEnName(dict.getEnName());
              outDTO.setValue(dict.getValue());
              dictOutDefDtoPage.getList().add(outDTO);
            });
    return dictOutDefDtoPage;
  }
}
