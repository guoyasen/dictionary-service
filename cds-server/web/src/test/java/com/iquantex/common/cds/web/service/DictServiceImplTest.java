package com.iquantex.common.cds.web.service;

import com.iquantex.common.cds.web.dao.model.SysDictData;
import com.iquantex.common.cds.web.dao.model.SysDictDataDef;
import com.iquantex.common.cds.web.dto.*;
import com.iquantex.portal.web.api.PageOutDTO;
import com.iquantex.portal.web.query.service.QueryService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
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
public class DictServiceImplTest {

  @Autowired private SysDictDataService dictDataService;

  @Autowired private QueryService queryService;

  @Autowired private IdGeneratorService idGeneratorService;

  @Test
  public void query_test() {

    String query =
        "{\"filterGroup\":{\"op\":\"and\",\"groups\":[{\"op\":\"and\",\"rules\":[]}]},\"searchRule\":{\"page\":1,\"pageSize\":20}}";

    AddDictDataDTO inDTO = new AddDictDataDTO();
    inDTO.setDictKey("test");
    inDTO.setDictValueType(1);
    inDTO.setRemark("备注");
    inDTO.setDictName("测试");
    inDTO.setAppId("boi");
    List<DictDataDefDTO> data = new ArrayList<>();
    DictDataDefDTO dictDataDefDTO = new DictDataDefDTO();
    dictDataDefDTO.setEnName("test_1");
    dictDataDefDTO.setValue("1");
    dictDataDefDTO.setName("测试1");
    data.add(dictDataDefDTO);
    inDTO.setDicts(data);

    // 新增 & 校验
    dictDataService.addDictData(inDTO);
    PageOutDTO<SysDictData> sysDictData = queryService.query(query, SysDictData.class);
    //    Assert.assertEquals("test", sysDictData.getList().get(0).getDictKey());

    // 更新字典 & 校验
    UpdateDictDataDTO updateInDTO = new UpdateDictDataDTO();
    updateInDTO.setDictName("测试_更新");
    updateInDTO.setAppId("coi");
    updateInDTO.setDictValueType(2);
    updateInDTO.setRemark("测试更新");
    List<DictDataDefDTO> dataUpdate = new ArrayList<>();
    DictDataDefDTO updataDef = new DictDataDefDTO();
    updataDef.setName("测试更新1");
    updataDef.setEnName("test_update_1");
    updataDef.setValue("test");
    dataUpdate.add(updataDef);
    updateInDTO.setDicts(dataUpdate);
    dictDataService.updateDictData(
        String.valueOf(sysDictData.getList().get(2).getId()), updateInDTO);
    PageOutDTO<SysDictData> sysDictData1 = queryService.query(query, SysDictData.class);
    PageOutDTO<SysDictDataDef> sysDictDataDef1 = queryService.query(query, SysDictDataDef.class);
    //    Assert.assertEquals(19, sysDictData1.getList().get(0).ge().intValue());
    //    Assert.assertEquals(19, persons1.getList().get(0).getAge().intValue());

    // 删除 & 校验
    //    dictDataService.deleteDictData("gys_test");
    //    PageOutDTO<SysDictData> sysDictData2 = queryService.query(query, SysDictData.class);
    //    PageOutDTO<SysDictDataDef> sysDictDataDef2 = queryService.query(query,
    // SysDictDataDef.class);
    //    Assert.assertEquals(0, sysDictData2.getTotalRecord());
    //    Assert.assertEquals(0, sysDictDataDef2.getTotalRecord());
  }

  @Test
  public void testIdGen() {
    Date date = new Date();
    System.out.println(idGeneratorService.nextId(date.getTime()));
  }
}
