package B6205232_B6231743_B6237066;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;

public class Dashboard {

	private JFrame frame;
	private JLabel HeadLabel;
	private JTabbedPane Container;
	private JPanel VaccinePage, GuidelinePage;
	private JButton VaccineButton, GuidelineButton, LogoutButton;
	private JScrollPane VaccineScroll, GuidelineScroll;
	private JTable VaccineTable, GuidelineTable;
	private ResultSet rsRead;
	private Vector data, row, column;

	/**
	 * Launch the application.
	 */
	public static void DashboardScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard window = new Dashboard();
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
	public Dashboard() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u0E41\u0E14\u0E0A\u0E1A\u0E2D\u0E23\u0E4C\u0E14");
		frame.setBounds(100, 100, 740, 540);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Container = new JTabbedPane(JTabbedPane.TOP);
		Container.setBounds(189, 75, 500, 400);
		frame.getContentPane().add(Container);
		
		VaccinePage = new JPanel();
		Container.addTab("Vaccine", null, getVaccinePage(), null);
		
		Container.addTab("Guideline", null, getGuidelinePage(), null);
		GuidelinePage.setLayout(null);
		

		
		VaccineButton = new JButton("\u0E02\u0E49\u0E2D\u0E21\u0E39\u0E25\u0E27\u0E31\u0E04\u0E0B\u0E35\u0E19");
		VaccineButton.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
		VaccineButton.setBounds(30, 100, 130, 40);
		VaccineButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminVaccine window = new AdminVaccine();
				window.VaccineScreen();
				
				frame.setVisible(false);
			}
		});
		frame.getContentPane().add(VaccineButton);
		
		GuidelineButton = new JButton("\u0E02\u0E49\u0E2D\u0E21\u0E39\u0E25\u0E44\u0E01\u0E14\u0E4C\u0E44\u0E25\u0E19\u0E4C");
		GuidelineButton.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
		GuidelineButton.setBounds(30, 163, 130, 40);
		GuidelineButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminGuideline window = new AdminGuideline();
				window.GuidelineScreen();
				
				frame.setVisible(false);
			}
		});
		frame.getContentPane().add(GuidelineButton);
		
		LogoutButton = new JButton("\u0E2D\u0E2D\u0E01\u0E08\u0E32\u0E01\u0E23\u0E30\u0E1A\u0E1A");
		LogoutButton.setFont(new Font("CordiaUPC", Font.PLAIN, 24));
		LogoutButton.setBounds(30, 435, 130, 40);
		LogoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Command window = new Command();
				window.VisibleScreen();
				
				frame.setVisible(false);
			}
		});
		frame.getContentPane().add(LogoutButton);
		
		HeadLabel = new JLabel("\u0E41\u0E14\u0E0A\u0E1A\u0E2D\u0E23\u0E4C\u0E14");
		HeadLabel.setFont(new Font("CordiaUPC", Font.BOLD, 36));
		HeadLabel.setBounds(29, 21, 220, 40);
		frame.getContentPane().add(HeadLabel);
	}
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public JPanel getVaccinePage() {
		VaccineScroll = new JScrollPane();
		VaccineScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		VaccineScroll.setBounds(25, 35, 445, 262);
		
		try {
			Database db = new Database();
			String sql = "SELECT vac_name, efficiency, range_age, vac_detail FROM vaccine";
			if (db.Connect()) {
				rsRead = db.ExecuteQuery(sql);
				
				if (rsRead != null) {
					ResultSetMetaData rsmt = rsRead.getMetaData();
					int count = rsmt.getColumnCount();
					column = new Vector(count);
					
					for(int i = 1; i <= count; i++) {
						if (rsmt.getColumnName(i).equals("vac_name")) {
							column.add("Name");
						}else if (rsmt.getColumnName(i).equals("efficiency")) {
							column.add("Efficiency");
						}else if (rsmt.getColumnName(i).equals("range_age")) {
							column.add("Age");
						}else if (rsmt.getColumnName(i).equals("vac_detail")) {
							column.add("Detail");
						}else {
							column.add(rsmt.getColumnName(i));
						}
					}
					
					data = new Vector();
					row = new Vector();
					
					while(rsRead.next()) {
						row = new Vector(count);
						for(int i = 1; i <= count; i++) {
							String columnName = "";
							if (rsRead.getString(i).equals("1")) {
								row.add("มากกว่า 16 ปี ขึ้นไป");
							}else if (rsRead.getString(i).equals("2")) {
								row.add("ไม่เกิน 60 ปี");
							}else {
								row.add(rsRead.getString(i));
							}
						}
						data.add(row);
					}
					
					VaccineTable = new JTable(data, column);
					VaccineTable.setFont(new Font("CordiaUPC", Font.PLAIN, 20));
					VaccineTable.setRowHeight(30);
					VaccineScroll.setViewportView(VaccineTable);
				}
			}
		}catch(SQLException e) {
			System.out.println(e);
		}catch(Exception ex) {
			System.out.println(ex);
		}

		VaccinePage = new JPanel();
		VaccinePage.setLayout(null);
		VaccinePage.add(VaccineScroll);
		
		return VaccinePage;
	}
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public JPanel getGuidelinePage() {
		GuidelineScroll = new JScrollPane();
		GuidelineScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		GuidelineScroll.setBounds(25, 35, 445, 262);
		
		try {
			Database db = new Database();
			String sql = "SELECT guide_color, guide_detail, guide_risk FROM guideline";
			if (db.Connect()) {
				rsRead = db.ExecuteQuery(sql);
				
				if (rsRead != null) {
					ResultSetMetaData rsmt = rsRead.getMetaData();
					int count = rsmt.getColumnCount();
					column = new Vector(count);
					
					for(int i = 1; i <= count; i++) {
						if (rsmt.getColumnName(i).equals("guide_color")) {
							column.add("Type");
						}else if (rsmt.getColumnName(i).equals("guide_detail")) {
							column.add("Detail");
						}else if (rsmt.getColumnName(i).equals("guide_risk")) {
							column.add("Important");
						}else {
							column.add(rsmt.getColumnName(i));
						}
					}
					
					data = new Vector();
					row = new Vector();
					
					while(rsRead.next()) {
						row = new Vector(count);
						for(int i = 1; i <= count; i++) {
							String columnName = "";
							row.add(rsRead.getString(i));
						}
						data.add(row);
					}
					
					GuidelineTable = new JTable(data, column);
					GuidelineTable.setFont(new Font("CordiaUPC", Font.PLAIN, 20));
					GuidelineTable.setRowHeight(30);
					GuidelineScroll.setViewportView(GuidelineTable);
				}
			}
		}catch(SQLException e) {
			System.out.println(e);
		}catch(Exception ex) {
			System.out.println(ex);
		}

		GuidelinePage = new JPanel();
		GuidelinePage.add(GuidelineScroll);
		
		return GuidelinePage;
	}
}
