package com.iquantex.common.cds.web.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import lombok.Data;
import lombok.ToString;

/**
 * @author szj
 * @date 2020/12/18 11:21
 */
@Data
@ToString
@ApiModel("更新组织入参")
public class OrganizationUpdateInDTO {

  @ApiModelProperty("组织编码")
  @NotBlank(message = "组织编码不能为空")
  private String code;

  @ApiModelProperty("组织信息")
  private String info;
}
