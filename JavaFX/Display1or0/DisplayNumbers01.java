package displays01;

/*
 * James Wolak
 * 4/1/2020
 * CSC-112
 * Java 2
 * HW5 Display Random 0 or 1
 * Using TextFields this program displays a series of randomized 0s and 1s
 */

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class DisplayNumbers01 extends Application {

//***********************************************************************************************

	@SuppressWarnings("exports")
	public void start(Stage primaryStage) {

		Scene scene = new Scene(new NumbersGridPane(), 300, 350);
		primaryStage.setTitle("Exercise14_07");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();

	}

//***********************************************************************************************

	public static void main(String[] args) {
		launch(args);

	}

//***********************************************************************************************

	class NumbersGridPane extends GridPane {

		private int screenWidth = 300;
		private int screenHeight = 350;
		private TextField textField;
		private int num;
		private String newNum;

//***********************************************************************************************

		public NumbersGridPane() {

			this.setBackgroundColor();
			this.setSpacing();
			this.setTextFields();
		}

//***********************************************************************************************

		private void setBackgroundColor() {

			this.setStyle("-fx-background-color: #2f4f4f");

		}

//***********************************************************************************************

		private void setSpacing() {

			this.setPadding(new Insets(8, 7, 7, 7));
			this.setHgap(2);
			this.setVgap(2);
		}

//***********************************************************************************************

		private void setTextFields() {

			for (int i = 0; i <= 9; i++) {

				for (int j = 0; j <= 9; j++) {
					num = (int) (Math.random() * 2);
					newNum = String.valueOf(num);
					textField = new TextField(newNum);
					textField.setAlignment(Pos.CENTER);
					textField.setPrefWidth(screenWidth / 10);
					textField.setPrefHeight(screenHeight / 10);
					this.add(textField, i, j);
				}
			}

		}
	}

}
