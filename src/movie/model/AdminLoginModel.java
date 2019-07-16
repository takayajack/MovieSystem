package movie.model;

import movie.beans.AdminLoginInfoBeans;
import movie.model.dao.AdminUserDao;

public class AdminLoginModel {

	public AdminLoginInfoBeans AdminLogin(String id,String pw) {

		AdminLoginInfoBeans loginInfo = null;

		AdminUserDao dao = new AdminUserDao();
		try {
			dao.connect();

			loginInfo = dao.adminGetBy(id, pw);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//接続（コネクション）を閉じる
			if(dao!=null) {
				dao.close();
			}
		}
		return loginInfo;
	}
}
