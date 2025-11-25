package com.sist.dao;

import org.springframework.stereotype.Repository;

/*
 * 	1. AOP
 * 		Before
 *      After
 *      After-Throwing
 *      After-Returning
 *      Around
 *      
 *      public String display()
 *      {
 *      	String res=""
 *      	=> Before
 *      	try {
 *      		--------------- setAutoCommit(false) Around
 *      			코딩
 *      		--------------- commit()
 *      	} catch(Exception ex)
 *      	  {
 *      		 => After-Throwing
 *      	  } finally {
 *      		 => After
 *      	  }
 *      	  return res; => After-returning
 *      }
 */
@Repository("dao")
public class MyDAO {
	public void select() {
		//getConnection(); // Before
		System.out.println("데이터 읽기");
		//disConnection(); // After
	}
	public void insert() {
		//getConnection();
		System.out.println("데이터 추가");
		//disConnection();
	}
	public void update() {
		//getConnection();
		System.out.println("데이터 수정");
		//disConnection();
	}
	public void delete() {
		//getConnection();
		System.out.println("데이터 삭제");
		//disConnection();
	}
}
