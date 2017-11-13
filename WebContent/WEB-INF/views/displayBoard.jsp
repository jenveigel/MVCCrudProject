<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"
	integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb"
	crossorigin="anonymous">
<link rel="stylesheet" href="css/styleDispBd.css">

<title>Display Board of Gift Ideas</title>
</head>

<body>


	<h1 align="center"><p><p>All Christmas Lists</p></p></h1>

	
	<c:forEach var="list" items="${list}">
<ul>
  <li>
    <a href="giftDetails.do?id=${list.id}">${list.recipient}<br>
    	
	<div class="pic"><img src="images/clipart_present.png" alt="clipart" height="70" width="70"></div>
<table>
<tr>
<td>
    		<form method="post" action="delete.do">
			<input type="submit" value="Delete"> <input type="hidden"
				name="id" value="${list.id}">
		</form>
</td>
	<td>	 </td>	
<td>
		<form method="post" action="update.do">
			<input type="submit" value="Update"> <input type="hidden"
				name="id" value="${list.id}">
		</form>
</td>
</tr>
</table>
    </a>

  </li>
</ul>
	</c:forEach>
	
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js"
		integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"
		integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ"
		crossorigin="anonymous"></script>

</body>
</html>