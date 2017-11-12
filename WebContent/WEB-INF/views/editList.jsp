<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit Gift Data</title>
</head>

<body>
<h3>Make Changes</h3>

	<form:form action="updateXmasList.do" method="POST" modelAttribute="xmasList"><br>
		Recipient Name: <form:input path="recipient"/><form:errors path="recipient"/><br>
		Gift Idea: <form:input path="giftItem"/><form:errors path="giftItem"/><br>
		Approximate Cost: <form:input path="cost"/><form:errors path="cost"/><br>
		Reason: <form:input path="reason"/><form:errors path="reason"/><br>
		<form:hidden path="id"/>
		<input type="submit" value="Done">
	</form:form>

</body>
</html>