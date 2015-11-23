import java.util.Scanner;


public class CarDriver {

	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		
		Car Car1 = new Car(" White", 2500, 50);
		Car1.setNewHorsepower();
		
		Car Car2 = new Car("Blue", 5000, 35);
		Car2.setNewHorsepower();
		
		Car Car3 = new Car("Yellow", 7500, 75);
		Car3.setNewHorsepower();
		
		System.out.println(Car1);
		System.out.println("\n" + Car2);
		System.out.println("\n" + Car3);
	}

}
