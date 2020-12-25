package com.iquantex.common.cds.web.facade;

import com.iquantex.common.cds.web.dto.OrganizationCreateInDTO;
import com.iquantex.common.cds.web.dto.OrganizationOutDTO;
import com.iquantex.common.cds.web.dto.OrganizationUpdateInDTO;
import com.iquantex.portal.web.api.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 1. get请求如果有请求参数,需要在接口请求参数前增加@RequestParam 2. post,put请求如果有参数,需要在实现类的参数前面增加@RequestBody
 *
 * @author szj
 * @date 2020/12/18 11:30
 */
@Api(value = "feign调用测试接口")
public interface OrganizationFacade {

  /**
   * 创建组织
   *
   * @param inDTO 创建入参
   * @return 组织信息出参
   */
  @ApiOperation("创建组织")
  @PostMapping("/organizations")
  Response<OrganizationOutDTO> create(OrganizationCreateInDTO inDTO);

  /**
   * 查询组织信息
   *
   * @param code 组织编码
   * @return 组织信息
   */
  @GetMapping("/organizations/{code}")
  @ApiOperation("查询组织")
  Response<OrganizationOutDTO> query(
      @ApiParam("组织编码") @PathVariable("code") @RequestParam("code") String code);

  /**
   * 更新请求
   *
   * @param code 组织编码
   * @param inDTO 更新入参
   * @return 组织信息
   */
  @PutMapping("/organizations/{code}")
  @ApiOperation("更新组织信息")
  Response<OrganizationOutDTO> update(
      @ApiParam("组织编码") @PathVariable("code") String code, OrganizationUpdateInDTO inDTO);
}
