<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="uf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Account</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/script/jquery.js"></script>
<script>
	function onLoad() {
		$("#password").keyup(passwordMatchCheck);
		$("#confirmPassword").keyup(passwordMatchCheck);
		$("#details").submit(onSubmit);
	}
	function onSubmit(){
		var password = $("#password").val();
		var cnfpassword = $("#confirmPassword").val();
		if(password!= cnfpassword){
			alert("Password Doesn't match!");
			return false;
		}else{
			return true;
		}
	}
	
	function passwordMatchCheck() {
		var password = $("#password").val();
		var cnfpassword = $("#confirmPassword").val();
		
		if (password.length > 3 || cnfpassword.length > 3) {
			if (password == cnfpassword) {
				$("#match").text("Passwords Matchs");
			} else {
				$("#match").text("Passwords Doesn't Matchs");
			}
		}
	}
	$(document).ready(onLoad);
</script>
</head>
<body>
	<h1>Create Account</h1>
	<uf:form id ="details" method="POST"
		action="${pageContext.request.contextPath}/accountCreated"
		commandName="account">
		<table>
			<tr>
				<td>UserName:</td>
				<td><uf:input name="userName" path="userName" type="text"></uf:input>
					<uf:errors path="userName" cssClass="error"></uf:errors></td>
			</tr>
			<tr>
				<td>FirstName:</td>
				<td><uf:input name="firstName" path="firstName" type="text"></uf:input>
					<uf:errors path="firstName" cssClass="error"></uf:errors></td>
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
				<td>Password:</td>
				<td><uf:input id="password" name="password" path="password" type="text"></uf:input>
					<uf:errors path="password" cssClass="error"></uf:errors></td>
			</tr>
			<tr>
				<td>ConfirmPassword:</td>
				<td><input id = "confirmPassword" name="confirmPassword" type="text">
					<div id="match"></div></td>
			</tr>
			<tr>
				<td><input value="Create User" type="Submit"></td>
			</tr>
		</table>
	</uf:form>
</body>
</html>