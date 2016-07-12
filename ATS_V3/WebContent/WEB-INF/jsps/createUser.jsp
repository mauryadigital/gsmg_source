<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="uf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create User</title>
</head>
<body>
	<h1>Create User</h1>
	<uf:form method="POST"
		action="${pageContext.request.contextPath}/doCreateUser"
		commandName="user">
		<table>
			<tr>
				<td>FirstName:</td>
				<td><uf:input name="firstName" path="firstName" type="text"></uf:input> <uf:errors
						path="firstName" cssClass="error"></uf:errors></td>
			</tr>
			<tr>
				<td>LastName:</td>
				<td><uf:input name="lastName" path="lastName" type="text"></uf:input>
					<uf:errors path="lastName" cssClass="error"></uf:errors></td>
			</tr>
			<tr>
				<td>Email-Id:</td>
				<td><uf:input name="emailID" path="emailId" type="text"></uf:input>
					<uf:errors path="emailId" cssClass="error"></uf:errors></td>
			</tr>
			<tr>
				<td>Contact:</td>
				<td><uf:input name="contact" path="contact" type="text"></uf:input>
					<uf:errors path="contact" cssClass="error"></uf:errors></td>
			</tr>
			<tr>
				<td><input value="Create User" type="Submit"></td>
			</tr>
		</table>
	</uf:form>
</body>
</html>