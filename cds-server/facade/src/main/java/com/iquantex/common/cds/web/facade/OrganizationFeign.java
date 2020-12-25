package com.iquantex.common.cds.web.facade;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * name 为服务名称
 *
 * @author szj
 * @date 2020/12/18 16:05
 */
@FeignClient(name = "cds-web")
public interface OrganizationFeign extends OrganizationFacade {}
