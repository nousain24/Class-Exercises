import javax.swing.JOptionPane;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class FXUserAuthenicationTwo extends Application {

	public enum AccountType {
		Administrator, Student, Staff
	}

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) {
		String[] cUsername = { "Mason", "Brad", "John" };
		String[] cPassword = { "Nousain", "123", "321" };
		AccountType[] cAcType = { AccountType.Student, AccountType.Staff, AccountType.Administrator };

		primaryStage.setTitle("Authentication");
		Label userNameLbl = new Label("Username");
		Label passwordLbl = new Label("Password");

		TextField usernameTxtFld = new TextField();
		PasswordField passwordTxtFld = new PasswordField();

		Button submitBtn = new Button("Submit");
		submitBtn.setOnAction(new EventHandler<ActionEvent>() {
			String inputUserName = "";
			String inputPassword = "";
			int i = 0;
			int trial = 0;
			int limit = 3;
			boolean found = false;
			@Override
			public void handle(ActionEvent arg0) {

				while(i<cUsername.length) {
					inputUserName = usernameTxtFld.getText();
					inputPassword = passwordTxtFld.getText();

					// scenario 1: username is existing in an array
					if (inputUserName.equals(cUsername[i])) {
						if (inputPassword.equals(cPassword[i])) {
							AccountType[] choices = { AccountType.Administrator, AccountType.Student,
									AccountType.Staff };

							AccountType input = (AccountType) JOptionPane.showInputDialog(null,
									"Select your account type.", "Account Type", JOptionPane.INFORMATION_MESSAGE, null,
									choices, choices[0]);

							while (input == cAcType[i]) {
								switch (input) {
								case Administrator:
									JOptionPane.showMessageDialog(null, "Welcome " + inputUserName);
									break;

								case Student:
									JOptionPane.showMessageDialog(null, "Welcome " + inputUserName);
									break;

								case Staff:
									JOptionPane.showMessageDialog(null, "Welcome " + inputUserName);
									break;
								}
								input = (AccountType) JOptionPane.showInputDialog(null, "Select your account type.",
										"Account Type", JOptionPane.INFORMATION_MESSAGE, null, choices, choices[0]);
								
								}
							}
							
						}
						
						else if (i<cPassword.length){
							i++;	
						}
					 else if (i<cUsername.length) {// scenario 2: increment index (i) to check each of the user name in an array
						i++;
					} 
				}
				
				if(found == false){
						trial++;
						JOptionPane.showMessageDialog(null, "Wrong Username or Password");
						
						while(trial>=limit){
							JOptionPane.showMessageDialog(null, "Please contact your adminstrator to unlock your account!");
							System.exit(0);
							
							
						}
				}

			}

		});

		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setVgap(10);
		grid.setHgap(10);
		grid.add(userNameLbl, 0, 0);
		grid.add(passwordLbl, 0, 1);

		grid.add(usernameTxtFld, 1, 0);
		grid.add(passwordTxtFld, 1, 1);
		grid.add(submitBtn, 1, 2);

		Scene scene = new Scene(grid, 500, 500);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}

