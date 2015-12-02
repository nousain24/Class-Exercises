
import javax.swing.JOptionPane;

public class InputDemo {

	public static void main(String[] args) {
	//integer
//	byte x = 100;
//	short y = 30000 ;
//	int z = 2000000000;
//	long u = 3000000000l;
//	//decimal
//	float v = 8.5f;
//	double w = 950.55;
//	
//	char letter = 'A';
//	
//	boolean status = false;
	String x = JOptionPane.showInputDialog("Enter byte");
	byte x1 = Byte.parseByte(x);
	
	String y = JOptionPane.showInputDialog("Enter short");
	short y1 = Short.parseShort(y);
	
	String z = JOptionPane.showInputDialog("Enter int");
	int z1 = Integer.parseInt(z);
	
	String u = JOptionPane.showInputDialog("Enter long");
	long u1 = Long.parseLong(u);
	
	String v = JOptionPane.showInputDialog("Enter float");
	float v1 = Float.parseFloat(v);
	
	String w = JOptionPane.showInputDialog("Enter double");
	double w1 = Double.parseDouble(w);
	
	String letter = JOptionPane.showInputDialog("Enter Character");
	
	String status = JOptionPane.showInputDialog("Enter true or false");
	boolean status1 =Boolean.parseBoolean(status);
	
	
	JOptionPane.showMessageDialog(null, "\n" + "Byte: " + x1 + "\n" + "Short: " + y1 + "\n" + "Int: " + z1 + "\n" + "Long: " + u1 + "\n" + "Float: " + v1 + "\n" + "Double: " + w1 + "\n" + "Character: " + letter  + "\n" + "Boolean: " + status1);
	

	}

}
