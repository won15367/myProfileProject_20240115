<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/resources/css/content.css">
<link rel="stylesheet" href="/resources/css/title.css">
<script type="text/javascript" src="/resources/js/join.js"></script>
<title>Profile Home</title>
</head>
<body>
	<%@ include file="include/header.jsp" %>
	
	<c:if test="${joinFail == 1 }">
		<script type="text/javascript">
			alert("가입하시려는 아이디는 이미 있는 아이디입니다.")
			history.go(-1)
		</script>
	</c:if>
	
	<form action="joinOk" method="post" name="joinForm">
	<table border="0" cellpadding="20" cellspacing="0" style=";margin-left:auto;margin-right:auto;">
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
		<table>
			<tr>
				<td class="con_text">
					${mname }님 회원가입 축하드립니다!<br>
					가입하신 아이디는 ${mid }입니다.
				 </td>
			</tr>
			<tr>
				<td align="center">
					<input type="button" class="con_btn" value="로그인" onclick="javascript:window.location.href='login'">
				</td>
			</tr>
		</table>
	</td>
	</tr>	
	</table>
	</form>
	<%@ include file="include/footer.jsp" %>
</body>
</html>