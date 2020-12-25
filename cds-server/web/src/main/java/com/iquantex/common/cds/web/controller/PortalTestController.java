package com.iquantex.common.cds.web.controller;

import com.iquantex.common.cds.web.util.ContextUtils;
import com.iquantex.portal.web.api.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yanliang
 * @date 12/18/2020 2:37 PM
 */
@Api(value = "获取当前用户接口")
@RestController
@RequestMapping("/portal/test")
public class PortalTestController {

  @ApiOperation("查询当前用户接口")
  @GetMapping
  public Response<String> list() {
    return Response.ok(ContextUtils.getUser(), "查询成功");
  }
}
