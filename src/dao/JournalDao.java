package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import diarysystem.Beans.DiaryBeans;
import diarysystem.Beans.LoginInfoBeans;

public class JournalDao extends Daobase {
/**
 * diaryDBより日誌情報を取得する。
 *
 * 	@author takaya
 *
 *@param class_code クラスコード
 *@param insert_code 日付
 *@param student_id 学籍番号
 *@param good_point 良い点
 *@param bad_point 悪い点
 *@param student_comment 学生のコメント
 *
 */
	public List<DiaryBeans> getList(String classcode) {

		 List<DiaryBeans> list = new ArrayList<DiaryBeans>();

			if( con == null) {
			         //接続して無い場合はエラーとする。
				return null;
			}
			DiaryBeans Diary = null;

			PreparedStatement stmt = null;
			ResultSet rs = null;

			try {

				//////////////////////////////////////////////
				//SELECT文の発行
				stmt = con.prepareStatement("SELECT * FROM Diary INNER JOIN student ON diary.student_id = student.student_id WHERE diary.class_code=?");

				stmt.setString(1,classcode);
				rs = stmt.executeQuery();

				/////////////////////////////////////////////
				//DBから値を取得
				while(rs.next()) {
					Diary = new DiaryBeans();

					Diary.setClasscode(rs.getString("class_code"));
					Diary.setInsertDate(rs.getTimestamp("insert_date"));
					Diary.setStudent(rs.getString("student_id"));
					Diary.setStudentname(rs.getString("student_name"));
					Diary.setGoodpoint(rs.getString("good_point"));
					Diary.setBadpoint(rs.getString("bad_point"));
					Diary.setComment(rs.getString("student_comment"));

					list.add(Diary);
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

				return list;
			}

	public void insert(LoginInfoBeans logininfobeans, DiaryBeans diarybeans){


		if( con == null){
			//接続していない場合は何もしない
			return;
		}

		PreparedStatement stmt = null;

		try{
			///////////////////////////////////
			//SELECT文の発行
			stmt = con.prepareStatement("INSERT INTO diary (class_code,insert_date,student_id,good_point,bad_point,student_comment,teacher_comment) "
										+ "VALUES(?,now(),?,?,?,?,null)");

			stmt.setString(1,logininfobeans.getClasscode() );
			stmt.setString(2,logininfobeans.getID());
			stmt.setString(3, diarybeans.getGoodpoint());
			stmt.setString(4, diarybeans.getBadpoint());
			stmt.setString(5, diarybeans.getComment());
			stmt.executeUpdate();


		}catch(SQLException e) {
			//エラー発生した場合にコンソールにログを出力する
			e.printStackTrace();
		}
		finally {
			//接続（コネクション）を閉じる
			if(con!=null) {
				try {
					con.close();
				}
				catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}
}

