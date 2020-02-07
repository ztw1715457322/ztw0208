package com.zhangsan.seionor1.week3.servcie.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhangsan.seionor1.week3.dao.ComMapper;
import com.zhangsan.seionor1.week3.entity.Depart;
import com.zhangsan.seionor1.week3.entity.Plan;
import com.zhangsan.seionor1.week3.servcie.ComService;

@Service
public class ComServiceImpl implements ComService{
	
	@Autowired
	ComMapper comMapper;

	@Override
	public Depart getDepartByName(String string){
		// TODO Auto-generated method stub
		return comMapper.getDepartByName(string) ;
	}

	@Override
	public void addPlan(Plan plan) {
		// TODO Auto-generated method stub
		comMapper.add(plan);
		
	}

	@Override
	public PageInfo<Plan> list(String name, int page) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, 5);
		
		return new PageInfo<Plan>(comMapper.list(name));
	}

	

}
