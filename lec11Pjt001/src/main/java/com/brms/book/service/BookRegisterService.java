package com.brms.book.service;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import com.brms.book.Book;
import com.brms.book.dao.BookDao;

public class BookRegisterService implements InitializingBean, DisposableBean {

	@Autowired
	private BookDao bookDao;
	
	public BookRegisterService() { }
	
	public void register(Book book) {
		bookDao.insert(book);
	}
	
	// 아래부분은 인터페이스 implements에 의해 오버라이드 된 메소드 
	@Override
	public void afterPropertiesSet() throws Exception {
		// InitializingBean
		System.out.println("BookRegisterService 인터페이스에서 생성");
	}

	@Override
	public void destroy() throws Exception {
		// DisposableBean
		System.out.println("BookRegisterService 인터페이스에서 소멸");
	}
	
}