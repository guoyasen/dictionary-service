package com.iquantex.common.cds.web.dto;

import io.swagger.annotations.ApiModel;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * @author lan
 * @description:
 * @date 2020-12-16
 */
@ApiModel("字典信息")
@Data
public class DictDataOutDTO {
  private Long id;

  private String dictKey;

  private String remark;

  private String dictName;

  private String creatorId;

  private LocalDateTime createTime;

  private String modifierId;

  private LocalDateTime modifyTime;

  private Integer dictValueType;

  private String appId;
}
