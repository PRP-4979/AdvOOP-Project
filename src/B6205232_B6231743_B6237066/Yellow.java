package B6205232_B6231743_B6237066;

public class Yellow extends Guideline {	
	public void setGuideline() {
		db = new Database();

		if(db.Connect()) {
			try {
				sql = "SELECT * FROM guideline WHERE guide_color='อาจมีความเสี่ยง'";
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
	}
}
