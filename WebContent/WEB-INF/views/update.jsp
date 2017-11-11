<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit Details</title>
</head>
<body>
<h3>Update details</h3>

	<form:form action="updateXmasList.do" method="POST" modelAttribute="xmasList">
		For: ${xmasList.recipient }<br>
		Gift Idea: ${xmasList.giftItem }<br>
		Cost: ${xmasList.cost }<br>
		Because... ${xmasList.reason }<br>
		<form:hidden path="id"/>
		<input type="submit" value="Done">
	</form:form>

</body>
</html>