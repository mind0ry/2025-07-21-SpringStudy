package com.sist.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sist.service.BoardService;
import com.sist.vo.BoardVO;

/*
 * 	Spring => MVC (DI / AOP) , Security
 *  MVC 동작 순서
 *  1) 클라이언트 요청
 *     HTML : <a href="요청"> <form action="">
 *     JS : location.href="요청"
 *     Ajax : $.ajax({
 *     			 url:요청주소
 *     		  })
 *     Axios : axios.get('요청주소') => react / vue
 *     			fetch('요청주소')
 *     2) DispatcherServlet (스프링에서 지원)
 *        ----------------- 배달부 (request를 받아서 (주문) => request에 요청결과를 닫는다)
 *        요청을 받는다 
 *        => 요청 처리 => 개발자가 제작 : Model(Controller,RestController)
 *                      --------------------------------------------
 *                      | HandlerMapping => 해당 Model
 *                        | url주소 메소드 찾기
 *                          ---------------
 *                          @RequestMapping
 *                          @GetMapping
 *                          @PostMapping
 *                          @PutMapping
 *                          @DeleteMapping
 *                          ---------------- RestFul
 *     3) HandlerMapping => 해당 Controller 찾기
 *     4) 해당기능을 수행하는 메소드 수행
 *     5) request/model에 담긴 데이터를 => DispatcherServlet이 받아서
 *     6) ViewResolver => JSP를 찾아서 request 를 전송
 *     7) JSP에서 화면 출력
 *        => JSP / Vue / ThymeLeaf / React
 *        							   |
 *        					 | 다음주 => UI ==> 2주 정도 : CI/CD
 *                             ------------------------------
 *                             | 우분투 : docker , docker-compose
 *                                      => minikube / jenkins
 *    JSP(요청) == DispatcherServlet = HandlerMapping
 *                                         |
 *                                      @Controller (Model)
 *                                         |
 *                                        ----------
 *                                        Mapper
 *                                         |
 *                                        DAO
 *                                         |
 *                                        Service
 *                                        ----------
 *                                         |
 *                                        DispatcherServlet
 *                                         |
 *                                        ViewResolver
 *                                         |
 *                                        JSP
 *            => DispatcherServlet : 모든 요청을 받아서 router
 *                    => FrontController
 *                    => 요청 : 응답 => 서빙
 *            => HandlerMapping : 어떤 모델을 호출할지 찾는 역할
 *            => @Controller / @RestController
 *                => 개발자 담당 : 비지니스로직 (요청 처리)
 *                              => DAO / Service / VO
 *            => Model : JSP로 전송할 데이터를 저장
 *                       addAttribute() => request.setAttribute()
 *            => ViewResolver : JSP를 찾아주는 역할
 *            => View : 화면 UI
 *            
 *            ---------------------------------------------------
 *            DI (주입) => 객체 생성 => 객체 소멸
 *                         | 필요한 데이터가 있는 경우 => 값을 채워준다
 *                         | setter / 생성자 => 멤버변수의 초기화
 *                         | 객체 생성 호출 : init-method
 *                         | 객체 소멸시 호출 : destory_method
 *                         | => 사용자 정의 클래스 (X) , MyBatis / JPA
 *                         | <bean> id="" class=""
 *                           p:변수명 = ""/>
 *                           -------------
 *                           <bean id="" class=""
 *                            c:변수명=""/> 생성자의 매개변수
 *                            
 *           AOP : 공통 모듈 (모든 기능시에서 사용이 되는 기능을 모아서 관리 => 필요시에 자동 호출)
 *           
 *           public String display() => 메소드 구분 (PointCut)
 *           {
 *           	try{
 *           		@Before : getConnection()
 *             		---------1) Around setAutoCommit(false)
 *           		1
 *           		2
 *           		3
 *           		---------2) commit() 
 *              } catch(Exception e) {
 *              	4 => @After-Throwable rollback()
 *              } finally {
 *              	@After
 *              }
 *              return "" @After-returning
 *           }
 *           
 *           JoinPoint : 어디서 사용할지
 *           PointCut : 어떤 메소드 안에 처리
 *           Advice 
 *           -----------Aspect
 *           
 *           => 위빙 : 모든 기능을 묶어서 => 호출
 *           => 사용자 정의 거의 없다(쿠키)
 *              ----------------
 *              이미 제작 : 트랜젝션 / 보안
 *           => 
 *             public void boardInsert() {
 *              	try{
 *              		getConnection()
 *              		setAutoCommit(false)
 *                		insert()
 *                		insert()	
 *                 		commit()	
 *              	} catch(Exception e) {
 *              		rollback()
 *              	} finally {
 *              		setAutoCommit(true)
 *              	}
 *             }
 *             
 *             @Transactional
 *             public void boardInsert()
 *             {
 *             		insert()
 *             		insert()
 *             }
 *             
 *             @Controller / @RestController
 *             |			 | => 데이터 전송만 (JSON)
 *             => View제어 => router => 화면 이동
 *             
 *             @Controller + @ResponseBody => @RestController
 *             	             ------------ 5버전 이전
 *             
 *             @PathVariable
 *               /board/list/1
 *               => *.do => / => boot는 기본이 /
 *             @RequestBody => VO
 *              => JSON => 객체로 변환
 *              axios.post('',{
 *              			name:this.name,
 *              			subject:this.subject,
 *                          content:this.content,
 *                          pwd:this.pwd
 *              		})
 *              @ResponseStatus => 응답 HTTP 상태
 *                 => 200 : OK , 500 , 404 ...
 *                 
 *              => DI 
 *              @Autowired : 스프링에 등록된 객체를 찾아서 => 메모리 주소값 대입
 *              
 *              => responseEntity : 응답 전체를 직접 제어
 *                 => HTTP 상태 코드 , 헤더 , Body => 제어할 수 있는 객체
 *                 => HttpStatus , Body
 *            ----------------------------------------
 *            사용법 / => 어떤 실행 / 어떤 데이터가 필요한지...
 */

@RestController
@CrossOrigin(origins = "*")
// 모든 port 허용
public class BoardRestController {
	@Autowired
	private BoardService bService;
	// ResponseEntity<Map> ==> 반드시 비동기 처리 async
	@GetMapping("board/list_vue.do")
	public ResponseEntity<Map> board_list(int page) {
		
		Map map=new HashMap();
		try {
			int rowSize=10;
			int start=(page-1)*rowSize;
			int end=rowSize*page;
			
			map.put("start", start);
			map.put("end", end);
			
			List<BoardVO> list=bService.boardListData(start, end);
			int count=bService.boardRowCount();
			int totalpage=(int)(Math.ceil(count/10.0));
			
			map=new HashMap();
			map.put("list", list);
			map.put("totalpage", totalpage);
			map.put("curpage", page);
			
		} catch (Exception ex) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(map,HttpStatus.OK);
	}
	
	@PostMapping("board/insert_vue.do")
	public ResponseEntity<Map> board_insert(@RequestBody BoardVO vo) {
		
		Map map=new HashMap();
		
		try {
			bService.boardInsert(vo);
			map.put("msg", "yes");
			
		} catch (Exception ex) {
			map.put("msg", "no");
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(map,HttpStatus.OK);
	}
	
	// 수정 / 삭제
	@GetMapping("board/detail_vue.do")
	public ResponseEntity<BoardVO> board_detail(int no) {
		
		BoardVO vo=new BoardVO();
		try {
			vo=bService.boardDetailData(no);
		} catch (Exception ex) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(vo,HttpStatus.OK);
	}
	
	@DeleteMapping("board/delete_vue.do")
	public ResponseEntity<Map> board_delete(int no,String pwd) {
		Map map=new HashMap();
		
		try {
			// DB연동
			String res=bService.boardDelete(no, pwd);
			map.put("msg", res);
		} catch (Exception ex) {

		}
		
		return new ResponseEntity<>(map,HttpStatus.OK);
	}
	
	@GetMapping("board/update_vue.do")
	public ResponseEntity<Map> board_update(int no) {
		Map map=new HashMap();
		
		try {
			BoardVO vo=bService.boardUpdateData(no);
			map.put("name", vo.getName());
			map.put("subject", vo.getSubject());
			map.put("content", vo.getContent());
		} catch (Exception ex) {

		}
		
		return new ResponseEntity<>(map,HttpStatus.OK);
	}
	
	@PutMapping("board/update_ok_vue.do")
	public ResponseEntity<Map> board_update_od(@RequestBody BoardVO vo) {
		Map map=new HashMap();
		try {
			String res=bService.boardUpdate(vo);
			map.put("msg", res);
		} catch (Exception ex) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(map,HttpStatus.OK);
	}
	
}
