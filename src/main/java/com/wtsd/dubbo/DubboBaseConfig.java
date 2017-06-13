package com.wtsd.dubbo;

import org.springframework.context.annotation.Bean;

import com.alibaba.dubbo.config.*;
import org.springframework.context.annotation.Configuration;

/**
 * Created by xianghao on 2017/6/5.
 */

public class DubboBaseConfig {
	@Bean
	public RegistryConfig registry() {
		RegistryConfig registryConfig = new RegistryConfig();
		registryConfig.setAddress("192.168.0.130:2181");
		registryConfig.setProtocol("zookeeper");
		registryConfig.setFile("registry3.properties");
		return registryConfig;
	}

	@Bean
	public ApplicationConfig application() {
		ApplicationConfig applicationConfig = new ApplicationConfig();
		applicationConfig.setName("dubbo_provider");
		return applicationConfig;
	}

	@Bean
	public MonitorConfig monitorConfig() {
		MonitorConfig mc = new MonitorConfig();
		mc.setProtocol("registry");

		return mc;
	}

//	@Bean
//	public ReferenceConfig referenceConfig() {
//		ReferenceConfig rc = new ReferenceConfig();
//		rc.setMonitor(monitorConfig());
//		return rc;
//	}

	@Bean
	public ProtocolConfig protocol() {
		ProtocolConfig protocolConfig = new ProtocolConfig();
		protocolConfig.setName("dubbo");
		protocolConfig.setPort(20880);
		protocolConfig.setThreads(1000);//服务线程池大小(固定大小)
		protocolConfig.setAccepts(1000);//服务提供方最大可接受连接数
		return protocolConfig;
	}

//	@Bean
//	public ProviderConfig provider() {
//		ProviderConfig providerConfig = new ProviderConfig();
//		providerConfig.setMonitor(monitorConfig());
//		return providerConfig;
//	}

}
