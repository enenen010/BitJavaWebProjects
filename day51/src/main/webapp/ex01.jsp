<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HOME</title>
</head>
<body>
<h1>로그인</h1>
<form action="ex01.do" method="post">
	<div>
		<label>id</label>
		<input name="id"/>
	</div>
	<div>
		<label>pw</label>
		<input type="password" name="pw"/>
	</div>
	<div>
		<button>로그인</button>
	</div>
	<div>
		<input type="checkbox" name="ch"/>아이디 저장
	</div>
</form>
</body>
</html>