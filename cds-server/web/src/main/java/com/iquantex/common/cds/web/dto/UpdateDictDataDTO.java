package com.iquantex.common.cds.web.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/** 字典修改 */
@ApiModel("字典修改")
@Data
public class UpdateDictDataDTO {
  /** 字典值列表 */
  @ApiModelProperty(value = "字典值列表")
  private List<DictDataDefDTO> data;
  /** 备注 */
  @ApiModelProperty(value = "备注")
  private String remark;

  /** 字典值类型 */
  @ApiModelProperty(value = "字典值类型")
  private Integer dictValueType;

  /** 字典名称 */
  @ApiModelProperty(value = "字典名称")
  private String dictName;

  /** 所属应用 */
  @ApiModelProperty(value = "所属应用")
  private String appId;
}
