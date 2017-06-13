package com.wtsd.dubbo;

import com.alibaba.dubbo.config.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by xianghao on 2017/6/5.
 */
@Configuration
public class DubboProvider extends DubboBaseConfig {

    private @Autowired(required = false) ServiceTest serviceTestImpl;

	@Bean
	public ServiceConfig serviceConfig(ApplicationConfig applicationConfig,
			RegistryConfig registryConfig, ProtocolConfig protocolConfig, MonitorConfig monitorConfig) {
		ServiceConfig<ServiceTest> service = new ServiceConfig<ServiceTest>();
		service.setApplication(applicationConfig);
		service.setRegistry(registryConfig);
		service.setProtocol(protocolConfig);
		service.setRef(serviceTestImpl);
		service.setInterface(ServiceTest.class);
		service.setMonitor(monitorConfig);

		service.export();
		return service;
	}


}
