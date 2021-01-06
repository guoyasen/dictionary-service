package com.iquantex.common.cds.web.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/** 字典子项修改 */
@ApiModel("字典子项修改")
@Data
public class UpdateDictDataDefDTO {
  /** 字典值 */
  @ApiModelProperty(value = "字典值")
  private String value;
  /** 中文翻译 */
  @ApiModelProperty(value = "中文翻译")
  private String name;
  /** 字典英文值 */
  @ApiModelProperty(value = "字典英文值")
  private String enName;
}
