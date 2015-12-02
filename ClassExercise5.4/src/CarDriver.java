import java.util.Scanner;

import javax.swing.JOptionPane;


public class CarDriver {

	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		
		Car Car1 = new Car("Blue", 5000, 35);
		
		
		Car Car2 = new Car("Blue", 5000, 35);
		
		
		Car Car3 = new Car("Yellow", 7500, 75);
		
		
		System.out.println(Car1);
		System.out.println("\n" + Car2);
		System.out.println("\n" + Car3);
		
		System.out.println("Cars created: " + Car.getCount());
		
		
		JOptionPane.showMessageDialog(null, "Compare car 1 and car 2: " + Car1.equals(Car2));
//		System.out.println("Compare car 1 and car 2: " + Car1.equals(Car2));
//		System.out.println("Compare car 1 and car 3: " + Car1.equals(Car3) );
//		System.out.println("Compare car 2 and car 3: " + Car2.equals(Car3) );
		
		
	}

}
