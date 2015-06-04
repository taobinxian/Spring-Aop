package com.alipay.baoxian;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class UserAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * ҵ�񷽷�ִ��ǰ��ִ�д˲���  
     * @param jp
     */
    @Before("execution(* com.alipay.baoxian.UserService.getUser(int))")
    public void before(JoinPoint jp) {
        logger.info(jp.getKind());
        System.out.println("before advice " + jp.getArgs()[0]);
    }

    /**
     * ҵ�񷽷�����ִ�н������ִ�д˲���  
     * @throws Exception
     */
    @AfterReturning("execution(* com.alipay.baoxian.UserService.getUser(int))")
    public void afterReturn() throws Exception {
        System.out.println("after-returning advice");
    }

    /**
     * �൱��finally,����ҵ�񷽷��Ƿ�����쳣��ִ�к󶼻�ִ�д˲��� 
     */
    @After("execution(* com.alipay.baoxian.UserService.getUser(int))")
    public void after() {
        System.out.println("after advice");
    }

    /**
     * ���쳣��ִ�д˲���
     * @param e
     */
    @AfterThrowing(pointcut = "execution(* com.alipay.baoxian.UserService.getUser(int))", throwing = "e")
    public void exception(Exception e) {
        System.err.println("after exception:" + e.getMessage());
    }
}
