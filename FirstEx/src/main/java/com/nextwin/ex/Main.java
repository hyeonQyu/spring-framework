package com.nextwin.ex;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.nextwin.config.ApplicationConfig;
import com.nextwin.pencil.Pencil;

public class Main {

	public static void main(String[] args) {
//		String configLocation = "classpath:applicationCTX.xml";
//		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation);
//		MyCalculator myCalculator = ctx.getBean("myCalculator", MyCalculator.class);
//		
//		myCalculator.add();
//		myCalculator.sub();
		
//		String configLocation = "classpath:applicationCTX.xml";
//		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation);
//		MyInfo myInfo = ctx.getBean("myInfo", MyInfo.class);
//		myInfo.getInfo();
//		ctx.close();
		
//		String configLocation = "classpath:applicationCTX.xml";
//		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation);
//		StudentInfo studentInfo = ctx.getBean("studentInfo", StudentInfo.class);
//		studentInfo.getStudentInfo();
//		ctx.close();
		
//		String configLocation = "classpath:applicationCTX.xml";
//		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation);
//		Pencil pencil = ctx.getBean("pencil", Pencil.class);
//		pencil.use();
//		ctx.close();
		
//		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
//		Person person1 = ctx.getBean("person1", Person.class);
//		person1.getInfo();
//		System.out.println();
//		Person person2 = ctx.getBean("person2", Person.class);
//		person2.getInfo();
//		ctx.close();
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
		Person person1 = ctx.getBean("person1", Person.class);
		person1.getInfo();
		ctx.close();
	}

}
