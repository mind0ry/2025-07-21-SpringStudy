package com.sist.dao;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.RecipeMapper;
import com.sist.vo.RecipeVO;

@Repository
public class RecipeDAO {
	@Autowired
	private RecipeMapper mapper;
	
	/*
	 * @Select("SELECT no,chef,title "
			+ "FROM recipe "
			+ "WHERE ${column} LIKE '%'||#{ss}||'%'")
	public List<RecipeVO> recipeFindData(Map map);
	
	@Select("SELECT COUNT(*) "
			+ "FROM recipe "
			+ "WHERE ${column} LIKE '%'||#{ss}||'%'")
	public int recipeFindCount(Map map);
	 */
	public List<RecipeVO> recipeFindData(Map map) {
		return mapper.recipeFindData(map);
	}
	
	public int recipeFindCount(Map map) {
		return mapper.recipeFindCount(map);
	}
}
