<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List Of Users</title>
</head>
<body>
	<b>Users:</b>
	<table>
		<tr>
			<td>FirstName</td>
			<td>LastName</td>
			<td>Email-Id</td>
			<td>Contact</td>
		</tr>
		<c:forEach var="row" items="${User}">
			<tr>
				<td><c:out value="${row.firstName}"></c:out></td>
				<td><c:out value="${row.lastName}"></c:out></td>
				<td><c:out value="${row.emailId}"></c:out></td>
				<td><c:out value="${row.contact}"></c:out></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>