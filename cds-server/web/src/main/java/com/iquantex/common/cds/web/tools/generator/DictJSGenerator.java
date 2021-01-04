package com.iquantex.common.cds.web.tools.generator;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.iquantex.common.cds.web.bean.dict.DictDataBean;
import com.iquantex.common.cds.web.bean.dict.DictJSEntity;
import com.iquantex.common.cds.web.bean.dict.JSField;
import com.iquantex.common.cds.web.bean.dict.JSFieldByDictKey;
import com.iquantex.common.cds.web.dao.mapper.SysDictDataMapper;
import com.iquantex.common.cds.web.service.SysDictDataService;
import com.iquantex.common.cds.web.util.TemplateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author gys
 * @date 2020/12/30
 */
@Service
public class DictJSGenerator {

    private static SysDictDataService sysDictDataService;

    /**
     * 前端导出文件模板
     */
    public static final String FRONT_FILE_TPL = "/dictjs.ftl";

    public static final String BACK_FILE_TPL = "/backdictjava.ftl";

    @Autowired
    public void setSysDictDataMapper(SysDictDataService sysDictDataService){
        DictJSGenerator.sysDictDataService = sysDictDataService;
    }

    /*private static final String SQL = "select * from v_dict_data where js_dict = 1 order by dict_key, dict_value";

    public DictJSGenerator() {
    }*/

    public List<DictJSEntity> listEntity(String appIds) throws Exception {
        List<DictDataBean> rs = new ArrayList<>();
        /*if (null == connection) {
            rs = dbUtil.query("select * from v_dict_data where js_dict = 1 order by dict_key, dict_value", new Object[0]);
        } else {
            rs = dbUtil.query(connection, "select * from v_dict_data where js_dict = 1 order by dict_key, dict_value", new Object[0]);
        }*/

//        PageOutDTO< SysDictData > sysDictData = queryService.query(query, SysDictData.class);

        List<String> appIdsArr = Arrays.asList(appIds.split(","));

        for(String appId : appIdsArr){
            rs.addAll(sysDictDataService.selectForDownload("%" + appId + "%"));
        }

        if (Objects.isNull(rs) || CollectionUtils.isEmpty(rs)) {
            return null;
        } else {
            List<DictDataBean> beans = JSON.parseArray(JSON.toJSONString(rs), DictDataBean.class);
            Map<String, DictJSEntity> map = new LinkedHashMap();
            DictDataBean bean;
            DictJSEntity entity;
            if (CollectionUtils.isNotEmpty(beans)) {
                for(Iterator var6 = beans.iterator(); var6.hasNext(); entity.getFields().add(this.parseField(bean)), entity.getJsFieldByDictKeys().add(this.parseFieldByDictKey(bean))) {
                    bean = (DictDataBean)var6.next();
                    String key = bean.getDictKey() + bean.getAppId();
                    entity = (DictJSEntity)map.get(key);
                    if (null == entity) {
                        entity = new DictJSEntity();
                        entity.setComment(bean.getDictName());
                        entity.setFields(new ArrayList());
                        entity.setAppIdAndDictKey(bean.getAppId() + "_" + bean.getDictKey());
                        entity.setJsFieldByDictKeys(new ArrayList<>());
                        map.put(key, entity);
                    }
                }
            }

            return new ArrayList(map.values());
        }
    }

    private JSField parseField(DictDataBean dictDataBean) {
        JSField field = new JSField();
        String name = null == dictDataBean.getEnName() ? dictDataBean.getValue() : dictDataBean.getEnName();
        field.setIdentifier(dictDataBean.getAppId() + "_" + dictDataBean.getDictKey() + "_" + name);
        field.setValue(dictDataBean.getValue());
        field.setAnnotation(dictDataBean.getName());
        field.setString((new Integer(2)).equals(dictDataBean.getDictValueType()));
        return field;
    }

    private JSFieldByDictKey parseFieldByDictKey(DictDataBean dictDataBean) {
        JSFieldByDictKey jsFieldByDictKey = new JSFieldByDictKey();
        jsFieldByDictKey.setValue(dictDataBean.getValue());
        jsFieldByDictKey.setName(dictDataBean.getName());
        jsFieldByDictKey.setString((new Integer(2)).equals(dictDataBean.getDictValueType()));
        return jsFieldByDictKey;
    }

    /*public void generateFile(List<DictJSEntity> list, String generatePath, String fileName) throws IOException {
        String content = this.getContent(list);
        FileUtil.writeFile(generatePath + File.separator + fileName, content, true);
    }*/

    public String getContent(List<DictJSEntity> list, boolean isBlack) {
        Map<String, List<DictJSEntity>> root = new HashMap();
        root.put("list", list);
        if(isBlack){
            return TemplateUtil.getContent(BACK_FILE_TPL, root);
        }else {
            return TemplateUtil.getContent(FRONT_FILE_TPL, root);
        }
    }
}
