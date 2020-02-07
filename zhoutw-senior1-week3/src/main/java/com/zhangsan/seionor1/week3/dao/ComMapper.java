package com.zhangsan.seionor1.week3.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.zhangsan.seionor1.week3.entity.Depart;
import com.zhangsan.seionor1.week3.entity.Plan;

public interface ComMapper {

	@Select("SELECT id,name FROM zhunneng_department WHERE name=#{value}")
	Depart getDepartByName(String string);
	

	@Insert("INSERT INTO zhunneng_2019plan(name,amount,manager,content,dept_id) "
			+ " VALUES(#{name},#{amount},#{manager},#{content},#{deptId})")
	void add(Plan plan);


	List<Plan> list(String name);

}
