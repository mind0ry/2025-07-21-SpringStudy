package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.RecipeVO;
public interface RecipeMapper {
	@Select("SELECT no,chef,title "
			+ "FROM recipe "
			+ "WHERE ${column} LIKE '%'||#{ss}||'%'")
	public List<RecipeVO> recipeFindData(Map map);
	
	@Select("SELECT COUNT(*) "
			+ "FROM recipe "
			+ "WHERE ${column} LIKE '%'||#{ss}||'%'")
	public int recipeFindCount(Map map);
}
