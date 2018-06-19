package dbUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * Class for attaining a connection to the database
 */
public class dbConnection {

	// you'll need these for MYSQL
	//private static final String USERNAME = "dbuser";
	//private static final String PASSWORD = "dbpassword";
	//private static final String CONN = "jbdc:mysql://localhost/login";
	
	/*
	 * A SQCONN is a String
	 * INTERP: represents the Query command to access the database
	 */
	private static final String SQCONN = "jdbc:sqlite:schoolsystem.sqlite";
	
	/*
	 * Signature
	 * Connection : URL String -> Connection
	 * Purpose
	 * GIVEN: a URL to the database and a String query command
	 * RETURNS: a Connection to the specified database
	 */
	public static Connection getConnection() throws SQLException {
		
		try {
			
			Class.forName("org.sqlite.JDBC");
			return DriverManager.getConnection(SQCONN);
			
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		
		return null;
	}
}
