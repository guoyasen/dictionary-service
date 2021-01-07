package com.iquantex.common.cds.web.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.iquantex.common.cds.web.dao.mapper.SysDictDataDefMapper;
import com.iquantex.common.cds.web.dao.mapper.SysDictDataMapper;
import com.iquantex.common.cds.web.dao.model.DictDataBeanPO;
import com.iquantex.common.cds.web.dao.model.SysDictData;
import com.iquantex.common.cds.web.dao.model.SysDictDataDef;
import com.iquantex.common.cds.web.dao.model.User;
import com.iquantex.common.cds.web.dto.AddDictDataDTO;
import com.iquantex.common.cds.web.dto.DictDataDefDTO;
import com.iquantex.common.cds.web.dto.UpdateDictDataDTO;
import com.iquantex.common.cds.web.dto.UpdateDictDataDefDTO;
import com.iquantex.common.cds.web.errorcode.CdsDictErrorCode;
import com.iquantex.common.cds.web.exception.AppException;
import com.iquantex.common.cds.web.jwt.SysUserSession;
import com.iquantex.common.cds.web.service.SysDictDataService;
import java.time.LocalDateTime;
import java.util.*;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class SysDictDataServiceImpl implements SysDictDataService {

  @Autowired private SysDictDataMapper dao;
  @Autowired private SysDictDataDefMapper dictDataDefDao;

  @Transactional
  @Override
  @Valid
  public void addDictData(AddDictDataDTO inParam) {
    String dictKey = inParam.getDictKey();

    // 校验新存的,和之前的是否重复
    QueryWrapper<SysDictData> wrapper = new QueryWrapper<>();
    wrapper
        .eq(SysDictData.DICT_KEY, inParam.getDictKey())
        .eq(SysDictData.APP_ID, inParam.getAppId());
    SysDictData dictData = dao.selectOne(wrapper);

    if (null != dictData) {
      throw new AppException(CdsDictErrorCode.CDSDICT0001, dictKey);
    }

    List<DictDataDefDTO> props = inParam.getDicts();
    dictData = new SysDictData();
    dictData.setRemark(inParam.getRemark());
    dictData.setDictKey(dictKey);
    dictData.setDictValueType(inParam.getDictValueType());
    dictData.setAppId(inParam.getAppId());
    dictData.setDictName(inParam.getDictName());
    String dictDateId = inParam.getAppId() + "_" + dictKey;
    dictData.setId(dictDateId);
    // TODO 如何获得用户ID

    User user = SysUserSession.get().getUser();
    if (Objects.nonNull(user)) {
      dictData.setCreatorId(user.getName());
    }
    dictData.setCreateTime(LocalDateTime.now());
    dao.insert(dictData);
    // 添加值信息
    insertDictDef(props, dictDateId, dictDateId);
    return;
  }

  // 因为目前只有静态字典，所以去除判断
  /*private void assertType(Integer type, int size) {
      if (SysDictData.c_type_dynamic.equals(type) && size > 1) {
          throw new SystemException("动态数据字典只能有一个子项");
      }
  }*/

  private void insertDictDef(List<DictDataDefDTO> props, String dictDateId, String dictDataId) {
    Map<String, DictDataDefDTO> dictDataDataInPropMap = new HashMap<>();
    if (Objects.isNull(props) || props.isEmpty()) {
      throw new AppException(CdsDictErrorCode.CDSDICT0009);
    }
    for (DictDataDefDTO prop : props) {
      String key = prop.getValue();
      if (dictDataDataInPropMap.containsKey(key)) {
        throw new AppException(CdsDictErrorCode.CDSDICT0002, dictDateId, key);
      } else {
        dictDataDataInPropMap.put(key, prop);
      }

      SysDictDataDef dictDataDef = new SysDictDataDef();
      BeanUtils.copyProperties(prop, dictDataDef);
      dictDataDef.setId(dictDateId + "_" + prop.getValue());
      dictDataDef.setDictId(dictDataId);

      dictDataDefDao.insert(dictDataDef);
    }
  }

  @Transactional
  @Override
  @Valid
  public void updateDictData(String dictId, UpdateDictDataDTO inParam) {

    SysDictData dictData = dao.selectById(dictId);

    if (null == dictData) {
      throw new AppException(CdsDictErrorCode.CDSDICT0003);
    }

    List<DictDataDefDTO> props = inParam.getDicts();
    dictData = new SysDictData();
    dictData.setDictKey(dictData.getDictKey());
    dictData.setRemark(inParam.getRemark());
    dictData.setDictValueType(inParam.getDictValueType());
    dictData.setDictName(inParam.getDictName());
    dictData.setAppId(inParam.getAppId());
    dictData.setId(dictId);
    // TODO 如何获取用户ID
    User user = SysUserSession.get().getUser();

    if (Objects.nonNull(user)) {
      dictData.setModifierId(user.getName());
    }
    dictData.setModifyTime(LocalDateTime.now());
    dao.updateById(dictData);

    // 删除原数据字典子项
    QueryWrapper<SysDictDataDef> defWrapper = new QueryWrapper<>();
    defWrapper.eq(SysDictDataDef.DICT_ID, dictData.getId());
    dictDataDefDao.delete(defWrapper);
    // 子项入库
    insertDictDef(props, dictData.getId(), dictData.getId());
  }

  /**
   * 修改数据字典子项
   *
   * @param id
   * @param inParam
   */
  @Override
  @Valid
  public void updateDictDataDef(String id, UpdateDictDataDefDTO inParam) {
    log.info("进入修改字典子项方法");
    SysDictDataDef dictDataDef = dictDataDefDao.selectById(id);
    if (null == dictDataDef) {
      throw new AppException(CdsDictErrorCode.CDSDICT0004, id);
    }

    // 如果修改了数据字典值，则需要判断是否唯一
    if (!dictDataDef.getValue().equals(inParam.getValue())) {
      QueryWrapper<SysDictDataDef> wrapper = new QueryWrapper<>();
      wrapper
          .eq(SysDictDataDef.DICT_ID, dictDataDef.getDictId())
          .eq(SysDictDataDef.VALUE, inParam.getValue());
      int count = dictDataDefDao.selectCount(wrapper);
      if (count > 0) {
        throw new AppException(CdsDictErrorCode.CDSDICT0005, inParam.getValue());
      }
    }

    log.info("修改字典子项，开始修改表数据");
    SysDictDataDef newDictDataDef = new SysDictDataDef();
    BeanUtils.copyProperties(inParam, newDictDataDef);
    newDictDataDef.setId(String.valueOf(id));
    dictDataDefDao.updateById(newDictDataDef);
  }

  @Override
  public List<DictDataBeanPO> selectForDownload(String appId) {
    return dao.getSysDictData(appId);
  }

  @Transactional
  @Override
  public void deleteDictData(String dictDataId) {
    QueryWrapper<SysDictData> wrapper = new QueryWrapper<>();
    wrapper.eq(SysDictData.ID, dictDataId);
    SysDictData dictData = dao.selectOne(wrapper);

    if (null == dictData) {
      throw new AppException(CdsDictErrorCode.CDSDICT0003);
    }

    // 删除数据字典
    dao.delete(wrapper);

    // 删除子项
    QueryWrapper<SysDictDataDef> defWrapper = new QueryWrapper<>();
    defWrapper.eq(SysDictDataDef.DICT_ID, dictDataId);
    dictDataDefDao.delete(defWrapper);
  }

  @Transactional
  @Override
  public void deleteDictDataDef(String id) {
    SysDictDataDef dictDataDef = dictDataDefDao.selectById(id);
    if (null == dictDataDef) {
      throw new AppException(CdsDictErrorCode.CDSDICT0008);
    }
    SysDictData sysDictData = dao.selectById(dictDataDef.getDictId());
    // 判断数据字典子项是否存在，如果不存在那么不进行删除唯一子字典操作
    QueryWrapper<SysDictDataDef> wrapper = new QueryWrapper<>();
    wrapper.eq(SysDictDataDef.DICT_ID, dictDataDef.getDictId());
    List<SysDictDataDef> sysDictDataDefList = dictDataDefDao.selectList(wrapper);
    if (!sysDictDataDefList.isEmpty() && sysDictDataDefList.size() == 1) {
      throw new AppException(CdsDictErrorCode.CDSDICT0006, sysDictData.getDictKey());
    }

    int num = dictDataDefDao.deleteById(id);
    if (num != 1) {
      throw new AppException(CdsDictErrorCode.CDSDICT0007);
    }
  }
}
