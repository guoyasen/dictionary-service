package com.iquantex.common.cds.web.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author gys
 * @date 2020/12/31
 */
@ApiModel("字典下载入参")
@Data
public class DictDownloadInDTO {
  @ApiModelProperty(value = "所属应用")
  private String appId;

  public String getAppId() {
    return appId;
  }

  public void setAppId(String appId) {
    this.appId = appId;
  }
}
