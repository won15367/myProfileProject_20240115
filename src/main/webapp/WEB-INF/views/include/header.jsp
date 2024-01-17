<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/resources/css/header.css">
<meta charset="UTF-8">
<title>Header</title>
</head>
<body>
	<table border="0" cellpadding="0" cellspacing="0" width="100%">
		<tr class="headerline">
			<td class="menutext" width="65%">
				&nbsp;
			</td>
			<td class="menutext" width="5%" align="center">
				<a href="index"><span class="menutext">HOME</span></a>
			</td>
			
		<c:choose>
			<c:when test="${sessionScope.sessionId eq null }">
				<td class="menutext" width="5%" align="center">
					<a href="login"><span class="menutext">LOGIN</span></a>
				</td>
				<td class="menutext" width="5%" align="center">
					<a href="join"><span class="menutext">JOIN</span></a>
				</td>
			</c:when>
			
			<c:otherwise>
				<td class="menutext" width="5%" align="center">
					<a href="logout"><span class="menutext">LOGOUT</span></a>
				</td>
				<td class="menutext" width="5%" align="center">
					<a href="modify_form"><span class="menutext">MODIFY</span></a>
				</td>
			</c:otherwise>
		</c:choose>
		
			<td class="menutext" width="5%" align="center">
				<a href="#"><span class="menutext">PROFILE</span></a>
			</td>
			<td class="menutext" width="5%" align="center">
				<a href="#"><span class="menutext">BOARD</span></a>
			</td>
			<td class="menutext" width="5%" align="center">
				<a href="#"><span class="menutext">CONTACT</span></a>
			</td>
			<td width="5%" align="center">
				&nbsp;
			</td>
		</tr>
		<tr height="20"><td>
			&nbsp;
		</td></tr>
	</table>
</body>
</html>