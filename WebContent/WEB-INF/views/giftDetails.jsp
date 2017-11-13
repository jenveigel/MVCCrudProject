<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Gift Idea Details</title>
</head>
<body>
<div class="displayBoard">
For: ${xmasList.recipient }<br>
Gift Idea: ${xmasList.giftItem }<br>
Cost: ${xmasList.cost }<br>
Because... ${xmasList.reason }<br>
</div>
<p>
<a href="displayAllLists.do">Back to Gift Ideas</a>
</p>
</body>
</html>