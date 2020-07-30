package com.nextwin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.nextwin.ex.ServerInfo;

@Configuration
@Profile("dev")
public class ApplicationConfigDev {

	@Bean
	public ServerInfo serverInfo() {
		ServerInfo info = new ServerInfo();
		info.setIp("localhost");
		info.setPort("8181");
		return info;
	}
	
}
