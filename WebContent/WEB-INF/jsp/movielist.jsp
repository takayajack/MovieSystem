<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="movie.beans.MovieListBeans" %>
    <%@page import="movie.beans.LoginInfoBeans" %>
    <%@page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MovieList</title>
<link rel="stylesheet" href="css/movielist.css">
</head>

<body>
<%
	List<MovieListBeans> list = (List<MovieListBeans>)request.getAttribute("list");
%>



	<div class="nowmovie">
	<h2>上映作品</h2>
	</div>

<%
if(list != null){
	for(MovieListBeans movie : list){
%>
	<div class="movie">
	<div class="image">
	<img src=<%= movie.getThumbnail() %> alt="画像" >
	</div>

	<div class="info">
		<div class="title">
			<h3><%= movie.getTitle() %></h3>
		</div>

		<div class="cast">
			<table>
				<tr>
					<td class="casticon">出演</td>
					<%if(movie.getCast() != null){
						String str="";
						for(String cast : movie.getCast()) {
					%>
					<% str+=cast; %>

					<%	}%>
						<td class="member"><%=str%></td>
					<%}%>
				</tr>
			</table>
		</div>

		<div class="todetailbtn">
			<input type="submit" class="button" value="作品詳細　上映スケジュール">
		</div>

	</div>
	</div>

<%
	}
}
%>

</body>

</html>
