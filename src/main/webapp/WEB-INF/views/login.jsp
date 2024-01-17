<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<form action="loginOk" method="post" name="loginForm">
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
				<td class="con_text">아이디: </td>
				<td><input class="input_box" type="text" name="mid"></td>
			</tr>
			<tr>
				<td class="con_text">비밀번호: </td>
				<td><input class="input_box" type="password" name="mpw"></td>
			<tr><td colspan=2>&nbsp;</td></tr>
			<tr>
				<td colspan=2 align="center">
					<input type="button" class="con_btn" value="로그인" onclick="loginCheck()">&nbsp;&nbsp;
					<input type="button" class="con_btn" value="회원가입" onclick="javascript:window.location.href='join'">
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