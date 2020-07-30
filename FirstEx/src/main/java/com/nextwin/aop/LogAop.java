package com.nextwin.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class LogAop {
	
	// 실제 공통 기능 메소드
	public Object loggerAop(ProceedingJoinPoint joinPoint) throws Throwable{
		// 메소드 이름
		String signature = joinPoint.getSignature().toShortString();
		System.out.println(signature + " is started");
		long st = System.currentTimeMillis();
		
		try {
			// 핵심 기능 실행(proxy)
			Object obj = joinPoint.proceed();
			return obj;
		} finally {
			long et = System.currentTimeMillis();
			System.out.println(signature + " is finished");
			System.out.println("경과 시간: " + (et - st));
		}
	}

}
