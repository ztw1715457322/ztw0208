<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
	<table>
		<tr>
			<td>id</td>
			<td>计划名称</td>
			<td>投资金额</td>
			<td>分管领导</td>
			<td>部门</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${pagePlan.list}" var="plan">
			<tr>
			<td>${plan.id}</td>
			<td>${plan.name}</td>
			<td>${plan.amount}</td>
			<td>${plan.manager}</td>
			<td>${plan.dept.name}</td>
			<td></td>
			</tr>
		</c:forEach>
	</table>
</div>

</body>
</html>