<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>映画新規追加</title>
<link rel="stylesheet"href="css/adminNewMovie.css">
</head>
<body>
	<article>
		<form id="movieForm"method="post"action="">
		<div class="hidden"><input type="text"name="no"id="no"></div>
		<table>
			<tr>
				<th>映画名</th>
			</tr>
			<tr class="under-border">
				<td><input type="text"name="name"required></td>
			</tr>

			<tr>
				<th>映画イメージ</th>
			</tr>
			<tr>
				<td><input type="file" name="thumbnail"required>
				<img id="thumbnail" src=""></td>
				<td><input type="text" name="url"required></td>
			</tr>

			<tr id="castList">
				<th>キャスト</th>
			</tr>
			<tr>
				<td id="castAdd"><img src="img/add.png" alt="新規追加"></td>
			</tr>

			<tr>
				<th>映画概要</th>
			</tr>
			<tr>
				<td><textarea rows="5" cols="20"name="synopsis"required></textarea></td>
			</tr>

			<tr>
				<th>上映時間</th>
			</tr>
			<tr>
				<td><input type="number" name="time"required>分</td>
			</tr>

			<tr>
				<td><input type="button" value="追加"></td>
			</tr>
		</table>
		</form>
	</article>
<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
<script type="text/javascript" src="js/adminNewMovie.js"></script>
</body>
</html>