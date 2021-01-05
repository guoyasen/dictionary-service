package com.iquantex.common.cds.web.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import lombok.Data;

/** 字典值列表$DictDataDef */
@ApiModel("新增字典详情入参")
@Data
public class DictDataDefDTO {
  /** 字典翻译 */
  @ApiModelProperty(value = "字典翻译")
  @NotBlank(message = "字典翻译不能为空")
  private String name;
  /** 字典值 */
  @ApiModelProperty(value = "字典值")
  @NotBlank(message = "字典值不能为空")
  private String value;
  /** 字典英文值 */
  @ApiModelProperty(value = "字典英文值")
  @NotBlank(message = "字典英文值不能为空")
  private String enName;
}
