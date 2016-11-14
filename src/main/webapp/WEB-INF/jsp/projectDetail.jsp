<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Project Detail</title>
<!-- <link rel="stylesheet" type="text/css" href="../datepicker.css" /> 
<script type="text/javascript" src="../datepicker.js"></script>  -->
</head>
<body>
	<form action="/projects/add" method="post">
	<h4>Project Details</h4>
	<table>
		<tr>
			<td>Name:</td>
			<td><input type="text" name="name" value="${project.name}" /> </td>
		</tr>
		<tr>
			<td>Status:</td>
			<%-- <td><input type="text" name="status" value="${project.status}" /> </td> --%>
			<td><input type="radio" name="status" value="1" checked> Enable<br>
  			<input type="radio" name="status" value="0"> Disable<br>
  			</td>		
		</tr>
		<tr>
			<td>Description:</td>
			<td><input type="text" name="description" value="${project.description}" /> </td>
		</tr>
		<tr>
			<td>Start Date:</td>
			<td><input type="text" class="datepicker" name="startDate" value="${project.startDateDisplay}" /> </td>
		</tr>
		<tr>
			<td>End Date:</td>
			<td><input type="text" class="datepicker" name="endDate" value="${project.endDateDisplay}" /> </td>
		</tr>
	</table>
	<input type="submit" value="update"/>
	</form>
	<c:if test="not empty project.id">
	<form action="delete?projectId=${project.id}" method="post">
		<button type="submit">Delete</button>
	</form>
	</c:if>
	<div>
		<span><a href="/projects"> Cancel </a></span>
	</div>
</body>
</html>