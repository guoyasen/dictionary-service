package com.iquantex.common.cds.web.controller;

import com.iquantex.common.cds.web.dao.model.Person;
import com.iquantex.common.cds.web.dto.AddPersonInDTO;
import com.iquantex.common.cds.web.dto.PersonOutDTO;
import com.iquantex.common.cds.web.dto.UpdatePersonInDTO;
import com.iquantex.common.cds.web.service.PersonService;
import com.iquantex.common.cds.web.transfer.PersonTransfer;
import com.iquantex.portal.web.api.PageOutDTO;
import com.iquantex.portal.web.api.Response;
import com.iquantex.portal.web.query.service.QueryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lan
 * @description:
 * @date 2020-12-16
 */
@Api("人员管理")
@Slf4j
@RestController
@RequestMapping("/persons")
public class PersonController {

  @Autowired private PersonService service;

  @Autowired private QueryService queryService;

  @ApiOperation("查询人员信息")
  @GetMapping
  public Response<PageOutDTO<PersonOutDTO>> query(@RequestParam @ApiParam("通用查询语句") String query) {
    PageOutDTO<Person> personPage = queryService.query(query, Person.class);
    PageOutDTO<PersonOutDTO> personOutDtoPage = PersonTransfer.toPersonOutDtoPage(personPage);
    return Response.ok(personOutDtoPage, "查询成功");
  }

  @ApiOperation("新增人员")
  @PostMapping
  public Response add(@RequestBody @Valid AddPersonInDTO param) {
    service.add(param);
    return Response.ok(null, "新增人员成功");
  }

  @ApiOperation("删除人员信息")
  @DeleteMapping("/{name}")
  public Response delete(@PathVariable String name) {
    service.delete(name);
    return Response.ok(null, "删除人员信息成功");
  }

  @ApiOperation("更新人员信息")
  @PutMapping("/{name}")
  public Response update(@PathVariable String name, @RequestBody @Valid UpdatePersonInDTO param) {
    service.update(name, param);
    return Response.ok(null, "新增人员成功");
  }
}
