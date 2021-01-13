package com.iquantex.common.cds.web.tools.generator;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.iquantex.common.cds.web.dao.model.DictDataBeanPO;
import com.iquantex.common.cds.web.dao.model.DictEntityPO;
import com.iquantex.common.cds.web.dao.model.FieldByDictKeyPO;
import com.iquantex.common.cds.web.dao.model.FieldPO;
import com.iquantex.common.cds.web.service.SysDictDataService;
import com.iquantex.common.cds.web.util.TemplateUtil;
import java.util.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author gys
 * @date 2020/12/30
 */
@Slf4j
@Service
public class DictGenerator {

  private static SysDictDataService sysDictDataService;

  /** 前端导出文件模板 */
  public static final String FRONT_FILE_TPL = "/dictjs.ftl";

  public static final String BACK_FILE_TPL = "/backdictjava.ftl";

  @Autowired
  public void setSysDictDataMapper(SysDictDataService sysDictDataService) {
    DictGenerator.sysDictDataService = sysDictDataService;
  }

  public List<DictEntityPO> listEntity(String appIds) throws Exception {
    log.info("进入list方法");
    List<DictDataBeanPO> rs = new ArrayList<>();

    String[] appIdsArr = appIds.split(",");

    for (String appId : appIdsArr) {
      rs.addAll(sysDictDataService.selectForDownload(appId));
    }

    log.info("导出功能，查询到的数据条数为：" + rs.size());
    if (CollectionUtils.isEmpty(rs)) {
      return null;
    } else {
      List<DictDataBeanPO> beans = JSON.parseArray(JSON.toJSONString(rs), DictDataBeanPO.class);
      log.info("转化后条数为：" + beans.size());
      Map<String, DictEntityPO> map = new LinkedHashMap();
      DictDataBeanPO bean;
      DictEntityPO entity;
      if (CollectionUtils.isNotEmpty(beans)) {
        for (Iterator var6 = beans.iterator();
            var6.hasNext();
            entity.getFields().add(this.parseField(bean)),
                entity.getFieldByDictKeys().add(this.parseFieldByDictKey(bean))) {
          bean = (DictDataBeanPO) var6.next();
          String key = bean.getDictKey() + bean.getAppId();
          entity = (DictEntityPO) map.get(key);
          if (null == entity) {
            entity = new DictEntityPO();
            entity.setComment(bean.getDictName());
            entity.setFields(new ArrayList());
            entity.setAppIdAndDictKey(bean.getAppId() + "_" + bean.getDictKey());
            entity.setFieldByDictKeys(new ArrayList<>());
            map.put(key, entity);
          }
        }
      }

      return new ArrayList(map.values());
    }
  }

  private FieldPO parseField(DictDataBeanPO dictDataBean) {
    FieldPO field = new FieldPO();
    String name =
        null == dictDataBean.getEnName() ? dictDataBean.getValue() : dictDataBean.getEnName();
    field.setIdentifier(dictDataBean.getAppId() + "_" + dictDataBean.getDictKey() + "_" + name);
    field.setIdentifierCapitalization(
        (dictDataBean.getAppId() + "_" + dictDataBean.getDictKey() + "_" + name).toUpperCase());
    field.setValue(dictDataBean.getValue());
    field.setAnnotation(dictDataBean.getName());
    field.setString((new Integer(2)).equals(dictDataBean.getDictValueType()));
    return field;
  }

  private FieldByDictKeyPO parseFieldByDictKey(DictDataBeanPO dictDataBean) {
    FieldByDictKeyPO jsFieldByDictKey = new FieldByDictKeyPO();
    jsFieldByDictKey.setValue(dictDataBean.getValue());
    jsFieldByDictKey.setName(dictDataBean.getName());
    jsFieldByDictKey.setString((new Integer(2)).equals(dictDataBean.getDictValueType()));
    return jsFieldByDictKey;
  }

  /*public void generateFile(List<DictEntityPO> list, String generatePath, String fileName) throws IOException {
      String content = this.getContent(list);
      FileUtil.writeFile(generatePath + File.separator + fileName, content, true);
  }*/

  public String getContent(List<DictEntityPO> list, boolean isBlack) {
    Map<String, List<DictEntityPO>> root = new HashMap();
    root.put("list", list);
    if (isBlack) {
      return TemplateUtil.getContent(BACK_FILE_TPL, root);
    } else {
      return TemplateUtil.getContent(FRONT_FILE_TPL, root);
    }
  }
}
