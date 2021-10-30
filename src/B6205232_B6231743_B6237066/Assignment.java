package B6205232_B6231743_B6237066;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
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
import javax.swing.SwingConstants;
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
import javax.swing.JCheckBox;

public class Assignment {

	private JFrame frame;
	private JButton NextButton, PrevButton, HomeButton, ProcessButton;
	
	private JLabel TitleLabel;
	private JTabbedPane ContainerPane;
	private JScrollPane Page1, Page2, Page3;
	private JPanel PreData, Assignment, Symptom;
	
	private JLabel TopicALabel, TopicBLabel, TopicCLabel;
	private JLabel FirstNameLabel, LastNameLabel, CardIDLabel;
	private JLabel AgeLabel, HeightLabel, WeightLabel, SexLabel; 
	private JLabel PreDataLabel;
	private JTextField FirstNameField, LastNameField, CardIDField;
	private JTextField AgeField, HeightField, WeightField;
	private JComboBox SexComboBox;
	
	private JTextPane QA1Text, QA2Text, QA3Text, QA4Text, QA5Text, QA6Text;
	private JRadioButton QA1NoRadio, QA2NoRadio, QA3NoRadio, QA4NoRadio, QA5NoRadio, QA6NoRadio;
	private JRadioButton QA1YesRadio, QA2YesRadio, QA3YesRadio, QA4YesRadio, QA5YesRadio, QA6YesRadio;
	private ButtonGroup QA1Group, QA2Group, QA3Group, QA4Group, QA5Group, QA6Group;
	
	private JCheckBox FeverCheckBox, CoughCheckBox, RunnyCheckBox, ThroatCheckBox, ExhaustedCheckBox, SmellCheckBox; 
	private JCheckBox TasteCheckBox, EyeCheckBox, RashCheckBox, DiarrheaCheckBox;
	
	private JTextField TemperatureField;
	private JLabel CelsiusLabel;
	
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
		
		NextButton = new JButton("\u0E16\u0E31\u0E14\u0E44\u0E1B");
		NextButton.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
		NextButton.setBounds(607, 534, 115, 37);
		NextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (currentPage < 2) {
					currentPage++;
					ContainerPane.setSelectedIndex(currentPage);
				}
			}
		});
		frame.getContentPane().add(NextButton);
		
		PrevButton = new JButton("\u0E22\u0E49\u0E2D\u0E19\u0E01\u0E25\u0E31\u0E1A");
		PrevButton.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
		PrevButton.setBounds(478, 534, 115, 37);
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
		HomeButton.setBounds(69, 534, 115, 37);
		HomeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Command window = new Command();
				window.VisibleScreen();
				
				frame.setVisible(false);
			}
		});
		frame.getContentPane().add(HomeButton);
		
		ProcessButton = new JButton("\u0E1B\u0E23\u0E30\u0E40\u0E21\u0E34\u0E19\u0E1C\u0E25");
		ProcessButton.setFont(new Font("CordiaUPC", Font.BOLD, 24));
		ProcessButton.setBounds(607, 534, 115, 37);
		ProcessButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String name = String.format("%s %s", FirstNameField.getText(), LastNameField.getText());
					int age = Integer.parseInt(AgeField.getText());
					double temperature = Double.parseDouble(TemperatureField.getText());
					
					String QA1Value, QA2Value, QA3Value, QA4Value, QA5Value, QA6Value;
					String FeverValue = "No", CoughValue = "No", RunnyValue = "No", ThroatValue = "No", ExhaustedValue = "No"; 
					String TasteValue = "No", SmellValue = "No", EyeValue = "No", RashValue = "No", DiarrheaValue = "No";
					
					if (QA1NoRadio.isSelected()) {
						QA1Value = "No";
					} else if (QA1YesRadio.isSelected()) {
						QA1Value = "Yes";
					} else {
						QA1Value = "Null";
					}
					
					if (QA2NoRadio.isSelected()) {
						QA2Value = "No";
					} else if (QA2YesRadio.isSelected()) {
						QA2Value = "Yes";
					} else {
						QA2Value = "Null";
					}
					
					if (QA3NoRadio.isSelected()) {
						QA3Value = "No";
					} else if (QA3YesRadio.isSelected()) {
						QA3Value = "Yes";
					} else {
						QA3Value = "Null";
					}
					
					if (QA4NoRadio.isSelected()) {
						QA4Value = "No";
					} else if (QA4YesRadio.isSelected()) {
						QA4Value = "Yes";
					} else {
						QA4Value = "Null";
					}
					
					if (QA5NoRadio.isSelected()) {
						QA5Value = "No";
					} else if (QA5YesRadio.isSelected()) {
						QA5Value = "Yes";
					} else {
						QA5Value = "Null";
					}
					
					if (QA6NoRadio.isSelected()) {
						QA6Value = "No";
					} else if (QA6YesRadio.isSelected()) {
						QA6Value = "Yes";
					} else {
						QA6Value = "Null";
					}
					
					String[] data1 = {QA1Value, QA2Value, QA3Value, QA4Value, QA5Value, QA6Value};
					
					if (FeverCheckBox.isSelected()) FeverValue = "Yes";
					if (CoughCheckBox.isSelected()) CoughValue = "Yes";
					if (RunnyCheckBox.isSelected()) RunnyValue = "Yes";
					if (ThroatCheckBox.isSelected()) ThroatValue = "Yes";
					if (ExhaustedCheckBox.isSelected()) ExhaustedValue = "Yes";
					if (TasteCheckBox.isSelected()) TasteValue = "Yes";
					if (SmellCheckBox.isSelected()) SmellValue = "Yes";
					if (EyeCheckBox.isSelected()) EyeValue = "Yes";
					if (RashCheckBox.isSelected()) RashValue = "Yes";
					if (DiarrheaCheckBox.isSelected()) DiarrheaValue = "Yes";
					
					String[] data2 = {FeverValue, CoughValue, RunnyValue, ThroatValue, ExhaustedValue, TasteValue, SmellValue, EyeValue, RashValue, DiarrheaValue};
					
					ProcessData process = new ProcessData(name, age, data1, data2, temperature);
					DisplayResult window = new DisplayResult(process);
					
					window.ResultScreen();
					frame.setVisible(false);
				} catch (Exception error) {
					JOptionPane.showMessageDialog(frame, "Please fill out the field completely.");
				}
				
			}
		});
		ProcessButton.setVisible(false);
		frame.getContentPane().add(ProcessButton);
		
		ContainerPane = new JTabbedPane(JTabbedPane.TOP);
		ContainerPane.setBounds(69, 97, 653, 406);
		ContainerPane.addTab("Step 1", null, getPage1(), null);
		ContainerPane.addTab("Step 2", null, getPage2(), null);
		ContainerPane.addTab("Step 3", null, getPage3(), null);
		ContainerPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (ContainerPane.getSelectedIndex() == 0) currentPage = 0;
				if (ContainerPane.getSelectedIndex() == 1) currentPage = 1;
				if (ContainerPane.getSelectedIndex() == 2) currentPage = 2;
				
				Page2.getVerticalScrollBar().setValue(0);
				
				if (ContainerPane.getSelectedIndex() == 2) {
					ProcessButton.setVisible(true);
					NextButton.setVisible(false);
				}else {
					NextButton.setVisible(true);
					ProcessButton.setVisible(false);
				}
			}
		});
		frame.getContentPane().add(ContainerPane);
	}
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public JScrollPane getPage1() {
		PreData = new JPanel();
		PreData.setBackground(SystemColor.menu);
		PreData.setLayout(null);
		
		FirstNameLabel = new JLabel("\u0E0A\u0E37\u0E48\u0E2D");
		FirstNameLabel.setBounds(90, 75, 30, 35);
		FirstNameLabel.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
		
		FirstNameField = new JTextField();
		FirstNameField.setBounds(90, 109, 180, 25);
		FirstNameField.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
		FirstNameField.setColumns(10);
		
		AgeField = new JTextField();
		AgeField.setBounds(379, 178, 178, 25);
		AgeField.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
		AgeField.setColumns(10);
		
		AgeLabel = new JLabel("\u0E2D\u0E32\u0E22\u0E38");
		AgeLabel.setBounds(377, 144, 44, 35);
		AgeLabel.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
		
		LastNameLabel = new JLabel("\u0E19\u0E32\u0E21\u0E2A\u0E01\u0E38\u0E25");
		LastNameLabel.setBounds(377, 75, 75, 35);
		LastNameLabel.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
		
		LastNameField = new JTextField();
		LastNameField.setBounds(377, 109, 180, 25);
		LastNameField.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
		LastNameField.setColumns(10);
		
		SexLabel = new JLabel("\u0E40\u0E1E\u0E28");
		SexLabel.setBounds(90, 298, 44, 35);
		SexLabel.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
		
		SexComboBox = new JComboBox();
		SexComboBox.setBounds(133, 303, 137, 25);
		SexComboBox.setFont(new Font("CordiaUPC", Font.ITALIC, 20));
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
		
		HeightLabel = new JLabel("\u0E2A\u0E48\u0E27\u0E19\u0E2A\u0E39\u0E07");
		HeightLabel.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
		HeightLabel.setBounds(90, 214, 60, 35);
		PreData.add(HeightLabel);
		
		HeightField = new JTextField();
		HeightField.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
		HeightField.setColumns(10);
		HeightField.setBounds(91, 248, 179, 25);
		PreData.add(HeightField);
		
		WeightLabel = new JLabel("\u0E19\u0E49\u0E33\u0E2B\u0E19\u0E31\u0E01");
		WeightLabel.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
		WeightLabel.setBounds(377, 214, 65, 35);
		PreData.add(WeightLabel);
		
		WeightField = new JTextField();
		WeightField.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
		WeightField.setColumns(10);
		WeightField.setBounds(376, 248, 181, 25);
		PreData.add(WeightField);
		
		CardIDField = new JTextField();
		CardIDField.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
		CardIDField.setColumns(10);
		CardIDField.setBounds(90, 178, 180, 25);
		PreData.add(CardIDField);
		
		CardIDLabel = new JLabel("\u0E40\u0E25\u0E02\u0E1A\u0E31\u0E15\u0E23\u0E1B\u0E23\u0E30\u0E0A\u0E32\u0E0A\u0E19");
		CardIDLabel.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
		CardIDLabel.setBounds(90, 144, 123, 35);
		PreData.add(CardIDLabel);
		
		PreDataLabel = new JLabel("\u0E02\u0E49\u0E2D\u0E21\u0E39\u0E25\u0E40\u0E1A\u0E37\u0E49\u0E2D\u0E07\u0E15\u0E49\u0E19");
		PreDataLabel.setFont(new Font("CordiaUPC", Font.BOLD, 24));
		PreDataLabel.setBounds(50, 30, 114, 29);
		PreData.add(PreDataLabel);
		
		return Page1;
	}
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public JScrollPane getPage2() {
		
		Assignment = new JPanel();
		Assignment.setBackground(SystemColor.menu);
		
		TopicALabel = new JLabel("\u0E17\u0E48\u0E32\u0E19\u0E21\u0E35\u0E1B\u0E23\u0E30\u0E27\u0E31\u0E15\u0E34\u0E40\u0E2A\u0E35\u0E48\u0E22\u0E07\u0E15\u0E48\u0E2D\u0E01\u0E32\u0E23\u0E15\u0E34\u0E14\u0E40\u0E0A\u0E37\u0E49\u0E2D \u0E2B\u0E23\u0E37\u0E2D\u0E44\u0E21\u0E48\u0E14\u0E31\u0E07\u0E19\u0E35\u0E49");
		TopicALabel.setFont(new Font("CordiaUPC", Font.BOLD, 24));
		
		QA1Text = new JTextPane();
		QA1Text.setText("1. \u0E17\u0E48\u0E32\u0E19\u0E40\u0E04\u0E22\u0E21\u0E35\u0E1B\u0E23\u0E30\u0E27\u0E31\u0E15\u0E34\u0E01\u0E32\u0E23\u0E15\u0E34\u0E14\u0E40\u0E0A\u0E37\u0E49\u0E2D Covid-19 \u0E20\u0E32\u0E22\u0E43\u0E19\u0E23\u0E30\u0E22\u0E30\u0E40\u0E27\u0E25\u0E32 3 \u0E40\u0E14\u0E37\u0E2D\u0E19\u0E17\u0E35\u0E48\u0E1C\u0E48\u0E32\u0E19\u0E21\u0E32\u0E2B\u0E23\u0E37\u0E2D\u0E44\u0E21\u0E48");
		QA1Text.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
		QA1Text.setBackground(SystemColor.menu);
		
		QA2Text = new JTextPane();
		QA2Text.setText("2. \u0E17\u0E48\u0E32\u0E19\u0E40\u0E04\u0E22\u0E21\u0E35\u0E1B\u0E23\u0E30\u0E27\u0E31\u0E15\u0E34\u0E40\u0E1B\u0E47\u0E19\u0E1C\u0E39\u0E49\u0E21\u0E35\u0E20\u0E39\u0E21\u0E34\u0E04\u0E38\u0E49\u0E21\u0E01\u0E31\u0E19\u0E1A\u0E01\u0E1E\u0E23\u0E48\u0E2D\u0E07\u0E2B\u0E23\u0E37\u0E2D\u0E44\u0E21\u0E48");
		QA2Text.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
		QA2Text.setBackground(SystemColor.menu);
		
		QA3Text = new JTextPane();
		QA3Text.setText("3. \u0E17\u0E48\u0E32\u0E19\u0E40\u0E04\u0E22\u0E21\u0E35\u0E1B\u0E23\u0E30\u0E27\u0E31\u0E15\u0E34\u0E20\u0E39\u0E21\u0E34\u0E41\u0E1E\u0E49\u0E2D\u0E22\u0E48\u0E32\u0E07\u0E23\u0E38\u0E07\u0E41\u0E23\u0E07\u0E2B\u0E23\u0E37\u0E2D\u0E44\u0E21\u0E48 \u0E40\u0E0A\u0E48\u0E19 \u0E41\u0E1E\u0E49\u0E2D\u0E32\u0E2B\u0E32\u0E23\u0E23\u0E38\u0E19\u0E41\u0E23\u0E07 \u0E41\u0E1E\u0E49\u0E42\u0E25\u0E2B\u0E30");
		QA3Text.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
		QA3Text.setBackground(SystemColor.menu);
		
		QA4Text = new JTextPane();
		QA4Text.setText("4. \u0E17\u0E48\u0E32\u0E19\u0E40\u0E1B\u0E47\u0E19\u0E1C\u0E39\u0E49\u0E17\u0E35\u0E48\u0E21\u0E35\u0E1B\u0E23\u0E30\u0E27\u0E31\u0E15\u0E34\u0E01\u0E32\u0E23\u0E41\u0E1E\u0E49  \"\u0E2A\u0E32\u0E23\u0E42\u0E1E\u0E25\u0E35\u0E40\u0E2D\u0E18\u0E34\u0E25\u0E35\u0E19 \u0E44\u0E01\u0E04\u0E2D\u0E25(Polyethylene glycol: PEG)\u0E2B\u0E23\u0E37\u0E2D\u0E44\u0E21\u0E48");
		QA4Text.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
		QA4Text.setBackground(SystemColor.menu);
		
		QA5Text = new JTextPane();
		QA5Text.setText("5. \u0E17\u0E48\u0E32\u0E19\u0E40\u0E1B\u0E47\u0E19\u0E1C\u0E39\u0E49\u0E21\u0E35\u0E42\u0E23\u0E04\u0E1B\u0E23\u0E30\u0E08\u0E33\u0E15\u0E31\u0E27\u0E02\u0E31\u0E49\u0E19\u0E23\u0E38\u0E19\u0E41\u0E23\u0E07\u0E17\u0E35\u0E48\u0E44\u0E21\u0E48\u0E2A\u0E32\u0E21\u0E32\u0E23\u0E16\u0E04\u0E27\u0E1A\u0E04\u0E38\u0E21\u0E42\u0E23\u0E04\u0E44\u0E14\u0E49 \u0E40\u0E0A\u0E48\u0E19 \u0E42\u0E23\u0E04\u0E04\u0E27\u0E32\u0E21\u0E14\u0E31\u0E19 \u0E42\u0E23\u0E04\u0E21\u0E30\u0E40\u0E23\u0E47\u0E07 \u0E42\u0E23\u0E04\u0E2B\u0E31\u0E27\u0E43\u0E08\u0E41\u0E25\u0E30\u0E2B\u0E25\u0E2D\u0E14\u0E40\u0E25\u0E37\u0E2D\u0E14 \u0E40\u0E1B\u0E47\u0E19\u0E15\u0E49\u0E19");
		QA5Text.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
		QA5Text.setBackground(SystemColor.menu);
		
		QA6Text = new JTextPane();
		QA6Text.setText("6. \u0E17\u0E48\u0E32\u0E19\u0E44\u0E21\u0E48\u0E40\u0E04\u0E22\u0E21\u0E35\u0E1B\u0E23\u0E30\u0E27\u0E31\u0E15\u0E34\u0E41\u0E1E\u0E49\u0E22\u0E32\u0E43\u0E0A\u0E48\u0E2B\u0E23\u0E37\u0E2D\u0E44\u0E21\u0E48");
		QA6Text.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
		QA6Text.setBackground(SystemColor.menu);
		
		QA1NoRadio = new JRadioButton("\u0E44\u0E21\u0E48\u0E43\u0E0A\u0E48");
		QA1NoRadio.setFont(new Font("CordiaUPC", Font.PLAIN, 24));	
		QA1YesRadio = new JRadioButton("\u0E43\u0E0A\u0E48");
		QA1YesRadio.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
		
		QA1Group = new ButtonGroup();
		QA1Group.add(QA1NoRadio);
		QA1Group.add(QA1YesRadio);
		
		QA2NoRadio = new JRadioButton("\u0E44\u0E21\u0E48\u0E43\u0E0A\u0E48");
		QA2NoRadio.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
		QA2YesRadio = new JRadioButton("\u0E43\u0E0A\u0E48");
		QA2YesRadio.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
		
		QA2Group = new ButtonGroup();
		QA2Group.add(QA2NoRadio);
		QA2Group.add(QA2YesRadio);
		
		QA3NoRadio = new JRadioButton("\u0E44\u0E21\u0E48\u0E43\u0E0A\u0E48");
		QA3NoRadio.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
		QA3YesRadio = new JRadioButton("\u0E43\u0E0A\u0E48");
		QA3YesRadio.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
		
		QA3Group = new ButtonGroup();
		QA3Group.add(QA3NoRadio);
		QA3Group.add(QA3YesRadio);

		QA4NoRadio = new JRadioButton("\u0E44\u0E21\u0E48\u0E43\u0E0A\u0E48");
		QA4NoRadio.setFont(new Font("CordiaUPC", Font.PLAIN, 24));	
		QA4YesRadio = new JRadioButton("\u0E43\u0E0A\u0E48");
		QA4YesRadio.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
		
		QA4Group = new ButtonGroup();
		QA4Group.add(QA4NoRadio);
		QA4Group.add(QA4YesRadio);
		
		QA5NoRadio = new JRadioButton("\u0E44\u0E21\u0E48\u0E43\u0E0A\u0E48");
		QA5NoRadio.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
		QA5YesRadio = new JRadioButton("\u0E43\u0E0A\u0E48");
		QA5YesRadio.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
		
		QA5Group = new ButtonGroup();
		QA5Group.add(QA5NoRadio);
		QA5Group.add(QA5YesRadio);
		
		QA6NoRadio = new JRadioButton("\u0E44\u0E21\u0E48\u0E43\u0E0A\u0E48");
		QA6NoRadio.setFont(new Font("CordiaUPC", Font.PLAIN, 24));	
		QA6YesRadio = new JRadioButton("\u0E43\u0E0A\u0E48");
		QA6YesRadio.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
		
		QA6Group = new ButtonGroup();
		QA6Group.add(QA6NoRadio);
		QA6Group.add(QA6YesRadio);

		GroupLayout gl_Assignment = new GroupLayout(Assignment);
		gl_Assignment.setHorizontalGroup(
			gl_Assignment.createParallelGroup(Alignment.LEADING)
				.addGap(0, 629, Short.MAX_VALUE)
				.addGroup(gl_Assignment.createSequentialGroup()
					.addGap(19)
					.addComponent(TopicALabel, GroupLayout.PREFERRED_SIZE, 320, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(290, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_Assignment.createSequentialGroup()
					.addContainerGap(47, Short.MAX_VALUE)
					.addGroup(gl_Assignment.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Assignment.createParallelGroup(Alignment.LEADING)
							.addComponent(QA1Text, GroupLayout.PREFERRED_SIZE, 560, GroupLayout.PREFERRED_SIZE)
							.addComponent(QA3Text, GroupLayout.PREFERRED_SIZE, 499, GroupLayout.PREFERRED_SIZE)
							.addGroup(gl_Assignment.createSequentialGroup()
								.addGap(30)
								.addGroup(gl_Assignment.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_Assignment.createSequentialGroup()
										.addGap(98)
										.addComponent(QA3YesRadio, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
									.addComponent(QA3NoRadio)))
							.addGroup(gl_Assignment.createSequentialGroup()
								.addGap(30)
								.addComponent(QA2NoRadio)
								.addGap(42)
								.addComponent(QA2YesRadio, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_Assignment.createSequentialGroup()
								.addGap(127)
								.addComponent(QA4YesRadio, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
							.addComponent(QA4Text, GroupLayout.PREFERRED_SIZE, 560, GroupLayout.PREFERRED_SIZE)
							.addGroup(gl_Assignment.createSequentialGroup()
								.addGap(29)
								.addComponent(QA4NoRadio))
							.addComponent(QA2Text, GroupLayout.PREFERRED_SIZE, 352, GroupLayout.PREFERRED_SIZE)
							.addComponent(QA5Text, GroupLayout.PREFERRED_SIZE, 560, GroupLayout.PREFERRED_SIZE)
							.addGroup(gl_Assignment.createSequentialGroup()
								.addGap(125)
								.addComponent(QA5YesRadio, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_Assignment.createSequentialGroup()
								.addGap(27)
								.addComponent(QA5NoRadio))
							.addComponent(QA6Text, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE)
							.addGroup(gl_Assignment.createSequentialGroup()
								.addGap(28)
								.addGroup(gl_Assignment.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_Assignment.createSequentialGroup()
										.addGap(98)
										.addComponent(QA6YesRadio, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
									.addComponent(QA6NoRadio))))
						.addGroup(gl_Assignment.createSequentialGroup()
							.addGap(31)
							.addComponent(QA1NoRadio)
							.addGap(43)
							.addComponent(QA1YesRadio, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)))
					.addGap(22))
		);
		gl_Assignment.setVerticalGroup(
			gl_Assignment.createParallelGroup(Alignment.LEADING)
				.addGap(0, 720, Short.MAX_VALUE)
				.addGroup(gl_Assignment.createSequentialGroup()
					.addGap(49)
					.addComponent(TopicALabel, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(QA1Text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_Assignment.createParallelGroup(Alignment.BASELINE)
						.addComponent(QA1YesRadio, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(QA1NoRadio))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(QA2Text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_Assignment.createParallelGroup(Alignment.BASELINE)
						.addComponent(QA2YesRadio, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(QA2NoRadio, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
					.addGap(20)
					.addComponent(QA3Text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_Assignment.createParallelGroup(Alignment.LEADING)
						.addComponent(QA3YesRadio, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(QA3NoRadio, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_Assignment.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Assignment.createSequentialGroup()
							.addGap(67)
							.addComponent(QA4YesRadio, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_Assignment.createSequentialGroup()
							.addComponent(QA4Text, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(QA4NoRadio, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_Assignment.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Assignment.createSequentialGroup()
							.addGap(67)
							.addComponent(QA5YesRadio, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_Assignment.createSequentialGroup()
							.addComponent(QA5Text, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(QA5NoRadio, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)))
					.addGap(19)
					.addComponent(QA6Text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_Assignment.createParallelGroup(Alignment.LEADING)
						.addComponent(QA6YesRadio, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(QA6NoRadio, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(37, Short.MAX_VALUE))
		);
		Assignment.setLayout(gl_Assignment);
		
		Page2 = new JScrollPane();
		Page2.setViewportView(Assignment);
		
		return Page2;
	}
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public JScrollPane getPage3() {
		Symptom = new JPanel();
		
		TopicBLabel = new JLabel("\u0E17\u0E48\u0E32\u0E19\u0E21\u0E35\u0E2D\u0E32\u0E01\u0E32\u0E23\u0E14\u0E31\u0E07\u0E15\u0E48\u0E2D\u0E44\u0E1B\u0E19\u0E35\u0E49\u0E2B\u0E23\u0E37\u0E2D\u0E44\u0E21\u0E48");
		TopicBLabel.setFont(new Font("CordiaUPC", Font.BOLD, 24));
		
		FeverCheckBox = new JCheckBox("\u0E21\u0E35\u0E44\u0E02\u0E49");
		FeverCheckBox.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
		
		CoughCheckBox = new JCheckBox("\u0E44\u0E2D");
		CoughCheckBox.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
		
		RunnyCheckBox = new JCheckBox("\u0E21\u0E35\u0E19\u0E49\u0E33\u0E21\u0E39\u0E01");
		RunnyCheckBox.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
		
		ThroatCheckBox = new JCheckBox("\u0E40\u0E08\u0E47\u0E1A\u0E04\u0E2D");
		ThroatCheckBox.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
		
		ExhaustedCheckBox = new JCheckBox("\u0E2B\u0E32\u0E22\u0E43\u0E08\u0E25\u0E33\u0E1A\u0E32\u0E01");
		ExhaustedCheckBox.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
		
		SmellCheckBox = new JCheckBox("\u0E44\u0E21\u0E48\u0E44\u0E14\u0E49\u0E01\u0E25\u0E34\u0E48\u0E19");
		SmellCheckBox.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
		
		TasteCheckBox = new JCheckBox("\u0E44\u0E21\u0E48\u0E23\u0E39\u0E49\u0E23\u0E2A");
		TasteCheckBox.setFont(new Font("CordiaUPC", Font.PLAIN, 24));

		EyeCheckBox = new JCheckBox("\u0E15\u0E32\u0E41\u0E14\u0E07");
		EyeCheckBox.setFont(new Font("CordiaUPC", Font.PLAIN, 24));

		RashCheckBox = new JCheckBox("\u0E1C\u0E37\u0E48\u0E19");
		RashCheckBox.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
		
		DiarrheaCheckBox = new JCheckBox("\u0E17\u0E49\u0E2D\u0E07\u0E40\u0E2A\u0E35\u0E22");
		DiarrheaCheckBox.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
		
		TopicCLabel = new JLabel("\u0E42\u0E1B\u0E23\u0E14\u0E23\u0E30\u0E1A\u0E38\u0E2D\u0E38\u0E13\u0E2B\u0E20\u0E39\u0E21\u0E34\u0E23\u0E48\u0E32\u0E07\u0E01\u0E32\u0E22\u0E02\u0E2D\u0E07\u0E17\u0E48\u0E32\u0E19");
		TopicCLabel.setFont(new Font("CordiaUPC", Font.BOLD, 24));
		
		TemperatureField = new JTextField();
		TemperatureField.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
		TemperatureField.setColumns(10);
		TemperatureField.setHorizontalAlignment(SwingConstants.RIGHT);
		
		CelsiusLabel = new JLabel("\u0E2D\u0E07\u0E28\u0E32");
		CelsiusLabel.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
		
		GroupLayout gl_Symptom = new GroupLayout(Symptom);
		gl_Symptom.setHorizontalGroup(
			gl_Symptom.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_Symptom.createSequentialGroup()
					.addGroup(gl_Symptom.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_Symptom.createSequentialGroup()
							.addGap(32)
							.addGroup(gl_Symptom.createParallelGroup(Alignment.LEADING)
								.addComponent(FeverCheckBox)
								.addComponent(TasteCheckBox, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE))
							.addGap(51)
							.addGroup(gl_Symptom.createParallelGroup(Alignment.LEADING)
								.addComponent(CoughCheckBox, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
								.addComponent(SmellCheckBox, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE))
							.addGap(30))
						.addGroup(gl_Symptom.createSequentialGroup()
							.addGap(20)
							.addGroup(gl_Symptom.createParallelGroup(Alignment.LEADING)
								.addComponent(TopicCLabel, GroupLayout.PREFERRED_SIZE, 257, GroupLayout.PREFERRED_SIZE)
								.addComponent(TopicBLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_Symptom.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Symptom.createSequentialGroup()
							.addGroup(gl_Symptom.createParallelGroup(Alignment.LEADING)
								.addComponent(RunnyCheckBox, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
								.addComponent(EyeCheckBox, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_Symptom.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_Symptom.createSequentialGroup()
									.addComponent(ThroatCheckBox, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED))
								.addGroup(gl_Symptom.createSequentialGroup()
									.addComponent(RashCheckBox, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
									.addGap(39)))
							.addGroup(gl_Symptom.createParallelGroup(Alignment.TRAILING)
								.addComponent(ExhaustedCheckBox, Alignment.LEADING)
								.addComponent(DiarrheaCheckBox, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_Symptom.createSequentialGroup()
							.addComponent(TemperatureField, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(CelsiusLabel, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(48, Short.MAX_VALUE))
		);
		gl_Symptom.setVerticalGroup(
			gl_Symptom.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Symptom.createSequentialGroup()
					.addGap(47)
					.addComponent(TopicBLabel, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_Symptom.createParallelGroup(Alignment.TRAILING)
						.addComponent(FeverCheckBox)
						.addGroup(gl_Symptom.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_Symptom.createParallelGroup(Alignment.BASELINE)
								.addComponent(ThroatCheckBox, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
								.addComponent(ExhaustedCheckBox, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_Symptom.createParallelGroup(Alignment.BASELINE)
								.addComponent(RunnyCheckBox, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
								.addComponent(CoughCheckBox, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_Symptom.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Symptom.createSequentialGroup()
							.addGroup(gl_Symptom.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_Symptom.createParallelGroup(Alignment.BASELINE)
									.addComponent(SmellCheckBox, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
									.addComponent(TasteCheckBox, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_Symptom.createParallelGroup(Alignment.BASELINE)
									.addComponent(RashCheckBox, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
									.addComponent(EyeCheckBox, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)))
							.addGap(13)
							.addGroup(gl_Symptom.createParallelGroup(Alignment.BASELINE)
								.addComponent(TopicCLabel)
								.addComponent(TemperatureField, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(CelsiusLabel, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)))
						.addComponent(DiarrheaCheckBox, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
					.addGap(207))
		);
		Symptom.setLayout(gl_Symptom);
		
		Page3 = new JScrollPane();
		Page3.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		Page3.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		Page3.setViewportView(Symptom);
		
		return Page3;
	}
}
