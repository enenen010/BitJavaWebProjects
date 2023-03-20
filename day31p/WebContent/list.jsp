<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table width="800" align="center">
<!-- 세로:4 가로:6 -->
<tr>
<td colspan="3">
<img alt="logo" src="imgs/logo.png"> 
</td>
<td colspan="3"></td>
</tr>
<tr>
<td height="35" background="imgs/mn1.png"></td>
<td width="150"  background="imgs/mn1.png" align="center"><a href="index.jsp">[HOME]</a></td>
<td width="150"  background="imgs/mn1.png" align="center"><a href="intro.jsp">[INTRO]</a></td>
<td width="150"  background="imgs/mn1.png" align="center"><a href="list.jsp">[B B S]</a></td>
<td width="150"  background="imgs/mn1.png" align="center"><a href="login.jsp">[LOGIN]</a></td>
<td background="imgs/mn1.png"></td>
</tr>
<tr>
<td colspan="6" height=""  valign="top" align="center">
<p><h1>게시판</h1></p>
<br>
<table width="80%" align="center">
<tr>
<td background="imgs/mn1.png">글번호</td>
<td>제목</td>
<td>글쓴이</td>
<td>날짜</td>
</tr>
<%@ page import="java.sql.*,java.util.*" %>
<%
Map<String, String> env = System.getenv();
String url = "jdbc:mysql://localhost:3306/lecture01";
java.util.Properties info = new java.util.Properties();
info.setProperty("user", env.get("local.mysql.user"));
info.setProperty("password", env.get("local.mysql.password"));

java.sql.Connection conn = null;
java.sql.Statement stmt = null;
java.sql.ResultSet rs = null;
try {
	
	String sql="select num, sub, id, nalja "
			+"from bbs01";
	
	Class.forName("com.mysql.cj.jdbc.Driver");
	conn = java.sql.DriverManager.getConnection(url, info);
	stmt = conn.createStatement();
	rs =  stmt.executeQuery(sql);
	
	while(rs.next()){//커서를 이동시키고 있는지 없는지를 반환 메서드
		//rs.getString(1) 현재 rs의 값

%>
<tr>
<td><%=rs.getString(1)%></td>
<td><a href=detail.jsp?num=<%=rs.getString(1)%> >
	<%=rs.getString(2)%></a></td>
<td><%=rs.getString(3)%></td>
<td><%=rs.getString(4)%></td>
</tr>
<%
	}
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
</table>
<br>
<a href="add.jsp" align="center">[입 력]</a>
</td>
</tr>




<tr>
<td colspan="6" background="imgs/footer.png">
<p>(주)비트컴퓨터</p>
</td>
</tr>



</table>
</body>
</html>