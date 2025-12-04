package com.sist.service;
import java.util.*;
import com.sist.vo.*;

// 의존성이 낮은 프로그램 (결합성) => 다른 클래스에 영향이 없이
// 유지보수 목적

public interface BoardService {
	
	public List<BoardVO> boardListData(int start,  int end);
	
	public int boardRowCount();
	
	public void boardInsert(BoardVO vo);
	
	public BoardVO boardDetailData(int no);
	
	public String boardDelete(int no, String pwd);
	
	public String boardUpdate(BoardVO vo);

	public BoardVO boardUpdateData(int no);
}
