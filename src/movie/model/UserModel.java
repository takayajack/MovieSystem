package movie.model;

import movie.beans.LoginInfoBeans;
import movie.model.dao.UserDao;

public class UserModel {
	
	UserDao userDao = new UserDao();
	LoginInfoBeans loginInfo = null;
	
	public LoginInfoBeans resitration(String mail,String password) {
		
		try {
			userDao.connect();
			
			loginInfo = userDao.getBy(mail,password);
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			
			if(userDao!=null) {
				userDao.close();
				
			}
		}
		return loginInfo;
	}
	
	public void unsubscribe() {
		
		try {
			userDao.connect();
			
			userDao.unsubscribe();
		
		}catch(Exception e) {
			//エラー発生した場合にコンソールにログを出力する
			e.printStackTrace();
		}
		finally {
			//接続（コネクション）を閉じる
			userDao.close();
		}
		
	}
	
	public void changeName() {
		try {
			userDao.connect();
			
			userDao.changeName();
		
		}catch(Exception e) {
			//エラー発生した場合にコンソールにログを出力する
			e.printStackTrace();
		}
		finally {
			//接続（コネクション）を閉じる
			userDao.close();
		}
		
	}

	public void changeMail() {
		
		try {
			userDao.connect();
			
			userDao.changeMail();
		
		}catch(Exception e) {
			//エラー発生した場合にコンソールにログを出力する
			e.printStackTrace();
		}
		finally {
			//接続（コネクション）を閉じる
			userDao.close();
		}
	
	}
	
	public void changePassword() {
		
		try {
			userDao.connect();
			
			userDao.changePassword();
		
		}catch(Exception e) {
			//エラー発生した場合にコンソールにログを出力する
			e.printStackTrace();
		}
		finally {
			//接続（コネクション）を閉じる
			userDao.close();
		}
	}

}
