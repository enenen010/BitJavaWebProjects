<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p><%request.getRemoteAddr(); %></p>
<p><%request.getMethod(); %></p>
<p><%request.getRequestURI(); %></p>
<p><%request.getContextPath(); %></p>
<a href="ex05.jsp">[link]</a>
</body>
</html>