package com.iquantex.common.cds.web.config;

import com.iquantex.common.cds.web.jwt.AuthenticationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author lan
 * @description: web服务相关配置
 * @date 2020-12-16
 */
@Configuration
public class WebAppConfig implements WebMvcConfigurer {

  /**
   * 服务端允许跨域访问
   *
   * @param registry
   */
  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry
        .addMapping("/**")
        .allowCredentials(true)
        .allowedOrigins("*")
        .allowedMethods("*")
        .allowedHeaders("*");
  }

  /**
   * 设置静态资源访问路径跟存储路径映射关系
   *
   * @param registry
   */
  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry
        .addResourceHandler("swagger-ui.html")
        .addResourceLocations("classpath:/META-INF/resources/");
    registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry
        .addInterceptor(authenticationInterceptor())
        .addPathPatterns("/**"); // 拦截所有请求，通过判断是否有 @LoginRequired 注解 决定是否需要登录
  }

  @Bean
  public AuthenticationInterceptor authenticationInterceptor() {
    return new AuthenticationInterceptor();
  }
}
