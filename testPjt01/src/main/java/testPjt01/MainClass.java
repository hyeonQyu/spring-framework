package testPjt01;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
//		TransportationWalk transportationWalk = new TransportationWalk();
//		transportationWalk.move();
	
		// 컨테이너를 가져옴
		// applicationContext.xml에 있는 객체(bean)에 접근하기 위함
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		
		// 컨테이너에서 특정 객체(bean)을 가져옴
		TransportationWalk transportationWalk = ctx.getBean("tWalk", TransportationWalk.class);
		transportationWalk.move();
		System.out.println(transportationWalk.getInfo());
		
		ctx.close();
	}

}
