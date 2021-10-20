package B6205232_B6231743_B6237066;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login {

	private JFrame frame;
	private JLabel TitleLabel;
	private JLabel UsernameLabel;
	private JLabel PasswordLabel;
	private JTextField UsernameField;
	private JPasswordField PasswordField;
	private JButton LoginButton;
	private JButton CancelButton;

	/**
	 * Launch the application.
	 */
	public static void LoginScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u0E40\u0E02\u0E49\u0E32\u0E2A\u0E39\u0E48\u0E23\u0E30\u0E1A\u0E1A");
		frame.setBounds(100, 100, 450, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		frame.getContentPane().add(getTitleLabel(), null);
		frame.getContentPane().add(getUsernameLabel(), null);
		frame.getContentPane().add(getPasswordLabel(), null);
		
		frame.getContentPane().add(getUsernameField(), null);
		frame.getContentPane().add(getPasswordField(), null);
		
		frame.getContentPane().add(getLoginButton(), null);
		frame.getContentPane().add(getCancelButton(), null);
	}
	
	private JLabel getTitleLabel() {
		if (TitleLabel == null) {
			TitleLabel = new JLabel("\u0E40\u0E02\u0E49\u0E32\u0E2A\u0E39\u0E48\u0E23\u0E30\u0E1A\u0E1A");
			TitleLabel.setFont(new Font("CordiaUPC", Font.BOLD, 36));
			TitleLabel.setBounds(156, 42, 121, 46);
		}
		return TitleLabel;
	}
	
	private JLabel getUsernameLabel() {
		if (UsernameLabel == null) {
			UsernameLabel = new JLabel("\u0E0A\u0E37\u0E48\u0E2D\u0E1A\u0E31\u0E0D\u0E0A\u0E35\u0E1C\u0E39\u0E49\u0E43\u0E0A\u0E49");
			UsernameLabel.setFont(new Font("CordiaUPC", Font.PLAIN, 20));
			UsernameLabel.setBounds(101, 117, 73, 24);
		}
		return UsernameLabel;
	}
	
	private JLabel getPasswordLabel() {
		if (PasswordLabel == null) {
			PasswordLabel = new JLabel("\u0E23\u0E2B\u0E31\u0E2A\u0E1C\u0E48\u0E32\u0E19");
			PasswordLabel.setFont(new Font("CordiaUPC", Font.PLAIN, 20));
			PasswordLabel.setBounds(101, 189, 73, 24);
		}
		return PasswordLabel;
	}
	
	private JTextField getUsernameField() {
		if (UsernameField == null) {
			UsernameField = new JTextField();
			UsernameField.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
			UsernameField.setColumns(10);
			UsernameField.setBounds(101, 146, 235, 29);
		}
		return UsernameField;
	}
	
	private JPasswordField getPasswordField() {
		if (PasswordField == null) {
			PasswordField = new JPasswordField();
			PasswordField.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
			PasswordField.setColumns(10);
			PasswordField.setBounds(101, 219, 235, 29);
		}
		return PasswordField;
	}
	
	private JButton getLoginButton() {
		if (LoginButton == null) {
			LoginButton = new JButton("\u0E40\u0E02\u0E49\u0E32\u0E2A\u0E39\u0E48\u0E23\u0E30\u0E1A\u0E1A");
			LoginButton.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
			LoginButton.setBounds(151, 283, 135, 46);
			LoginButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String username = "", password = "";
					
					username = String.format("%s", UsernameField.getText());
					password = String.valueOf(PasswordField.getPassword());
					
					Account acc = new Account(username, password);
					
					if (acc.checkLogin()) {
						JOptionPane.showMessageDialog(frame, "Login successfully !");
						frame.setVisible(false);
					}
					else JOptionPane.showMessageDialog(frame, "Login failed !");
				}
			});
		}
		return LoginButton;
	}
	
	private JButton getCancelButton() {
		if (CancelButton == null) {
			CancelButton = new JButton("\u0E22\u0E01\u0E40\u0E25\u0E34\u0E01");
			CancelButton.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
			CancelButton.setBounds(152, 346, 135, 46);
		}
		return CancelButton;
	}
}
