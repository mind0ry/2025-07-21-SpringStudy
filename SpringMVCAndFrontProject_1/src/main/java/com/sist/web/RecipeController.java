package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;
import com.sist.service.*;
import com.sist.vo.*;
@Controller
public class RecipeController {
  @Autowired
  private RecipeService service;
  // daum.net?page=1
  @GetMapping("recipe/list.do")
  public String recipe_list(String page,Model model) {
	  // 처음 실행시 데이터가 없는 경우 => String , 검색어 
	  if(page==null)
		  page="1";
	  int curpage=Integer.parseInt(page);
	  final int ROWSIZE=12; // totalpage와 동일
	  List<RecipeVO> list=service.recipeListData(
			  (curpage*ROWSIZE)-(ROWSIZE-1), (curpage*ROWSIZE));
	  int totalpage=service.recipeTotalPage();
	  
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
	  
	  return "recipe/list"; // /recipe/list.jsp
  }
  /*
   * 	GetMapping / PostMapping
   *        |			  |
   *        ---------------
   *               |
   *          RequestMapping
   */
  @RequestMapping("recipe/find.do")
  public String recipe_find(String page,String fd,String column,Model model) {
	  
	  if(page==null)
		  page="1";
	  
	  if(fd==null)
		  fd="감자";
	  
	  if(column==null) 
		  column="title";
	  
	  int curpage=Integer.parseInt(page);
	  
	  Map map=new HashMap();
	  map.put("fd", fd);
	  map.put("column", column);
	  map.put("start", (curpage*12)-(11));
	  map.put("end", curpage*12);
	  
	  List<RecipeVO> list=service.recipeFindData(map);
	  int totalpage=service.recipeFindTotalPage(map);
	  
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
	  
	  return "recipe/find";
  }
}




