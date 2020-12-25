package com.iquantex.common.cds.web.transfer;

import com.iquantex.common.cds.web.constant.PersonGenderEnum;
import com.iquantex.common.cds.web.dao.model.Person;
import com.iquantex.common.cds.web.dto.AddPersonInDTO;
import com.iquantex.common.cds.web.dto.PersonOutDTO;
import com.iquantex.common.cds.web.dto.UpdatePersonInDTO;
import com.iquantex.portal.web.api.PageOutDTO;
import java.util.ArrayList;
import org.springframework.util.CollectionUtils;

/**
 * @author lan
 * @description: TODO
 * @date 2020-12-16
 */
public class PersonTransfer {

  public static PageOutDTO<PersonOutDTO> toPersonOutDTOPage(PageOutDTO<Person> personPage) {
    PageOutDTO<PersonOutDTO> personOutDTOPage = new PageOutDTO<>();
    personOutDTOPage.setTotalRecord(personPage.getTotalRecord());
    personOutDTOPage.setList(new ArrayList<>());
    if (CollectionUtils.isEmpty(personPage.getList())) {
      return personOutDTOPage;
    }
    personPage
        .getList()
        .forEach(
            person -> {
              PersonOutDTO outDTO = new PersonOutDTO();
              outDTO.setName(person.getName());
              outDTO.setAge(person.getAge());
              outDTO.setNumber(person.getNumber());
              outDTO.setGender(person.getGender().getValue());
              personOutDTOPage.getList().add(outDTO);
            });
    return personOutDTOPage;
  }

  public static Person toPerson(String name, UpdatePersonInDTO inDTO) {
    Person person = new Person();
    person.setName(name);
    person.setAge(inDTO.getAge());
    person.setNumber(inDTO.getNumber());
    person.setGender(PersonGenderEnum.vaule(inDTO.getGender()));
    return person;
  }

  public static Person toPerson(AddPersonInDTO inDTO) {
    Person person = new Person();
    person.setName(inDTO.getName());
    person.setAge(inDTO.getAge());
    person.setNumber(inDTO.getNumber());
    person.setGender(PersonGenderEnum.vaule(inDTO.getGender()));
    return person;
  }
}
