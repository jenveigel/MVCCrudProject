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
<link rel="stylesheet" href="css/style.css">
<title>Christmas List</title>
</head>

<body>


	<h1 align="center"><p><p>The Spirit of Giving</p></p></h1>

	<div align="center">
		<div class="container-fluid"></div>

		<form:form action="getXmasList.do" method="post"
			modelAttribute="idForm">
			<form:input path="id" />
			<form:errors path="id" />

			<input type="submit" value="Look at your list">
		</form:form>

	</div>
	</div>
	

	<br>
	<div id=xyz>
		<!-- <img height=200 src="images/box_xmas_3d.jpg" alt="xmas Boxes"> -->		
	</div>
	<br>

<div class="row align-items-center">
    <div class="col">
      <p>
		<a href="add.do">Add a Christmas List</a>
	</p>
    </div>
    <div class="col">
      <div class="all">
		<p>
			All Christmas Lists:<br>
		</p>
	
	
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
</div>
    </div>
    <div class="col">
      One of three columns
    </div>
  </div>



	<%-- <c:if test="${not empty giftsToBuy}">
Left to Buy: ${giftsToBuy}
</c:if> --%>



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