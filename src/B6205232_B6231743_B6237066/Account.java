package B6205232_B6231743_B6237066;

public class Account {
	private String username = "";
	private String password = "";
	private boolean confirm;
	
	public Account(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public boolean checkLogin() {
		if (username.equals("admin") && password.equals("1234")) confirm = true;
		else confirm = false;
		
		return confirm;
	}
}
