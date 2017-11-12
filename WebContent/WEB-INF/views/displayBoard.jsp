<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Display Board of Lists</title>
</head>

<body>


	<h1 align="center"><p><p>All Christmas Lists</p></p></h1>

	
	
	
	<c:forEach var="li" items="${list}">

		<a href="giftDetails.do?id=${li.id}">${li.recipient}</a>
		<form method="post" action="delete.do">
			<input type="submit" value="Delete"> <input type="hidden"
				name="id" value="${li.id}">
		</form>
		<br>

		<form method="post" action="update.do">
			<input type="submit" value="Update"> <input type="hidden"
				name="id" value="${li.id}">
		</form>
		<br>

	</c:forEach>

</body>
</html>