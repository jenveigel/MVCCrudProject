<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!--  <link rel="stylesheet" href="css/style.css">-->
<title>Christmas List</title>
</head>
<body>
<h3>The Spirit of Giving</h3>

<form action="getXmasList.do" method="post">
<input type="number" name="xmasListId">
<input type="submit" value="Look at your list">
</form>
<br>
<div id=xyz>
<img height=60 src="box_xmas_3d.jpg" alt="xmas Boxes">
<p>....................We wish you a merry Christmas...<br>
...........................We wish you a merry Christmas...<br>
...............................We wish you a merry Christmas...<br>
...................................We wish you a merry Christmas...<br>
</p>
</div>
<br>
<c:if test="${not empty giftsToBuy}">
Left to Buy: ${giftsToBuy}
</c:if>

</body>
</html>