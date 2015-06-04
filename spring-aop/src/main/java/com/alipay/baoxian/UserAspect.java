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
     * 业务方法执行前会执行此操作  
     * @param jp
     */
    @Before("execution(* com.alipay.baoxian.UserService.getUser(int))")
    public void before(JoinPoint jp) {
        logger.info(jp.getKind());
        System.out.println("before advice " + jp.getArgs()[0]);
    }

    /**
     * 业务方法正常执行结束后会执行此操作  
     * @throws Exception
     */
    @AfterReturning("execution(* com.alipay.baoxian.UserService.getUser(int))")
    public void afterReturn() throws Exception {
        System.out.println("after-returning advice");
    }

    /**
     * 相当于finally,无论业务方法是否产生异常，执行后都会执行此操作 
     */
    @After("execution(* com.alipay.baoxian.UserService.getUser(int))")
    public void after() {
        System.out.println("after advice");
    }

    /**
     * 抛异常后执行此操作
     * @param e
     */
    @AfterThrowing(pointcut = "execution(* com.alipay.baoxian.UserService.getUser(int))", throwing = "e")
    public void exception(Exception e) {
        System.err.println("after exception:" + e.getMessage());
    }
}
