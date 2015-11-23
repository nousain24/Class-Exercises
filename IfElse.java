import javax.swing.JOptionPane;

/**
 *This Program Calculates team and group size.  
 * @author Mason Nousain
 *@version 1.0
 */
public class IfElse {
	/**
	 * Main Method
	 * @param args default parameters for main 
	 */
	public static void main(String[] args) {
		String people = JOptionPane.showInputDialog(" Enter number of people.");
		String players = JOptionPane.showInputDialog(" Enter number of players.");
		int numpeople = Integer.parseInt(people);
		int numplayers = Integer.parseInt(players);
		int groupSize = 0, team = 0;
		
		
		if(numpeople>10){
			groupSize= numpeople/2;
		}else if(numpeople>=3 && numpeople<=10){
			groupSize = numpeople/3;
		}else {
			JOptionPane.showMessageDialog(null, "The number of people has to be at least 3.");
		}
		
		if(numplayers>=11 && numplayers<=55){
			team = numplayers/11;
		}else {
			team = 1;
		}
		JOptionPane.showMessageDialog(null, "The Number of people is " + numpeople + "." + " The group size is " + groupSize);
		JOptionPane.showMessageDialog(null, "The number of players is " + numplayers + "." + " The team size is " + team);
		}
	}


