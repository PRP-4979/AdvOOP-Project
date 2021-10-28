package B6205232_B6231743_B6237066;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class DisplayResult {

	private JFrame frame;
	private JLabel HeadLabel;
	private JLabel PrefixLabel, StatusLabel, DateLabel, SuggestLabel;
	private JLabel DisplayName, DisplayStatus, DisplayDate;
	private JTextArea GuidelineArea;
	private JButton BackToHomeButton;

	/**
	 * Launch the application.
	 */
	public static void ResultScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DisplayResult window = new DisplayResult();
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
	public DisplayResult() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u0E1C\u0E25\u0E01\u0E32\u0E23\u0E1B\u0E23\u0E30\u0E40\u0E21\u0E34\u0E19");
		frame.setBounds(100, 100, 760, 660);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		BackToHomeButton = new JButton("\u0E01\u0E25\u0E31\u0E1A\u0E2A\u0E39\u0E48\u0E2B\u0E19\u0E49\u0E32\u0E2B\u0E25\u0E31\u0E01");
		BackToHomeButton.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
		BackToHomeButton.setBounds(565, 550, 135, 37);
		BackToHomeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Command window = new Command();
				window.VisibleScreen();
				
				frame.setVisible(false);
			}
		});
		frame.getContentPane().add(BackToHomeButton);
		
		HeadLabel = new JLabel("\u0E1C\u0E25\u0E01\u0E32\u0E23\u0E1B\u0E23\u0E30\u0E40\u0E21\u0E34\u0E19\u0E04\u0E27\u0E32\u0E21\u0E40\u0E2A\u0E35\u0E48\u0E22\u0E07 Covid 19");
		HeadLabel.setFont(new Font("CordiaUPC", Font.BOLD, 36));
		HeadLabel.setBounds(180, 35, 381, 50);
		frame.getContentPane().add(HeadLabel);
		
		GuidelineArea = new JTextArea();
		GuidelineArea.setWrapStyleWord(true);
		GuidelineArea.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
		GuidelineArea.setEditable(false);
		GuidelineArea.setBounds(40, 269, 660, 255);
		frame.getContentPane().add(GuidelineArea);
		
		PrefixLabel = new JLabel("\u0E04\u0E38\u0E13:");
		PrefixLabel.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
		PrefixLabel.setBounds(40, 112, 34, 30);
		frame.getContentPane().add(PrefixLabel);
		
		DisplayName = new JLabel("");
		DisplayName.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
		DisplayName.setBounds(74, 112, 240, 30);
		frame.getContentPane().add(DisplayName);
		
		StatusLabel = new JLabel("\u0E04\u0E38\u0E13\u0E2D\u0E22\u0E39\u0E48\u0E43\u0E19\u0E01\u0E25\u0E38\u0E48\u0E21:");
		StatusLabel.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
		StatusLabel.setBounds(40, 153, 100, 30);
		frame.getContentPane().add(StatusLabel);
		
		DisplayStatus = new JLabel("");
		DisplayStatus.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
		DisplayStatus.setBounds(138, 153, 200, 30);
		frame.getContentPane().add(DisplayStatus);
		
		DateLabel = new JLabel("\u0E27\u0E31\u0E19\u0E17\u0E35\u0E48\u0E1B\u0E23\u0E30\u0E40\u0E21\u0E34\u0E19:");
		DateLabel.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
		DateLabel.setBounds(335, 112, 90, 30);
		frame.getContentPane().add(DateLabel);
		
		DisplayDate = new JLabel("");
		DisplayDate.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
		DisplayDate.setBounds(423, 112, 200, 30);
		frame.getContentPane().add(DisplayDate);
		
		SuggestLabel = new JLabel("\u0E04\u0E33\u0E41\u0E19\u0E30\u0E19\u0E33");
		SuggestLabel.setFont(new Font("CordiaUPC", Font.BOLD, 30));
		SuggestLabel.setBounds(40, 220, 100, 30);
		frame.getContentPane().add(SuggestLabel);
	}
}
