package com.nextwin.config;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.nextwin.ex.AdminConnection2;
import com.nextwin.ex.Person;

@Configuration
@ImportResource("classpath:applicationCTX2.xml")
public class ApplicationConfig {
	
	@Value("${admin.id}")
	private String adminId;
	@Value("${admin.pw}")
	private String adminPw;
	@Value("${sub_admin.id}")
	private String subAdminId;
	@Value("${sub_admin.pw}")
	private String subAdminPw;
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer Properties() {
		PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
		
		Resource[] locations = new Resource[2];
		locations[0] = new ClassPathResource("admin.properties");
		locations[1] = new ClassPathResource("sub_admin.properties");
		configurer.setLocations(locations);
		
		return configurer;
	}
	
	@Bean
	public AdminConnection2 adminConnection2() {
		AdminConnection2 adminConnection2 = new AdminConnection2();
		adminConnection2.setAdminId(adminId);
		adminConnection2.setAdminPw(adminPw);
		adminConnection2.setSubAdminId(subAdminId);
		adminConnection2.setSubAdminPw(subAdminPw);
		
		return adminConnection2;
	}

	@Bean
	public Person person1() {
		
		ArrayList<String> hobbys = new ArrayList<String>();
		hobbys.add("수영");
		hobbys.add("요리");
		
		Person person = new Person("김철수", 20, hobbys);
		person.setHeight(180);
		person.setWeight(80);
		
		return person;
		
	}
	
	@Bean
	public Person person2() {
		
		ArrayList<String> hobbys = new ArrayList<String>();
		hobbys.add("독서");
		hobbys.add("영화시청");
		
		Person person = new Person("한복남", 25, hobbys);
		person.setHeight(178);
		person.setWeight(77);
		
		return person;
		
	}
	
}
