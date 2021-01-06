package com.iquantex.common.cds.web.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.iquantex.common.cds.web.dao.model.DictDataBeanPO;
import com.iquantex.common.cds.web.dao.model.SysDictData;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Mapper 接口
 *
 * @author auto_generate
 * @since 2020-12-29
 */
public interface SysDictDataMapper extends BaseMapper<SysDictData> {
  @Select(
      "SELECT a.dict_key,b.value,b.name,b.en_name,a.dict_value_type,a.remark,a.app_id,a.dict_name,a.id as dict_data_id,b.id as dict_data_def_id from sys_dict_data a left join sys_dict_data_def b on a.id = b.dict_id where app_id = #{appId}")
  List<DictDataBeanPO> getSysDictData(@Param("appId") String appId);
}
