package com.iquantex.common.cds.web.facade.imp;

import com.iquantex.portal.web.api.Response;
import com.iquantex.common.cds.web.dto.OrganizationCreateInDTO;
import com.iquantex.common.cds.web.dto.OrganizationOutDTO;
import com.iquantex.common.cds.web.dto.OrganizationUpdateInDTO;
import com.iquantex.common.cds.web.facade.OrganizationFacade;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author szj
 * @date 2020/12/18 11:40
 */
@RestController
public class OrganizationFacadeImpl implements OrganizationFacade {

  @Override
  public Response<OrganizationOutDTO> create(@Valid @RequestBody OrganizationCreateInDTO inDTO) {
    return Response.ok(new OrganizationOutDTO(inDTO.getCode(), inDTO.getInfo()), "请求成功");
  }

  @Override
  public Response<OrganizationOutDTO> query(String code) {
    return Response.ok(new OrganizationOutDTO(code, "info code:" + code), "请求成功");
  }

  @Override
  public Response<OrganizationOutDTO> update(
      String code, @Valid @RequestBody OrganizationUpdateInDTO inDTO) {
    return Response.ok(new OrganizationOutDTO(inDTO.getCode(), inDTO.getInfo()), "请求成功");
  }
}
