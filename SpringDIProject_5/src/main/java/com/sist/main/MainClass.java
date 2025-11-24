package com.sist.main;
import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.*;
import com.sist.vo.*;
public class MainClass {
	public static void main(String[] args) {
		// 1. XML ÆÄ½Ì
		ApplicationContext app=new ClassPathXmlApplicationContext("app.xml");
		//FoodDAO dao=new FoodDAO();
		FoodDAO dao=(FoodDAO)app.getBean("dao");
		List<FoodVO> list=dao.foodListData(1, 10);
		for(FoodVO vo:list) {
			System.out.println(vo.getName()+" "+vo.getAddress());
		}
	}
}
