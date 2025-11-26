package com.sist.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.sist.vo.MemberVO;

@Controller
public class MainController {
	
	@GetMapping("main/input.do")
	public String main_input() {
		
		return "main/input";
	}
	
	/*
	 * @PostMapping("main/input_ok.do") public String
	 * main_input_ok(HttpServletRequest request, HttpServletResponse response) {
	 * 
	 * String name=request.getParameter("name"); String
	 * sex=request.getParameter("sex"); String
	 * address=request.getParameter("address"); String
	 * content=request.getParameter("content");
	 * 
	 * MemberVO vo=new MemberVO(); vo.setAddress(address); vo.setContent(content);
	 * vo.setName(name); vo.setSex(sex);
	 * 
	 * request.setAttribute("vo", vo);
	 * 
	 * return "main/output"; }
	 */
	@PostMapping("main/input_ok.do")
	public String main_input_ok(MemberVO vo, Model model) {
		
		// ModelVO vo => 目膏靛 按眉
		// Model model => 傈价 按眉
		
		model.addAttribute("vo",vo);
		
		return "main/output";
	}
}
