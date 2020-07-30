package com.nextwin.ex;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class AdminConnection2 implements DisposableBean, InitializingBean {
	
	private String adminId;
	private String adminPw;
	private String subAdminId;
	private String subAdminPw;

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getAdminPw() {
		return adminPw;
	}

	public void setAdminPw(String adminPw) {
		this.adminPw = adminPw;
	}

	public String getSubAdminId() {
		return subAdminId;
	}

	public void setSubAdminId(String subAdminId) {
		this.subAdminId = subAdminId;
	}

	public String getSubAdminPw() {
		return subAdminPw;
	}

	public void setSubAdminPw(String subAdminPw) {
		this.subAdminPw = subAdminPw;
	}

	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub

	}

	public void destroy() throws Exception {
		// TODO Auto-generated method stub

	}

}
