package com.sist.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.vo.FoodVO;
import com.sist.vo.RecipeVO;
import com.sist.service.FoodService;

@Controller
public class FoodController {
	@Autowired
	private FoodService service;
	
	@RequestMapping("food/find.do")
	  public String recipe_find(String page,String fd,String column,Model model) {
		  
		  if(page==null)
			  page="1";
		  
		  if(fd==null)
			  fd="양식";
		  
		  if(column==null) 
			  column="type";
		  
		  int curpage=Integer.parseInt(page);
		  
		  Map map=new HashMap();
		  map.put("fd", fd);
		  map.put("column", column);
		  map.put("start", (curpage*12)-(11));
		  map.put("end", curpage*12);
		  
		  List<FoodVO> list=service.foodFindData(map);
		  int totalpage=service.foodFindTotalPage(map);
		  
		  // 블록별 처리 
		  final int BLOCK=10;
		  int startPage=((curpage-1)/BLOCK*BLOCK)+1; // 1 11 21...
		  int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;// 10 20 30...
		  
		  if(endPage>totalpage)
		      endPage=totalpage;
		  
		  // JSP 전송 
		  model.addAttribute("curpage", curpage);
		  model.addAttribute("totalpage", totalpage);
		  model.addAttribute("list", list);
		  model.addAttribute("startPage", startPage);
		  model.addAttribute("endPage", endPage);
		  
		  model.addAttribute("fd", fd);
		  model.addAttribute("column", column);
		  
		  return "food/find";
	  }
}
