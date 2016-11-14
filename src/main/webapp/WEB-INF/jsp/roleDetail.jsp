<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Role Detail</title>
</head>
<body>
	<form action="../role/${role.id}" method="post">
	<h4>Role Details</h4>
	<table>
		<tr>
			<td>Name:</td>
			<td><input type="text" name="name" value="${role.name}" /> </td>
		</tr>		
		<tr>
			<td>Description:</td>
			<td><input type="text" name="description" value="${role.description}" /> </td>
		</tr>		
	</table>
	<input type="submit" value="update"/>
	</form>
	<form action="delete?roleId=${role.id}" method="post">
		<button type="submit">Delete</button>
	</form>
</body>
</html>