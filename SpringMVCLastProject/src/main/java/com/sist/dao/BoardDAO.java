package com.sist.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.sist.mapper.*;
import com.sist.vo.*;
/*
 * 	프로그램
 * 	  1. 공통 사용 => 자주 코딩이 되는 부분
 *    2. 핵심 코딩 => DAO => SQL *****
 */
@Repository // 스프링 관리 대상
public class BoardDAO {
	@Autowired
	private BoardMapper mapper;
	
		public List<BoardVO> boardListData(int start,  int end) {
			return mapper.boardListData(start, end);
		}
		
		public int boardRowCount() {
			return mapper.boardRowCount();
		}
		
		public void boardInsert(BoardVO vo) {
			mapper.boardInsert(vo);
		}
}
