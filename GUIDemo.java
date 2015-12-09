import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUIDemo implements ActionListener {

	private JFrame frame;
	
	private JPanel panel;
	
	private JLabel label;
	private JLabel output;
	
	private JTextField textfield1;
	private JTextField textfield2;
	
	private JButton button;
	
	public GUIDemo() {
		frame = new JFrame("Sum");
		frame.setVisible(true);
		frame.setSize(320, 320);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();	
		panel.setBackground(Color.RED);
		
		label = new JLabel();
		label.setText("Enter Number");
		label.setForeground(Color.WHITE);
		output = new JLabel();
		output.setText("");
		
		textfield1 = new JTextField(5);
		textfield2 = new JTextField(5);
		
		button = new JButton("Add");
		button.addActionListener(this);
		
		panel.add(label);
		panel.add(output);
		panel.add(textfield1);
		panel.add(textfield2);
		panel.add(button);

		frame.add(panel);
		
		
	}
	public void actionPerformed(ActionEvent e) {
		//System.out.println(textfield1.getText()+textfield2.getText());
		int num1 = Integer.parseInt(textfield1.getText());
		int num2 = Integer.parseInt(textfield2.getText());
		int sum = num1+num2;
		output.setText(String.valueOf(sum));
	}
}
