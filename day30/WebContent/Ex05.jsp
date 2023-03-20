<%@page import="java.util.Map"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <!-- ?id=root&pw=11 -->
	<p>id:<%=request.getParameter("id")%>
	<p>pw:<%=request.getParameter("pw")%>
	<p>ra:<%=request.getParameter("ra")%>
	<p>ch:<%
	String[] vals = request.getParameterValues("ch");
	out.print(java.util.Arrays.toString(vals));
	%>
	<p>select:<%=request.getParameter("sel")%>
	
	<!-- 넘어오는게 뭔지 모르면? -->
	<p>
	<%
	Enumeration en = request.getParameterNames();
	while(en.hasMoreElements()){
		out.println(en.nextElement());
	}
	
	java.util.Map map = request.getParameterMap();
	Set<Map.Entry> set= map.entrySet();
	Iterator<Map.Entry> ite = set.iterator();
	while(ite.hasNext()){
		Map.Entry<String, String[]> entry = ite.next();
		System.out.println(entry.getKey()+":"
		+java.util.Arrays.toString(entry.getValue()));
	}
	
	%>
	<%en=request.getHeaderNames(); 
	while(en.hasMoreElements()){
		System.out.println(en.nextElement());
	}
	%>
	</p>
</body>
</html>