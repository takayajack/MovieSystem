$(function(){
	let no = 0;
	$("#castAdd").on("click",function(){
		$("#castList").after("<tr><td><input type='text' name="+no+"></td>" +
				"<td id="+no+" class='remove'><img src='./img/batsu.png'alt='×'></td></tr>");
		no += 1;
		$("#no").val(no);
	});
	$(document).on("click",".remove",function(){
		let id = $(this).attr("id");
	});
});