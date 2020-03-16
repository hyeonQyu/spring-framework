package com.iowe.member1.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.iowe.member1.Member;
import com.iowe.member1.service.MemberService;



@Controller
@RequestMapping("/member")	// /member + 각 메소드 속성 값
public class MemberController {

//	MemberService service = new MemberService();
//	@Autowired
	@Resource(name="memService")
	MemberService service;
	
	// method가 GET방식이면 명시해주지 않아도 됨, value만 있을 경우 value=도 생략 가능
	@RequestMapping(value="/memJoin", method=RequestMethod.POST)
	public String memJoin(Member member) {//Model model, HttpServletRequest request) {
//		String memId = request.getParameter("memId");
//		String memPw = request.getParameter("memPw");
//		String memMail = request.getParameter("memMail");
//		String memPhone1 = request.getParameter("memPhone1");
//		String memPhone2 = request.getParameter("memPhone2");
//		String memPhone3 = request.getParameter("memPhone3");
		
//		service.memberRegister(memId, memPw, memMail, memPhone1, memPhone2, memPhone3);
		service.memberRegister(member.getMemId(), member.getMemPw(), member.getMemMail(), 
					member.getMemPhone1(), member.getMemPhone2(), member.getMemPhone3());
		
//		model.addAttribute("memId", memId);
//		model.addAttribute("memPw", memPw);
//		model.addAttribute("memMail", memMail);
//		model.addAttribute("memPhone", memPhone1 + " - " + memPhone2 + " - " + memPhone3);
		
		return "memJoinOk";
	}
	
	@RequestMapping(value="/memLogin", method=RequestMethod.POST)
	public String memLogin(Model model, @RequestParam("memId") String memId, 
			@RequestParam(value="memPw", required=false, defaultValue="1234") String memPw) {	//HttpServletRequest request) {
										// required가 true이면 반드시 입력되어야 하는 값
//		String memId = request.getParameter("memId");
//		String memPw = request.getParameter("memPw");
		
		Member member = service.memberSearch(memId, memPw);
		
		try {
			model.addAttribute("memId", member.getMemId());
			model.addAttribute("memPw", member.getMemPw());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return "memLoginOk";
	}
	
}