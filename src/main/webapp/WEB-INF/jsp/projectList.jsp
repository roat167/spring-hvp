<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Projects</title>
</head>
<body>
	<!-- <a href="/"> HOME</a> --> 
	<a href="/home"> HOME</a>
	<a href="projects/add"> Add a Project</a>
	<h2>List of projects</h2>
	<table>
	<c:if test="${not empty projects}">
	<tr>
		<td>Name </td>
		<td> Status </td>
		<td> Description </td>		
		<td> Start Date </td>
		<td> End Date</td>		
	</tr>
	</c:if>
	<c:forEach var="project" items="${projects}">
	<tr>
		<td>${project.status}</td>
		<td>${project.name}</td>		
		<td>${project.description}</td>		
		<td>${project.startDateDisplay}</td>
		<td>${project.endDateDisplay}</td>		
		<td><a href="projects/u/${project.id}"> Edit</a></td>
	</tr>
	</c:forEach>	
	</table>	
	
</body>
</html>