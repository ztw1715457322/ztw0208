package com.zhangsan.senior1.week3.test;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.b1709.utils.FileUtils;
import com.zhangsan.seionor1.week3.entity.Depart;
import com.zhangsan.seionor1.week3.entity.Plan;
import com.zhangsan.seionor1.week3.servcie.ComService;

@RunWith(SpringRunner.class)//使用spring的启动类 进行测试 
@ContextConfiguration("classpath:spring-beans.xml") //加载配置文件
public class TestImport {
	
	@Autowired
	ComService comService;

	@Test
	public void testimport() throws IOException {
		
		
		List<String> lines = FileUtils.readFileByLines("d:\\zhunneng.txt");
		for (String data : lines) {
			
			String[] split = data.split("\\|\\|");
			System.err.println(split);
			// 列次序分别是：项目名称、投资金额、项目说明、	分管领导、所属部门。
			Plan plan = new Plan();
			plan.setName(split[0]);
			// 字符串=》dobble类型  =》 BigDecaimail 类型
			plan.setAmount( new BigDecimal(Double.parseDouble(split[1])));
			plan.setContent(split[2]);
			plan.setManager(split[3]);
			
			// 根据部门的名称获取部门
			Depart depart = comService.getDepartByName(split[4]);
			if(depart!=null)
				plan.setDeptId(depart.getId());
			else
				plan.setDeptId(0);
			
			
			comService.addPlan(plan);
		}
		
		
		
	}
}
