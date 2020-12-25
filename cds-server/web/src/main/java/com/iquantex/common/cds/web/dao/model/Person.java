package com.iquantex.common.cds.web.dao.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.iquantex.common.cds.web.constant.PersonGenderEnum;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author auto_generate
 * @since 2020-12-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("person")
public class Person implements Serializable {

  private static final long serialVersionUID = 1L;

  @TableId("name")
  private String name;

  @TableField("age")
  private Integer age;

  @TableField("number")
  private String number;

  @TableField("gender")
  private PersonGenderEnum gender;
}
