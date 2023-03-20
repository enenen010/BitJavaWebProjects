<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page pageEncoding="utf-8" %>
<% System.out.println("jsp ..."); %>
<!doctype html>
<html>
<head>
	<meta charset="utf-8">
	<title>Home</title>
</head>
<body>
	<h1>파일 업로드</h1>
	<form action="upload" method="post" enctype="multipart/form-data">
		<div>
			<input type="text" name="msg" />
		</div>
		<div>
			<input type="file" name="file1" />
		</div>
		<div>
			<button>업로드</button>
		</div>
	</form>
</body>
</html>
