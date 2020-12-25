package com.iquantex.common.cds.web.controller;

import com.iquantex.common.cds.web.dto.OrganizationCreateInDTO;
import com.iquantex.common.cds.web.dto.OrganizationOutDTO;
import com.iquantex.common.cds.web.dto.OrganizationUpdateInDTO;
import com.iquantex.common.cds.web.facade.OrganizationFacade;
import com.iquantex.portal.web.api.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author szj
 * @date 20:11 2020/12/18
 */
@Api(value = "feign调用测试接口")
@RestController
@RequestMapping("/feign/test")
public class FeignTestController {

  @Resource private OrganizationFacade feign;

  @GetMapping("/post")
  @ApiOperation("post测试接口")
  public Response<OrganizationOutDTO> postTest() {
    OrganizationCreateInDTO inDTO = new OrganizationCreateInDTO();
    inDTO.setCode("post code");
    inDTO.setInfo("organization info");
    return feign.create(inDTO);
  }

  @GetMapping("/get")
  @ApiOperation("get测试接口")
  public Response<OrganizationOutDTO> getTest() {
    return feign.query("get code");
  }

  @GetMapping("/update")
  @ApiOperation("put测试接口")
  public Response<OrganizationOutDTO> putTest() {
    OrganizationUpdateInDTO inDTO = new OrganizationUpdateInDTO();
    inDTO.setCode("update code");
    inDTO.setInfo("organization info");
    return feign.update(inDTO.getCode(), inDTO);
  }
}
