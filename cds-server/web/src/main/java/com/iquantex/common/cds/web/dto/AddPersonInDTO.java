package com.iquantex.common.cds.web.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 * @author yanliang
 * @date 12/17/2020 3:05 PM
 */
@ApiModel("新增人员入参")
@Data
public class AddPersonInDTO {

  @ApiModelProperty(value = "名字", required = true)
  @NotBlank(message = "名字不能为空")
  private String name;

  @ApiModelProperty(value = "年龄", required = true)
  @Min(value = 0, message = "年龄不能小于0岁")
  @Max(value = 200, message = "年龄不能超过200岁")
  private Integer age;

  @ApiModelProperty(value = "电话号码", required = true)
  @NotBlank(message = "电话号码不能为空")
  private String number;

  @ApiModelProperty(value = "性别", required = true)
  @NotNull(message = "性别不能为空")
  private Integer gender;
}
