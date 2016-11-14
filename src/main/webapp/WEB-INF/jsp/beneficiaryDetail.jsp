<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Beneficiary Page</title>
</head>
<body>
	<form action="../beneficiary/${beneficiary.id}" method="post">
	<h4>Beneficiary Details</h4>
	<table>		
		<tr>
			<td>Description:</td>
			<td><input type="text" name="description" value="${beneficiary.description}" /> </td>
		</tr>		
	</table>
	<input type="submit" value="update"/>
	</form>
	<form action="delete?beneficiaryId=${beneficiary.id}" method="post">
		<button type="submit">Delete</button>
	</form>
</body>
</html>