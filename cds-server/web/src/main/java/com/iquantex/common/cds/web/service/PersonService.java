package com.iquantex.common.cds.web.service;

import com.iquantex.common.cds.web.dto.AddPersonInDTO;
import com.iquantex.common.cds.web.dto.UpdatePersonInDTO;

/**
 * @author lan
 * @description: TODO
 * @date 2020-12-16
 */
public interface PersonService {

  void add(AddPersonInDTO inDTO);

  void delete(String name);

  void update(String name, UpdatePersonInDTO inDTO);
}
