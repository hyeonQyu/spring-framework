package com.iowe.member1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.iowe.member1.Member;
import com.iowe.member1.dao.MemberDao;


// 아래 3개의 어노테이션을 이용하면 컨테이너 설정파일에 빈 객체를 명시해주지 않아도 됨
//@Service
//@Service("memService")
//@Component
//@Component("memService")
//@Repository
@Repository("memService")
public class MemberService implements IMemberService {

	@Autowired
	MemberDao dao;
	
	@Override
	public void memberRegister(String memId, String memPw, String memMail,
			String memPhone1, String memPhone2, String memPhone3) {
		System.out.println("memberRegister()");
		System.out.println("memId : " + memId);
		System.out.println("memPw : " + memPw);
		System.out.println("memMail : " + memMail);
		System.out.println("memPhone : " + memPhone1 + " - " + memPhone2 + " - " + memPhone3);
		
		dao.memberInsert(memId, memPw, memMail, memPhone1, memPhone2, memPhone3);
	}

	@Override
	public Member memberSearch(String memId, String memPw) {
		System.out.println("memberSearch()");
		System.out.println("memId : " + memId);
		System.out.println("memPw : " + memPw);
		
		Member member = dao.memberSelect(memId, memPw);
		
		return member;
	}

	@Override
	public void memberModify() {
		
	}

	@Override
	public void memberRemove() {
		
	}

}