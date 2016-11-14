<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Projects</title>
</head>
<body>
	<h2>List of roles</h2>
	<table>
	<%-- 
	<c:forEach var="role" items="${roles}">
	<tr>
		<td>${role.name}</td>
		<td>${role.status}</td>
		<td><a href="role/${role.id}">edit</a></td>
	</tr>
	</c:forEach>
	--%>
	</table>
	
	<a href="role/add"> Add a Project</a>
</body>
</html>