package clock;

/*
 * James Wolak
 * 4/19/2020
 * CSC-112
 * Java 2
 * HW8 Set Clock Time and Animate
 * This program creates a clock with several features such as start, stop, load current time and start, and just current time.
 * The program also uses textfields in order for the user to set different times.
 * 
 */

import java.util.Calendar;
import java.util.GregorianCalendar;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Clock extends Application {

	private TextField hrText, minText, secText;
	private int screenW = 500;
	private int screenH = 500;

//*************************************************************************************
	@SuppressWarnings("exports")
	public void start(Stage primaryStage) {

		Scene scene = new Scene(new CreateClock(), screenW, screenH);
		primaryStage.setTitle("Clock");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

//*************************************************************************************

	public static void main(String[] args) {

		launch(args);
	}

//*************************************************************************************

	class CreateClock extends BorderPane {

		private int hr = 0, min = 0, sec = 0;
		private Timeline animation;
		private ClockPane clock = new ClockPane();

		public CreateClock() {

			setTimeAnimation(clock);

		}

//*************************************************************************************

		public void setTimeAnimation(ClockPane clock) {

			animation = new Timeline(new KeyFrame(Duration.millis(1000), e -> clock.tick()));
			animation.setCycleCount(Timeline.INDEFINITE);
			animation.play();

			animation.currentTimeProperty().addListener(ov -> {
				hrText.setText(String.valueOf((int) clock.hour));
				minText.setText(String.valueOf((int) clock.minute));
				secText.setText(String.valueOf((int) clock.second));

			});

			this.setTop(new Controls());
			this.setCenter(clock);
			this.setBottom(new SetTime());

		}

//*************************************************************************************

		public void currentTimeAnimation() {

			ClockPane currentTime = new ClockPane();
			animation = new Timeline(new KeyFrame(Duration.millis(1000), e -> currentTime.tick()));
			animation.setCycleCount(Timeline.INDEFINITE);

			animation.currentTimeProperty().addListener(ov -> {
				hrText.setText(String.valueOf((int) currentTime.hour));
				minText.setText(String.valueOf((int) currentTime.minute));
				secText.setText(String.valueOf((int) currentTime.second));

			});

			this.setCenter(currentTime);

		}

//*************************************************************************************

		class Controls extends HBox {

			private Button stop, start, currentTAndS, currentT;

			public Controls() {

				stop = new Button("Stop");
				stop.setOnAction(e -> {
					animation.pause();
				});

				start = new Button("Start");
				start.setOnAction(e -> {
					animation.play();
				});

				currentTAndS = new Button("Load Current Time & Start");
				currentTAndS.setOnAction(e -> {
					animation.pause();
					currentTimeAndStart();
					animation.play();
				});

				currentT = new Button("Just Load Current Time");
				currentT.setOnAction(e -> {
					displayCurrentTime();
					animation.pause();
				});

				this.setSpacing(10);
				this.setAlignment(Pos.CENTER);
				this.setPadding(new Insets(15, 5, 5, 5));
				this.getChildren().addAll(stop, start, currentTAndS, currentT);

			}

		}

//*************************************************************************************

		public void currentTimeAndStart() {

			currentTimeAnimation();
			animation.play();

		}

//*************************************************************************************

		public void displayCurrentTime() {

			Calendar calendar = new GregorianCalendar();
			hrText.setText(String.valueOf(calendar.get(Calendar.HOUR_OF_DAY)));
			minText.setText(String.valueOf(calendar.get(Calendar.MINUTE)));
			secText.setText(String.valueOf(calendar.get(Calendar.SECOND)));

		}

//*************************************************************************************

		class SetTime extends HBox {

			private Label hrL, minL, secL;

			public SetTime() {

				hrText = new TextField();
				hrText.setMaxWidth(50);

				minText = new TextField();
				minText.setMaxWidth(50);

				secText = new TextField();
				secText.setMaxWidth(50);

				hrL = new Label("Hour: ", hrText);
				hrL.setContentDisplay(ContentDisplay.RIGHT);
				hrText.setOnKeyPressed(e -> {
					if (e.getCode().equals(KeyCode.ENTER)) {
						setBlankText(hrText, minText, secText);
						reset();
						e.consume();
					}
				});

				minL = new Label("Minute: ", minText);
				minL.setContentDisplay(ContentDisplay.RIGHT);
				minText.setOnKeyPressed(e -> {
					if (e.getCode().equals(KeyCode.ENTER)) {
						setBlankText(hrText, minText, secText);
						reset();
						e.consume();
					}
				});

				secL = new Label("Second: ", secText);
				secL.setContentDisplay(ContentDisplay.RIGHT);
				secText.setOnKeyPressed(e -> {
					if (e.getCode().equals(KeyCode.ENTER)) {
						setBlankText(hrText, minText, secText);
						reset();
						e.consume();
					}
				});

				this.setSpacing(15);
				this.setAlignment(Pos.CENTER);
				this.setPadding(new Insets(5, 5, 10, 5));
				this.getChildren().addAll(hrL, minL, secL);

			}

//*************************************************************************************

			public void setBlankText(TextField hrText, TextField minText, TextField secText) {

				if (hrText.getText().equals("") || hrText.getText() == null)
					hrText.setText("0");

				if (minText.getText().equals("") || minText.getText() == null)
					minText.setText("0");

				if (secText.getText().equals("") || secText.getText() == null)
					secText.setText("0");

			}
//*************************************************************************************

			public void reset() {

				hr = Integer.parseInt(hrText.getText());
				min = Integer.parseInt(minText.getText());
				sec = Integer.parseInt(secText.getText());

				ClockPane cP = new ClockPane(hr, min, sec);
				setTimeAnimation(cP);

			}

		}
	}
}