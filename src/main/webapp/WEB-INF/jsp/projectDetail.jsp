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
	<a href="/home"> HOME</a>
	<span><a href="/projects"> Cancel </a></span>	
	<form action="/projects/add" method="post" modelAttribute="project">
	<h4>Project Details</h4>
	<table>
		<tr>
			<td>Name:</td>
			<td><input type="text" name="name" value="${project.name}" /> </td>
		</tr>
		<tr>
			<td>Status:</td>
			<%-- <td><input type="text" name="status" value="${project.status}" /> </td> --%>
			<td>
			<c:choose>
				<c:when test="${project.status eq 1}">
					<input type="radio" name="status" value="1" checked> Enable<br>
		  			<input type="radio" name="status" value="0"> Disable<br>
	  			</c:when>
	  			<c:otherwise>
	  				<input type="radio" name="status" value="1"> Enable<br>
		  			<input type="radio" name="status" value="0" checked> Disable<br>
	  			</c:otherwise>
  			</c:choose>
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
				<td><input type="text" class="datepicker" name="endDate"
					value="${project.endDateDisplay}" /></td>
			</tr>
			<c:if test="${not empty project.taskList}">
			<tr>
				<td>Tasks: </td>
				<td><table class="clsTaskList">
					<tr>
					<td>TaskName</td>
					<td>Status</td>
					<td>Description</td>
					<td>StartDate</td>
					<td>EndDate</td>
					</tr>
					<c:forEach var="tt" items="${project.taskList}">
						<tr>
						<td>${tt.name}</td>
						<td>${tt.status}</td>
						<td>${tt.description}</td>
						<td>${tt.startDate}</td>
						<td>${tt.endDate}</td>
						</tr>
					</c:forEach>
				</table></td>
			</tr>
			</c:if>
			<%-- 
			<tr>
				<td>Add new task</td>
				<td>
					<table>
						<tr>
							<td>Name:</td>
							<td><input type="text" name="task.name" value="${project.task.name}" /></td>
						</tr>
						<tr>
							<td>Status:</td>
							<td><c:choose>
									<c:when test="${project.task.status eq '1'}">
										<input type="radio" name="task.status" value="1" checked> Enable<br>
										<input type="radio" name="task.status" value="0"> Disable<br>
									</c:when>
									<c:otherwise>
										<input type="radio" name="task.task.status" value="1"> Enable<br>
										<input type="radio" name="status" value="0" checked> Disable<br>
									</c:otherwise>
								</c:choose></td>
						</tr>
						<tr>
							<td>Description:</td>
							<td><input type="text" name="task.description" value="${project.task.description}" /></td>
						</tr>
						<tr>
							<td>Start Date:</td>
							<td><input type="text" class="datepicker" 
								name="task.startDate" value="${project.task.startDateDisplay}" /></td>
						</tr>
						<tr>
							<td>End Date:</td>
							<td><input type="text" class="datepicker"
								name="task.endDate" value="${project.task.endDateDisplay}" /></td>
						</tr>
					</table>
				</td>
			</tr> --%>
		</table>
	<input type="submit" value="Save"/>
	</form>
	<c:if test="${not empty project.id}">
	<form action="/projects/remove?id=${project.id}" method="post">
		<button type="submit">Delete</button>
	</form>
	</c:if>
	<input type="hidden" name="id" value="${project.id}" />	
</body>
</html>