<!-- text/html 결국 .class파일 까지 실행해서 나오는 결과는 다시 문자열
문자열(html)을 받아 코드로만들어(.java.class) 실행하면 다시 문자열(html)

페이지 이동 등 앵커 -> 결국 jsp내의 자바는 문자열 제어 밖에 할게... 
 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 이건 문서 전체 앞에 붙을 헤더임 tomcat에서 java소스코드로 만들기 위해 붙이는 -->
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 	<!-- 이건 보이고 -->
	<h1>문서 작성</h1>
	<%
	//이안은 자바의 영역(이건 안보임)
	System.out.println();
	
	//내장객체 쓰면 페이지에 출력
	//단 이 개행은 소스의 개행 <br><p>를 통한 개행이 아님
	//: 자바를 사용하지만 HTML의 문법대로 문자열이 작성되야함
	
	//결국 문자열 제어
	//웹은 문자열을 어떻게 제어하느냐
	out.print("<p>하난</p>");
	out.print("<p>둘</p>");
	//이클립스 없으면 톰캣로그에 찍힘
	%>
	
	
	<%
	//요것도 가능
	for(int i=0;i<5;i++){
	%>
	<p>화면 출력 <%out.print(i); %></p>
	<%
	}
	%>
	
	
</body>
</html>