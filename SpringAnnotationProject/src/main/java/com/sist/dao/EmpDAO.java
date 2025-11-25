package com.sist.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.sist.mapper.*;
import com.sist.vo.*;

@Repository
public class EmpDAO {
	@Autowired
	private EmpMapper mapper;
	
	/*
	 * @Select("SELECT empno,ename,job,sal,"
				+ "TO_CHAR(hiredate,'YYYY-MM-DD') as dbday "
				+ "FROM emp ORDER BY empno")
		public List<EmpVO> empListData();
		
		@Results({
			@Result(property = "dvo.dname" , column = "dname"),
			@Result(property = "dvo.loc" , column = "loc")
		})
		@Select("SELECT empno,ename,job,sal,"
				+ "TO_CHAR(hiredate,'YYYY-MM-DD') as dbday, "
				+ "dname,loc "
				+ "FROM emp,dept "
				+ "WHERE emp.deptno=dept.deptno "
				+ "AND empno=#{empno}")
		public EmpVO empDetailData(int empno);
	 */
	public List<EmpVO> empListData() {
		return mapper.empListData();
	}
	public EmpVO empDetailData(int empno) {
		return mapper.empDetailData(empno);
	}
}
