<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/DietManagement/css/layout.css" />
<script src="/DietManagement/js/jquery-3.3.1.min.js" type="text/javascript"></script>
</head>
<body>

<div id = "wapper">
	<header>
		 <c:if test="${not empty sessionScope._USER_}">
			${sessionScope._USER_.name}님의 POINT : (${sessionScope._USER_.point}점)
		</c:if> 
	</header>
	<section class="inline">
		<aside>
			Aside
		</aside>
		<section>
			
		