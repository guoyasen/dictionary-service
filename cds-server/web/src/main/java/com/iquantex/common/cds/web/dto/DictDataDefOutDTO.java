package com.iquantex.common.cds.web.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author lan
 * @description:
 * @date 2020-12-16
 */
@ApiModel("字典子项信息")
@Data
public class DictDataDefOutDTO {
  private Long id;

  private Long sysDictDataId;

  private String value;

  private String name;

  private String enName;
}
