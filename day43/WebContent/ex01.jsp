{"emp":[
<%@page import="com.mysql.cj.protocol.Resultset"%>
<%@page import="java.sql.DriverManager"%>
<%
String dirver="com.mysql.jdbc.Driver";
String url="jdbc:mysql://localhost:3306/lecture";
Map<String,String> env = System.getenv();
String user=env.get("MYSQL_USER");
String password=env.get("MYSQL_PW");
String sql="select * from emp";
Connection conn=null;
Statement stmt = null;
Resultset rs=null;
try{
	Class.forName(dirver);
	conn=DriverManager.getConnection(url, user, password);
	stmt=conn.createStatement();
	rs=stmt.executeQuery(sql);
	while(rs.next()){
%>
{
"empno"

]}
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
