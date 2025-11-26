package com.sist.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.BoardMapper;
import com.sist.vo.BoardVO;

@Repository
public class BoardDAO {
	@Autowired
	private BoardMapper mapper;
/*
 * 	@Select("SELECT no,subject,name,TO_CHAR(regdate , 'YYYY-MM-DD') as dbday,hit,num "
			+ "FROM (SELECT no,subject,name,regdate,hit,rownum as num "
			+ "FROM (SELECT no,subject,name,regdate,hit "
			+ "FROM springBoard ORDER BY no DESC)) "
			+ "WEHRE num BETWEEN #{start} AND #{end}")
	public List<BoardVO> boardListData(@Param("start") int start, @Param("end") int end);
	
	@Select("SELECT CEIL(COUNT(*)/10.0) FROM springBoard")
	public int boardTotalPage();
	
	@Insert("INSERT INTO springBoard(no,name,subject,content,pwd) "
			+ "VALUES(sb_no_seq.nextval,#{name},#{subject},#{content},#{pwd})")
	public void boardInsert(BoardVO vo);
 */
	public List<BoardVO> boardListData(int start,int end) {
		
		return mapper.boardListData(start, end);
	}
	
	public int boardTotalPage() {
		
		return mapper.boardTotalPage();
	}
	
	public void boardInsert(BoardVO vo) {
		
		mapper.boardInsert(vo);
	}
}
