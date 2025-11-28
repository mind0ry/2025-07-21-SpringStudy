package com.sist.service;

import java.util.List;

import com.sist.vo.DataBoardVO;

public interface DataBoardService {

	public List<DataBoardVO> databoardListdata(int start);
	public int databoardRowCount();
	public void databoardInsert(DataBoardVO vo);

	public DataBoardVO databoardDetailData(int no);
	
	public boolean databoardDelete(int no,String pwd);
	public DataBoardVO databoardFileInfoData(int no);
	
	public DataBoardVO databoardUpdateData(int no);
	public boolean databoardUpdate(DataBoardVO vo);
}
