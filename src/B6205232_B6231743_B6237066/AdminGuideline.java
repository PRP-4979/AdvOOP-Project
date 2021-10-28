package B6205232_B6231743_B6237066;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class AdminGuideline {

	private JFrame frame;
	private JLabel HeadLabel, GroupLabel;
	private JTextField GroupIdField, GroupField;
	private JTextArea DetailArea, RiskArea;
	private JButton AddButton, EditButton, DeleteButton, SaveButton, CancelButton, HomeButton;
	private JButton FirstButton, PreviousButton, NextButton, LastButton;
	
	private Database db;
	private String sql = "", action = "", id = "";
	private ResultSet rsRead;
	private int confirm = 0;
	private JLabel ForceLabel;

	/**
	 * Launch the application.
	 */
	public static void GuidelineScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminGuideline window = new AdminGuideline();
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
	public AdminGuideline() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		db = new Database();
		if (db.Connect()) {
			try {
				sql = "SELECT * FROM guideline";
				rsRead = db.ExecuteQuery(sql);
			}catch(Exception ex) {
				System.out.println(ex);
			}
		}
		
		frame = new JFrame();
		frame.setTitle("\u0E41\u0E19\u0E27\u0E17\u0E32\u0E07\u0E01\u0E32\u0E23\u0E1B\u0E49\u0E2D\u0E07\u0E01\u0E31\u0E19");
		frame.setBounds(100, 100, 810, 580);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		HeadLabel = new JLabel("\u0E41\u0E19\u0E27\u0E17\u0E32\u0E07\u0E01\u0E32\u0E23\u0E1B\u0E49\u0E2D\u0E07\u0E01\u0E31\u0E19");
		HeadLabel.setFont(new Font("CordiaUPC", Font.BOLD, 36));
		HeadLabel.setBounds(265, 27, 209, 46);
		frame.getContentPane().add(HeadLabel);
		
		GroupLabel = new JLabel("\u0E1B\u0E23\u0E30\u0E40\u0E20\u0E17\u0E01\u0E25\u0E38\u0E48\u0E21:");
		GroupLabel.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
		GroupLabel.setBounds(115, 109, 96, 25);
		frame.getContentPane().add(GroupLabel);
		
		frame.getContentPane().add(getGroupIdField(), null);
		frame.getContentPane().add(getGroupField(), null);
		frame.getContentPane().add(getDetailArea(), null);
		frame.getContentPane().add(getRiskArea(), null);
		
		frame.getContentPane().add(getAddButton(), null);
		frame.getContentPane().add(getEditButton(), null);
		frame.getContentPane().add(getDeleteButton(), null);
		frame.getContentPane().add(getSaveButton(), null);
		frame.getContentPane().add(getCancelButton(), null);
		
		frame.getContentPane().add(getFirstButton(), null);
		frame.getContentPane().add(getPreviousButton(), null);
		frame.getContentPane().add(getNextButton(), null);
		frame.getContentPane().add(getLastButton(), null);
		frame.getContentPane().add(getHomeButton(), null);
		frame.getContentPane().add(getForceLabel());
	}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public JTextField getGroupIdField() {
		if (GroupIdField == null) {
			GroupIdField = new JTextField();
			GroupIdField.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
			GroupIdField.setText((String) null);
			GroupIdField.setColumns(10);
			GroupIdField.setBounds(410, 110, 160, 26);
			GroupIdField.setEditable(false);
			GroupIdField.setVisible(false);
			
			try {
				if (rsRead != null) GroupIdField.setText(rsRead.getString("guide_id"));
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return GroupIdField;
	}

	public JTextField getGroupField() {
		if (GroupField == null) {
			GroupField = new JTextField();
			GroupField.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
			GroupField.setText((String) null);
			GroupField.setColumns(10);
			GroupField.setBounds(210, 110, 160, 26);
			GroupField.setEditable(false);
			
			try {
				if (rsRead != null) GroupField.setText(rsRead.getString("guide_color"));
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return GroupField;
	}
	
	public JTextArea getDetailArea() {
		if (DetailArea == null) {
			DetailArea = new JTextArea();
			DetailArea.setLineWrap(true);
			DetailArea.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
			DetailArea.setText((String) null);
			DetailArea.setBounds(111, 147, 490, 113);
			DetailArea.setEditable(false);
			
			try {
				if (rsRead != null) DetailArea.setText(rsRead.getString("guide_detail"));
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return DetailArea;
	}
	
	public JTextArea getRiskArea() {
		if (RiskArea == null) {
			RiskArea = new JTextArea();
			RiskArea.setLineWrap(true);
			RiskArea.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
			RiskArea.setText((String) null);
			RiskArea.setBounds(111, 316, 490, 113);
			RiskArea.setEditable(false);
			
			try {
				if (rsRead != null) RiskArea.setText(rsRead.getString("guide_risk"));
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return RiskArea;
	}
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private void updateTextField() {
		if (rsRead != null) {
			try {
				GroupIdField.setText(rsRead.getString("guide_id"));
				GroupField.setText(rsRead.getString("guide_color"));
				DetailArea.setText(rsRead.getString("guide_detail"));
				RiskArea.setText(rsRead.getString("guide_risk"));
			}catch (SQLException e) {
				e.printStackTrace();
			}			
		}
	}
	
	private void clearData() {
		GroupIdField.setText("");
		GroupField.setText("");
		DetailArea.setText("");
		RiskArea.setText("");
	}

	private void setActive() {
		GroupField.setEditable(true);
		DetailArea.setEditable(true);
		RiskArea.setEditable(true);
	}
	
	private void setInActive() {
		GroupField.setEditable(false);
		DetailArea.setEditable(false);
		RiskArea.setEditable(false);
	}
	 
	private void showButton() {
		SaveButton.setEnabled(true);
		CancelButton.setEnabled(true);
	} 
	 
	private void hideButton() {
		SaveButton.setEnabled(false);
		CancelButton.setEnabled(false);
	}
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public JButton getAddButton() {
		if (AddButton == null) {
			AddButton = new JButton("\u0E40\u0E1E\u0E34\u0E48\u0E21");
			AddButton.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
			AddButton.setBounds(631, 110, 90, 40);
			AddButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					clearData();
					setActive();
					showButton();
					
					try {
						if (rsRead != null) {
							rsRead.last();
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					action = "add";
				}
			});
		}
		return AddButton;
	}
	
	public JButton getEditButton() {
		if (EditButton == null) {
			EditButton = new JButton("\u0E41\u0E01\u0E49\u0E44\u0E02");
			EditButton.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
			EditButton.setBounds(631, 161, 90, 40);
			EditButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setActive();
					showButton();
					
					action = "edit";
					id = GroupIdField.getText();
				}
			});
		}
		return EditButton;
	}
	
	public JButton getDeleteButton() {
		if (DeleteButton == null) {
			DeleteButton = new JButton("\u0E25\u0E1A");
			DeleteButton.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
			DeleteButton.setBounds(631, 212, 90, 40);
			DeleteButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						id = GroupIdField.getText();
						
						confirm = JOptionPane.showConfirmDialog(frame, "Are you sure you want to delete ID '" + id +"' ?");
						if (confirm == 0) {
							rsRead = db.DeleteRow("guideline", "guide_id", id);
							
							if (rsRead != null) {
								updateTextField();							
							}else {
								clearData();
							}							
						}
					}catch(Exception ex) {
						System.out.println(ex);
					}
				}
			});
		}
		return DeleteButton;
	}
	
	public JButton getSaveButton() {
		if (SaveButton == null) {
			SaveButton = new JButton("\u0E1A\u0E31\u0E19\u0E17\u0E36\u0E01");
			SaveButton.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
			SaveButton.setBounds(631, 316, 90, 40);
			SaveButton.setEnabled(false);
			SaveButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (action.equals("add")) {
						sql = "INSERT INTO guideline (guide_color, guide_detail, guide_risk) VALUES('" + GroupField.getText() + "', '" + DetailArea.getText() + "', '" + RiskArea.getText() + "')";
						rsRead = db.AddRow("guideline", sql);
						updateTextField();
					}else if(action == "edit") {
						confirm = JOptionPane.showConfirmDialog(frame, "Are you sure you want to save your changes ?");
						if (confirm == 0) {
							try {
								sql = "UPDATE guideline SET guide_color='" + GroupField.getText() + "', guide_detail='" + DetailArea.getText() + "', guide_risk='" + RiskArea.getText() + "' WHERE guide_id=" + id;
									
								rsRead = db.UpdateRow("guideline", sql);
								JOptionPane.showMessageDialog(frame, "Guideline ID " + id + " has been updated !");
							}catch(Exception ex) {
								System.out.println(ex);
							}
						}
					}
						
					setInActive();
					hideButton();
				}
			});
		}
		return SaveButton;
	}
	
	public JButton getCancelButton() {
		if (CancelButton == null) {
			CancelButton = new JButton("\u0E22\u0E01\u0E40\u0E25\u0E34\u0E01");
			CancelButton.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
			CancelButton.setBounds(631, 367, 90, 40);
			CancelButton.setEnabled(false);
			CancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (rsRead != null) {
						try {
							if (rsRead.isLast()) {
								rsRead.previous();		
								rsRead.next();				
							}else {
								rsRead.next();
								rsRead.previous();
							}						
						}catch (SQLException el) {
							el.printStackTrace();
						}						
					}

					setInActive();
					hideButton();
					updateTextField();
				}
			});
		}
		return CancelButton;
	}
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public JButton getFirstButton() {
		if (FirstButton == null) {
			FirstButton = new JButton("<<");
			FirstButton.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
			FirstButton.setBounds(168, 460, 60, 40);
			FirstButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setInActive();
					hideButton();
					
					try {
						rsRead.first();
						updateTextField();
					}catch (SQLException el) {
						el.printStackTrace();
					}
				}
			});
		}
		return FirstButton;
	}
	
	public JButton getPreviousButton() {
		if (PreviousButton == null) {
			PreviousButton = new JButton("<");
			PreviousButton.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
			PreviousButton.setBounds(238, 460, 60, 40);
			PreviousButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setInActive();
					hideButton();
					
					try {
						if (rsRead.isFirst()) {
							rsRead.first();
							updateTextField();
						}else{
							rsRead.previous();
							updateTextField();
						}
					}catch (SQLException el) {
						el.printStackTrace();
					}
				}
			});
		}
		return PreviousButton;
	}
	
	public JButton getNextButton() {
		if (NextButton == null) {
			NextButton = new JButton(">");
			NextButton.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
			NextButton.setBounds(418, 460, 60, 40);
			NextButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setInActive();
					hideButton();
					
					try {
						if (rsRead.isLast()) {
							rsRead.last();
							updateTextField();
						}else{
							rsRead.next();
							updateTextField();
						}
					}catch (SQLException el) {
						el.printStackTrace();
					}
				}
			});
		}
		return NextButton;
	}
	
	public JButton getLastButton() {
		if (LastButton == null) {
			LastButton = new JButton(">>");
			LastButton.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
			LastButton.setBounds(488, 460, 60, 40);
			LastButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setInActive();
					hideButton();
					
					try {
						rsRead.last();
						updateTextField();
					}catch (SQLException el) {
						el.printStackTrace();
					}
				}
			});
		}
		return LastButton;
	}
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public JButton getHomeButton() {
		if (HomeButton == null) {
			HomeButton = new JButton("\u0E2B\u0E19\u0E49\u0E32\u0E2B\u0E25\u0E31\u0E01");
			HomeButton.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
			HomeButton.setBounds(308, 460, 100, 40);
			HomeButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Command window = new Command();
					window.VisibleScreen();
					
					db.Close();
					frame.setVisible(false);
				}
			});
		}
		return HomeButton;
	}
	private JLabel getForceLabel() {
		if (ForceLabel == null) {
			ForceLabel = new JLabel("\u0E2A\u0E34\u0E48\u0E07\u0E17\u0E35\u0E48\u0E04\u0E27\u0E23\u0E17\u0E33\u0E2D\u0E22\u0E48\u0E32\u0E07\u0E22\u0E34\u0E48\u0E07");
			ForceLabel.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
			ForceLabel.setBounds(115, 282, 135, 25);
		}
		return ForceLabel;
	}
}
