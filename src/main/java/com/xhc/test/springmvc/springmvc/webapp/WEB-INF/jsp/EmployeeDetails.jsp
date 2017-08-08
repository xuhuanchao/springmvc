<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Employee Details</title>
	<style type="text/css">@import url("<c:url value="/css/main.css/"/>")</style>
</head>
<body>
	<div id="global">
		<h1>Employee Detail</h1>
		<table border="1">
			<tr>
				<th>id</th>
				<th>firstName</th>
				<th>lastName</th>
				<th>birthDate</th>
				<th>salaryLevel</th>
			</tr>
			<tr>
				<td>${employee.id }</td>
				<td>${employee.firstName }</td>
				<td>${employee.lastName }</td>
				<td>${employee.birthDate }</td>
				<td>${employee.salaryLevel }</td>
			</tr>
		</table>
	</div>
</body>
</html>