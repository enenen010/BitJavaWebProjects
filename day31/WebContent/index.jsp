<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border>
<%
java.util.Map<String, String> env = System.getenv();
String url = "jdbc:mysql://localhost:3306/lecture01";
java.util.Properties info = new java.util.Properties();
info.setProperty("user", "scott");
info.setProperty("password", "tiger");

java.sql.Connection conn = null;
java.sql.Statement stmt = null;
java.sql.ResultSet rs = null;
try {
	
	String sql="select EMPNO, ENAME, JOB, MGR "
			+"from emp";
	
	Class.forName("com.mysql.cj.jdbc.Driver");
	conn = java.sql.DriverManager.getConnection(url, info);
	stmt = conn.createStatement();
	rs =  stmt.executeQuery(sql);
	
	while(rs.next()){//커서를 이동시키고 있는지 없는지를 반환 메서드
		//rs.getString(1) 현재 rs의 값
%>
<tr>
<td><%=rs.getString(1)%></td>
<td><a href=detail.jsp?empno=<%=rs.getString(1)%> >
	<%=rs.getString(2)%></a></td>
<td><%=rs.getString(3)%></td>
<td><%=rs.getString(4)%></td>
</tr>
<%
	}
} catch (java.sql.SQLException e) {
	System.out.println("문법 오류 또는 실행오류");
} catch (ClassNotFoundException e) {
	System.out.println("드라이버 로딩 확인");
	System.out.println("드라이버 등록이 잘못되었습니다.");
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
</body>
</html>