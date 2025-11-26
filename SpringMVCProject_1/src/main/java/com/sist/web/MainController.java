package com.sist.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * 	Spring MVC 구조				HandlerMapping
 *         .do					   |
 *  브라우저 ==== DispatcherServlet ==== Model
 *  								   요청 처리 => DAO/Service
 *                                        | request/session
 *                                    DispatcherServlet
 *                                           | => ViewResolver
 *                                         JSP찾기
 *                                           |
 *                                         JSP로 데이터 전송
 *  1. DispatcherServlet : 사용자 요청을 받아서 
 *  					   처리된 데이터 전송
 *  2. HandlerMapping : DispatcherServlet으로부터 요청 URL/데이터를 받아서
 *  					해당 Model을 찾아서 전송
 *  			            ----- 요청 구현
 *                          => @RequestMapping : 전체 처리가 가능
 *                          => @GetMapping : SELECT
 *                          => @PostMapping : INSERT
 *                          => @PutMapping : UPDATE
 *                          => @DeleteMapping => RestFul : DELETE
 *                          ==> @GetMapping,@PostMapping (WEB)
 *                              <a> default  <form> , ajax 
 *                              axios.get     axios.post
 *                              => 415
 *  3. ViewResolver : JSP를 찾아주는 역할
 *                    => 경로명 : p:prefix="/"
 *                    => 확장자 : p:suffix=".jsp"
 *  4. View(JSP) : 처리 데이터를 받아서 화면 UI
 *  		       ----------------------
 *                 | JSP
 *                 | VueJS => 일반 (vue3 => CDN)
 *                            Vuex/Pinia
 *                 | ReactJS => Redux / tanStaqck-Query
 *                 	                           | 
 *                                          NodeJS / TypeScript
 *                           => NextJS / NextJS
 *  	=> 1. 화면 변경
 *            = forward : request를 유지
 *                        return "폴더/파일명";
 *            = sendRedirect : 기존의 화면으로 이동
 *            	          return "redirect:main.do" => insert / update / delete
 *         2. 데이터 받기 (사용자가 전송한 데이터 받기)
 *            => 스프링 5.0이상에서는 Request/response 사용자제
 *               보안 : IP
 *            => 매개변수 데이터를 받는다
 *            public String main_main(HttpServletRequest request, HttpServletResponse response)
 *            {
 *            		String page=request.getParameter("page");
 *                  // session
 *                  HttpSession session=request.getSession()
 *            }
 *            public String main_main(int page,HttpSession session) => 순서는 상관없다
 *            {
 *            		String page=request.getParameter("page");
 *            }
 *            
 *            => 매개변수
 *               일반 데이터 : 페이지 / 검색어 / 번호
 *               Command 객체 : VO단위로 값을 받는다
 *               public String main_main(MemberVO vo)
 *               => 내장 객체
 *                  HttpServletRequest / HttpServletResponse
 *                  HttpSession / RedirectAttributes
 *                                ------------------
 *                                | return "redirect:detail.do?no="+no
 *                                |
 *         3. 데이터 전송 (JSP로 값을 전송)
 *            ----------------------- Model model
 *            model.addAttribute("키",값)
 *                    |
 *                 request.setAttribute(키,값)
 *            
 */

@Controller
public class MainController {
	@RequestMapping("main/main.do")
	public String main_main(HttpServletRequest request, HttpServletResponse response) {
		
		request.setAttribute("msg", "Hello Spring!!");
		
		return "main/main";
	}
}
