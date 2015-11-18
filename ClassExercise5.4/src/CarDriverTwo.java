import javax.swing.JOptionPane;

public class CarDriverTwo {

	public static void main(String[] args) {
		String color1, color2, color3;
		int hPower1,hPower2, hPower3;
		int eSize1, eSize2, eSize3;
		String inputHP1, inputHP2, inputHP3;
		String inputESz1, inputESz2, inputESz3;
		
		Car car1 = new Car();
		Car car2 = new Car();
		Car car3 = new Car();
		Car car4 = new Car("Red", 500, 500);
		
		//Car 1 
		color1 = JOptionPane.showInputDialog("Enter the color of car 1");
		car1.setColor(color1);
		
		inputHP1 = JOptionPane.showInputDialog("Enter the horsepower of car 1");
		hPower1 = Integer.parseInt(inputHP1);
		car1.setHorsepower(hPower1);
		
		inputESz1 = JOptionPane.showInputDialog("Enter the engine size of car 1");
		eSize1 = Integer.parseInt(inputESz1);
		car1.setEngineSize(eSize1);
		
		//Car 2
		color2 = JOptionPane.showInputDialog("Enter the color of car 2");
		car2.setColor(color2);
		
		inputHP2 = JOptionPane.showInputDialog("Enter the horsepower of car 2");
		hPower2 = Integer.parseInt(inputHP2);
		car2.setHorsepower(hPower2);
		
		inputESz2 = JOptionPane.showInputDialog("Enter the engine size of car 2");
		eSize2 = Integer.parseInt(inputESz2);
		car2.setEngineSize(eSize2);
		
		//Car 3
		color3 = JOptionPane.showInputDialog("Enter the color of car 3");
		car3.setColor(color3);
		
		inputHP3 = JOptionPane.showInputDialog("Enter the horsepower of car 3");
		hPower3 = Integer.parseInt(inputHP3);
		car3.setHorsepower(hPower3);
		
		inputESz3 = JOptionPane.showInputDialog("Enter the engine size of car 3");
		eSize3 = Integer.parseInt(inputESz3);
		car3.setEngineSize(eSize3);
		
		
		JOptionPane.showMessageDialog(null, "CAR 1\n" + car1);
		JOptionPane.showMessageDialog(null, "CAR 2\n" +  car2);
		JOptionPane.showMessageDialog(null, "CAR 3\n" +  car3);
		JOptionPane.showMessageDialog(null, "CAR 4\n" +  car4);
		
		//count
		JOptionPane.showMessageDialog(null, "Number of cars created: " +  Car.getCount());
		
		//Compares two cars
		JOptionPane.showMessageDialog(null, "Compare car 1 and car 4: " + car1.equals(car4));
	}

}
