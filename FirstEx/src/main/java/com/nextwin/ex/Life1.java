package com.nextwin.ex;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Life1 implements InitializingBean, DisposableBean{
	
	private String name;
	private int num;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public void afterPropertiesSet() throws Exception {
		System.out.println("create");
	}
	
	public void destroy() throws Exception {
		System.out.println("destroy");		
	}

}
