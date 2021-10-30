package B6205232_B6231743_B6237066;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProcessData {
	private String name, status, vaccineSet;
	private int age;
	private String[] data1, data2;
	private double temperature;
	
	private Database db;
	private String sql = "";
	private ResultSet rsRead;
	
	public ProcessData(String name, int age, String[] data1, String[] data2, double temperature) {
		this.name = name;
		this.age = age;
		this.data1 = data1;
		this.data2 = data2;
		this.temperature = temperature;
	}
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public String getName() {
		return name;
	}
	
	public String getDate() {
		String date = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss a").format(new Date());
		
		return date;
	}
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public void calStatus() {
		int sum = 0;
		
		if (data1[0].equals("Yes")) {
			status = "����դ�������§";
		}else {
			if (temperature < 37.5) {
				status = "����դ�������§";
			}
			if (temperature >= 37.5) {
				status = "�Ҩ�դ�������§";
				
				for (int i = 0; i < data2.length; i++) {
					if (data2[i].equals("Yes")) sum += 1;
					
					if (data2[4].equals("Yes") || data2[5].equals("Yes") || data2[6].equals("Yes")) status = "�դ�������§�٧";
				}
				
				if (sum == 10) {
					status = "�դ�������§�٧";
				}				
			}		
		}
	}
	
	public String getStatus() {
		return status;
	}
	
	public void calVaccine() {	
		vaccineSet = "";
		
		if (age > 16) {
			if (data1[1].equals("Yes")) {
				if (vaccineSet.indexOf("Pizer") == -1) vaccineSet += "Pizer";
			}
			else if (data1[1].equals("No")) {
				if (vaccineSet.indexOf("AstraZeneca") == -1) vaccineSet += "AstraZeneca";
			}
				
			if (data1[2].equals("Yes")) {
				if (vaccineSet.indexOf("Pizer") == -1) vaccineSet += "Pizer";
			}
			else if (data1[2].equals("No")) {
				if (vaccineSet.indexOf("Pizer") == -1) vaccineSet += "Pizer";
			}
			
			if (data1[3].equals("Yes")) {
				if (vaccineSet.indexOf("Pizer") == -1) vaccineSet += "Pizer";
			}
			else if (data1[3].equals("No")) {
				if (vaccineSet.indexOf("Pizer") == -1) vaccineSet += "Pizer";
			}
			
			if (data1[4].equals("Yes")) {
				if (vaccineSet.indexOf("AstraZeneca") == -1) vaccineSet += "AstraZeneca";
			}
			else if (data1[4].equals("No")) {
				if (vaccineSet.indexOf("Pizer") == -1) vaccineSet += "Pizer";
			}
			
			if (data1[5].equals("Yes")) {
				if (vaccineSet.indexOf("AstraZeneca") == -1) vaccineSet += "AstraZeneca";
			}
			else if (data1[5].equals("No")) {
				if (vaccineSet.indexOf("Pizer") == -1) vaccineSet += "Pizer";
			}
			
			if (age < 60) {
				if (data1[1].equals("Yes")) {
					if (vaccineSet.indexOf("Sinopharm") == -1) vaccineSet += "Sinopharm";
				}
				else if (data1[1].equals("No")) {
					if (vaccineSet.indexOf("Sinovac") == -1) vaccineSet += "Sinovac";
				}
					
				if (data1[2].equals("Yes")) {
					if (vaccineSet.indexOf("Moderna") == -1) vaccineSet += "Moderna";
				}
				else if (data1[2].equals("No")) {
					if (vaccineSet.indexOf("Sinopharm") == -1) vaccineSet += "Sinopharm";
				}
				
				if (data1[3].equals("Yes")) {
					if (vaccineSet.indexOf("Pizer") == -1) vaccineSet += "Pizer";
				}
				else if (data1[3].equals("No")) {
					if (vaccineSet.indexOf("Moderna") == -1) vaccineSet += "Moderna";
				}
				
				if (data1[4].equals("Yes")) {
					if (vaccineSet.indexOf("AstraZeneca") == -1) vaccineSet += "AstraZeneca";
				}
				else if (data1[4].equals("No")) {
					if (vaccineSet.indexOf("Pizer") == -1) vaccineSet += "Pizer";
				}
				
				if (data1[5].equals("Yes")) {
					if (vaccineSet.indexOf("AstraZeneca") == -1) vaccineSet += "AstraZeneca";
				}
				else if (data1[5].equals("No")) {
					if (vaccineSet.indexOf("Pizer") == -1) vaccineSet += "Pizer";
				}
			}
		}
	}
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public String getGuideline() {
		String guideline = "";
		
		db = new Database();
		
		if(db.Connect()) {
			try {
				sql = "SELECT * FROM guideline WHERE guide_color='" + status + "'";
				rsRead = db.ExecuteQuery(sql);
				
				if (rsRead != null) {
					if (rsRead.getString("guide_detail").length() > 0) guideline = String.format("- %s", rsRead.getString("guide_detail"));
					if ((rsRead.getString("guide_detail").length() > 0) && (rsRead.getString("guide_risk").length() > 0)) guideline += "\n\n";
					if (rsRead.getString("guide_risk").length() > 0) guideline += String.format("- %s", rsRead.getString("guide_risk"));
				}
			}catch(Exception ex) {
				System.out.println(ex);
			}
		}
		
		return guideline;
	}
	
	public String getVaccine() {
		String vaccine = "";
		
		db = new Database();
		
		if(db.Connect()) {
			if (vaccineSet != "") {
				if (vaccineSet.indexOf("Sinovac") >= 0) {
					try {
						sql = "SELECT * FROM vaccine WHERE vac_name='Sinovac'";
						rsRead = db.ExecuteQuery(sql);
						
						if (rsRead != null) {
							if (vaccine != "") vaccine += "\n";
							vaccine += String.format("�����Ѥ�չ: %s\n", rsRead.getString("vac_name"));
							vaccine += String.format("����Է���Ҿ: %s �����繵�\n", rsRead.getString("efficiency"));
							vaccine += String.format("��������´: %s\n", rsRead.getString("vac_detail"));
							vaccine += String.format("�Ţ�ҧ��§: %s\n", rsRead.getString("side_effects"));
							vaccine += "\n================================================================\n";
						}
					}catch(Exception ex) {
						System.out.println(ex);
					}	
				}
				
				if (vaccineSet.indexOf("Sinopharm") >= 0) {
					try {
						sql = "SELECT * FROM vaccine WHERE vac_name='Sinopharm'";
						rsRead = db.ExecuteQuery(sql);
						
						if (rsRead != null) {
							if (vaccine != "") vaccine += "\n";
							vaccine += String.format("�����Ѥ�չ: %s\n", rsRead.getString("vac_name"));
							vaccine += String.format("����Է���Ҿ: %s �����繵�\n", rsRead.getString("efficiency"));
							vaccine += String.format("��������´: %s\n", rsRead.getString("vac_detail"));
							vaccine += String.format("�Ţ�ҧ��§: %s\n", rsRead.getString("side_effects"));
							vaccine += "\n================================================================\n";
						}
					}catch(Exception ex) {
						System.out.println(ex);
					}					
				}
				
				if (vaccineSet.indexOf("Moderna") >= 0) {
					try {
						sql = "SELECT * FROM vaccine WHERE vac_name='Moderna'";
						rsRead = db.ExecuteQuery(sql);
						
						if (rsRead != null) {
							if (vaccine != "") vaccine += "\n";
							vaccine += String.format("�����Ѥ�չ: %s\n", rsRead.getString("vac_name"));
							vaccine += String.format("����Է���Ҿ: %s �����繵�\n", rsRead.getString("efficiency"));
							vaccine += String.format("��������´: %s\n", rsRead.getString("vac_detail"));
							vaccine += String.format("�Ţ�ҧ��§: %s\n", rsRead.getString("side_effects"));
							vaccine += "\n================================================================\n";
						}
					}catch(Exception ex) {
						System.out.println(ex);
					}					
				}
				
				if (vaccineSet.indexOf("AstraZeneca") >= 0) {
					try {
						sql = "SELECT * FROM vaccine WHERE vac_name='AstraZeneca'";
						rsRead = db.ExecuteQuery(sql);
						
						if (rsRead != null) {
							if (vaccine != "") vaccine += "\n";
							vaccine += String.format("�����Ѥ�չ: %s\n", rsRead.getString("vac_name"));
							vaccine += String.format("����Է���Ҿ: %s �����繵�\n", rsRead.getString("efficiency"));
							vaccine += String.format("��������´: %s\n", rsRead.getString("vac_detail"));
							vaccine += String.format("�Ţ�ҧ��§: %s\n", rsRead.getString("side_effects"));
							vaccine += "\n================================================================\n";
						}
					}catch(Exception ex) {
						System.out.println(ex);
					}					
				}
				
				if (vaccineSet.indexOf("Pizer") >= 0) {
					try {
						sql = "SELECT * FROM vaccine WHERE vac_name='Pizer'";
						rsRead = db.ExecuteQuery(sql);
						
						if (rsRead != null) {
							if (vaccine != "") vaccine += "\n";
							vaccine += String.format("�����Ѥ�չ: %s\n", rsRead.getString("vac_name"));
							vaccine += String.format("����Է���Ҿ: %s �����繵�\n", rsRead.getString("efficiency"));
							vaccine += String.format("��������´: %s\n", rsRead.getString("vac_detail"));
							vaccine += String.format("�Ţ�ҧ��§: %s\n", rsRead.getString("side_effects"));
							vaccine += "\n================================================================\n";
						}
					}catch(Exception ex) {
						System.out.println(ex);
					}
				}				
			}
		}

		return vaccine;
	}
}
