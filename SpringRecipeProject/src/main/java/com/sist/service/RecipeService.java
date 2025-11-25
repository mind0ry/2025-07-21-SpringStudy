package com.sist.service;

import java.util.List;
import java.util.Map;

import com.sist.vo.RecipeVO;

public interface RecipeService {
	
	public List<RecipeVO> recipeFindData(Map map);
	public int recipeFindCount(Map map);
}
