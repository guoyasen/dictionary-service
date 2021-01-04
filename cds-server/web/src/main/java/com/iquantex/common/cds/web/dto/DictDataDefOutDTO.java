package com.iquantex.common.cds.web.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author lan
 * @description:
 * @date 2020-12-16
 */
@ApiModel("字典子项信息")
@Data
public class DictDataDefOutDTO {
  @ApiModelProperty(value = "字典详情主键ID")
  private Long id;

  @ApiModelProperty(value = "字典项ID")
  private Long sysDictDataId;

  @ApiModelProperty(value = "字典值")
  private String value;

  @ApiModelProperty(value = "字典翻译")
  private String name;

  @ApiModelProperty(value = "字典英文值")
  private String enName;
}
