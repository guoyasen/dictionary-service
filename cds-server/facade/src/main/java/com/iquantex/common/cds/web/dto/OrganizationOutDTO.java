package com.iquantex.common.cds.web.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author szj
 * @date 2020/12/18 13:43
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("组织信息")
public class OrganizationOutDTO {

  @ApiModelProperty("组织编码")
  private String code;

  @ApiModelProperty("组织信息")
  private String info;
}
