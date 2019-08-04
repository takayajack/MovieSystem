<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import = "java.util.HashMap" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>


	<% HashMap<String,String> data = (HashMap<String,String>)request.getAttribute("seat"); %>
	<head>
		<meta content="text/html; charset=utf-8" http-equiv="Content-Type">
		<title>座席予約</title>
		<link rel="stylesheet" type="text/css" href="css/SeatReservation.css">
		<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
		<script type="text/javascript" src="js/SeatReservation.js"></script>
	</head>


	<body>
	<p id = "screen" >

		<span></span>
	</p>
	<div class="target-table">
    	<table>

			<%for (int i = 1;i <= 10; i++){ %>
				<tr>
			<%for (int j = 1;j <= 10; j++){ %>
		 	 <% String seat = data.get(i + "-" + j); %>
					<td>
						<input type="checkbox" id="chkroom<%= i %>-<%= j %>" name="chkroom<%= i %>-<%= j %>" style = "display:none">
						<a href="#" onclick="onClick(<%=i*100+j %>);">
						<% if(seat.equals("有")){%>
							<img id="imgchange<%= i %>-<%= j %>" alt="有" src="img/seatOffjpg.jpg" width="40px" height="40px">
						<% }else{%>
							<img id="imgchange<%= i %>-<%= j %>" alt="無" src="img/seatOn.png" width="40px" height="40px">
						<% } %>
						</a>
					</td>
			<%} %>
				</tr>
			<%} %>
    	</table>
	</div>

	</body>


</html>