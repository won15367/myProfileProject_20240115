<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/resources/css/content.css">
<link rel="stylesheet" href="/resources/css/title.css">
<link rel="stylesheet" href="/resources/css/board.css">
<script type="text/javascript" src="/resources/js/write.js"></script>
<title>Profile Home</title>
</head>
<body>
	<%@ include file="include/header.jsp" %>
	<form action="content_modifyOk" name="writeForm">
	<input type="hidden" value="${boardDto.qbnum }" name="qbnum">
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
				<td class="con_text">아이디</td>
				<td><input class="input_box" type="text" name="qbmid" value="${boardDto.qbmid }" readonly="readonly"></td>
			</tr>
			<tr>
				<td class="con_text">이름</td>
				<td><input class="input_box" type="text" name="qbmname" value="${boardDto.qbmname }" readonly="readonly"></td>
			</tr>
			<tr>
				<td class="con_text">이메일</td>
				<td><input class="input_box" type="text" name="qbemail" value="${boardDto.qbemail }" readonly="readonly"></td>
			</tr>
			<tr>
				<td class="con_text">제목</td>
				<td><input class="input_box" type="text" name="qbtitle" value="${boardDto.qbtitle }"></td>
			</tr>
			<tr>
				<td class="con_text">내용</td>
				<td><textarea class="btextarea" rows="10" cols="30" name="qbcontent">
					${boardDto.qbtitle }</textarea>
			</td></tr>	
			<tr>
				<td class="con_text">등록일</td>
				<td><input class="input_box" type="text" name="qbemail" value="${boardDto.qbdate }" readonly="readonly"></td>
			</tr>
					
			<tr><td colspan=2>&nbsp;</td></tr>
			<tr>
				<td colspan=2 align="center">
					<input type="button" class="con_btn" value="수정완료" onclick="writeCheck()">&nbsp;&nbsp;
					<input type="button" class="con_btn" value="취소" onclick="javascript:history.go(-1)">
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