package com.sist.main3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ApplicationContext app=
        	new ClassPathXmlApplicationContext("app2.xml");
        Member m=(Member)app.getBean("mem");
        System.out.println("번호:"+m.getNo());
        System.out.println("이름:"+m.getHman().getName());
        System.out.println("성별:"+m.getHman().getSex());
        System.out.println("주소:"+m.getHman().getAddress());
        System.out.println("전화:"+m.getHman().getPhone());
        
        
	}

}