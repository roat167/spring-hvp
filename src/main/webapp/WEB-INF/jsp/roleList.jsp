<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Role Page</title>
</head>
<body>
	<a href="/home"> HOME</a>
	<a href="role/add"> Add a Role</a>
	<h2>List of roles</h2>
	<table>	
	<c:if test="${not empty roles}">
	<tr>
		<td> Status </td>
		<td> Name </td>		
		<td> Description </td>				
	</tr>
	</c:if>
	<c:forEach var="role" items="${roles}">
	<tr>
		<td>${role.status}</td>
		<td>${role.name}</td>		
		<td>${role.description}</td>
		<td><a href="role/${role.id}">Edit</a></td>
	</tr>
	</c:forEach>	
	</table>	
</body>
</html>