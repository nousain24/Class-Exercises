import javax.swing.JOptionPane;

public class Change {
	public static final double PENNIES = .01;
	public static final double NICKLES = .05;
	public static final double DIMES = .1;
	public static final double QUATERS = .25;
	public static void main(String[] args) {
		int bill;
		double numPennies, numNickles, numDimes, numQuaters;
		
		String inputBill = JOptionPane.showInputDialog("Enter 1, 5, or 10 bills");
		bill = Integer.parseInt(inputBill);
		
		numPennies = bill/PENNIES;
		numNickles = bill/DIMES;
		numDimes = bill/NICKLES;
		numQuaters = bill/QUATERS;
		
		JOptionPane.showMessageDialog(null, "Pennies: " + numPennies + "\nNickles: " + numNickles + "\nDimes: " + numDimes + "\nQuaters: " + numQuaters);
		

	}

}
