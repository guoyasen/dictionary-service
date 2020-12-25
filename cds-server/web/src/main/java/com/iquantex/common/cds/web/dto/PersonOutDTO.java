package com.iquantex.common.cds.web.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author lan
 * @description:
 * @date 2020-12-16
 */
@ApiModel("人员信息")
@Data
public class PersonOutDTO {
  @ApiModelProperty(value = "名字")
  private String name;

  @ApiModelProperty(value = "年龄")
  private Integer age;

  @ApiModelProperty(value = "电话号码")
  private String number;

  @ApiModelProperty(value = "性别")
  private Integer gender;
}
