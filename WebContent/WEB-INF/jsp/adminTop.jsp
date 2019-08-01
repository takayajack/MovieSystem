<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Top</title>
<link rel="stylesheet" href="css/adminTop.css">
</head>
<body>
<jsp:include page="./header/header.jsp"/>
	<article id="list">
		<table id="list-table">
		</table>
	</article>

	<article class="hidden" id="movie-table">
		<form id="movieForm"method="post"action="">
		<table>
			<tr><td class="id"></td></tr>
			<tr>
				<th>映画名</th>
				<td><input type="text" class="name"></td>
			</tr>
			<tr>
				<th>映画概要</th>
				<td><textarea rows="20" cols="5"class="synopsis"></textarea></td>
			</tr>
			<tr>
				<th>映画イメージ</th>
				<td><input type="file" class="thumbnail">
				<img id="thumbnail" src=""></td>
				<td><input type="text" class="url"></td>
			<tr>
				<th>上映時間</th>
				<td><input type="number" class="time">分</td>
			</tr>
			<tr>
				<td><input type="button" value="更新"></td>
				<td><input type="button" value="cast"></td>
				<td><input type="button" value="削除"></td>
			</tr>
		</table>
		</form>
	</article>

	<article class="hidden" id="cast-table">
		<table>
			<tr id="cast">
				<th>キャスト</th>
			</tr>
		</table>
	</article>
	<p id="movieAdd"><a href="/adminMovieAdd"><img src="img/add.png" alt="新規追加"></a></p>

<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
<script type="text/javascript" src="js/adminTop.js"></script>
</body>
</html>