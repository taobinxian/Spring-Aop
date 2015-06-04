package com.alipay.baoxian;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * @author binxian.tbx
 * @version $Id: App.java, v 0.1 2014年12月19日 下午6:49:29 binxian.tbx Exp $
 */
public class App {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        ApplicationContext con = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService us = (UserService) con.getBean("userService");
        us.getUser(12);
    }
    
}
