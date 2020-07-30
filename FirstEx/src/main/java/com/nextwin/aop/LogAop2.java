package com.nextwin.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LogAop2 {

	// 핵심 코드 범주
	@Pointcut("within(com.nextwin.aop.*)")
	private void pointcutMethod() {}
	
	// 어노테이션 값에 핵심 코드 범주를 지정한 메소드를 넣어도 되고 아래의 @Before처럼 바로 범주를 명시해도 됨
	@Around("pointcutMethod()")
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
	
	@Before("within(com.nextwin.aop.*)")
	public void beforeAdvice() {
		System.out.println("beforeAdvice()");
	}
	
}
