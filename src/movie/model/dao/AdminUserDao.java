package movie.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import movie.beans.AdminLoginInfoBeans;

public class AdminUserDao extends DaoBase {

	public AdminLoginInfoBeans adminGetBy(String id,String pw) {

		if( con == null) {
			return null;
		}
		AdminLoginInfoBeans loginInfo = null;

		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			stmt = con.prepareStatement("SELECT admin_name "
									+	"FROM admins "
									+	"WEHRE admin_code = ? AND admin_password = ?");

			stmt.setString(1, id);
			stmt.setString(2, pw);
			rs = stmt.executeQuery();

			while( rs.next() ) {
				loginInfo = new AdminLoginInfoBeans();

				loginInfo.setName(rs.getString("admin_name"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
				try {
					if(rs!=null) {
						rs.close();
					}
					if(stmt!=null) {
						stmt.close();
					}
				}catch(SQLException e) {
					System.out.println("closeに失敗しました");
				}
			}
			return loginInfo;
		}
}
