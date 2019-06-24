package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import diarysystem.Beans.LoginInfoBeans;

public class Userdao extends Daobase {
	/**
	 * ユーザーDBよりユーザー情報を取得する
	 * （ログイン処理と等価）
	 *
	 * @param student_id 学籍番号
	 * @param student_password パスワード
	 * @return
	 */
	public LoginInfoBeans getBy(String ID,String password){

		if( con == null){
			//接続していない場合はエラーとする
			return null;
		}
		LoginInfoBeans loginInfo = null;

		PreparedStatement stmt = null;
		ResultSet rs = null;

		try{

			///////////////////////////////////
			//SELECT文の発行
			stmt = con.prepareStatement("SELECT * FROM student inner join class ON student.class_code = class.class_code join course ON course.course_code = class.course_code WHERE student_id=? AND student_password=?");

			stmt.setString(1, ID);
			stmt.setString(2, password);
			rs = stmt.executeQuery();

			///////////////////////////////////
			//DBから値を取得
			while( rs.next() ){
				loginInfo = new LoginInfoBeans();

				loginInfo.setID(rs.getString("student_id"));
				loginInfo.setName(rs.getString("student_name"));
				loginInfo.setClasscode(rs.getString("class_code"));
				loginInfo.setCoursecode(rs.getString("course_code"));
				loginInfo.setCoursname(rs.getString("course_name"));
			}

		}catch(SQLException e) {
			//エラー発生した場合にコンソールにログを出力する
			e.printStackTrace();
		}
		finally {
	    	try {
		        // 接続を閉じる
	        	if( rs != null ){
					rs.close();
	        	}
	        	if( stmt != null ){
	        		stmt.close();
	        	}
			} catch (SQLException e) {
				System.out.println("closeに失敗しました");
				;	//closeの失敗は無視
			}
		}

		return loginInfo;
	}
}


