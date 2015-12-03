import javax.swing.JOptionPane;

public class DayDriver {

	public static void main(String[] args) {
//		 TODO Auto-generated method stub
		Day day = new Day("Friday");
		System.out.println(day);
		System.out.println(day.nextDay());
		System.out.println(day.previousDay());
		System.out.println(day.calculateDay(23));
	
	}

}
