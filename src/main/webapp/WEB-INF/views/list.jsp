<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/resources/css/content.css">
<link rel="stylesheet" href="/resources/css/title.css">
<link rel="stylesheet" href="/resources/css/board.css">
<script type="text/javascript" src="/resources/js/join.js"></script>
<title>Profile Home</title>
</head>
<body>
	<%@ include file="include/header.jsp" %>
	<form action="joinOk" method="post" name="joinForm">
	<table border="0" cellpadding="20" cellspacing="0" style=";margin-left:auto;margin-right:auto;" width="80%">
	<tr>
		<td align="center">
			<span class="title01">My Profile</span>
		</td>
	</tr>
	<tr>
		<td align="center">
			<span class="title02">developer</span>
		</td>
	</tr>
	<tr>
	<td class="con_box" align="center">
		<table border="0" cellpadding="0" cellspacing="0" width="80%" style=";margin-left:auto;margin-right:auto;">
			<tr>
				<th class="btitle">번호</th>
				<th class="btitle">아이디</th>
				<th class="btitle">이름</th>
				<th class="btitle" width="50%">글제목</th>
				<th class="btitle">등록일</th>
			</tr>
			
			<c:forEach items="${list}" var="dto">
				<tr>
					<td class="bcontent" align="center">${dto.qbnum }</td>
					<td class="bcontent" align="center">${dto.qbmid }</td>
					<td class="bcontent" align="center">${dto.qbmname }</td>
					<td class="bcontent" align="left">${dto.qbtitle }</td>
					<td class="bcontent" align="center">${dto.qbdate }</td>
				</tr>
			</c:forEach>
		</table>
	</td>
	</tr>	
	</table>
	</form>
	<%@ include file="include/footer.jsp" %>
</body>
</html>