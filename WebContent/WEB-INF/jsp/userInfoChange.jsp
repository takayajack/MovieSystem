<!DOCTYPE html>
<html>

<head>
<meta content="text/html; charset=utf-8" http-equiv="Content-Type">
<title>無題 1</title>
</head>

<body>
<link rel="stylesheet" type="text/css" href="userInfoChange.css">
<script type="text/javascript">
<!-- 

function check(){

	var flag = 0;


	// 設定開始（必須にする項目を設定してください）

	if(document.form1.mail.value == ""){ // 「お名前」の入力をチェック

		flag = 1;

	}
	else if(document.form1.pass.value == ""){ // 「パスワード」の入力をチェック

		flag = 1;

	}
	else if(document.form1.conf.value == ""){ // 「コメント」の入力をチェック

		flag = 1;

	}

	// 設定終了


	if(flag){

		window.alert('必須項目に未入力がありました'); // 入力漏れがあれば警告ダイアログを表示
		return false; // 送信を中止

	}
	else{

		return true; // 送信を実行

	}

}

</script>
<div><h1>会員情報変更</h1></div>
<form method="POST" action="登録完了（仮）.html" name="form1" onSubmit="return check()">

	<div>メールアドレス</div>
		
		<div><input type="text" name="mail"></div>
		<div><input type="button" name="NameChange" value="変更"></div>
		<div>パスワード</div>
		<div><input type="password" name="pass"></div>
		<div>パスワードの再入力</div>
		<div><input type="password" name="conf"></div>
		<div><input type="button" name="PassChange" value="変更"></div>
		<div><input type="button" name="send" value="認証メールを送信"></div>
</form>

</body>

</html>
