<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Beneficiaries</title>
</head>
<body>	 
	<a href="/home"> HOME</a>
	<a href="beneficiaries/add"> Add a Beneficiary</a>
	<h2>List of beneficiaries</h2>
	<table>	
	 
	<c:forEach var="beneficiary" items="${beneficiaries}">
	<tr>
		<td>${beneficiary.name}</td>
		<td>${beneficiary.description}</td>		
		<td><a href="/beneficiaries/u/${beneficiary.id}">edit</a></td>
	</tr>
	</c:forEach>
	
	</table>	

</body>
</html>