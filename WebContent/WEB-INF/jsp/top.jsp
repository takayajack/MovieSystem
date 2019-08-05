<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.*" %>
<!DOCTYPE html>
<html lang="ja" dir="ltr">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="css/top.css">
  </head>
  <body>
	<jsp:include page="header/header.jsp"/>

<!-- <header> -->
<!-- 	<ul> -->
<!-- 		<li class="header-left"><a href="Logout"><input type="button"value="ログアウト"></a> -->
<!-- 	</ul> -->
<!-- </header> -->
  <%
	List<Map<String,String>> list = (List<Map<String,String>>)request.getAttribute("list");
%>

      <div id="example-4" class="carousel slide" data-ride="carousel" style="width:900px; margin-right: auto; margin-left: auto">

        <ol class="carousel-indicators">
          <li data-target="#example-4" data-slide-to="0" class="active"></li>
          <li data-target="#example-4" data-slide-to="1"></li>
          <li data-target="#example-4" data-slide-to="2"></li>
          <li data-target="#example-4" data-slide-to="3"></li>
        </ol>
<%

	for(Map map : list){
%>
        <div class="carousel-inner">
          <div class="carousel-item active">
            <img src=<%=map.get("thumbnail") %> alt="First slide">
          </div>

          <%
	}%>

          <a class="carousel-control-prev" href="#example-4" role="button" data-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
          </a>

          <a class="carousel-control-next" href="#example-4" role="button" data-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
          </a>
        </div>
      </div>
   <div class="button-panel">
      <form action="list" method = "GET">
      	<input type="submit" class="button" value="映画一覧">
      	</form>
      	<input type="submit" class="button" value="映画スケジュール">
      </div>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>


  </body>
</html>
