package com.alipay.baoxian;


public class UserService {
    public void getUser(int id) {
        System.out.println("the user id: " + id);
        throw new RuntimeException("test the aop execution");
    }
}