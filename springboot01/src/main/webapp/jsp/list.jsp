<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
	  <tr>
	  	<td>用户名</td>
	  	<td>密码</td>
	  </tr>
	  <c:forEach items="${date }" var="i">
	   <tr>
	  	<td>${i.u_name}</td>
	  	<td>${i.u_password}</td>
	  </tr>
	</c:forEach>
	</table>
	

</body>
</html>