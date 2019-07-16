
	//席取得
	 function onClick(link){
		 //alert("!"+link);
		 var row = parseInt(link/100);
		 var col = link%100;
		// alert(row+"行目 "+col+"列目");
	      // 冗長なので、closestを使用する
	      // console.log($(link).parent().parent().find('td').first().text());
	      console.log($(link).closest('tr').find('td').first().text());

	      var boxes = document.getElementById("chkroom"+ row +"-"+ col);

	      if(boxes.checked == true){
	    	  var imgchange =  document.getElementById("imgchange"+ row +"-"+ col);
	    	  imgchange.src = "img/seatOn.png";
	    	  boxes.checked = false;
	      }else{
	    	  boxes.checked = true;
	    	  var imgchange = document.getElementById("imgchange"+ row +"-"+ col);
	    	  imgchange.src = "img/seatCheck.png";
	      }
	    }
