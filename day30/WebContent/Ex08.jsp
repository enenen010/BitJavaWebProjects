<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 응답관련(헤더 설정 등) -->
<h1>에러 페이지</h1>
<%
response.setStatus(404);
%>
</body>
</html>