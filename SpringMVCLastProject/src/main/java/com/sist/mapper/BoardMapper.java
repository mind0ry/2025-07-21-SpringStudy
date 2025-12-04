package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sist.vo.*;

// component : page
// => detail => prop:[변수] => v-bind
// => RestFul
public interface BoardMapper {
	@Select("SELECT no,subject,name,TO_CHAR(regdate,'YYYY-MM-DD') as dbday,hit,num "
			+ "FROM (SELECT no,subject,name,regdate,hit,rownum as num "
			+ "FROM (SELECT no,subject,name,regdate,hit "
			+ "FROM springBoard ORDER BY no DESC)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<BoardVO> boardListData(@Param("start") int start, @Param("end") int end);
	
	@Select("SELECT COUNT(*) FROM springBoard")
	public int boardRowCount();
	
	@Insert("INSERT INTO springBoard VALUES("
			+ "sb_no_seq.nextval,"
			+ "#{name}, #{subject}, #{content}, #{pwd}, SYSDATE,0)")
	public void boardInsert(BoardVO vo);
	
	// 상세보기
	@Update("UPDATE springBoard SET "
			+ "hit=hit+1 "
			+ "WHERE no=#{no}")
	public void boardHitIncrement(int no);
	
	@Select("SELECT no,name,subject,content,hit,"
			+ "TO_CHAR(regdate, 'YYYY-MM-DD HH24:MI:SS') as dbday "
			+ "FROM springBoard "
			+ "WHERE no=#{no}")
	public BoardVO boardDetailData(int no); 
	
	// 수정하기
	@Update("UPDATE springBoard SET "
			+ "name=#{name},subject=#{subject},content=#{content} "
			+ "WHERE no=#{no}")
	public void boardUpdate(BoardVO vo);
	@Select("SELECT no,name,subject,content "
			+ "FROM springBoard "
			+ "WHERE no=#{no}")
	public BoardVO boardUpdateData(int no); 
	
	// 삭제하기
	@Select("SELECT pwd FROM springBoard WHERE no=#{no}")
	public String boardGetPassword(int no);
	
	@Delete("DELETE FROM springBoard WHERE no=#{no}")
	public void boardDelete(int no);
}
