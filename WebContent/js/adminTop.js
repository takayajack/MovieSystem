$(function(){

	getList();

	$(document).on("click",".movie-data",function(){
		$("#movie-table").removeClass("hidden");
		$("#movie-table .id").val($(".id",this).text());
		$("#movie-table .synopsis").val($(".synopsis",this).text());
		$("#movie-table .thumbnail #thumbnail").attr("src",$(".thumbnail",this).text());
		$("#movie-table .url").val($(".url",this).text());
		$("#movie-table .time").val($(".time",this).text());
		$("#movie-table .open").val($(".open",this).text());
		$("#movie-table .close").val($(".close",this).text());
	});
	$('.thumbnail').change(function(){
		if (this.files.length > 0) {
		    let file = this.files[0];

		    let reader = new FileReader();
		    reader.readAsDataURL(file);

		    reader.onload = function() {
		      $('#thumbnail').attr('src', reader.result );
		    }
		}
	});
	function getList(){
		$.ajax({
			contentType : "Content-Type: application/json; charset=UTF-8",
			url : "./adminMovieList",
			type : "GET",
			cache: false,
		}).done(function(data){
			listShow(data);
		});
	}
	function listShow(data){
		const obj = data;
		console.log(obj);
		let str = "";
		if( !(obj == null) ){
			$.each(obj, function(i,val){
				str += "<tr class='movie-data'>";
				str += "<td class='hidden id'>"+val["id"]+"</td>";
				str += "<td class='name'>"+val["name"]+"</td>";
				str += "<td class='hidden thumbnail'><img src='"+val["thumbnail"]+"'alt='サムネイル'></td>";
				str += "<td class='hidden url'>"+val["url"]+"</td>";
				str += "<td class='hidden synopsis'>"+val["synopsis"]+"</td>";
				str += "<td class='hidden time'>"+val["time"]+"</td>";
				str += "<td class='hidden open'>"+val["open"]+"</td>";
				str += "<td class='hidden close'>"+val["close"]+"</td>";
				str += "</tr>";
			})
			$("#list-table").html(str);
		}else{
			console.log("aaa");
			str += "登録されている映画はありません";
			$("#list").html(str);
		}
	}

	function getCast(id){
		$.ajax({
			contentType : "Content-Type: application/json; charset=UTF-8",
			url : "./adminMovieCast",
			type : "GET",
			cache: false,
			data : {
				id : id
			}
		}).done(function(data){
			castShow(data);
		});
	}
	function castShow(data){
		const obj = data;
		let str = "";
		if(!(obj.length == 0)){
			$.each(obj,function(i,val){
				str += "<tr><td>"+val+"</td><tr>";
			})
			str += "<tr><td id='add'>＋</td></tr>";
			$("#cast").after(str);
		}
	}

});