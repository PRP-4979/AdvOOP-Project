package B6205232_B6231743_B6237066;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.ScrollPaneConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Assignment {

	private JFrame frame;
	private JButton NextButton, PrevButton, HomeButton;
	
	private JLabel TitleLabel;
	private JTabbedPane ContainerPane;
	private JScrollPane Page1, Page2;
	
	private JPanel PreData, Assignment;
	private JLabel FirstNameLabel, LastNameLabel, AgeLabel, SexLabel, TopicALabel;
	private JTextField FirstNameField, LastNameField, AgeField;
	private JComboBox SexComboBox;
	
	private JTextPane QA1Text, QA11Text, QA12Text, QA2Text, QA3Text, QA4Text, QA5Text, QA6Text;
	private JRadioButton QA11NoRadio, QA12NoRadio, QA2NoRadio, QA3NoRadio, QA4NoRadio, QA5NoRadio, QA6NoRadio;
	private JRadioButton QA11YesRadio, QA12YesRadio, QA2YesRadio, QA3YesRadio, QA4YesRadio, QA5YesRadio, QA6YesRadio;
	
	private int currentPage = 0;

	/**
	 * Launch the application.
	 */
	public static void AssignmentScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Assignment window = new Assignment();
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
	public Assignment() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u0E41\u0E1A\u0E1A\u0E1B\u0E23\u0E30\u0E40\u0E21\u0E34\u0E19\u0E04\u0E27\u0E32\u0E21\u0E40\u0E2A\u0E35\u0E48\u0E22\u0E07\u0E42\u0E04\u0E27\u0E34\u0E14 19");
		frame.setBounds(100, 100, 810, 650);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				Command window = new Command();
				
				window.VisibleScreen();
			}
		});
		frame.getContentPane().setLayout(null);
		
		TitleLabel = new JLabel("\u0E41\u0E1A\u0E1A\u0E1B\u0E23\u0E30\u0E40\u0E21\u0E34\u0E19\u0E04\u0E27\u0E32\u0E21\u0E40\u0E2A\u0E35\u0E48\u0E22\u0E07\u0E42\u0E04\u0E27\u0E34\u0E14 19");
		TitleLabel.setFont(new Font("CordiaUPC", Font.BOLD, 36));
		TitleLabel.setBounds(226, 28, 345, 55);
		frame.getContentPane().add(TitleLabel);
		
		ContainerPane = new JTabbedPane(JTabbedPane.TOP);
		ContainerPane.setBounds(69, 97, 653, 406);
		ContainerPane.addTab("Step 1", null, getPage1(), null);
		ContainerPane.addTab("Step 2", null, getPage2(), null);
		ContainerPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (ContainerPane.getSelectedIndex() == 0) currentPage = 0;
				if (ContainerPane.getSelectedIndex() == 1) currentPage = 1;
				
				Page2.getVerticalScrollBar().setValue(0);
			}
		});
		frame.getContentPane().add(ContainerPane);
		
		NextButton = new JButton("\u0E16\u0E31\u0E14\u0E44\u0E1B");
		NextButton.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
		NextButton.setBounds(622, 534, 100, 37);
		NextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (currentPage < 1) {
					currentPage++;
					ContainerPane.setSelectedIndex(currentPage);
				}
			}
		});
		frame.getContentPane().add(NextButton);
		
		PrevButton = new JButton("\u0E22\u0E49\u0E2D\u0E19\u0E01\u0E25\u0E31\u0E1A");
		PrevButton.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
		PrevButton.setBounds(493, 534, 100, 37);
		PrevButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (currentPage > 0) {
					currentPage--;
					ContainerPane.setSelectedIndex(currentPage);
				}
			}
		});
		frame.getContentPane().add(PrevButton);
		
		HomeButton = new JButton("\u0E2B\u0E19\u0E49\u0E32\u0E2B\u0E25\u0E31\u0E01");
		HomeButton.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
		HomeButton.setBounds(69, 534, 100, 37);
		HomeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Command window = new Command();
				
				window.VisibleScreen();
				frame.setVisible(false);
			}
		});
		frame.getContentPane().add(HomeButton);
	}
	
	public JScrollPane getPage1() {
		PreData = new JPanel();
		PreData.setBackground(SystemColor.menu);
		PreData.setLayout(null);
		
		FirstNameLabel = new JLabel("\u0E0A\u0E37\u0E48\u0E2D");
		FirstNameLabel.setBounds(76, 38, 30, 35);
		FirstNameLabel.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
		
		FirstNameField = new JTextField();
		FirstNameField.setBounds(105, 43, 160, 25);
		FirstNameField.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
		FirstNameField.setColumns(10);
		
		AgeField = new JTextField();
		AgeField.setBounds(107, 101, 158, 25);
		AgeField.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
		AgeField.setColumns(10);
		
		AgeLabel = new JLabel("\u0E2D\u0E32\u0E22\u0E38");
		AgeLabel.setBounds(64, 96, 44, 35);
		AgeLabel.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
		
		LastNameLabel = new JLabel("\u0E19\u0E32\u0E21\u0E2A\u0E01\u0E38\u0E25");
		LastNameLabel.setBounds(319, 38, 75, 35);
		LastNameLabel.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
		
		LastNameField = new JTextField();
		LastNameField.setBounds(393, 43, 160, 25);
		LastNameField.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
		LastNameField.setColumns(10);
		
		SexLabel = new JLabel("\u0E40\u0E1E\u0E28");
		SexLabel.setBounds(349, 96, 44, 35);
		SexLabel.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
		
		SexComboBox = new JComboBox();
		SexComboBox.setBounds(392, 101, 110, 25);
		SexComboBox.setFont(new Font("CordiaUPC", Font.ITALIC, 24));
		SexComboBox.setModel(new DefaultComboBoxModel(new String[] {"\u0E0A\u0E32\u0E22", "\u0E2B\u0E0D\u0E34\u0E07", "\u0E44\u0E21\u0E48\u0E23\u0E30\u0E1A\u0E38"}));
		
		PreData.add(FirstNameLabel);
		PreData.add(FirstNameField);
		PreData.add(LastNameLabel);
		PreData.add(LastNameField);
		PreData.add(AgeLabel);
		PreData.add(AgeField);
		PreData.add(SexLabel);
		PreData.add(SexComboBox);
		
		Page1 = new JScrollPane();
		Page1.setViewportView(PreData);
		
		return Page1;
	}
	
	public JScrollPane getPage2() {
		Assignment = new JPanel();
		Assignment.setBackground(SystemColor.menu);
		
		TopicALabel = new JLabel("\u0E17\u0E48\u0E32\u0E19\u0E21\u0E35\u0E1B\u0E23\u0E30\u0E27\u0E31\u0E15\u0E34\u0E40\u0E2A\u0E35\u0E48\u0E22\u0E07\u0E15\u0E48\u0E2D\u0E01\u0E32\u0E23\u0E15\u0E34\u0E14\u0E40\u0E0A\u0E37\u0E49\u0E2D \u0E2B\u0E23\u0E37\u0E2D\u0E44\u0E21\u0E48\u0E14\u0E31\u0E07\u0E19\u0E35\u0E49");
		TopicALabel.setFont(new Font("CordiaUPC", Font.BOLD, 24));
		
		QA1Text = new JTextPane();
		QA1Text.setText("1. \u0E17\u0E48\u0E32\u0E19\u0E40\u0E14\u0E34\u0E19\u0E17\u0E32\u0E07\u0E21\u0E32\u0E08\u0E32\u0E01\u0E2B\u0E23\u0E37\u0E2D\u0E2D\u0E22\u0E39\u0E48\u0E2D\u0E32\u0E28\u0E31\u0E22\u0E43\u0E19\u0E1E\u0E37\u0E49\u0E19\u0E17\u0E35\u0E48\u0E17\u0E35\u0E48\u0E21\u0E35\u0E23\u0E32\u0E22\u0E07\u0E32\u0E19\u0E01\u0E32\u0E23\u0E15\u0E34\u0E14\u0E40\u0E0A\u0E37\u0E49\u0E2D \u0E02\u0E2D\u0E07\u0E42\u0E23\u0E04 COVID-19 \u0E43\u0E19 1 \u0E40\u0E14\u0E37\u0E2D\u0E19\u0E17\u0E35\u0E48\u0E1C\u0E48\u0E32\u0E19\u0E21\u0E32");
		QA1Text.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
		QA1Text.setBackground(SystemColor.menu);
		
		QA11Text = new JTextPane();
		QA11Text.setText("1.1) \u0E17\u0E48\u0E32\u0E19\u0E44\u0E14\u0E49\u0E40\u0E14\u0E34\u0E19\u0E17\u0E32\u0E07\u0E21\u0E32\u0E01\u0E08\u0E32\u0E01\u0E15\u0E48\u0E32\u0E07\u0E1B\u0E23\u0E30\u0E40\u0E17\u0E28 \u0E17\u0E38\u0E01\u0E1B\u0E23\u0E30\u0E40\u0E17\u0E28\u0E43\u0E19\u0E0A\u0E48\u0E27\u0E07 1 \u0E40\u0E14\u0E37\u0E2D\u0E19\u0E17\u0E35\u0E48\u0E1C\u0E48\u0E32\u0E19\u0E21\u0E32\u0E2B\u0E23\u0E37\u0E2D\u0E44\u0E21\u0E48 (\u0E15\u0E48\u0E32\u0E07\u0E1B\u0E23\u0E30\u0E40\u0E17\u0E28)");
		QA11Text.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
		QA11Text.setBackground(SystemColor.menu);
		
		QA12Text = new JTextPane();
		QA12Text.setText("1.2) \u0E17\u0E48\u0E32\u0E19\u0E44\u0E14\u0E49\u0E40\u0E14\u0E34\u0E19\u0E17\u0E32\u0E07\u0E21\u0E32\u0E08\u0E32\u0E01\u0E2B\u0E23\u0E37\u0E2D\u0E2D\u0E32\u0E28\u0E31\u0E22\u0E2D\u0E22\u0E39\u0E48\u0E43\u0E19\u0E1E\u0E37\u0E49\u0E19\u0E17\u0E35\u0E48\u0E21\u0E35\u0E01\u0E32\u0E23\u0E23\u0E32\u0E22\u0E07\u0E32\u0E19\u0E01\u0E32\u0E23\u0E15\u0E34\u0E14\u0E40\u0E0A\u0E37\u0E49\u0E2D\u0E2B\u0E23\u0E37\u0E2D\u0E44\u0E21\u0E48 \u0E20\u0E32\u0E22\u0E43\u0E19 1 \u0E40\u0E14\u0E37\u0E2D\u0E19\u0E17\u0E35\u0E48\u0E1C\u0E48\u0E32\u0E19\u0E21\u0E32 (\u0E20\u0E32\u0E22\u0E43\u0E19\u0E1B\u0E23\u0E30\u0E40\u0E17\u0E28\u0E44\u0E17\u0E22)");
		QA12Text.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
		QA12Text.setBackground(SystemColor.menu);
		
		QA2Text = new JTextPane();
		QA2Text.setText("2. \u0E17\u0E48\u0E32\u0E19\u0E17\u0E33\u0E07\u0E32\u0E19\u0E43\u0E19 \u0E2A\u0E16\u0E32\u0E19\u0E01\u0E31\u0E01\u0E01\u0E31\u0E19\u0E42\u0E23\u0E04\u0E2B\u0E23\u0E37\u0E2D\u0E44\u0E21\u0E48");
		QA2Text.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
		QA2Text.setBackground(SystemColor.menu);
		
		QA3Text = new JTextPane();
		QA3Text.setText("3. \u0E17\u0E48\u0E32\u0E19\u0E40\u0E04\u0E22\u0E21\u0E35\u0E1B\u0E23\u0E30\u0E27\u0E31\u0E15\u0E34\u0E2A\u0E31\u0E21\u0E1C\u0E31\u0E2A\u0E01\u0E31\u0E1A\u0E1C\u0E39\u0E49\u0E1B\u0E48\u0E27\u0E22\u0E22\u0E37\u0E19\u0E22\u0E31\u0E19\u0E42\u0E23\u0E04\u0E15\u0E34\u0E14\u0E40\u0E0A\u0E37\u0E49\u0E2D\u0E44\u0E27\u0E23\u0E31\u0E2A COVID-19 \u0E2B\u0E23\u0E37\u0E2D\u0E44\u0E21\u0E48");
		QA3Text.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
		QA3Text.setBackground(SystemColor.menu);
	
		QA4Text = new JTextPane();
		QA4Text.setText("4. \u0E17\u0E48\u0E32\u0E19\u0E40\u0E1B\u0E47\u0E19\u0E1A\u0E38\u0E04\u0E25\u0E32\u0E01\u0E23\u0E17\u0E32\u0E07\u0E01\u0E32\u0E23\u0E41\u0E1E\u0E17\u0E22\u0E4C\u0E2B\u0E23\u0E37\u0E2D\u0E2A\u0E32\u0E18\u0E32\u0E23\u0E13\u0E2A\u0E38\u0E02 \u0E17\u0E31\u0E49\u0E07\u0E2A\u0E16\u0E32\u0E19\u0E1E\u0E22\u0E32\u0E1A\u0E32\u0E25, \u0E04\u0E25\u0E34\u0E19\u0E34\u0E04 , \u0E17\u0E35\u0E21\u0E2A\u0E2D\u0E1A\u0E2A\u0E27\u0E19\u0E42\u0E23\u0E04 \u0E2B\u0E23\u0E37\u0E2D \u0E23\u0E49\u0E32\u0E19\u0E02\u0E32\u0E22\u0E22\u0E32 \u0E2B\u0E23\u0E37\u0E2D\u0E44\u0E21\u0E48");
		QA4Text.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
		QA4Text.setBackground(SystemColor.menu);
		
		QA5Text = new JTextPane();
		QA5Text.setText("5. \u0E17\u0E48\u0E32\u0E19\u0E40\u0E04\u0E22\u0E21\u0E35\u0E1B\u0E23\u0E30\u0E27\u0E31\u0E15\u0E34\u0E44\u0E1B\u0E43\u0E19\u0E2A\u0E16\u0E32\u0E19\u0E17\u0E35\u0E48\u0E1B\u0E23\u0E30\u0E0A\u0E32\u0E0A\u0E19\u0E2B\u0E19\u0E32\u0E41\u0E19\u0E48\u0E19 \u0E0A\u0E38\u0E21\u0E19\u0E38\u0E21\u0E0A\u0E19 \u0E2B\u0E23\u0E37\u0E2D\u0E17\u0E35\u0E48\u0E21\u0E35\u0E01\u0E32\u0E23\u0E23\u0E27\u0E21\u0E01\u0E25\u0E38\u0E48\u0E21\u0E04\u0E19 \u0E40\u0E0A\u0E48\u0E19 \u0E15\u0E25\u0E32\u0E14\u0E19\u0E31\u0E14 \u0E2B\u0E49\u0E32\u0E07\u0E2A\u0E23\u0E23\u0E1E\u0E2A\u0E34\u0E19\u0E04\u0E49\u0E32 \u0E2A\u0E16\u0E32\u0E19\u0E1E\u0E22\u0E32\u0E1A\u0E32\u0E25 \u0E2B\u0E23\u0E37\u0E2D\u0E02\u0E19\u0E2A\u0E48\u0E07\u0E2A\u0E32\u0E18\u0E32\u0E23\u0E13\u0E30 \u0E17\u0E35\u0E48\u0E1E\u0E1A\u0E1C\u0E39\u0E49\u0E2A\u0E07\u0E2A\u0E31\u0E22\u0E2B\u0E23\u0E37\u0E2D\u0E22\u0E37\u0E19\u0E22\u0E31\u0E19 COVID-19 \u0E2B\u0E23\u0E37\u0E2D\u0E44\u0E21\u0E48 \u0E43\u0E19\u0E0A\u0E48\u0E27\u0E07 1 \u0E40\u0E14\u0E37\u0E2D\u0E19\u0E17\u0E35\u0E48\u0E1C\u0E48\u0E32\u0E19\u0E21\u0E32");
		QA5Text.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
		QA5Text.setBackground(SystemColor.menu);
		
		QA6Text = new JTextPane();
		QA6Text.setText("6. \u0E43\u0E19\u0E2A\u0E16\u0E32\u0E19\u0E17\u0E35\u0E48\u0E17\u0E48\u0E32\u0E19\u0E17\u0E35\u0E48\u0E44\u0E1B\u0E1B\u0E23\u0E30\u0E08\u0E33 \u0E04\u0E19\u0E17\u0E35\u0E48\u0E2A\u0E19\u0E34\u0E17\u0E43\u0E01\u0E25\u0E49\u0E0A\u0E34\u0E14\u0E01\u0E31\u0E1A\u0E17\u0E48\u0E32\u0E19 \u0E21\u0E35\u0E2D\u0E32\u0E01\u0E32\u0E23 \u0E44\u0E02\u0E49 \u0E44\u0E2D \u0E19\u0E49\u0E33\u0E21\u0E39\u0E01 \u0E40\u0E2A\u0E21\u0E2B\u0E30 \u0E21\u0E32\u0E01\u0E01\u0E27\u0E48\u0E32 5 \u0E04\u0E19 \u0E1E\u0E23\u0E49\u0E2D\u0E21\u0E46\u0E01\u0E31\u0E19 \u0E43\u0E19\u0E0A\u0E48\u0E27\u0E07\u0E40\u0E27\u0E25\u0E32\u0E20\u0E32\u0E22\u0E43\u0E19\u0E2A\u0E31\u0E1B\u0E14\u0E32\u0E2B\u0E4C\u0E2B\u0E23\u0E37\u0E2D\u0E44\u0E21\u0E48");
		QA6Text.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
		QA6Text.setBackground(SystemColor.menu);
		

		QA11NoRadio = new JRadioButton("\u0E44\u0E21\u0E48\u0E43\u0E0A\u0E48");
		QA11NoRadio.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
		QA11YesRadio = new JRadioButton("\u0E43\u0E0A\u0E48");
		QA11YesRadio.setFont(new Font("CordiaUPC", Font.PLAIN, 24));

		QA12NoRadio = new JRadioButton("\u0E44\u0E21\u0E48\u0E43\u0E0A\u0E48");
		QA12NoRadio.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
		QA12YesRadio = new JRadioButton("\u0E43\u0E0A\u0E48");
		QA12YesRadio.setFont(new Font("CordiaUPC", Font.PLAIN, 24));

		QA2NoRadio = new JRadioButton("\u0E44\u0E21\u0E48\u0E43\u0E0A\u0E48");
		QA2NoRadio.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
		QA2YesRadio = new JRadioButton("\u0E43\u0E0A\u0E48");
		QA2YesRadio.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
		
		QA3NoRadio = new JRadioButton("\u0E44\u0E21\u0E48\u0E43\u0E0A\u0E48");
		QA3NoRadio.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
		QA3YesRadio = new JRadioButton("\u0E43\u0E0A\u0E48");
		QA3YesRadio.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
		
		QA4NoRadio = new JRadioButton("\u0E44\u0E21\u0E48\u0E43\u0E0A\u0E48");
		QA4NoRadio.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
		QA4YesRadio = new JRadioButton("\u0E43\u0E0A\u0E48");
		QA4YesRadio.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
		
		QA5NoRadio = new JRadioButton("\u0E44\u0E21\u0E48\u0E43\u0E0A\u0E48");
		QA5NoRadio.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
		QA5YesRadio = new JRadioButton("\u0E43\u0E0A\u0E48");
		QA5YesRadio.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
		
		QA6NoRadio = new JRadioButton("\u0E44\u0E21\u0E48\u0E43\u0E0A\u0E48");
		QA6NoRadio.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
		QA6YesRadio = new JRadioButton("\u0E43\u0E0A\u0E48");
		QA6YesRadio.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
		
		GroupLayout gl_Assignment = new GroupLayout(Assignment);
		gl_Assignment.setHorizontalGroup(
			gl_Assignment.createParallelGroup(Alignment.LEADING)
				.addGap(0, 629, Short.MAX_VALUE)
				.addGroup(gl_Assignment.createSequentialGroup()
					.addGroup(gl_Assignment.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Assignment.createSequentialGroup()
							.addGap(19)
							.addGroup(gl_Assignment.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_Assignment.createParallelGroup(Alignment.TRAILING)
									.addGroup(gl_Assignment.createParallelGroup(Alignment.LEADING)
										.addComponent(QA2Text, GroupLayout.PREFERRED_SIZE, 271, GroupLayout.PREFERRED_SIZE)
										.addComponent(QA3Text, GroupLayout.PREFERRED_SIZE, 499, GroupLayout.PREFERRED_SIZE)
										.addComponent(QA5Text, GroupLayout.PREFERRED_SIZE, 560, GroupLayout.PREFERRED_SIZE)
										.addComponent(QA6Text, GroupLayout.PREFERRED_SIZE, 560, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_Assignment.createSequentialGroup()
											.addGap(19)
											.addGroup(gl_Assignment.createParallelGroup(Alignment.LEADING)
												.addComponent(QA12Text, GroupLayout.PREFERRED_SIZE, 560, GroupLayout.PREFERRED_SIZE)
												.addGroup(gl_Assignment.createSequentialGroup()
													.addGap(10)
													.addComponent(QA12NoRadio)
													.addGap(39)
													.addGroup(gl_Assignment.createParallelGroup(Alignment.LEADING)
														.addGroup(gl_Assignment.createSequentialGroup()
															.addGap(2)
															.addComponent(QA12YesRadio, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
														.addGroup(gl_Assignment.createSequentialGroup()
															.addGap(2)
															.addComponent(QA4YesRadio, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
														.addComponent(QA5YesRadio, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
														.addGroup(gl_Assignment.createSequentialGroup()
															.addGap(3)
															.addComponent(QA6YesRadio, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))))))
										.addComponent(QA4Text, GroupLayout.PREFERRED_SIZE, 560, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_Assignment.createSequentialGroup()
											.addGap(29)
											.addComponent(QA4NoRadio)))
									.addGroup(gl_Assignment.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_Assignment.createSequentialGroup()
											.addGap(10)
											.addComponent(QA11NoRadio)
											.addGap(18)
											.addComponent(QA11YesRadio, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
										.addComponent(QA11Text, GroupLayout.PREFERRED_SIZE, 560, GroupLayout.PREFERRED_SIZE)))
								.addComponent(QA1Text, GroupLayout.PREFERRED_SIZE, 560, GroupLayout.PREFERRED_SIZE)
								.addComponent(TopicALabel, GroupLayout.PREFERRED_SIZE, 320, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_Assignment.createSequentialGroup()
							.addGap(46)
							.addComponent(QA5NoRadio))
						.addGroup(gl_Assignment.createSequentialGroup()
							.addGap(49)
							.addComponent(QA6NoRadio))
						.addGroup(gl_Assignment.createSequentialGroup()
							.addGap(49)
							.addGroup(gl_Assignment.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_Assignment.createSequentialGroup()
									.addGap(98)
									.addComponent(QA3YesRadio, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
								.addComponent(QA3NoRadio)))
						.addGroup(gl_Assignment.createSequentialGroup()
							.addGap(50)
							.addGroup(gl_Assignment.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_Assignment.createSequentialGroup()
									.addGap(98)
									.addComponent(QA2YesRadio, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
								.addComponent(QA2NoRadio))))
					.addContainerGap(31, Short.MAX_VALUE))
		);
		gl_Assignment.setVerticalGroup(
			gl_Assignment.createParallelGroup(Alignment.LEADING)
				.addGap(0, 975, Short.MAX_VALUE)
				.addGroup(gl_Assignment.createSequentialGroup()
					.addGap(25)
					.addComponent(TopicALabel, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(QA1Text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(13)
					.addComponent(QA11Text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_Assignment.createParallelGroup(Alignment.LEADING)
						.addComponent(QA11NoRadio)
						.addComponent(QA11YesRadio, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(QA12Text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_Assignment.createParallelGroup(Alignment.LEADING)
						.addComponent(QA12YesRadio, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_Assignment.createSequentialGroup()
							.addComponent(QA12NoRadio, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
							.addGap(37)
							.addComponent(QA2Text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_Assignment.createParallelGroup(Alignment.LEADING)
						.addComponent(QA2YesRadio, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(QA2NoRadio, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
					.addGap(20)
					.addComponent(QA3Text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_Assignment.createParallelGroup(Alignment.LEADING)
						.addComponent(QA3YesRadio, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(QA3NoRadio, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_Assignment.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Assignment.createSequentialGroup()
							.addGap(89)
							.addComponent(QA4YesRadio, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
							.addGap(96)
							.addComponent(QA5YesRadio, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
							.addGap(86)
							.addComponent(QA6YesRadio, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_Assignment.createSequentialGroup()
							.addGap(22)
							.addComponent(QA4Text, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(QA4NoRadio, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
							.addGap(29)
							.addComponent(QA5Text, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(QA5NoRadio, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
							.addGap(19)
							.addComponent(QA6Text, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(QA6NoRadio, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(11, Short.MAX_VALUE))
		);
		
		Assignment.setLayout(gl_Assignment);
		
		Page2 = new JScrollPane();
		Page2.setViewportView(Assignment);
		
		return Page2;
	}
}
