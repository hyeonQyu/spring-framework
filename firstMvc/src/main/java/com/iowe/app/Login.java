package com.iowe.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Login {

	// method = RequestMethod.GET은 생략 가능
	// 인자가 1개인 경우 value = 도 생략 가능, "/요청내용"만 명시해줘도 됨
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {
		model.addAttribute("loginKey", "loginValue");
		
		// login.jsp파일 실행
		return "login";
	}
	
}
