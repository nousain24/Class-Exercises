import javax.swing.JOptionPane;

public class Height {

	public static void main(String[] args) {
	int iHeight, fHeight, rHeight;
	
	String Height = JOptionPane.showInputDialog("Enter your height in centimeters");
	double inputHeight = Double.parseDouble(Height);
	//converts string into double
	
	iHeight = (int) (inputHeight*0.3937008);
	//converts centimeters to inches
	
	fHeight = iHeight/12;
	//calculates feet
	
	rHeight = iHeight%12;
	//calculates remaining inches
	
	JOptionPane.showMessageDialog(null, "You are " + fHeight + "' " + rHeight + "\"");
	
	}

}
