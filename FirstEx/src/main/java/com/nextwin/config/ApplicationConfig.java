package com.nextwin.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.nextwin.ex.Person;

@Configuration
public class ApplicationConfig {

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
