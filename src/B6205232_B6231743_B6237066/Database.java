package B6205232_B6231743_B6237066;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
	private Statement st;
	private Connection con = null;
	protected ResultSet rsRead;
	private String action = "", sql = "";

	public boolean Connect() {
		boolean success = false;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/covid19", "root", "");
			st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			
			success = true;
		}catch(SQLException e) {
			System.out.println(e);
		}catch(Exception ex) {
			System.out.println(ex);
		}
		
		return success;
	}
	
	public boolean Close() {
		boolean success = false;
		
		try {
			st.close();
			con.close();
			
			success = true;
		}catch (Exception err) {
			System.out.println("ERROR: " + err);
		}
		
		return success;
	}
	
	public ResultSet ExecuteQuery(String sql) {
		try {
			rsRead = st.executeQuery(sql);
			rsRead.first();
		}catch (SQLException el) {
			el.printStackTrace();
		}
		
		return rsRead;
	}
}
