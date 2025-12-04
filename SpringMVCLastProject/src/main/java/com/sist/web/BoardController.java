package com.sist.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {
	@GetMapping("board/list.do")
	public String board_list(Model model) {
		model.addAttribute("main_jsp", "../board/list.jsp");
		return "main/main";
	}
	
	@GetMapping("board/insert.do")
	public String board_insert(Model model) {
		model.addAttribute("main_jsp", "../board/insert.jsp");
		return "main/main";
	}
	
	@GetMapping("board/update.do")
	public String board_update(int no,Model model) {
		model.addAttribute("no",no);
		
		model.addAttribute("main_jsp", "../board/update.jsp");
		
		return "main/main";
	}
	
	@GetMapping("board/detail.do")
	public String board_detail(int no,Model model) {
		
		model.addAttribute("no",no);
		model.addAttribute("main_jsp", "../board/detail.jsp");
		
		return "main/main";
	}
}
