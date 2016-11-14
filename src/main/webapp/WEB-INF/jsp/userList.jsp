<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Projects</title>
</head>
<body>
	<h2>List of projects</h2>
	<table>
	<%-- 
	<c:forEach var="project" items="${projects}">
	<tr>
		<td>${project.name}</td>
		<td>${project.status}</td>
		<td>${project.description}</td>		
		<td>${project.startDate}</td>
		<td>${project.endDate}</td>
		<td><a href="projects/${project.id}">edit</a></td>
	</tr>
	</c:forEach>
	--%>
	</table>
	
	<a href="addProject.html"> Add a Project</a>
</body>
</html>