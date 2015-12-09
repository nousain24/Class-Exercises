import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
import javax.swing.JLabel;

public class SortArray extends JFrame {
	// values of array
	int num[] = { 5, 1, 13, 7, 21, 3, 12, 10, 4, 0};
	int min ;{
	for (int i = 0; i < num.length; i++) {
		min = num[i];
	for (int j = i; j < num.length; j++) {
		if (min > num[j]) {
				swap(i, j, num);
				min = num[i];
			}
		}}
	}
	
	public SortArray() {
		JFrame frame = new JFrame("Sort Array");
		frame.setLayout(new FlowLayout());
		JLabel a1 = new JLabel(String.valueOf(num[0]));
		JLabel a2 = new JLabel(String.valueOf(num[1]));
		JLabel a3 = new JLabel(String.valueOf(num[2]));
		JLabel a4 = new JLabel(String.valueOf(num[3]));
		JLabel a5 = new JLabel(String.valueOf(num[4]));
		JLabel a6 = new JLabel(String.valueOf(num[5]));
		JLabel a7 = new JLabel(String.valueOf(num[6]));
		JLabel a8 = new JLabel(String.valueOf(num[7]));
		JLabel a9 = new JLabel(String.valueOf(num[8]));
		JLabel a10 = new JLabel(String.valueOf(num[9]));
		
		frame.setVisible(true);
		frame.setBounds(200, 100, 300, 300);
	
		frame.getContentPane().add(a1);
		frame.getContentPane().add(a2);
		frame.getContentPane().add(a3);
		frame.getContentPane().add(a4);
		frame.getContentPane().add(a5);
		frame.getContentPane().add(a6);
		frame.getContentPane().add(a7);
		frame.getContentPane().add(a8);
		frame.getContentPane().add(a9);
		frame.getContentPane().add(a10);
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static int[] swap(int i, int j, int[] array) {
		int x;
		x = array[i];
		array[i] = array[j];
		array[j] = x;
		return (array);
	}

	public static void main(String[] args) {
		new SortArray();
	}
}