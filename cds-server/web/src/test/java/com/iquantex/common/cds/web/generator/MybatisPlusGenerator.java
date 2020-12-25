package com.iquantex.common.cds.web.generator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.IFileCreate;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.builder.ConfigBuilder;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.FileType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

/**
 * @author yanliang
 * @date 12/17/2020 2:01 PM
 */
public class MybatisPlusGenerator {

  public static void main(String[] args) throws IOException {
    Properties properties = new Properties();
    properties.load(MybatisPlusGenerator.class.getResourceAsStream("/mp.generator.properties"));

    // 数据源配置
    DataSourceConfig dataSourceConfig = new DataSourceConfig();
    dataSourceConfig.setDbType(DbType.getDbType(properties.getProperty("jdbc.type").toUpperCase()));
    dataSourceConfig.setDriverName(properties.getProperty("jdbc.driver.className"));
    dataSourceConfig.setUrl(properties.getProperty("jdbc.url"));
    dataSourceConfig.setUsername(properties.getProperty("jdbc.username"));
    dataSourceConfig.setPassword(properties.getProperty("jdbc.password"));

    // 生成策略
    StrategyConfig strategyConfig = new StrategyConfig();
    System.out.print("请输入需要生成的表名：");
    Scanner scanner = new Scanner(System.in);
    String tableName = scanner.nextLine();

    // 设置需要生成的表名
    strategyConfig.setInclude(tableName.split(","));
    // 文件名策略：驼峰
    strategyConfig.setNaming(NamingStrategy.underline_to_camel);
    // 使用lombok
    strategyConfig.setEntityLombokModel(true);
    strategyConfig.setCapitalMode(true);

    InjectionConfig injectionConfig = new CustomInjectConfig();

    // 全局
    GlobalConfig globalConfig = new GlobalConfig();
    globalConfig.setOutputDir(
        System.getProperty("user.dir") + File.separator + properties.getProperty("code.basePath"));
    globalConfig.setAuthor("auto_generate");
    globalConfig.setIdType(IdType.INPUT);
    // 使用jdk1.8日期类型
    globalConfig.setDateType(DateType.TIME_PACK);
    globalConfig.setFileOverride(true);
    globalConfig.setOpen(false);
    // 是否覆盖原文件
    globalConfig.setFileOverride(true);

    // 包配置
    PackageConfig packageConfig = new PackageConfig();
    packageConfig.setParent(properties.getProperty("code.package"));

    // 设置entity包名
    System.out.print("sub dao package: ");
    String daoPackage = scanner.nextLine();
    if (StringUtils.isNotEmpty(daoPackage)) {
      daoPackage += ".";
    }
    scanner.close();
    packageConfig.setEntity(daoPackage + "model");
    packageConfig.setMapper(daoPackage + "mapper");
    packageConfig.setXml(daoPackage + "mapper.xml");

    AutoGenerator autoGenerator = new AutoGenerator();
    autoGenerator.setStrategy(strategyConfig);
    autoGenerator.setCfg(injectionConfig);
    autoGenerator.setPackageInfo(packageConfig);
    autoGenerator.setDataSource(dataSourceConfig);
    autoGenerator.setGlobalConfig(globalConfig);

    // 除使用默认Velocity外，使用其他模版引擎（如freemarker）需要手动注入模版引擎
    autoGenerator.setTemplateEngine(new FreemarkerTemplateEngine());
    autoGenerator.execute();
  }

  static class CustomInjectConfig extends InjectionConfig {

    @Override
    public InjectionConfig setConfig(ConfigBuilder config) {
      // 移除controller、service等目录，防止自动生成目录
      Map<String, String> pathInfo = config.getPathInfo();
      pathInfo.remove("controller_path");
      pathInfo.remove("service_path");
      pathInfo.remove("service_impl_path");
      pathInfo.remove("xml_path");

      // 将所有convert设置为True，这样生成的model上就会将TableName，TableField的注解带上
      config
          .getTableInfoList()
          .forEach(
              tableInfo -> {
                tableInfo.setConvert(true);
                tableInfo.getImportPackages().add(TableName.class.getCanonicalName());
                tableInfo.getImportPackages().add(TableField.class.getCanonicalName());
                tableInfo.getFields().forEach(tableField -> tableField.setConvert(true));
              });

      return super.setConfig(config);
    }

    @Override
    public IFileCreate getFileCreate() {
      return (configBuilder, fileType, filePath) -> {
        // 仅生成entity、mapper、xml文件
        // mapper、xml文件不能覆盖
        if (FileType.MAPPER.equals(fileType)) {
          return !new File(filePath).exists();
        }

        return FileType.ENTITY.equals(fileType);
      };
    }

    @Override
    public void initMap() {}
  }
}
