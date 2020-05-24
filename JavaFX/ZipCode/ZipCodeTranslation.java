package zipcode;

/*
 * James Wolak
 * 5/12/2020
 * CSC-112
 * Java 2
 * HW 12 ZipCode/City/State Gui
 *Using Regex, this program will determine whether or not the inserted information provides
 *all of the details needed in order to continue to process information. The program then 
 *displays the info needed.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class ZipCodeTranslation extends Application {

	private static final int SCREENWIDTH = 650;
	private static final int SCREENHEIGHT = 300;

//***********************************************************************************
	@SuppressWarnings("exports")
	public void start(Stage primaryStage) {

		Scene scene = new Scene(new SetUp(), SCREENWIDTH, SCREENHEIGHT);
		scene.getStylesheets().add("style.css");
		primaryStage.setTitle("Zip Code Translation");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

//***********************************************************************************

	public static void main(String[] args) {
		launch(args);
	}

//***********************************************************************************

	class SetUp extends BorderPane {

		private Line line;
		private TextField topZipText, topCityText, centerCityText, topStateText, centerStateText, statusText;
		private TextArea textArea;
		private Label zipLabel, cityLabel, stateLabel, statusLabel;
		private Button btn;
		private static final String DATABASE = "silvestri";
		private static final String USERNAME = "readonly";
		private static final String PASSWORD = "readonly";
		private static final String url = "jdbc:mysql://cs.stcc.edu/" + DATABASE;

//***********************************************************************************

		public SetUp() {
			this.setTop(new TopRow());
			this.setCenter(new CenterRow());
			this.setBottom(new BottomRow());
		}

//***********************************************************************************

		class TopRow extends VBox {

			public TopRow() {

				topZipText = new TextField();
				topZipText.setPrefWidth(75);
				zipLabel = new Label("Zip Code: ", topZipText);
				zipLabel.setContentDisplay(ContentDisplay.RIGHT);

				btn = new Button("Zip to City");
				btn.setOnAction(e -> {
					zipCodeCheck(topZipText.getText());
				});

				topCityText = new TextField();
				topCityText.setPrefWidth(150);
				topCityText.setEditable(false);
				cityLabel = new Label("City: ", topCityText);
				cityLabel.setContentDisplay(ContentDisplay.RIGHT);

				topStateText = new TextField();
				topStateText.setPrefWidth(50);
				topStateText.setEditable(false);
				stateLabel = new Label("State: ", topStateText);
				stateLabel.setContentDisplay(ContentDisplay.RIGHT);

				HBox hInfo = new HBox();
				hInfo.setSpacing(30);
				hInfo.setPadding(new Insets(0, 0, 25, 0));
				hInfo.getChildren().addAll(zipLabel, btn, cityLabel, stateLabel);

				HBox hLine = new HBox();
				line = new Line(10, 0, 575, 0);
				line.setId("line");
				hLine.getChildren().add(line);

				this.setPadding(new Insets(30, 30, 25, 50));
				this.getChildren().addAll(hInfo, hLine);

			}

//***********************************************************************************

			public void zipCodeCheck(String zip) {

				final String regex = "^\\d{5}$";
				final String string = zip;

				final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
				final Matcher matcher = pattern.matcher(string);

				if (matcher.find()) {
					statusText.clear();
					statusText.appendText("Zip Code Entry Correct.");
					locateCityState();
				} else {
					statusText.clear();
					statusText
							.appendText("Zip Code Entry Incorrect. Zip Code must be a 5 digit number without spacing.");
					topCityText.clear();
					topStateText.clear();
				}
			}

//***********************************************************************************

			public void locateCityState() {

				try {

					Connection conn = DriverManager.getConnection(url, USERNAME, PASSWORD);
					Statement statement = conn.createStatement();
					String query = "SELECT city, state_id, zip from ZipCodes where zip = " + topZipText.getText();
					ResultSet resultSet = statement.executeQuery(query);

					if (resultSet.next()) {
						do {
							topCityText.clear();
							topStateText.clear();
							centerCityText.clear();
							centerStateText.clear();
							textArea.clear();
							textArea.appendText("ZipCode(s)\n");
							topCityText.appendText(resultSet.getString(1));
							topStateText.appendText(resultSet.getString(2));
						} while (resultSet.next());
					} else {
						topZipText.clear();
						topCityText.clear();
						topStateText.clear();
						statusText.clear();
						statusText.appendText("Cannot find ZipCode");
					}
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
		}

//***********************************************************************************

		class CenterRow extends VBox {

			public CenterRow() {

				centerCityText = new TextField();
				centerCityText.setPrefWidth(150);
				cityLabel = new Label("City: ", centerCityText);
				cityLabel.setContentDisplay(ContentDisplay.RIGHT);

				centerStateText = new TextField();
				centerStateText.setPrefWidth(50);
				stateLabel = new Label("State: ", centerStateText);
				stateLabel.setContentDisplay(ContentDisplay.RIGHT);

				btn = new Button("City to Zip");
				btn.setOnAction(e -> {
					textArea.clear();
					textArea.appendText("ZipCode(s)\n");
					cityStateCheck(centerCityText.getText(), centerStateText.getText());
				});

				textArea = new TextArea("Zip Code(s)\n");
				textArea.setPrefWidth(130);
				textArea.setMaxHeight(100);
				textArea.setEditable(false);

				HBox hInfo = new HBox();
				hInfo.setSpacing(30);
				hInfo.setPadding(new Insets(0, 0, 25, 0));
				hInfo.getChildren().addAll(cityLabel, stateLabel, btn, textArea);

				HBox hLine = new HBox();
				line = new Line(10, 0, 575, 0);
				line.setId("line");
				hLine.getChildren().add(line);

				this.setPadding(new Insets(5, 30, 25, 50));
				this.getChildren().addAll(hInfo, hLine);

			}

//***********************************************************************************

			public void cityStateCheck(String city, String state) {

				final String cityRegex = "^([a-z,A-Z ]+)$";
				final String stateRegex = "^([A-Z]{2})$";

				final Pattern pattern1 = Pattern.compile(cityRegex, Pattern.MULTILINE);
				final Matcher cityMatcher = pattern1.matcher(city);

				final Pattern pattern2 = Pattern.compile(stateRegex, Pattern.MULTILINE);
				final Matcher stateMatcher = pattern2.matcher(state);

				if (cityMatcher.find()) {

					if (stateMatcher.find()) {
						statusText.clear();
						statusText.appendText("City and State Entry Correct");
						locateZip();
					} else {
						statusText.clear();
						statusText.appendText(
								"Incorrect State Abbreviation Entry. Please insert Capitalization on Abbreviation");
					}
				} else {
					statusText.clear();
					statusText.appendText("City Entry Incorrect.");
				}
			}

//***********************************************************************************

			public void locateZip() {

				String city = convert(centerCityText.getText());
				String state = convert(centerStateText.getText());

				try {

					Connection conn = DriverManager.getConnection(url, USERNAME, PASSWORD);
					Statement statement = conn.createStatement();
					String query = "SELECT zip from ZipCodes where city = " + city + "and state_id = " + state;
					ResultSet resultSet = statement.executeQuery(query);

					if (resultSet.next()) {
						do {
							topZipText.clear();
							topCityText.clear();
							topStateText.clear();
							textArea.appendText(resultSet.getString(1) + "\n");
						} while (resultSet.next());
					} else {
						statusText.clear();
						statusText.appendText("Cannot find City or State Abbreviation");
					}
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}

//***********************************************************************************

			public String convert(String s) {
				return new StringBuilder().append('\'').append(s).append('\'').toString();
			}
		}

//***********************************************************************************

		class BottomRow extends Pane {

			public BottomRow() {

				statusText = new TextField();
				statusText.setPrefWidth(450);
				statusText.setEditable(false);
				statusLabel = new Label("Status: ", statusText);
				statusLabel.setContentDisplay(ContentDisplay.RIGHT);

				statusLabel.setAlignment(Pos.CENTER);
				statusLabel.setPadding(new Insets(0, 0, 30, 100));
				this.getChildren().add(statusLabel);

			}
		}

	}
}
