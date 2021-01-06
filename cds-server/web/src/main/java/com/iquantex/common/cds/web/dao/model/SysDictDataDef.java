package com.iquantex.common.cds.web.dao.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author auto_generate
 * @since 2020-12-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_dict_data_def")
public class SysDictDataDef implements Serializable {

  private static final long serialVersionUID = 1L;

  public static final String SYS_DICT_DATA_ID = "SYS_DICT_DATA_ID";

  public static final String VALUE = "VALUE";

  @TableId(value = "id")
  private String id;

  @TableField("dict_id")
  private String dictId;

  @TableField("value")
  private String value;

  @TableField("name")
  private String name;

  @TableField("en_name")
  private String enName;
}
