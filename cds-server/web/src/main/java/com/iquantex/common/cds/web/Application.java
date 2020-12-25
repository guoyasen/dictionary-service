package com.iquantex.common.cds.web;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author lan
 * @description: 启动类
 * @date 2020-12-16
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableSwagger2
@Slf4j
@ComponentScan({"com.iquantex.portal.web.query", "com.iquantex.common.cds.web"})
@MapperScan({"com.iquantex.portal.cds.web.mapper", "com.iquantex.common.cds.web.dao"})
public class Application {
  public static void main(String[] args) {
    try {
      SpringApplication.run(Application.class, args);
    } catch (Exception e) {
      log.error(e.getMessage(), e);
    }
  }
}
