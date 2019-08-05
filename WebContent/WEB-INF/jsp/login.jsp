<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<link rel="stylesheet" href="css/login.css">
</head>
<body>
<%String err = (String)session.getAttribute("err"); %>

<div class="form-wrapper">
<h1>ログイン</h1>

<%if(err!=null){%>
<font color="red"><%=err %></font>
<%} %>

	<form action="auth" method="POST">

	<div class="form-item">
		<input type="email" name="email"
		required="required" placeholder="Email Address">
	</div>

	<div class="form-item">
		<input type="password" name="password"
		required="required" placeholder="Password">
	</div>
	<div class="button-panel">
		<input type="submit" class="button" value="ログイン">
	</div>
	</form>

	<form action="Register" method="POST">
	<div class="footer">
		<p><input type="submit" class="newbutton" value="新規会員登録はこちら"></p>
	</div>
	</form>
</div>


</body>

</html>
