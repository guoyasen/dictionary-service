package com.iquantex.common.cds.web.service.impl;

import com.iquantex.common.cds.web.dao.mapper.PersonMapper;
import com.iquantex.common.cds.web.dao.model.Person;
import com.iquantex.common.cds.web.dto.AddPersonInDTO;
import com.iquantex.common.cds.web.dto.UpdatePersonInDTO;
import com.iquantex.common.cds.web.errorcode.CdsPsnErrorCode;
import com.iquantex.common.cds.web.exception.AppException;
import com.iquantex.common.cds.web.service.PersonService;
import com.iquantex.common.cds.web.transfer.PersonTransfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lan
 * @description: TODO
 * @date 2020-12-16
 */
@Service
public class PersonServiceImpl implements PersonService {

  @Autowired private PersonMapper personMapper;

  /**
   * 新增人员
   *
   * @param inDTO
   */
  @Override
  public void add(AddPersonInDTO inDTO) {
    Person person = personMapper.selectById(inDTO.getName());
    if (person != null) {
      throw new AppException(CdsPsnErrorCode.CDSPSN0001, inDTO.getName());
    }
    person = PersonTransfer.toPerson(inDTO);
    personMapper.insert(person);
  }

  /**
   * 删除人员
   *
   * @param name
   */
  @Override
  public void delete(String name) {
    personMapper.deleteById(name);
  }

  /**
   * 更新人员信息
   *
   * @param name
   * @param inDTO
   */
  @Override
  public void update(String name, UpdatePersonInDTO inDTO) {
    Person person = personMapper.selectById(name);
    if (person == null) {
      throw new AppException(CdsPsnErrorCode.CDSPSN0002, name);
    }
    person = PersonTransfer.toPerson(name, inDTO);
    personMapper.updateById(person);
  }
}
