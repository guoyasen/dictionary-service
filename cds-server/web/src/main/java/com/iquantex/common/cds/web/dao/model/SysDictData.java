package com.iquantex.common.cds.web.dao.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.LocalTime;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author auto_generate
 * @since 2020-12-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_dict_data")
public class SysDictData implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String DICT_KEY = "DICT_KEY";

    public static final String APP_ID = "APP_ID";

    public static final String ID = "ID";

    @TableId("id")
    private Long id;

    @TableField("dict_key")
    private String dictKey;

    @TableField("remark")
    private String remark;

    @TableField("dict_name")
    private String dictName;

    @TableField("creator_id")
    private String creatorId;

    @TableField("create_time")
    private LocalDateTime createTime;

    @TableField("modifier_id")
    private String modifierId;

    @TableField("modify_time")
    private LocalDateTime modifyTime;

    @TableField("dict_value_type")
    private Integer dictValueType;

    @TableField("app_id")
    private String appId;


}
