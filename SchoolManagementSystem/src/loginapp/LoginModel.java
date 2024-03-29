package loginapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dbUtil.dbConnection;

public class LoginModel {

	Connection connection;
	
	public LoginModel() {
		
		//check if we're connected
		try {
			this.connection = dbConnection.getConnection();
		} catch (SQLException ex) {
			
			ex.printStackTrace();
		}
		
		if(this.connection == null) {
			
			System.exit(1);
		}
	}
	
	//is db connected
	public boolean isDatabaseConnected() {
		return this.connection != null;
	}
	
	// check login
	public boolean isLogin(String user, String pass, String opt) throws Exception {
		
		PreparedStatement pr = null;
		ResultSet rs = null;
		
		// sql query
		String sql = "SELECT * FROM login where username = ? and password = ? and division = ?";
		
		try {
			
			//check from the database username/password
			pr = this.connection.prepareStatement(sql);
			pr.setString(1, user);
			pr.setString(2, pass);
			pr.setString(3, opt);
			
			rs = pr.executeQuery();
			
			boolean boll1;
			
			if(rs.next()) {
				return true;
			}
			return false;
			
			} 
		catch (SQLException ex){
				return false;
			}
		// need to close the connection
		finally {
			pr.close();
			rs.close();
	}

	}
}
