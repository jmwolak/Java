package keyEvent;

/*
 * James Wolak
 * 4/12/2020
 * CSC-112
 * Java 2
 * HW7 Draw with Arrow Keys
 * This program allows the user to create drawings while using a mouse and arrow keys on the keyboard.
 * The program also provides buttons to help the user create the drawings.
 */

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class DrawingWithArrowKeys extends Application {
	private Line line = new Line(100, 100, 100, 100);
	private Circle circle = new Circle(100, 100, 10);
	private Button clear, penDown, penUp;
	private int setWidth = 400;
	private int setHeight = 400;
	private double xStart = 100;
	private double yStart = 100;

// ***********************************************************

	@SuppressWarnings({ "exports" })
	public void start(Stage primaryStage) {

		Scene scene = new Scene(new Draw(), setWidth, setHeight);
		primaryStage.setTitle("Drawing_With_Keys");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();

		circle.requestFocus();

	}

//***********************************************************

	public static void main(String[] args) {
		launch(args);
	}

//***********************************************************

	class Draw extends BorderPane {

		private Sketch sketch = new Sketch();

		public Draw() {

			ButtonControls bC = new ButtonControls(sketch);
			this.setBackground();
			this.setCenter(sketch);
			this.setBottom(bC);

		}

//***********************************************************

		public void setBackground() {

			this.setStyle("-fx-background-color: #000000");

		}

//***********************************************************

		class Sketch extends Pane {

			public Sketch() {

				this.getChildren().add(circle);
				penDown(circle);

			}

//***********************************************************

			@SuppressWarnings("incomplete-switch")
			private void penDown(Circle circle) {

				circle.setFill(Color.CADETBLUE);

				circle.setOnKeyPressed(e -> {
					switch (e.getCode()) {
					case DOWN:
						circle.setCenterY(circle.getCenterY() + 10);
						yBoundaries();
						line();
						break;
					case UP:
						circle.setCenterY(circle.getCenterY() - 10);
						yBoundaries();
						line();
						break;
					case LEFT:
						circle.setCenterX(circle.getCenterX() - 10);
						xBoundaries();
						line();
						break;
					case RIGHT:
						circle.setCenterX(circle.getCenterX() + 10);
						xBoundaries();
						line();
						break;

					}

					e.consume();

				});

				circle.setOnMouseDragged(e -> {
					circle.setCenterX(e.getX());
					circle.setCenterY(e.getY());
					xBoundaries();
					yBoundaries();
					line();

				});

			}

//***********************************************************

			@SuppressWarnings("incomplete-switch")
			private void penUp() {

				circle.setFill(Color.INDIANRED);

				circle.setOnKeyPressed(e -> {
					switch (e.getCode()) {
					case DOWN:
						circle.setCenterY(circle.getCenterY() + 10);
						yBoundaries();
						break;
					case UP:
						circle.setCenterY(circle.getCenterY() - 10);
						yBoundaries();
						break;
					case LEFT:
						circle.setCenterX(circle.getCenterX() - 10);
						xBoundaries();
						break;
					case RIGHT:
						circle.setCenterX(circle.getCenterX() + 10);
						xBoundaries();
						break;

					}

					xStart = circle.getCenterX();
					yStart = circle.getCenterY();
					e.consume();

				});

				circle.setOnMouseDragged(e -> {
					circle.setCenterX(e.getX());
					circle.setCenterY(e.getY());
					xStart = circle.getCenterX();
					yStart = circle.getCenterY();
					xBoundaries();
					yBoundaries();

				});

			}

//***********************************************************

			private void line() {

				line = new Line(xStart, yStart, circle.getCenterX(), circle.getCenterY());
				line.setStroke(Color.LIGHTGRAY);
				line.setStrokeWidth(3);

				this.getChildren().add(line);

				xStart = circle.getCenterX();
				yStart = circle.getCenterY();

			}

//***********************************************************

			private void xBoundaries() {

				if (circle.getCenterX() > setWidth)
					circle.setCenterX(setWidth - circle.getRadius());
				if (circle.getCenterX() < 0)
					circle.setCenterX(10);

			}

//***********************************************************

			private void yBoundaries() {

				if (circle.getCenterY() > setHeight)
					circle.setCenterY(setHeight - circle.getRadius());
				if (circle.getCenterY() < 0)
					circle.setCenterY(10);

			}

//***********************************************************

			private void clearCanvas() {

				circle = new Circle(circle.getCenterX(), circle.getCenterY(), circle.getRadius());
				this.getChildren().add(circle);
				penDown(circle);

			}
		}

//***********************************************************

		class ButtonControls extends HBox {

			public ButtonControls(Sketch sketch) {

				clear = new Button("Clear");
				clear.setStyle("-fx-background-color: #87ceeb; -fx-font-weight: bold");
				clear.setOnAction(e -> {
					sketch.getChildren().clear();
					circle = new Circle(circle.getCenterX(), circle.getCenterY(), 10);
					sketch.clearCanvas();
					circle.requestFocus();
				});

				penUp = new Button("Pen Up");
				penUp.setStyle("-fx-background-color: #87ceeb; -fx-font-weight: bold");
				penUp.setOnAction(e -> {
					sketch.penUp();
					circle.requestFocus();
				});

				penDown = new Button("Pen Down");
				penDown.setStyle("-fx-background-color: #87ceeb; -fx-font-weight: bold");
				penDown.setOnAction(e -> {
					sketch.penDown(circle);
					circle.requestFocus();
				});

				this.setSpacing(20);
				this.setAlignment(Pos.CENTER);
				this.setPadding(new Insets(5, 5, 5, 5));
				this.getChildren().addAll(clear, penUp, penDown);

			}

		}
	}
}