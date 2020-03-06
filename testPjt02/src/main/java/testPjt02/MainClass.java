package testPjt02;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		
		TransportationWalk tWalk = ctx.getBean("tWalk", TransportationWalk.class);
		tWalk.move();
		
		ctx.close();
	}

}
