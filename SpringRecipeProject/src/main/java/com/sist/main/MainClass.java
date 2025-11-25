package com.sist.main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.service.RecipeService;
import com.sist.vo.RecipeVO;

public class MainClass {
	
	public static void main(String[] args) {
		ApplicationContext app=new ClassPathXmlApplicationContext("application-*.xml");
		Scanner scan=new Scanner(System.in);
		System.out.print("검색할 카테고리 선택(1.제목, 2.쉐프):");
		String column="";
		int cate=scan.nextInt();
		String[] strColumn= {"","title","chef"};
		System.out.print("검색어 입력:");
		String ss=scan.next();
		Map map=new HashMap();
		map.put("column", strColumn[cate]);
		map.put("ss", ss);
		
		RecipeService rs=(RecipeService)app.getBean("recipeServiceImpl");
		int count=rs.recipeFindCount(map);
		List<RecipeVO> list=rs.recipeFindData(map);
		System.out.println("검색 결과:"+count+"건");
		for(RecipeVO vo:list) {
			System.out.println(vo.getChef()+ " "+vo.getTitle());
		}
	}
}
