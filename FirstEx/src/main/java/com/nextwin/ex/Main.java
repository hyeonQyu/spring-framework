package com.nextwin.ex;

import java.io.IOException;
import java.util.Scanner;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.support.ResourcePropertySource;

import com.nextwin.config.ApplicationConfig;
import com.nextwin.config.ApplicationConfigDev;
import com.nextwin.config.ApplicationConfigRun;
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
		
//		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
//		Person person1 = ctx.getBean("person1", Person.class);
//		person1.getInfo();
//		ctx.close();
		
//		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
//		Person person1 = ctx.getBean("person1", Person.class);
//		Person person2 = ctx.getBean("person2", Person.class);
//		Person person3 = ctx.getBean("person3", Person.class);
//		person1.getInfo();
//		System.out.println();
//		person2.getInfo();
//		System.out.println();
//		person3.getInfo();
//		ctx.close();
		
//		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
//		ctx.load("classpath:applicationCTX.xml");
//		ctx.refresh();
//		ctx.close();
		
//		ConfigurableApplicationContext ctx = new GenericXmlApplicationContext();
//		ConfigurableEnvironment env = ctx.getEnvironment();
//		MutablePropertySources propertySources = env.getPropertySources();
//		
//		try {
//			propertySources.addLast(new ResourcePropertySource("classpath:admin.properties"));
//			
//			System.out.println(env.getProperty("admin.id"));
//			System.out.println(env.getProperty("admin.pw"));
//		} catch (IOException e) {}
//		
//		GenericXmlApplicationContext gCtx = (GenericXmlApplicationContext)ctx;
//		gCtx.load("classpath:applicationCTX.xml");
//		gCtx.refresh();
//		
//		AdminConnection adminConnection = gCtx.getBean("adminConnection", AdminConnection.class);
//		System.out.println("admin ID: " + adminConnection.getAdminId());
//		System.out.println("admin PW: " + adminConnection.getAdminPw());
//		
//		ctx.close();
//		gCtx.close();
		
//		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX3.xml");	
//		AdminConnection2 adminConnection2 = ctx.getBean("adminConnection2", AdminConnection2.class);
//		System.out.println("admin ID : " + adminConnection2.getAdminId());
//		System.out.println("admin PW : " + adminConnection2.getAdminPw());
//		System.out.println("sub admin ID : " + adminConnection2.getSubAdminId());
//		System.out.println("sub admin PW : " + adminConnection2.getSubAdminPw());
//		ctx.close();
		
//		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
//		AdminConnection2 adminConnection2 = ctx.getBean("adminConnection2", AdminConnection2.class);
//		System.out.println("admin ID : " + adminConnection2.getAdminId());
//		System.out.println("admin PW : " + adminConnection2.getAdminPw());
//		System.out.println("sub admin ID : " + adminConnection2.getSubAdminId());
//		System.out.println("sub admin PW : " + adminConnection2.getSubAdminPw());
//		ctx.close();
		
		String config = null;
		Scanner scanner = new Scanner(System.in);
		String str = scanner.next();
		scanner.close();
		if(!(str.equals("dev") || str.equals("run")))
			return;
		config = str;
		
//		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
//		ctx.getEnvironment().setActiveProfiles(config);
//		// config의 값에 따라 아래 두 xml 파일 중 하나가 사용됨
//		ctx.load("applicationCTX_dev.xml", "applicationCTX_run.xml");
//		ctx.refresh();
//		ServerInfo info = ctx.getBean("serverInfo", ServerInfo.class);
//		System.out.println("ip " + info.getIp());
//		System.out.println("port " + info.getPort());
//		ctx.close();
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.getEnvironment().setActiveProfiles(config);
		ctx.register(ApplicationConfigDev.class, ApplicationConfigRun.class);
		ctx.refresh();
		ServerInfo info = ctx.getBean("serverInfo", ServerInfo.class);
		System.out.println("ip " + info.getIp());
		System.out.println("port " + info.getPort());
		ctx.close();
	}

}
