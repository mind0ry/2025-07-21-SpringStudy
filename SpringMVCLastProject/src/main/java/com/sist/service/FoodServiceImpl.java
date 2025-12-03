package com.sist.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.dao.FoodDAO;
import com.sist.vo.FoodVO;

@Service
public class FoodServiceImpl implements FoodService {
	@Autowired
	private FoodDAO fDao;
	
	@Override
	public List<FoodVO> foodListData(int start, int end) {
		return fDao.foodListData(start, end);
	}
	
	@Override
	public int foodTotalPage() {
		return fDao.foodTotalPage();
	}

	@Override
	public FoodVO foodDetailData(int fno) {
		// TODO Auto-generated method stub
		return fDao.foodDetailData(fno);
	}

	@Override
	public FoodVO foodCookieData(int fno) {
		// TODO Auto-generated method stub
		return fDao.foodDetailData(fno);
	}

	@Override
	public List<FoodVO> foodFindData(Map map) {
		// TODO Auto-generated method stub
		return fDao.foodFindData(map);
	}

	@Override
	public int foodFindTotalPage(String address) {
		// TODO Auto-generated method stub
		return fDao.foodFindTotalPage(address);
	}

	@Override
	public List<FoodVO> foodTypeData(Map map) {
		// TODO Auto-generated method stub
		return fDao.foodTypeData(map);
	}

	@Override
	public int foodTypeTotalPage(String type) {
		// TODO Auto-generated method stub
		return fDao.foodTypeTotalPage(type);
	}
	
}
