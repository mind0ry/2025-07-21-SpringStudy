package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.*;
public interface FoodMapper {
	@Select("SELECT fno,name,address,type,phone "
			+ "FROM menupan_food "
			+ "WHERE ${column} LIKE '%'||#{ss}||'%'")
	public List<FoodVO> foodFindData(Map map);
	
	@Select("SELECT COUNT(*) "
			+ "FROM menupan_food "
			+ "WHERE ${column} LIKE '%'||#{ss}||'%'")
	public int foodFindCount(Map map);
}
