package B6205232_B6231743_B6237066;

public class GuidelineFactory {
	public Guideline GuidelineCreator(String status) {
		if (status.equals("ไม่มีความเสี่ยง")) return new Green();
		else if (status.equals("อาจมีความเสี่ยง")) return new Yellow();
		else if (status.equals("มีความเสี่ยงสูง")) return new Red();
		else return new Green();
	}
}
