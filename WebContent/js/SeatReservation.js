


	//ホバーしたときのセルの色を変える。

	$(function(){
		 tr_default("#target-table");
		 $("#target-table").click(function(){
		  tr_default("#target-table");
		  tr_click($(this));
		 });


		function tr_default(tblID){
		 var vTR = tblID + " td";
		 $(vTR).css("background-color","#ffffff");
		 $(vTR).mouseover(function(){
		  $(this).css("background-color","#CCFFCC") .css("cursor","pointer")
		 });
		 $(vTR).mouseout(function(){
		  $(this).css("background-color","#ffffff") .css("cursor","normal")
		 });
		}

		function tr_click(trID){
		 trID.css("background-color","#e49e61");
		 trID.mouseover(function(){
		  $(this).css("background-color","#CCFFCC") .css("cursor","pointer")
		 });
		 trID.mouseout(function(){
		  $(this).css("background-color","#e49e61") .css("cursor","normal")
		 });
		}
	});


	//選択されたセルの値を返す。
	$(function() {
	    $('#target-table td').on('click',function() {
		  var td= $(this);
	      var select = $(this).text();//xx-xx




	      var rowData = select.substr(0,select.indexOf('-'));
	      var colData = select.substr(select.indexOf('-')+1);



		  console.log("行：" + rowData);
		  console.log("横：" + colData);

	    });
	  });




