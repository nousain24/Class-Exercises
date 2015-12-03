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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
/**
 * This program can set the day of the week, return the day, return the next day,
 * return the previous day, and calculate and return the day by adding certain days to the current day
 * @author Mason
 * @version 1.0
 * December 1, 2015
 */
public class DaysOfTheWeek extends Application{

	public static void main(String[] args) {
		launch(args);
	
		}
	@Override
	public void start(Stage primaryStage) {
		/**
		 * Creates labels for GUI
		 */
		primaryStage.setTitle("Days of The Week");
		//labels
		Label dayLbl = new Label("Select Day");
		Label calcDayLbl = new Label("Add Days");

		
		
		Label errorLbl = new Label("error");
		errorLbl.setTextFill(Color.web("#FF0000"));
		errorLbl.setVisible(false);
		
		//text fields
		ComboBox<String> DayCombo = new ComboBox<String>();
		DayCombo.getItems().addAll("Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday");
		
		TextField calcDayTxtFld = new TextField();
		
		
		
		
		
		Button calcBtn = new Button("Calculate");
		calcBtn.setOnAction(new EventHandler<ActionEvent>() {
			//variables
			String inputDay = "";
			String inputCalcDay = "";
		
//			boolean statusDay = false;
			boolean statusCalcDay = false;

			
			
			@Override
			
			public void handle(ActionEvent arg0) {
				/**
				 * Actions after you click the calculate button
				 */
				String errorText = "";
				// Validates calcDay textfield
				statusCalcDay = validate(calcDayTxtFld);
				
				
				if(!statusCalcDay ){
					errorText+=Configuration.CALCDAY_ERROR + "\n";
				}
				
				if( statusCalcDay) {
				
				//Gets value from combobox
				String inputDay = DayCombo.getValue();	
				
				inputCalcDay = calcDayTxtFld.getText();
				//changes from string to int
				int calcDay1 = Integer.parseInt(inputCalcDay);
				
				Day day = new Day(inputDay);
				//output
				JOptionPane.showMessageDialog(null, day + "\nThe next day is " + day.nextDay()+ "\nThe previous day is " + day.previousDay() + "\nThe calculated day is " + day.calculateDay(calcDay1));
				

				
				}else{
					//blank textfield error 
					errorLbl.setText(errorText);
					errorLbl.setVisible(true);
				}
			}
		});
		
		
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setVgap(10);
		grid.setHgap(10);
		grid.add(dayLbl, 0, 0);
		grid.add(calcDayLbl,0,1);
		grid.add(errorLbl, 1, 3);
		
		grid.add(DayCombo, 1, 0);
		grid.add(calcDayTxtFld, 1, 1);
		grid.add(calcBtn, 1, 2);

		Scene scene = new Scene(grid, 300, 300);
		scene.getStylesheets().add("Day.css");
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

}
