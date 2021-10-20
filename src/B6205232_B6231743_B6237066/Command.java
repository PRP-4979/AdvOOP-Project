package B6205232_B6231743_B6237066;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Command {

	private JFrame frame;
	private JLabel TitleLabel;
	private JButton StartButton;
	private JButton ManageButton;
	private JButton ExitButton;
	private int confirm = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Command window = new Command();
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
	public Command() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u0E42\u0E1B\u0E23\u0E41\u0E01\u0E23\u0E21\u0E1B\u0E23\u0E30\u0E40\u0E21\u0E34\u0E19\u0E04\u0E27\u0E32\u0E21\u0E40\u0E2A\u0E35\u0E48\u0E22\u0E07\u0E42\u0E04\u0E27\u0E34\u0E14 19");
		frame.setBounds(100, 100, 700, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		frame.getContentPane().add(getTitleLabel(), null);
		frame.getContentPane().add(getStartButton(), null);
		frame.getContentPane().add(getManageButton(), null);
		frame.getContentPane().add(getExitButton(), null);
	}
	
	private JLabel getTitleLabel() {
		if (TitleLabel == null) {
			TitleLabel = new JLabel("\u0E42\u0E1B\u0E23\u0E41\u0E01\u0E23\u0E21\u0E1B\u0E23\u0E30\u0E40\u0E21\u0E34\u0E19\u0E04\u0E27\u0E32\u0E21\u0E40\u0E2A\u0E35\u0E48\u0E22\u0E07\u0E42\u0E04\u0E27\u0E34\u0E14 19");
			TitleLabel.setFont(new Font("CordiaUPC", Font.BOLD, 36));
			TitleLabel.setBounds(161, 55, 398, 46);
		}
		return TitleLabel;
	}
	
	private JButton getStartButton() {
		if (StartButton == null) {
			StartButton = new JButton("\u0E40\u0E23\u0E34\u0E48\u0E21\u0E1B\u0E23\u0E30\u0E40\u0E21\u0E34\u0E19 !");
			StartButton.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
			StartButton.setBounds(256, 204, 180, 45);
		}
		return StartButton;
	}
	
	private JButton getManageButton() {
		if (ManageButton == null) {
			ManageButton = new JButton("\u0E08\u0E31\u0E14\u0E01\u0E32\u0E23\u0E02\u0E49\u0E2D\u0E21\u0E39\u0E25");
			ManageButton.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
			ManageButton.setBounds(256, 277, 180, 45);
			ManageButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Login window = new Login();
					window.LoginScreen();
				}
			});
		}
		return ManageButton;
	}

	private JButton getExitButton() {
		if (ExitButton == null) {
			ExitButton = new JButton("\u0E2D\u0E2D\u0E01\u0E08\u0E32\u0E01\u0E42\u0E1B\u0E23\u0E41\u0E01\u0E23\u0E21");
			ExitButton.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
			ExitButton.setBounds(256, 349, 180, 45);
			ExitButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					confirm = JOptionPane.showConfirmDialog(frame, "Are you sure you want to exit ?");
					if (confirm == 0) {
						System.exit(1);
					}
				}
			});
		}
		return ExitButton;
	}
	
}
