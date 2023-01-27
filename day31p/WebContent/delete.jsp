<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="refresh" content="0; url=list.jsp">
</head>
<body>
<%@ page import="java.sql.*,java.util.*" %>
<%
String id=request.getParameter("id");
String sub=request.getParameter("sub");
String content=request.getParameter("content");
String sql="delete from bbs01 "
+" where num="+request.getParameter("num");

Map<String, String> env = System.getenv();
String url = "jdbc:mysql://localhost:3306/lecture01";
java.util.Properties info = new java.util.Properties();
info.setProperty("user", env.get("local.mysql.user"));
info.setProperty("password", env.get("local.mysql.password"));

java.sql.Connection conn = null;
java.sql.Statement stmt = null;
java.sql.ResultSet rs = null;
try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	conn = java.sql.DriverManager.getConnection(url, info);
	stmt = conn.createStatement();
	stmt.executeUpdate(sql);
} catch (Exception e){
	out.println("<tr><td colspan=\"4\">"+e.toString()+"에러 관리자에게 문의하세요</td></tr>");
} finally {
	try {
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
		if(conn!=null) conn.close();
	} catch (java.sql.SQLException e) {
		e.printStackTrace();
	}
}

%>

</body>
</html>