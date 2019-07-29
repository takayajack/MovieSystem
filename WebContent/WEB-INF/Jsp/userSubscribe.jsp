<!DOCTYPE html>
<html>

<head>
<meta content="ja" http-equiv="Content-Language">
<meta content="text/html; charset=utf-8" http-equiv="Content-Type">
<title>会員 登録</title>
</head>

<body>
<link rel="stylesheet" type="text/css" href="userSubscribe.css">
<div><h1>会員　登録</h1></div>

<form action=""  onsubmit="return false;">
	<div>
		<label>メールアドレス</label>
		<input type="email" name="mail" required>
	</div>
	<div>
		<label>パスワード</label>
		<input type="password" name="pass" required>
	</div>
	<div>
		<label>パスワードの再入力</label>
		<input type="password" name="passConf" oninput="CheckPassword(this)" required>
		
	</div>
	<div>
	<input type="button" name="send" value="認証メールを送信">
	</div>
</form>
<script>
	function CheckPassword(confirm){
		// 入力値取得
		var input1 = pass.value;
		var input2 = conf.value;
		// パスワード比較
		if(input1 != input2){
			confirm.setCustomValidity("入力値が一致しません。");
		}else{
			confirm.setCustomValidity('');
		}
	}
</script>
</body>

</html>
