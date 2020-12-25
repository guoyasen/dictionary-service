package com.iquantex.common.cds.web.constant;

import com.baomidou.mybatisplus.annotation.EnumValue;

/**
 * @author yanliang
 * @date 12/18/2020 2:20 PM
 */
public enum PersonGenderEnum {
  MALE(1, "男"),
  FEMALE(2, "女");

  @EnumValue private final int value;

  private final String remark;

  PersonGenderEnum(final int value, final String remark) {
    this.value = value;
    this.remark = remark;
  }

  public static PersonGenderEnum vaule(int code) {
    switch (code) {
      case 1:
        return MALE;
      case 2:
        return FEMALE;
      default:
        return null;
    }
  }

  public int getValue() {
    return value;
  }

  public String getDescp() {
    return remark;
  }
}
