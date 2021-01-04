package com.iquantex.common.cds.web.dao.mapper;

import com.iquantex.common.cds.web.bean.dict.DictDataBean;
import com.iquantex.common.cds.web.bean.dict.VDictData;
import com.iquantex.common.cds.web.dao.model.SysDictData;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author auto_generate
 * @since 2020-12-29
 */
public interface SysDictDataMapper extends BaseMapper<SysDictData> {
    @Select("SELECT a.dict_key,b.value,b.name,b.en_name,a.dict_value_type,a.remark,a.app_id,a.dict_name,a.id as dict_data_id,b.id as dict_data_def_id from SYS_DICT_DATA a left join SYS_DICT_DATA_DEF b on a.id = b.sys_dict_data_id where app_id like #{appId}")
    List<DictDataBean> getVSysDictData(@Param("appId")String appId);
}
