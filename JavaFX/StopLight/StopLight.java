package StopLight;

/*
 * James Wolak
 * 4/6/2020
 * CSC-112
 * Java 2
 * HW6 Traffic Lights
 * This program Displays a Traffic Light with 3 buttons underneath.
 * Once pressed, the buttons with display the red, yellow, or green light.
 */

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class StopLight extends Application {
	private int setWidth = 300;
	private int setHeight = 350;

//***********************************************************************	

	@SuppressWarnings("exports")
	public void start(Stage primaryStage) {

		Scene scene = new Scene(new Setup(), setWidth, setHeight);
		primaryStage.setTitle("StopLight");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
	}

//***********************************************************************	

	public static void main(String[] args) {
		launch(args);

	}

//***********************************************************************	

	class Setup extends BorderPane {
		private Rectangle rect;
		private int rectWidth = 150;
		private int rectHeight = 300;
		private Circle light1, light2, light3;
		private Button btn1, btn2, btn3;
		private VBox vBox;

//***********************************************************************	

		public Setup() {

			this.setBackground();
			this.setCenter(new Center());
			this.setBottom(new Bottom());

		}

//***********************************************************************	

		private void setBackground() {
			this.setStyle("-fx-background-color: #f8f8ff;");

		}

//***********************************************************************	
		class Center extends StackPane {

			private Center() {

				rectangle();
				lights();

			}
		}

//***********************************************************************	

		public void rectangle() {

			rect = new Rectangle();
			rect.setWidth(rectWidth);
			rect.setHeight(rectHeight);
			rect.setX((setWidth - rectWidth) / 2);
			rect.setY(10);
			rect.setFill(Color.KHAKI);
			rect.setStroke(Color.BLACK);
			rect.setStrokeWidth(2);

			this.getChildren().add(rect);

		}

//***********************************************************************	

		public void lights() {

			vBox = new VBox();
			vBox.setSpacing(20);

			light1 = new Circle();
			light1.setRadius(35);
			light1.setFill(Color.INDIANRED);
			light1.setStroke(Color.BLACK);
			light1.setStrokeWidth(2);

			light2 = new Circle();
			light2.setRadius(35);
			light2.setFill(Color.BLACK);
			light2.setStroke(Color.BLACK);
			light2.setStrokeWidth(2);

			light3 = new Circle();
			light3.setRadius(35);
			light3.setFill(Color.BLACK);
			light3.setStroke(Color.BLACK);
			light3.setStrokeWidth(2);

			vBox.setPadding(new Insets(30, 0, 0, 112.5));
			vBox.getChildren().addAll(light1, light2, light3);

			this.getChildren().add(vBox);

		}

//***********************************************************************	

		class Bottom extends HBox {

			private Bottom() {

				buttons();

			}

//***********************************************************************	

			private void buttons() {

				btn1 = new Button("Red");
				btn1.setStyle(
						"-fx-background-radius: 5em; -fx-background-color: #cd5c5c; -fx-border-radius: 5em; -fx-border-color: #000000");
				btn1.setOnAction(e -> {
					light1.setFill(Color.INDIANRED);
					light2.setFill(Color.BLACK);
					light3.setFill(Color.BLACK);
				});

				btn2 = new Button("Yellow");
				btn2.setStyle(
						"-fx-background-radius: 5em; -fx-background-color: #ffd700; -fx-border-radius: 5em; -fx-border-color: #000000");
				btn2.setOnAction(e -> {
					light1.setFill(Color.BLACK);
					light2.setFill(Color.GOLD);
					light3.setFill(Color.BLACK);
				});

				btn3 = new Button("Green");
				btn3.setStyle(
						"-fx-background-radius: 5em; -fx-background-color: #9acd32; -fx-border-radius: 5em; -fx-border-color: #000000");
				btn3.setOnAction(e -> {
					light1.setFill(Color.BLACK);
					light2.setFill(Color.BLACK);
					light3.setFill(Color.YELLOWGREEN);
				});

				this.setAlignment(Pos.CENTER);
				this.setSpacing(10);
				this.setPadding(new Insets(5, 5, 5, 5));
				this.getChildren().addAll(btn1, btn2, btn3);

			}

		}
	}
}
