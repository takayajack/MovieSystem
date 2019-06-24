package diarysystem.model;

import dao.Userdao;
import diarysystem.Beans.LoginInfoBeans;

public class LoginModel {
	/**
	 * ログイン処理を行う
	 * 引数でもらったmailとパスワード
	 *
	 * @param ID
	 * @param password
	 * @return
	 */
	public LoginInfoBeans login(String ID,String password){
		LoginInfoBeans loginInfo = null;

		Userdao userDao = new Userdao();
		try{
			///////////////////////////////////
			//DBの接続
			userDao.connect();

			///////////////////////////////////
			//ユーザー情報の取得
			loginInfo = userDao.getBy(ID, password);

		}catch(Exception e) {
			//エラー発生した場合にコンソールにログを出力する
			e.printStackTrace();
		}
		finally {
			//接続（コネクション）を閉じる
			if(userDao!=null) {
				userDao.close();
			}
		}

		return loginInfo;
	}
}

