import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class GUIDemoTwo extends JFrame {


	private JPanel contentPane;
	static JTextField[] fields =new JTextField[4];
	static JLabel numOneLbl = new JLabel("Label 1.");
	static JLabel numTwoLbl = new JLabel("Label 2.");
	static JButton submitBtn = new JButton("Button");



	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIDemoTwo frame = new GUIDemoTwo();
					frame.setVisible(true);
					submitBtn.addActionListener(new ActionListener(){

						public void actionPerformed(ActionEvent evt){
						
						}
						});
					}catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}


			public GUIDemoTwo() {
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				setBounds(100, 100, 450, 300);
				numOneLbl.setBounds(20, 20, 100, 20);
				numTwoLbl.setBounds(20, 70, 100, 20);
				
				for(int i = 0; i<4; i++){
					fields[i] = new JTextField();
				}
				
				fields[0].setColumns(10);
				fields[1].setColumns(10);
				fields[2].setColumns(10);
				fields[3].setColumns(10);
				submitBtn.setBounds(150, 170, 100, 20);
				contentPane = new JPanel();
				contentPane.add(numOneLbl);
				contentPane.add(numTwoLbl);
				contentPane.add(fields[0]);
				contentPane.add(fields[1]);
				contentPane.add(fields[2]);
				contentPane.add(fields[3]);
				contentPane.add(submitBtn);
				contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
				contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5 ));
				setContentPane(contentPane);





			}

		}