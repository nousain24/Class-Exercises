import javax.swing.JOptionPane;
/**
 * This program authenticates a username and password and validates user account type. 
 * @author Mason Nousain
 * @version 1.0
 */
public class UserLogin {

	public enum Type {Administrator, Student, Staff }
	/**
	 * This is the main method.
	 * @param args default parameters
	 */
	public static void main(String[] args) {
		 String CUser, CPassW, UserInput, PasswordInput;
		//variables
		 CUser = "nousain";
		// Correct Username 
		 CPassW = "nousain";
		//Correct Password
		int trial = 1, limit = 3;
		
		Type[] choices = {Type.Administrator, Type.Student, Type.Staff};
		
		Type select = (Type) JOptionPane.showInputDialog(null, "Select account type.", "Account Type", JOptionPane.INFORMATION_MESSAGE, null, choices, choices[0]);
		
		do{
		
			UserInput = JOptionPane.showInputDialog(null, "Enter Username");
			//Prompt for username
		if(UserInput.equals(CUser)){
			//if username is correct 
			do{
				PasswordInput = JOptionPane.showInputDialog(null, "Enter Password");
				// prompt for password
				if(PasswordInput.equals(CPassW)){
					// if password is correct
					Type selectA = (Type) JOptionPane.showInputDialog(null, "Select account type.", "Account Type", JOptionPane.INFORMATION_MESSAGE, null, choices, choices[0]);
					//select account type
				
				
				while (!selectA.equals(select))//loop
				{selectA = (Type) JOptionPane.showInputDialog(null, "Select account type.", "Account Type", JOptionPane.INFORMATION_MESSAGE, null, choices, choices[0]);
	}			// account types
				
					switch (select){
					case Administrator:
					JOptionPane.showMessageDialog(null, "Welcome Admin! You can update and read file.");
					return;
					
					case Student:
					JOptionPane.showMessageDialog(null, "Welcome Student! You can only read file.");
					return;
					
					case Staff:
					JOptionPane.showMessageDialog(null, "Welcome Staff! You can update, read, add, delete file.");
					return;
					
					}
				}
				
				else{trial = trial + 1;}
			}
				while(trial<=limit);
				JOptionPane.showMessageDialog(null, "Your account has been locked, please contact Administrator.");
				//trial exceeds 3 then account is locked
				return;
			
			}else{trial = trial + 1;
			JOptionPane.showMessageDialog(null, "Invalid username");
			//if username is incorrect
			}
		}while(trial<=3);
			JOptionPane.showMessageDialog(null, "Your account has been locked, please contact Administrator.");
			// trial exceeds 3 then account is locked
		}
	}