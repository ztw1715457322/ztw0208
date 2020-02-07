package com.zhangsan.seionor1.week3.entity;

import java.math.BigDecimal;

public class Plan {
	
	private Integer id;//	主键	int	否	唯一主键，自增长
	private String name;//	工程名称	varchar(80)	否	
	private BigDecimal amount;//	投资金额	decimal	否	2019年投资总额
	private String manager;//	分管领导	varchar(30)	否	
	private String content;//	投资说明	longtext	是	
	private int deptId;//	部门ID	int	否	所属部门
	
	private Depart dept;//	部门ID	int	否	所属部门

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public Depart getDept() {
		return dept;
	}

	public void setDept(Depart dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "Plan [id=" + id + ", name=" + name + ", amount=" + amount + ", manager=" + manager + ", content="
				+ content + ", deptId=" + deptId + ", dept=" + dept + "]";
	}
	
	
}
