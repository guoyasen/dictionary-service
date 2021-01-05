package com.iquantex.common.cds.web.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/** 增加数据字典 */
@ApiModel("新增字典入参")
@Data
public class AddDictDataDTO {
  /** 字典值列表 */
  @ApiModelProperty(value = "字典值列表")
  private List<DictDataDefDTO> data;
  /** 备注 */
  @ApiModelProperty(value = "备注")
  private String remark;
  /** 字典key' */
  @ApiModelProperty(value = "字典KEY")
  @NotBlank(message = "字典KEY不能为空")
  private String dictKey;
  /** 字典值类型 */
  @ApiModelProperty(value = "字典值类型")
  private Integer dictValueType;

  /** 字典名称 */
  @ApiModelProperty(value = "字典名称")
  @NotBlank(message = "字典名称不能为空")
  private String dictName;

  /** 所属应用 */
  @ApiModelProperty(value = "所属应用")
  @NotBlank(message = "所属应用不能为空")
  private String appId;
}
