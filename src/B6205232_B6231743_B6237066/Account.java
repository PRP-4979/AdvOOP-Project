package B6205232_B6231743_B6237066;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Account extends Database {
	private String username = "";
	private String password = "";
	private String sql = "";
	private ResultSet rsRead;
	
	public Account(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public boolean checkLogin() {
		boolean confirm = false;
		
		Database db = new Database();
		if (db.Connect()) {
			try {
				sql = "SELECT * FROM user WHERE username='" + username + "' AND password='" + password + "'";
				rsRead = db.ExecuteQuery(sql);
				
				if (rsRead != null) {
					if (username.equals(rsRead.getString("username")) && password.equals(rsRead.getString("password"))) {
						confirm = true;	
					}					
				}
				
			}catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Error: Username or Password is invalid !!");
			}
		}

		return confirm;
	}
}
