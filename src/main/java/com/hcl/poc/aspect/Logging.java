package com.hcl.poc.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * This Class is used for Aspect Logging the Service Layer
 * 
 * @author Rounak.Nayak
 *
 */
@Aspect
public class Logging {

	private static Logger log = LoggerFactory.getLogger(Logging.class);
	
	/**
	 * This Method is used to print the logs when we enter a Service method
	 * 
	 * @param joinPoint
	 */
	@Before("execution(* com.hcl.poc.service.*.*(*))")
	public void logBeforeServiceMethod(JoinPoint joinPoint){
		log.info("Service Method Called : "+joinPoint.getSignature().getName());
		log.info("Arguments : "+Arrays.toString(joinPoint.getArgs()));
	}
	
	/**
	 * This Method is used to print the logs when we exit a Service method
	 * 
	 * @param joinPoint
	 */
	@After("execution(* com.hcl.poc.service.*.*(*))")
	public void logAfterServiceMethod(JoinPoint joinPoint){
		log.info("Service Method Ended : "+joinPoint.getSignature().getName());
	}
}