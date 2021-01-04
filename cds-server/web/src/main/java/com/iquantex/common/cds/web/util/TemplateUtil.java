package com.iquantex.common.cds.web.util;

import freemarker.template.Configuration;
import freemarker.template.Template;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.net.URL;
import org.apache.commons.lang3.StringUtils;

/**
 * @author gys
 * @date 2020/12/30
 */
public class TemplateUtil {
    private static final Configuration cfg;

    public TemplateUtil() {
    }

    public static String getContent(String tpFile, Object root) {
        return getContent(getTemplate(tpFile, (String)null), root);
    }

    public static String getContent(String tpFile, Object root, String encoding) {
        return getContent(getTemplate(tpFile, encoding), root);
    }

    public static String getContent(Template template, Object root) {
        try {
            StringWriter sw = new StringWriter();
            template.process(root, sw);
            return sw.toString();
        } catch (Exception var3) {
            throw new RuntimeException("获取生成代码错误", var3);
        }
    }

    public static Template getTemplate(String path, String encoding) {
        try {
            return cfg.getTemplate(path, StringUtils.isBlank(encoding) ? "UTF-8" : encoding);
        } catch (Exception var3) {
            throw new RuntimeException("获取freeMarker模版失败", var3);
        }
    }

    public static Template getTemplate(String path) {
        return getTemplate(path, (String)null);
    }

    static {
        cfg = new Configuration(Configuration.VERSION_2_3_22);

        try {
            URL url = TemplateUtil.class.getProtectionDomain().getCodeSource().getLocation();
            String templatePath = url.getPath();
            cfg.setDirectoryForTemplateLoading(new File(templatePath));
        } catch (IOException var2) {
            cfg.setClassForTemplateLoading(TemplateUtil.class, "/");
        } catch (Exception var3) {
            throw new RuntimeException("模板初始化失败", var3);
        }

    }
}
