package B6205232_B6231743_B6237066;

public class GuidelineFactory {
	public Guideline GuidelineCreator(String status) {
		if (status.equals("����դ�������§")) return new Green();
		else if (status.equals("�Ҩ�դ�������§")) return new Yellow();
		else if (status.equals("�դ�������§�٧")) return new Red();
		else return new Green();
	}
}
