package com.iquantex.common.cds.web.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * ribbon负载均衡配置
 *
 * @author szj
 * @date 2020/12/18 14:02
 */
@Configuration
public class RibbonConfig {

  /** ribbon配置为随机策略 */
  @Bean
  public IRule ribbonRule() {
    return new RandomRule();
  }

  /** 使RestTemplate以负载均衡的方式调用服务 */
  @Bean
  @LoadBalanced
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }
}
