package com.zhangsan.seionor1.week3.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.b1709.utils.FileUtils;
import com.github.pagehelper.PageInfo;
import com.zhangsan.seionor1.week3.entity.Depart;
import com.zhangsan.seionor1.week3.entity.Plan;
import com.zhangsan.seionor1.week3.servcie.ComService;

@Controller
public class ComController {
	
	@Autowired
	ComService comService;
	
	@RequestMapping("import")
	@ResponseBody
	public String importData() throws IOException {
		
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
			plan.setDeptId(depart.getId());
			
			comService.addPlan(plan);
		}
		
		return "success";
	}
	
	@RequestMapping("list")
	public String list(HttpServletRequest request,@RequestParam(defaultValue="") String name,
			@RequestParam(defaultValue="1") int page) {
		
		PageInfo<Plan>  pagePlan = comService.list(name,page);
		request.setAttribute("pagePlan", pagePlan);
		return "list";
		
	}

}
