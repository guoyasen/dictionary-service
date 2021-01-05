package com.iquantex.common.cds.web.controller;

import com.iquantex.common.cds.web.dao.model.SysDictData;
import com.iquantex.common.cds.web.dto.AddDictDataDTO;
import com.iquantex.common.cds.web.dto.DictDataOutDTO;
import com.iquantex.common.cds.web.dto.UpdateDictDataDTO;
import com.iquantex.common.cds.web.dto.UpdateDictDataDefDTO;
import com.iquantex.common.cds.web.service.SysDictDataService;
import com.iquantex.common.cds.web.transfer.DictTransfer;
import com.iquantex.portal.web.api.PageOutDTO;
import com.iquantex.portal.web.api.Response;
import com.iquantex.portal.web.query.service.QueryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/** 字典管理 */
@Api("字典管理")
@Slf4j
@RestController
@RequestMapping("/sys_dict_data")
public class SysDictDataController {

  @Autowired private SysDictDataService service;

  @Autowired private QueryService queryService;

  @ApiOperation("查询字典信息")
  @GetMapping
  public Response<PageOutDTO<DictDataOutDTO>> query(
      @RequestParam @ApiParam("通用查询语句") String query) {
    PageOutDTO<SysDictData> dictPage = queryService.query(query, SysDictData.class);
    PageOutDTO<DictDataOutDTO> dictOutDtoPage = DictTransfer.toDictOutResult(dictPage);
    return Response.ok(dictOutDtoPage, "查询成功");
  }

  /**
   * 增加数据字典（批量）
   *
   * @param inParam
   * @return
   */
  @PostMapping()
  @Valid
  public Response addDictData(@RequestBody AddDictDataDTO inParam) {
    service.addDictData(inParam);
    return Response.ok(null, "新增字典成功");
  }

  /**
   * 删除数据字典子项
   *
   * @param id
   * @return
   */
  @DeleteMapping("/defs/{id}")
  public Response deleteDictDataDef(@PathVariable Long id) {
    service.deleteDictDataDef(id);
    return Response.ok(null, "删除字典子项成功");
  }

  /**
   * 修改
   *
   * @param id
   * @param inParam
   * @return
   */
  @PutMapping("/{id}")
  @Valid
  public Response updateDictData(
      @PathVariable String id, @RequestBody UpdateDictDataDTO inParam) {
    service.updateDictData(id, inParam);
    return Response.ok(null, "修改字典成功");
  }

  /**
   * 修改数据字典子项
   *
   * @param id
   * @return
   */
  @PutMapping("/defs/{id}")
  public Response updateDictDataDef(
      @PathVariable Integer id, @RequestBody UpdateDictDataDefDTO inParam) {
    service.updateDictDataDef(id, inParam);
    return Response.ok(null, "修改字典子项成功");
  }

  /**
   * 删除数据字典
   *
   * @param id
   * @return
   */
  @DeleteMapping("/{id}")
  public Response deleteDictData(@PathVariable String id) {
    service.deleteDictData(id);
    return Response.ok(null, "删除字典成功");
  }
}
