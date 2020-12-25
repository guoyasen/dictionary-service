package com.iquantex.common.cds.web.service;

import com.iquantex.portal.web.api.PageOutDTO;
import com.iquantex.portal.web.query.service.QueryService;
import com.iquantex.common.cds.web.dao.model.Person;
import com.iquantex.common.cds.web.dto.AddPersonInDTO;
import com.iquantex.common.cds.web.dto.UpdatePersonInDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author yanliang
 * @date 12/17/2020 3:33 PM
 */
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class PersonServiceImplTest {

  @Autowired private PersonService personService;

  @Autowired private QueryService queryService;

  @Test
  public void query_test() {

    String query =
        "{\"filterGroup\":{\"op\":\"and\",\"groups\":[{\"op\":\"and\",\"rules\":[]}]},\"searchRule\":{\"page\":1,\"pageSize\":20}}";

    AddPersonInDTO inDTO = new AddPersonInDTO();
    inDTO.setName("test");
    inDTO.setAge(18);
    inDTO.setNumber("6666666");
    inDTO.setGender(1);

    // 新增 & 校验
    personService.add(inDTO);
    PageOutDTO<Person> persons = queryService.query(query, Person.class);
    Assert.assertEquals(1, persons.getTotalRecord());
    Assert.assertEquals("test", persons.getList().get(0).getName());

    // 更新 & 校验
    UpdatePersonInDTO updateInDTO = new UpdatePersonInDTO();
    updateInDTO.setAge(19);
    updateInDTO.setGender(2);
    updateInDTO.setNumber("77777");
    personService.update(inDTO.getName(), updateInDTO);
    PageOutDTO<Person> persons1 = queryService.query(query, Person.class);
    Assert.assertEquals(1, persons1.getTotalRecord());
    Assert.assertEquals(19, persons1.getList().get(0).getAge().intValue());

    // 删除 & 校验
    personService.delete(persons.getList().get(0).getName());
    PageOutDTO<Person> persons2 = queryService.query(query, Person.class);
    Assert.assertEquals(0, persons2.getTotalRecord());
  }
}
