package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.*;
import com.sist.vo.*;
// Spring => 메모리 할당을 안한다 : Mapper / VO

@Repository
public class StudentDAO {
	@Autowired // getBean
	private StudentMapper mapper; // 구현된 클래스를 대입 요청
	
	/*
	@Insert("INSERT INTO student VALUES(#{hakbun},#{name},#{kor},#{eng},#{math})")
	public void studentInsert(StudentVO vo);
	// select
	@Select("SELECT * FROM student ORDER BY hakbun")
	public List<StudentVO> studentListData();
	// update
	@Update("UPDATE student SET "
			+ "kor=#{kor},eng=#{eng},math=#{math} "
			+ "WHERE hakbun=#{hakbun}")
	public void studentUpdate(StudentVO vo);
	// select
	@Select("SELECT * FROM student WHERE hakbun=#{hakbun}")
	public StudentVO studentDetailData(int hakbun);
	// delete
	@Delete("DELETE FROM student WHERE hakbun=#{hakbun}")
	public void studentDelete(int hakbun);
	 */
	
	public void studentInsert(StudentVO vo) {
		mapper.studentInsert(vo);
	}
	public List<StudentVO> studentListData() {
		return mapper.studentListData();
	}
	public void studentUpdate(StudentVO vo) {
		mapper.studentUpdate(vo);
	}
	public StudentVO studentDetailData(int hakbun) {
		return mapper.studentDetailData(hakbun);
	}
	public void studentDelete(int hakbun) {
		mapper.studentDelete(hakbun);
	}
}
