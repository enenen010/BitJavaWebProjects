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
			<td colspan="3"><img alt="logo" src="imgs/logo.png"></td>
			<td colspan="3"></td>
		</tr>
		<tr>
			<td height="35" background="imgs/mn1.png"></td>
			<td width="150" background="imgs/mn1.png" align="center"><a
				href="index.jsp">[HOME]</a></td>
			<td width="150" background="imgs/mn1.png" align="center"><a
				href="intro.jsp">[INTRO]</a></td>
			<td width="150" background="imgs/mn1.png" align="center"><a
				href="list.jsp">[B B S]</a></td>
			<td width="150" background="imgs/mn1.png" align="center"><a
				href="login.jsp">[LOGIN]</a></td>
			<td background="imgs/mn1.png"></td>
		</tr>
		<tr>
			<td colspan="6" height="" valign="top">
				<%@ page import="java.sql.*,java.util.*" %>
				<%
					String url = "jdbc:mysql://localhost:3306/lecture01";
				String sql = "select num,sub,id,nalja,content from";
				sql += "bbs01 where num=" + request.getParameter("num");
				System.out.println(sql);
				
				Map<String, String> env = System.getenv();
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
					stmt = conn.createStatement();
					rs = stmt.executeQuery(sql);

					if (rs.next()) {
				%>
				<form action="update.jsp">
					<input type="hidden" name="num" value=<%=rs.getInt(1)%>>
					</h1>
					<table align="center">
						<tr>
							<td>제목</td>
							<td colspan="4" height="20"><input type="text" name="sub">
							<input type="text" name="sub" value=<%=rs.getString(2)%>>
							</td>
						</tr>

						<tr>
							<td>글쓴이</td>
							<td><%=rs.getString(3)%></td>
							<td>날짜</td>
							<td><%=rs.getDate(4)%></td>
						</tr>

						<tr>
							<td>제목</td>
							<td colspan="4" height="20">
								<%
									
								%>
							</td>
						</tr>
						<tr>
							<td colspan="4" align="center"><input type="submit"
								value="입력"> <input type="reset" value="취소"></td>
						</tr>
					</table>
				</form> <%
 	}
 } catch (Exception e) {
 out.println("<tr><td colspan=\"4\">" + e.toString() + "에러 관리자에게 문의하세요</td></tr>");
 } finally {
 try {
 if (rs != null)
 	rs.close();
 if (stmt != null)
 	stmt.close();
 if (conn != null)
 	conn.close();
 } catch (java.sql.SQLException e) {
 e.printStackTrace();
 }
 }
 %>
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