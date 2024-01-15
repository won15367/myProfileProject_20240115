<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/resources/css/title.css">
<title>Profile Home</title>
</head>
<body>
	<%@ include file="include/header.jsp" %>
	<center>
	<table border="0" cellpadding="20" cellspacing="0">
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
		<td>
			<table border="0" cellpadding="10" cellspacing="0">
				<tr>
					<td class="skillbox">
						<span class="title03">J</span><span class="title04">ava</span>
					</td>
					<td rowspan=6 class="imgbox">
						<img src="/resources/img/rabbit.jpg" style="width:500px; heigth:500px" />
					</td>
				</tr>
				<tr>
					<td class="skillbox">
						<span class="title03">J</span><span class="title04">sp</span>
					</td>
					<td></td>
				</tr>
				<tr>
					<td class="skillbox">
						<span class="title03">S</span><span class="title04">prigBoot</span>
					</td>
					<td></td>
				</tr>
				<tr>
					<td class="skillbox">
						<span class="title03">J</span><span class="title04">avascript</span>
					</td>
					<td></td>
				</tr>
				<tr>
					<td class="skillbox">
						<span class="title03">H</span><span class="title04">tml5&CSS</span>
					</td>
					<td></td>
				</tr>
				<tr>
					<td class="skillbox">
						<span class="title03">D</span><span class="title04">atabase</span>
					</td>
					<td></td>
				</tr>
			</table>
		</td>
	</tr>	
	</table>
	</center>
	<%@ include file="include/footer.jsp" %>
</body>
</html>