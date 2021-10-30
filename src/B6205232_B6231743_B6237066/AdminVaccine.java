package B6205232_B6231743_B6237066;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class AdminVaccine {

	private JFrame frame;
	
	private JTextField VaccineIdField, NameField, EfficiencyField, RangeField;
	private JTextArea DetailArea, SideEffectsArea, Disease1Area, Disease2Area;
	private JButton AddButton, EditButton, DeleteButton, SaveButton, CancelButton;
	private JButton FirstButton,PreviousButton,HomeButton,NextButton,LastButton;
	
	private JLabel HeadLabel, NameLabel, EfficiencyLabel;
	private JLabel ConditionLabel, RangeLabel, PercentLabel;
	private JLabel DetailLabel, SideEffectsLabel;
	private JLabel Disease1Label, Disease2Label;
	private JRadioButton Age1Radio, Age2Radio;
	
	private Database db;
	private String sql = "", action = "", id = "";
	private ResultSet rsRead;
	private ButtonGroup age;
	private int confirm = 0;

	/**
	 * Launch the application.
	 */
	public static void VaccineScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminVaccine window = new AdminVaccine();
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
	public AdminVaccine() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		db = new Database();
		if (db.Connect()) {
			try {
				sql = "SELECT * FROM vaccine";
				rsRead = db.ExecuteQuery(sql);
			}catch(Exception ex) {
				System.out.println(ex);
			}
		}
		
		frame = new JFrame();
		frame.setTitle("\u0E02\u0E49\u0E2D\u0E21\u0E39\u0E25\u0E27\u0E31\u0E04\u0E0B\u0E35\u0E19");
		frame.setBounds(100, 100, 800, 890);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		HeadLabel = new JLabel("\u0E02\u0E49\u0E2D\u0E21\u0E39\u0E25\u0E27\u0E31\u0E04\u0E0B\u0E35\u0E19");
		HeadLabel.setFont(new Font("CordiaUPC", Font.BOLD, 36));
		HeadLabel.setBounds(313, 11, 150, 51);
		frame.getContentPane().add(HeadLabel);
		
		frame.getContentPane().add(getAddButton(), null);
		frame.getContentPane().add(getEditButton(), null);
		frame.getContentPane().add(getDeleteButton(), null);
		frame.getContentPane().add(getSaveButton(), null);
		frame.getContentPane().add(getCancelButton(), null);
		frame.getContentPane().add(getHomeButton(), null);
		
		frame.getContentPane().add(getFirstButton(), null);
		frame.getContentPane().add(getPreviousButton(), null);		
		frame.getContentPane().add(getNextButton(), null);
		frame.getContentPane().add(getLastButton(), null);
		
		frame.getContentPane().add(getNameLabel(), null);
		frame.getContentPane().add(getEfficiencyLabel(), null);
		frame.getContentPane().add(getConditionLabel(), null);
		frame.getContentPane().add(getRangeLabel(), null);
		frame.getContentPane().add(getDetailLabel(), null);
		frame.getContentPane().add(getSideEffectsLabel(), null);
		frame.getContentPane().add(getDisease1Label(), null);
		frame.getContentPane().add(getDisease2Label(), null);	

		frame.getContentPane().add(getVaccineIdField(), null);
		frame.getContentPane().add(getNameField(), null);
		frame.getContentPane().add(getEfficiencyField(), null);
		frame.getContentPane().add(getRangeField(), null);
		frame.getContentPane().add(getAge1Radio(), null);
		frame.getContentPane().add(getAge2Radio(), null);
		frame.getContentPane().add(getPercentLabel(), null);
		frame.getContentPane().add(getDetailArea(), null);
		frame.getContentPane().add(getSideEffectsArea(), null);		
		frame.getContentPane().add(getDisease1(), null);
		frame.getContentPane().add(getDisease2(), null);
		
		age = new ButtonGroup();
		age.add(Age1Radio);
		age.add(Age2Radio);
		checkRadio();
	}
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	private JTextField getVaccineIdField() {
		if(VaccineIdField == null) {
			VaccineIdField = new JTextField();
			VaccineIdField.setEditable(false);
			VaccineIdField.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
			VaccineIdField.setBounds(647, 480, 90, 26);
			VaccineIdField.setColumns(10);
			VaccineIdField.setVisible(false);
		
			try {
				if (rsRead != null) VaccineIdField.setText(rsRead.getString("vac_id"));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return VaccineIdField;
	}
	
	private JTextField getNameField() {
		if(NameField == null) {
			NameField = new JTextField();
			NameField.setEditable(false);
			NameField.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
			NameField.setBounds(146, 107, 160, 26);
			NameField.setColumns(10);
		
			try {
				if (rsRead != null) NameField.setText(rsRead.getString("vac_name"));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return NameField;
	}
	
	private JTextField getEfficiencyField() {
		if (EfficiencyField == null) {
			EfficiencyField = new JTextField();
			EfficiencyField.setEditable(false);
			EfficiencyField.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
			EfficiencyField.setText((String) null);
			EfficiencyField.setColumns(10);
			EfficiencyField.setBounds(451, 107, 136, 26);
			EfficiencyField.setHorizontalAlignment(SwingConstants.RIGHT);
			
			try {
				if (rsRead != null) EfficiencyField.setText(rsRead.getString("efficiency"));
			} catch (SQLException e) {
			 	e.printStackTrace();
			}
		}
		return EfficiencyField;
	}
	
	private JTextField getRangeField() {
		if(RangeField == null) {
			RangeField = new JTextField();
			RangeField.setEditable(false);
			RangeField.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
			RangeField.setBounds(647, 517, 90, 26);
			RangeField.setColumns(10);
			RangeField.setVisible(false);
		
			try {
				if (rsRead != null) RangeField.setText(rsRead.getString("range_age"));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return RangeField;
	}
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	private JTextArea getDetailArea() {
		if (DetailArea == null) {
			DetailArea = new JTextArea();
			DetailArea.setEditable(false);
			DetailArea.setLineWrap(true);
			DetailArea.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
			DetailArea.setBounds(146, 209, 465, 113);
			
			try {
				if (rsRead != null) DetailArea.setText(rsRead.getString("vac_detail"));
			} catch (SQLException e) {
			 	e.printStackTrace();
			}
		}
		return DetailArea;
	}
	
	private JTextArea getSideEffectsArea() {
		if (SideEffectsArea == null) {
			SideEffectsArea = new JTextArea();
			SideEffectsArea.setEditable(false);
			SideEffectsArea.setLineWrap(true);
			SideEffectsArea.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
			SideEffectsArea.setBounds(146, 345, 465, 113);
		
			try {
				if (rsRead != null) SideEffectsArea.setText(rsRead.getString("side_effects"));
			} catch (SQLException e) {
		 		e.printStackTrace();
			}
		}
		
		return SideEffectsArea;
	}
	
	private JTextArea getDisease1() {
		if(Disease1Area == null) {
			Disease1Area = new JTextArea();
			Disease1Area.setEditable(false);
			Disease1Area.setLineWrap(true);
			Disease1Area.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
			Disease1Area.setBounds(146, 480, 465, 113);
		
			try {
				if (rsRead != null) Disease1Area.setText(rsRead.getString("Disease1"));
		 	} catch (SQLException e) {
		 		e.printStackTrace();
		 	}
		}
		return Disease1Area;
	}
	
	private JTextArea getDisease2() {
		if(Disease2Area == null) {
			Disease2Area = new JTextArea();
			Disease2Area.setEditable(false);
			Disease2Area.setLineWrap(true);
			Disease2Area.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
			Disease2Area.setBounds(146, 615, 465, 113);
		
			try {
				if (rsRead != null) Disease2Area.setText(rsRead.getString("disease2"));
		 	} catch (SQLException e) {
		 		e.printStackTrace();
		 	}
		}
		return Disease2Area;
	}
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	private JRadioButton  getAge1Radio() {
		if (Age1Radio == null) {
			Age1Radio = new JRadioButton("> 16 \u0E02\u0E36\u0E49\u0E19\u0E44\u0E1B");
			Age1Radio.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
			Age1Radio.setBounds(220, 158, 100, 23);
			Age1Radio.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					RangeField.setText("1");
				}
			});
		}
		return Age1Radio;
	}
	
	private JRadioButton getAge2Radio() {
		if (Age2Radio == null) {
			Age2Radio = new JRadioButton("\u0E44\u0E21\u0E48\u0E40\u0E01\u0E34\u0E19 60");
			Age2Radio.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
			Age2Radio.setBounds(340, 159, 90, 23);
			Age2Radio.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					RangeField.setText("2");
				}
			});
		}
		return Age2Radio;
	}
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	private void updateTextField() {
		if (rsRead != null) {
			try {
				VaccineIdField.setText(rsRead.getString("vac_id"));
				NameField.setText(rsRead.getString("vac_name"));
				EfficiencyField.setText(rsRead.getString("efficiency"));
				RangeField.setText(rsRead.getString("range_age"));
				DetailArea.setText(rsRead.getString("vac_detail"));
				SideEffectsArea.setText(rsRead.getString("side_effects"));
				Disease1Area.setText(rsRead.getString("disease1"));
				Disease2Area.setText(rsRead.getString("disease2"));
			}catch (SQLException e) {
				e.printStackTrace();
			}			
		}
	}
	
	private void clearData() {
		VaccineIdField.setText("");
		NameField.setText("");
		EfficiencyField.setText("");
		RangeField.setText("");
		DetailArea.setText("");
		SideEffectsArea.setText("");
		Disease1Area.setText("");
		Disease2Area.setText("");
	}

	private void setActive() {
		NameField.setEditable(true);
		EfficiencyField.setEditable(true);
		DetailArea.setEditable(true);
		SideEffectsArea.setEditable(true);
		Disease1Area.setEditable(true);
		Disease2Area.setEditable(true);
	}
	
	private void setInActive() {
		NameField.setEditable(false);
		EfficiencyField.setEditable(false);
		DetailArea.setEditable(false);
		SideEffectsArea.setEditable(false);
		Disease1Area.setEditable(false);
		Disease2Area.setEditable(false);
	}
	 
	private void showButton() {
		SaveButton.setEnabled(true);
		CancelButton.setEnabled(true);
	} 
	 
	private void hideButton() {
		SaveButton.setEnabled(false);
		CancelButton.setEnabled(false);
	}
	
	private void checkRadio() {		
		if (RangeField.getText().equals("1")) {
			Age1Radio.setSelected(true);
		}
		
		if (RangeField.getText().equals("2")) {
			Age2Radio.setSelected(true);
		}
		
		if (RangeField.getText().equals("")) {
			age.clearSelection();
		}
	}
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	private JButton getAddButton() {
		if (AddButton == null) {
			AddButton = new JButton("\u0E40\u0E1E\u0E34\u0E48\u0E21");
			AddButton.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
			AddButton.setBounds(647, 107, 90, 40);
			AddButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					clearData();
					setActive();
					showButton();
					checkRadio();

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
	
	private JButton getEditButton() {
		if (EditButton == null) {
			EditButton = new JButton("\u0E41\u0E01\u0E49\u0E44\u0E02");
			EditButton.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
			EditButton.setBounds(647, 158, 90, 40);
			EditButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setActive();
					showButton();
					
					action = "edit";
					id = VaccineIdField.getText();
				}
			});
		}
		return EditButton;
	}
	
	private JButton getDeleteButton() {
		if (DeleteButton == null) {
			DeleteButton = new JButton("\u0E25\u0E1A");
			DeleteButton.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
			DeleteButton.setBounds(647, 209, 90, 40);
			DeleteButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						id = VaccineIdField.getText();
						
						confirm = JOptionPane.showConfirmDialog(frame, "Are you sure you want to delete ID '" + id +"' ?");
						if (confirm == 0) {
							rsRead = db.DeleteRow("vaccine", "vac_id", id);
							
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

	private JButton getSaveButton() {
		if (SaveButton == null) {
			SaveButton = new JButton("\u0E1A\u0E31\u0E19\u0E17\u0E36\u0E01");
			SaveButton.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
			SaveButton.setBounds(647, 329, 90, 40);
			SaveButton.setEnabled(false);
			SaveButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (action.equals("add")) {
						double percentage = Double.parseDouble(EfficiencyField.getText());
						int rangeAge = Integer.parseInt(RangeField.getText());
						
						sql = "INSERT INTO vaccine (vac_name, vac_detail, side_effects, efficiency, range_age, disease1, disease2) VALUES ('" + NameField.getText() + "', '" + DetailArea.getText() + "', '" + SideEffectsArea.getText() + "', " + percentage + ", " + rangeAge + ", '" + Disease1Area.getText() + "', '" + Disease2Area.getText() + "')";
						rsRead = db.AddRow("vaccine", sql);
						updateTextField();
					}else if(action == "edit") {
						confirm = JOptionPane.showConfirmDialog(frame, "Are you sure you want to save your changes ?");
						if (confirm == 0) {
							try {
								double percentage = Double.parseDouble(EfficiencyField.getText());
								int rangeAge = Integer.parseInt(RangeField.getText());
								
								sql = "UPDATE vaccine SET vac_name='" + NameField.getText() + "', vac_detail='" + DetailArea.getText() + "', side_effects='" + SideEffectsArea.getText() + "', efficiency=" + percentage + ", range_age=" + rangeAge + ", disease1='" + Disease1Area.getText() + "', disease2='" + Disease2Area.getText() + "' WHERE vac_id=" + id;	
								rsRead = db.UpdateRow("vaccine", sql);
								JOptionPane.showMessageDialog(frame, "Vaccine ID " + id + " has been updated !");
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
	 
	private JButton getCancelButton() {
		if (CancelButton == null) {
			CancelButton = new JButton("\u0E22\u0E01\u0E40\u0E25\u0E34\u0E01");
			CancelButton.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
			CancelButton.setBounds(647, 380, 90, 40);
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
					checkRadio();
				}
			});
		}
		return CancelButton;
	}
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	 
	public JButton getFirstButton() {
		if (FirstButton == null) {
			FirstButton = new JButton("<<");
			FirstButton.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
			FirstButton.setBounds(190, 768, 60, 40);
			FirstButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setInActive();
					hideButton();
					
					try {
						rsRead.first();
						updateTextField();
						checkRadio();
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
			PreviousButton.setBounds(260, 768, 60, 40);
			PreviousButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setInActive();
					hideButton();
					
					try {
						if (rsRead.isFirst()) {
							rsRead.first();
							updateTextField();
							checkRadio();
						}else{
							rsRead.previous();
							updateTextField();
							checkRadio();
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
			NextButton.setBounds(440, 768, 60, 40);
			NextButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setInActive();
					hideButton();
					
					try {
						if (rsRead.isLast()) {
							rsRead.last();
							updateTextField();
							checkRadio();
						}else{
							rsRead.next();
							updateTextField();
							checkRadio();
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
			LastButton.setBounds(510, 768, 60, 40);
			LastButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setInActive();
					hideButton();
					
					try {
						rsRead.last();
						updateTextField();
						checkRadio();
					}catch (SQLException el) {
						el.printStackTrace();
					}
				}
			});
		}
		return LastButton;
	}
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	 
	private JButton getHomeButton() {
		if (HomeButton == null) {
			HomeButton = new JButton("\u0E2B\u0E19\u0E49\u0E32\u0E2B\u0E25\u0E31\u0E01");
			HomeButton.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
			HomeButton.setBounds(330, 768, 100, 40);
			HomeButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Dashboard window = new Dashboard();
					window.DashboardScreen();
					
					db.Close();
					frame.setVisible(false);
				}
			});
		}
		return HomeButton;
	} 
	 
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
	private JLabel getNameLabel() {
		if (NameLabel == null) {
			NameLabel = new JLabel("\u0E0A\u0E37\u0E48\u0E2D");
			NameLabel.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
			NameLabel.setBounds(118, 106, 18, 26);
		}
		return NameLabel;
	}
	
	private JLabel getEfficiencyLabel() {
		if (EfficiencyLabel == null) {
			EfficiencyLabel = new JLabel("\u0E1B\u0E23\u0E30\u0E2A\u0E34\u0E17\u0E18\u0E34\u0E20\u0E32\u0E1E");
			EfficiencyLabel.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
			EfficiencyLabel.setBounds(353, 106, 90, 26);
		}
		return EfficiencyLabel;
	}
	
	private JLabel getConditionLabel() {
		if (ConditionLabel == null) {
			ConditionLabel = new JLabel("\u0E40\u0E07\u0E37\u0E48\u0E2D\u0E19\u0E44\u0E02");
			ConditionLabel.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
			ConditionLabel.setBounds(89, 157, 47, 26);
		}
		return ConditionLabel;
	}
	
	private JLabel getRangeLabel() {
		if (RangeLabel == null) {
			RangeLabel = new JLabel("\u0E0A\u0E48\u0E27\u0E07\u0E2D\u0E32\u0E22\u0E38:");
			RangeLabel.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
			RangeLabel.setBounds(146, 156, 78, 26);
		}
		return RangeLabel;
	}
	
	private JLabel getPercentLabel() {
		if (PercentLabel == null) {
			PercentLabel = new JLabel("%");
			PercentLabel.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
			PercentLabel.setBounds(593, 107, 18, 26);
		}
		return PercentLabel;
	}
	
	private JLabel getDetailLabel() {
		if (DetailLabel == null) {
			DetailLabel = new JLabel("\u0E23\u0E32\u0E22\u0E25\u0E30\u0E40\u0E2D\u0E35\u0E22\u0E14");
			DetailLabel.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
			DetailLabel.setBounds(58, 209, 78, 26);
		}
		return DetailLabel;
	}
	
	private JLabel getSideEffectsLabel() {
		if (SideEffectsLabel == null) {
			SideEffectsLabel = new JLabel("\u0E1C\u0E25\u0E02\u0E49\u0E32\u0E07\u0E40\u0E04\u0E35\u0E22\u0E07");
			SideEffectsLabel.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
			SideEffectsLabel.setBounds(58, 345, 78, 26);
		}
		return SideEffectsLabel;
	}
	
	private JLabel getDisease1Label() {
		if (Disease1Label == null) {
			Disease1Label = new JLabel("\u0E42\u0E23\u0E04\u0E1B\u0E23\u0E30\u0E08\u0E33\u0E15\u0E31\u0E27 1");
			Disease1Label.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
			Disease1Label.setBounds(36, 480, 100, 26);
		}
		return Disease1Label;
	}
	
	private JLabel getDisease2Label() {
		if (Disease2Label == null) {
			Disease2Label = new JLabel("\u0E42\u0E23\u0E04\u0E1B\u0E23\u0E30\u0E08\u0E33\u0E15\u0E31\u0E27 2");
			Disease2Label.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
			Disease2Label.setBounds(36, 616, 100, 26);
		}
		return Disease2Label;
	}
}
