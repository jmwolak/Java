package lottery;

/*
 * James Wolak
 * 5/1/2020
 * CSC-112
 * Java 2
 * HW10 NetWork Client GUI
 * Once the "Generate" button is clicked, this program will take the information given from
 * the combo-box and radio buttons and display the information (lottery numbers) in the text area.
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class LotteryQuickPicksGUI extends Application {

	private int screenWidth = 550;
	private int screenHeight = 450;

//**********************************************************************************
	@SuppressWarnings("exports")
	public void start(Stage primaryStage) {

		Scene scene = new Scene(new DisplayScreen(), screenWidth, screenHeight);
		scene.getStylesheets().add("style.css");
		primaryStage.setTitle("Lottery Quick Picks");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();

	}

//**********************************************************************************

	public static void main(String[] args) {
		launch(args);
	}

//**********************************************************************************

	class DisplayScreen extends BorderPane {

		private ComboBox<String> cB = new ComboBox<>();
		private RadioButton powerBall, megaMillions, luckyForLife;
		private Button generate;
		private TextArea text = new TextArea();

//**********************************************************************************

		DisplayScreen() {

			text.setPrefColumnCount(40);
			text.setPrefRowCount(15);
			text.setEditable(false);
			text.setPadding(new Insets(20));

			this.setTop(new Options());
			this.setCenter(text);
			this.setBottom(new Message());

		}

//**********************************************************************************

		class Options extends HBox {

			private PowerMegaLucky pml;

//**********************************************************************************

			public Options() {
				cB.getItems().addAll("1", "2", "5", "10");

				Label quickPicks = new Label("Number of Quick Picks   ", cB);
				quickPicks.setId("quickPicks");
				quickPicks.setContentDisplay(ContentDisplay.RIGHT);

				pml = new PowerMegaLucky();

				generate = new Button("Generate");
				generate.setId("button");

				generate.setOnAction(e -> {

					try {
						Socket client = new Socket("cs.stcc.edu", 5000);
						Scanner input = new Scanner(client.getInputStream());
						PrintWriter output = new PrintWriter(client.getOutputStream());

						output.println(cB.getValue());
						output.flush();

						output.println(pml.getSelectedText());
						output.flush();

						text.appendText(cB.getValue() + "-");
						text.appendText(pml.getSelectedText() + "\n");
						int num = Integer.parseInt(cB.getValue());

						input.nextLine();

						for (int i = 0; i < num; i++) {
							String ans = input.nextLine();
							text.appendText(ans + "\n");
						}

						text.appendText("\n");
					} catch (ConnectException e1) {
						text.appendText("-1\nCorrect Socket not Found\n\n");
					} catch (UnknownHostException e1) {
						text.appendText("-1\nIP address of host name could not be Found\n\n");
					} catch (NumberFormatException e1) {
						text.appendText("-1\nQuick Pick Numbers must be 1, 2, 5, or 10\n\n");
					} catch (NullPointerException e1) {
						text.appendText("-1\nChoices must be PowerBall, MegaMillions, or LuckyForLife\n\n");
					} catch (NoSuchElementException e1) {
						text.appendText("-1\nChoices must be PowerBall, MegaMillions, or LuckyForLife\n\n");
					} catch (IOException e1) {
						text.appendText("-1\nError\n\n");
					} catch (RuntimeException e1) {
						text.appendText("-1\nPlease make sure all the correct information is provided\n\n");
					}

				});

				this.setPadding(new Insets(50, 10, 5, 40));
				this.getChildren().addAll(quickPicks, pml, generate);

			}

//**********************************************************************************

			class PowerMegaLucky extends VBox {

				public PowerMegaLucky() {

					powerBall = new RadioButton("PowerBall");
					powerBall.setContentDisplay(ContentDisplay.LEFT);

					megaMillions = new RadioButton("MegaMillions");
					megaMillions.setContentDisplay(ContentDisplay.LEFT);

					luckyForLife = new RadioButton("LuckyForLife");
					luckyForLife.setContentDisplay(ContentDisplay.LEFT);

					ToggleGroup group = new ToggleGroup();
					powerBall.setToggleGroup(group);
					megaMillions.setToggleGroup(group);
					luckyForLife.setToggleGroup(group);

					powerBall.setId("radio-button");
					megaMillions.setId("radio-button");
					luckyForLife.setId("radio-button");

					this.setSpacing(10);
					this.setPadding(new Insets(-25, 20, 5, 30));
					this.getChildren().addAll(powerBall, megaMillions, luckyForLife);

				}

//**********************************************************************************

				public String getSelectedText() {
					if (powerBall.isSelected())
						return powerBall.getText();
					if (megaMillions.isSelected())
						return megaMillions.getText();
					if (luckyForLife.isSelected())
						return luckyForLife.getText();
					return null;
				}
			}

		}

//**********************************************************************************

		class Message extends Pane {

			private Timeline animation;
			private Text lottery;

//**********************************************************************************

			public Message() {

				animation = new Timeline(new KeyFrame(Duration.millis(10), e -> move()));
				animation.setCycleCount(Timeline.INDEFINITE);
				animation.play();

			}

//**********************************************************************************

			public void move() {

				screenWidth--;

				if (screenWidth == -250)
					screenWidth = 550;

				paint();

			}

//**********************************************************************************

			public void paint() {

				lottery = new Text("LOTTERY QUICK PICKS!!!");
				lottery.setId("lottery");
				lottery.setX(screenWidth);
				lottery.setY(screenHeight / 15);

				this.getChildren().clear();
				this.getChildren().add(lottery);

			}

		}
	}
}
