<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import ="java.util.*, com.spring3.simBoard.model.NBoardDto" %>
{
"obj":
{
"nqid":"${bean.nqid}",
"content":"${bean.content}",
"sub":"${bean.sub}",
"img":"${bean.img}",
"id":"${bean.id}",
"wDate":"${bean.wDate}"
}
}