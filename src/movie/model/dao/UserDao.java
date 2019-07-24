package movie.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import movie.beans.LoginInfoBeans;

public class UserDao extends DaoBase{
	
	public LoginInfoBeans getBy(String id, String pw) {
		
		if(con == null) {
			return null;
		}
		LoginInfoBeans loginInfo = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
			try {
				stmt = con.prepareStatement("SELECT ");
				
	
				stmt.setString(1, id);
				stmt.setString(2, pw);
				
				rs = stmt.executeQuery();
				
				while(rs.next()){
					loginInfo = new LoginInfoBeans();
				}
			}catch(SQLException e) {
				//エラー発生した場合にコンソールにログを出力する
				e.printStackTrace();
			}
			finally {
				try {
					if(rs != null) {
						rs.close();
					}
					if( stmt != null) {
						stmt.close();
					}
				} catch (SQLException e) {
					System.out.println("closeに失敗しました");
			}
		}
		return loginInfo;
	}
	
	public boolean insertUser(String mail,String password) {
		if(con == null) {
			return false;
		}
		
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("INSERT INTO ");
			
			stmt.setString(1, mail);
			stmt.setString(2, password);
			
			stmt.executeUpdate();
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(con!=null) {
				try {
					con.close();
				}
				catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return true;
	}
	
	public void unsubscribe() {
		if(con == null) {
			return;
		}
		
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("DELETE ");
			
			stmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
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
	
	public void changeName() {
		if(con == null) {
			return;
		}
		
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("UPDATE ");
			
			stmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
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
	
	public void changeMail() {
		if(con == null) {
			return;
		}
		
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("UPDATE ");
			
			
			stmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
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
	
	public void changePassword() {
		if(con == null) {
			return;
		}
		
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("UPDATE ");
			
			stmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
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
