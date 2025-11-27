package com.sist.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.FoodVO;

public interface FoodMapper {
	@Select("SELECT fno,poster,name,address,type,num "
			+ "FROM (SELECT fno,poster,name,address,type,rownum as num "
			+ "FROM (SELECT fno,poster,name,address,type "
			+ "FROM menupan_food "
			+ "WHERE ${column} LIKE '%'||#{fd}||'%' "
			+ "ORDER BY fno ASC)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<FoodVO> foodFindData(Map map);
	
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM menupan_food "
			+ "WHERE ${column} LIKE '%'||#{fd}||'%' ")
	public int foodFindTotalPage(Map map);
}
