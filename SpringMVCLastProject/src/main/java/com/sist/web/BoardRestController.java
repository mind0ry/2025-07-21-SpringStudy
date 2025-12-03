package com.sist.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sist.service.BoardService;
import com.sist.vo.BoardVO;

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
}
