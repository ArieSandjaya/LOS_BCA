package com.multifinance.util;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.multifinance.dao.GetDao;

@Aspect
@Configuration
public class AspectCloseSession {

	@Autowired
	GetDao getDao;
		
	@AfterReturning(value = "execution(* com.multifinance.controller.*.*(..))")
	public void after(JoinPoint joinPoint) {
		getDao.closeSession();
	}
}