<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>

<head>
<meta content="ja" http-equiv="Content-Language">
<meta content="text/html; charset=utf-8" http-equiv="Content-Type">
<title>会員 登録</title>
</head>

<body>
<% String errflg1 = request.getParameter("errflg1"); %>
<% String errflg2 = request.getParameter("errflg2"); %>
<% String errflg3 = request.getParameter("errflg3"); %>
<% String errflg4 = request.getParameter("errflg4"); %>

<%if(errflg1 != null){ %>
	メールアドレスを正しく入力してください。

<%}else if(errflg2 != null){ %>
	パスワードを正しく入力してください。

<%}else if(errflg3 != null){ %>
	上記と同じパスワードを正しく入力してください。

<%}else if(errflg4 != null){ %>
	入力されたパスワードと違います。
<%} %>

<link rel="stylesheet" type="text/css" href="userSubscribe.css">
<div><h1>会員 登録</h1></div>

<form action = "Register">
	<div>
		<label>メールアドレス</label>
		<input type="email" name="mail" required>
	</div>
	<div>
		<label>パスワード</label>
		<input type="password" name="pass" required>
	</div>
	<div>
		<label>パスワードの再入力</label>
		<input type="password" name="passConf" oninput="CheckPassword(this)" required>

	</div>
	<div>
	<input type="button" name="send" value="認証メールを送信">
	</div>
</form>
</body>

</html>
