package com.zhangsan.seionor1.week3.servcie;

import com.github.pagehelper.PageInfo;
import com.zhangsan.seionor1.week3.entity.Depart;
import com.zhangsan.seionor1.week3.entity.Plan;

public interface ComService {

	Depart getDepartByName(String string);

	void addPlan(Plan plan);

	PageInfo<Plan> list(String name, int page);

}
