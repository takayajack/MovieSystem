package movie.model;

import movie.beans.LoginInfoBeans;
import movie.model.dao.UserDao;

public class LoginModel {

	public LoginInfoBeans login(String ID,String password){
		LoginInfoBeans loginInfo = null;

		UserDao userDao = new UserDao();
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



