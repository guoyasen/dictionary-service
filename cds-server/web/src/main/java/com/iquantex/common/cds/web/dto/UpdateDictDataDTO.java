package com.iquantex.common.cds.web.dto;

import java.util.List;

/** 字典修改 */
public class UpdateDictDataDTO {
  /** 字典值列表 */
  private List<DictDataDefDTO> data;
  /** 备注 */
  private String remark;

  /** 字典值类型 */
  private Integer dictValueType;

  /** 字典名称 */
  private String dictName;

  /** 所属应用 */
  private String appId;

  /** 获取字典值列表 */
  public List<DictDataDefDTO> getData() {
    return this.data;
  }

  /** 设置字典值列表 */
  public void setData(List<DictDataDefDTO> data) {
    this.data = data;
  }

  /** 获取备注 */
  public String getRemark() {
    return this.remark;
  }

  /** 设置备注 */
  public void setRemark(String remark) {
    this.remark = remark;
  }

  public Integer getDictValueType() {
    return dictValueType;
  }

  public void setDictValueType(Integer dictValueType) {
    this.dictValueType = dictValueType;
  }

  /**
   * 获取字典名称
   *
   * @return
   */
  public String getDictName() {
    return dictName;
  }

  /**
   * 设置字典名称
   *
   * @param dictName
   */
  public void setDictName(String dictName) {
    this.dictName = dictName;
  }

  /**
   * 获取所属应用
   *
   * @return
   */
  public String getAppId() {
    return appId;
  }

  /**
   * 设置所属应用
   *
   * @param appId
   */
  public void setAppId(String appId) {
    this.appId = appId;
  }
}
