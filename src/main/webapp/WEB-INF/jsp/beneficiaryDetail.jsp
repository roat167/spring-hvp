<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Beneficiary Page</title>
</head>
<body>
	<a href="/home"> HOME</a>
	<span><a href="/beneficiaries"> Cancel </a></span>
	<form action="/beneficiaries/add" method="post">
	<h4>Beneficiary Details</h4>
	<table>		
		<tr>
			<td>Name:</td>
			<td><input type="text" name="name" value="${beneficiary.name}" /> </td>
			<td>Description:</td>
			<td><input type="text" name="description" value="${beneficiary.description}" /> </td>
		</tr>		
	</table>
	<input type="submit" value="Save"/>
	</form>
	<c:if test="${not empty beneficiary.id}">
	<form action="/beneficiaries/remove?id=${beneficiary.id}" method="post">
		<button type="submit">Delete</button>
	</form>
	</c:if>
	<span></span>	
</body>
</html>