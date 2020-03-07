package com.brms.book.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import com.brms.book.Book;

public class BookDao {

	private Map<String, Book> bookDB = 
			new HashMap<String, Book>();
	
	public void insert(Book book) {
		bookDB.put(book.getbNum(), book);
	}
	
	public Book select(String bNum) {
		return bookDB.get(bNum);
	}
	
	public void update(Book book) {
		
	}
	
	public void delete() {
		
	}
	
	public Map<String, Book> getBookDB() {
		return bookDB;
	}
	
	// 인터페이스 implements 없이 생성, 소멸 단계에서 작업하기 위한 메소드
	// 단, xml파일에서 객체 속성에 명시해주어야 함 
	public void initialize() {
		System.out.println("Dao 빈(Bean)객체 생성 단계");
	}
	
	public void destroy() {
		System.out.println("Dao 빈(Bean)객체 소멸 단계");
	}
	
}
