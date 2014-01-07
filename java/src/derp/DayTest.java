package derp;

public class DayTest {
	static Day derp;
	
	public DayTest(Day derp) {
		this.derp = derp;
	}
	
	public static void main(String[] args) {
		DayTest merp = new DayTest(Day.MERP);
		switch (derp) {
		case HERP:
			System.out.println("HERP");			
			break;

		default:
			System.out.print("lol");
			break;
		}
	}
	
}
