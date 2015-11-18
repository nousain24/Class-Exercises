

import java.util.Collections;

import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
/**
 * This program sets up the GUI for creating an user account. 
 * @author Mason
 * @version 1.0
 * 11/4/15
 */
public class UserFX extends Application {

	private static final int SIZE = 10;
	private static User [] users = new User[SIZE];
	private static int index = 0;
	/**
	 * 
	 * @param args Main method
	 */
	public static void main(String[] args) {
		launch(args);
		int i =0;
		while(i<SIZE){
			System.out.println(users[i]);
			i++;
		}

	}

	@Override
	public void start(Stage primaryStage) {
		/**
		 * Creates labels for GUI
		 */
		primaryStage.setTitle("Sign Up Page");
		//labels
		Label firstNameLbl = new Label("First Name");
		Label lastNameLbl = new Label("Last Name");
		Label emailLbl = new Label("Email");
		Label userNameLbl = new Label("Username");
		Label passwordLbl = new Label("Password");
		Label confirmPasswordLbl = new Label("Confirm Password");
		Label accountTypeLbl = new Label("Account Type");
		Label errorLbl = new Label("error");
		errorLbl.setTextFill(Color.web("#FF0000"));
		errorLbl.setVisible(false);
		
		TextField fNameTxtFld = new TextField();
		TextField lNameTxtFld = new TextField();
		TextField emailTxtFld = new TextField();
		TextField usernameTxtFld = new TextField();
		PasswordField passwordTxtFld = new PasswordField();
		PasswordField cPasswordTxtFld = new PasswordField();
		ComboBox<String> AccountCombo = new ComboBox<String>();
		AccountCombo.getItems().addAll("Adminitstrator", "Staff", "Student", "Faculty", "Guest");
		
		
		
		Button signUpBtn = new Button("Sign Up");
		signUpBtn.setOnAction(new EventHandler<ActionEvent>() {
			String inputFname = "";
			String inputLname = "";
			String inputEmail = "";
			String inputUname = "";
			String inputPword = "";
			String inputCPword = "";
			String inputAccountType;
			boolean fNameStatus = false;
			boolean lNameStatus = false;
			boolean emailStatus = false;
			boolean usernameStatus = false;
			boolean passwordStatus = false;
			boolean cPasswordStatus = false;
			String emailPattern = "\\w+@\\w+\\.\\w+";
			String passwordPattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()_+=-/?<>])(?=\\S+$).{8,64}";
			
			
			@Override
			
			public void handle(ActionEvent arg0) {
				
				String errorText = "";
				
				//validates text fields
				fNameStatus = validate(fNameTxtFld);
				lNameStatus = validate(lNameTxtFld);
				emailStatus = validate(emailTxtFld);
				usernameStatus = validate(usernameTxtFld);
				passwordStatus = validate(passwordTxtFld);
				cPasswordStatus = validate(cPasswordTxtFld);
				
				if(!fNameStatus ){
					errorText+=Configuration.FIRSTNAME_ERROR + "\n";
				}
				if(!lNameStatus) {
					errorText+=Configuration.LASTNAME_ERROR + "\n";		
				}
				
				if(!emailStatus) {
					errorText+=Configuration.EMAIL_ERROR + "\n";
				}
				
				if(!usernameStatus) {
					errorText+=Configuration.USERNAME_ERROR + "\n";
				}
				
				if(!passwordStatus) {
					errorText+=Configuration.PASSWORD_ERROR + "\n";
				}
				
				if(!cPasswordStatus) {
					errorText+=Configuration.CPASSWORD_ERROR + "\n";
				}
				
				
				if(fNameStatus && lNameStatus && emailStatus && usernameStatus && passwordStatus && cPasswordStatus ) {
				
				inputFname = fNameTxtFld.getText();
				inputLname = lNameTxtFld.getText();
				inputEmail = emailTxtFld.getText();
				inputUname = usernameTxtFld.getText();
				inputPword = passwordTxtFld.getText();
				inputCPword = cPasswordTxtFld.getText();
				inputAccountType = AccountCombo.getValue();
				// Changes username to lowercase
				String uNameLC = inputUname.toLowerCase();
					
					//Checks email pattern
					if(inputEmail.matches(emailPattern)){
					
						//Checks to make sure password and comfirm password are equal
						if(inputPword.equals(inputCPword)){
						
							//Checks password length
							if(inputPword.length()>=8){
								
								//Checks password pattern
								if(inputPword.matches(passwordPattern)){
								
									//Creates new user
									users[index] = new User(inputFname, inputLname, inputEmail, inputUname, inputPword, inputCPword, inputAccountType);
										
									//Displays account information
									JOptionPane.showMessageDialog(null,"You have successfully created an account!" + "\nWelcome " + inputFname + "\n" + "Here is your account information " + 
									"\nUsername: " + uNameLC + "\nEmail: " + inputEmail + "\nAccount Type: " + inputAccountType);
									
									index++;
									
									
									
								}else{
									//password pattern error message
									errorText+=Configuration.PW_PATTERN_ERROR + "\n";
									errorLbl.setText(errorText);
									errorLbl.setVisible(true);
								}
							}else{
								//password length error message
								errorText+=Configuration.PW_LENGTH_ERROR + "\n";
								errorLbl.setText(errorText);
								errorLbl.setVisible(true);
							}
						}else{
							//password match error message
							errorText+=Configuration.PW_MATCH_ERROR + "\n";
							errorLbl.setText(errorText);
							errorLbl.setVisible(true);
							}
				
					}else{
						//email pattern error message
						errorText+=Configuration.EMAIL_PATTERN_ERROR + "\n";
						errorLbl.setText(errorText);
						errorLbl.setVisible(true);
						}
				}else{
					//blank text fields error message
					errorLbl.setText(errorText);
					errorLbl.setVisible(true);
				}
			}

		});
		
		/**
		 * Puts labels, text fields, and password fields on GUI
		 */
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setVgap(10);
		grid.setHgap(10);
		grid.add(firstNameLbl, 0, 0);
		grid.add(lastNameLbl, 0, 1);
		grid.add(emailLbl, 0, 2);
		grid.add(userNameLbl, 0, 3);
		grid.add(passwordLbl, 0, 4);
		grid.add(confirmPasswordLbl, 0, 5);
		grid.add(accountTypeLbl, 0, 6);
		grid.add(errorLbl, 1, 9);
		
		grid.add(fNameTxtFld, 1, 0);
		grid.add(lNameTxtFld, 1, 1);
		grid.add(emailTxtFld, 1, 2);
		grid.add(usernameTxtFld, 1, 3);
		grid.add(passwordTxtFld, 1, 4);
		grid.add(cPasswordTxtFld, 1, 5);
		grid.add(AccountCombo, 1, 6);
		grid.add(signUpBtn, 1, 7);

		Scene scene = new Scene(grid, 500, 500);
		scene.getStylesheets().add("JavaFX.css");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	//validates text fields
	private boolean validate(TextField tf) {
      /**
       * 
       */
		boolean pass = false;
		ObservableList<String> styleClass = tf.getStyleClass();
        if (tf.getText().trim().length()==0) {
            if (! styleClass.contains("error")) {
                styleClass.add("error");
           
            }
        } else {
            // remove all occurrences:
            styleClass.removeAll(Collections.singleton("error"));
            pass = true;
        }
        return pass;
    }
	
	//validates password fields
	private boolean validate(PasswordField tf) {
        boolean pass = false;
		ObservableList<String> styleClass = tf.getStyleClass();
        if (tf.getText().trim().length()==0) {
            if (! styleClass.contains("error")) {
                styleClass.add("error");
           
            }
        } else {
            // remove all occurrences:
            styleClass.removeAll(Collections.singleton("error"));
            pass = true;
        }
        return pass;
    }

}


