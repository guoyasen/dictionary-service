package com.iquantex.common.cds.web.controller;

import com.iquantex.common.cds.web.dao.model.SysDictDataDef;
import com.iquantex.common.cds.web.dto.*;
import com.iquantex.common.cds.web.transfer.DictDefTransfer;
import com.iquantex.portal.web.api.PageOutDTO;
import com.iquantex.portal.web.api.Response;
import com.iquantex.portal.web.query.service.QueryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/** 字典管理 */
@Api("字典子项管理")
@Slf4j
@RestController
@RequestMapping("/sys_dict_data_def")
public class SysDictDataDefController {

  @Autowired private QueryService queryService;

  @ApiOperation("查询字典子项信息")
  @GetMapping
  public Response<PageOutDTO<DictDataDefOutDTO>> query(
      @RequestParam @ApiParam("通用查询语句") String query) {
    PageOutDTO<SysDictDataDef> DictDefPage = queryService.query(query, SysDictDataDef.class);
    PageOutDTO<DictDataDefOutDTO> dictDefOutDTOPage =
        DictDefTransfer.toDictDefOutDTOPage(DictDefPage);
    return Response.ok(dictDefOutDTOPage, "查询成功");
  }
}
