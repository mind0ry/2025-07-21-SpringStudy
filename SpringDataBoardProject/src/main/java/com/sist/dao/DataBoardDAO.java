package com.sist.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.DataBoardMapper;

import com.sist.vo.*;

// Mapper ±¸Çö
@Repository
public class DataBoardDAO {
	@Autowired
	private DataBoardMapper mapper;
	
	public List<DataBoardVO> databoardListdata(int start) {
		return mapper.databoardListData(start);
	}
	
	public int databoardRowCount() {
		return mapper.databoardRowCount();
	}
	
	public void databoardInsert(DataBoardVO vo) {
		mapper.databoardInsert(vo);
	}

	public DataBoardVO databoardDetailData(int no) {
		mapper.hitIncrement(no);
		return mapper.databoardDetailData(no);
	}
	
	public DataBoardVO databoardFileInfoData(int no) {
		return mapper.databoardFileInfoData(no);
	}
	
	public String databoardGetPassword(int no) {
		return mapper.databoardGetPassword(no);
	}
	
	public void databoardDelete(int no) {
		mapper.databoardDelete(no);
	}
	
	public DataBoardVO databoardUpdateData(int no) {
		return mapper.databoardDetailData(no);
	}
	
	public void databoardUpdate(DataBoardVO vo) {
		mapper.databoardUpdate(vo);
	}
}
