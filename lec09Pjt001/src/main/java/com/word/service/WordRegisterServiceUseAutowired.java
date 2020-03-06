package com.word.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.word.WordSet;
import com.word.dao.WordDao;

public class WordRegisterServiceUseAutowired {

	// 필드 변수나 메소드에 @Autowired 어노테이션을 사용하려면 디폴트 생성자가 필요
	// 타입이 일치하는 객체를 자동으로 주입
	@Autowired
	// xml설정파일에 WordDao형 객체가 여러개 있을 때 어떤 객체를 주입할 지 결정하기 위해 @Qualifier을 사용하여 명시
	@Qualifier("usedDao")
	private WordDao wordDao;
	
	public WordRegisterServiceUseAutowired() {
		// TODO Auto-generated constructor stub
	}
	
	// 생성자에 @Qualifier 어노테이션을 사용하기 위해서는 매개변수 앞에 써주어야 함
//	@Autowired
	public WordRegisterServiceUseAutowired(WordDao wordDao) {
		this.wordDao = wordDao;
	}
	
	public void register(WordSet wordSet) {
		String wordKey = wordSet.getWordKey();
		if(verify(wordKey)) {
			wordDao.insert(wordSet);
		} else {
			System.out.println("The word has already registered.");
		}
	}
	
	public boolean verify(String wordKey){
		WordSet wordSet = wordDao.select(wordKey);
		return wordSet == null ? true : false;
	}
	
//	@Autowired
	public void setWordDao(WordDao wordDao) {
		this.wordDao = wordDao;
	}
	
}
