<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Page</title>
</head>
<body>
	<h2>List of users</h2>
	<table>
	<%-- 
	<c:forEach var="user" items="${users}">
	<tr>
		<td>${user.name}</td>
		<td>${user.status}</td>
		<td>${user.description}</td>		
		<td>${user.startDate}</td>
		<td>${user.endDate}</td>
		<td><a href="user/${user.id}">edit</a></td>
	</tr>
	</c:forEach>
	--%>
	</table>
	
	<a href="user/add"> Add a user</a>
</body>
</html>