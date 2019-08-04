<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理者ログイン</title>
</head>
<body>
<%
	String errflg = request.getParameter("errflg");
%>
<form action="adminAuth"method="post">
	<article>
		<h1>管理者ログイン画面です</h1>
<%if(errflg!=null && "1".equals(errflg)){ %>
		<div class="error">学籍番号かパスワードが間違っています</div>
<% } %>
		<table>
			<tr>
				<td><input type="text" name="id" placeholder="ID"></td>
			</tr>
			<tr>
				<td><input type="password"name="password"placeholder="パスワード"></td>
			</tr>
		</table>
		<input type="submit" value="ログイン">
	</article>
</form>
</body>
</html>