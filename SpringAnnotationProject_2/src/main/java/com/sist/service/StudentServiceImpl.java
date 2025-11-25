package com.sist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.dao.StudentDAO;
import com.sist.vo.StudentVO;

/*
 * 	MainClass ===> StudentService ====> StudentServiceImpl ==> StudentDAO
 */

@Service("service")
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentDAO sDao;
	@Override
	public void studentInsert(StudentVO vo) {
		// TODO Auto-generated method stub
		sDao.studentInsert(vo);
	}

	@Override
	public List<StudentVO> studentListData() {
		// TODO Auto-generated method stub
		return sDao.studentListData();
	}

	@Override
	public void studentUpdate(StudentVO vo) {
		// TODO Auto-generated method stub
		sDao.studentUpdate(vo);
	}

	@Override
	public StudentVO studentDetailData(int hakbun) {
		// TODO Auto-generated method stub
		return sDao.studentDetailData(hakbun);
	}

	@Override
	public void studentDelete(int hakbun) {
		// TODO Auto-generated method stub
		sDao.studentDelete(hakbun);
	}

}
