package com.sist.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sist.config.StudentConfig;


public class MainClass {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext app=new AnnotationConfigApplicationContext(StudentConfig.class);
		
		Student std=(Student)app.getBean("std");
		System.out.println("학번:"+std.getHakbun());
		System.out.println("이름:"+std.getName());
		System.out.println("성별:"+std.getSex());
		System.out.println("학과:"+std.getSubject());
	}

}
