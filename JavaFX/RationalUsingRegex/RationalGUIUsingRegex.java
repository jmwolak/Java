package rationalRegex;

/*
 * Application GUI Code for the Rational App Using Regex
 * James Wolak
 * CSC-112  Intermediate Java
 * 02/29/20
 * This program requires the user to input two rational number.
 * It then uses the Rational class to determine the output.
 */

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class RationalGUIUsingRegex extends Application {

	private static final int APPWIDTH = 820;
	private static final int APPHEIGHT = 170;
	private static final String TITLE = "Rationals Using Regex GUI App";
	private TextField tfARational;
	private TextField tfBRational;
	private ComboBox<String> operation;
	private TextField tfCRational;
	private Button btnCalculate;

//**********************************************************************	

	private void doCalculation() {

		try {

			String text1 = tfARational.getText();
			RationalRegex r1 = new RationalRegex(text1);
			Rational a = new Rational(r1.getNumerator(), r1.getDenominator());

			String text2 = tfBRational.getText();
			RationalRegex r2 = new RationalRegex(text2);
			Rational b = new Rational(r2.getNumerator(), r2.getDenominator());

			String op = this.operation.getValue();

			Rational c = null;

			switch (op) {

			case "+":
				c = a.plus(b); // a + b
				break;

			case "-":
				c = a.minus(b);
				break;

			case "*":
				c = a.times(b);
				break;

			case "/":
				c = a.divides(b);
				break;

			}

			this.tfCRational.setText(c.getNumerator() + "/" + c.getDenominator());

		} catch (Exception ex) {

			this.tfCRational.setText("Error");

		}

	}

//**********************************************************************	

	private BorderPane setupGUI() {

		final String COMPONENTSTYLE = "-fx-font-weight: bold; -fx-font-size: 16pt";
		this.tfARational = new TextField();
		this.tfARational.setStyle(COMPONENTSTYLE);
		this.tfARational.setPrefWidth(150);
		this.tfBRational = new TextField();
		this.tfBRational.setStyle(COMPONENTSTYLE);
		this.tfBRational.setPrefWidth(150);
		this.tfCRational = new TextField();
		this.tfCRational.setStyle(COMPONENTSTYLE);
		this.tfCRational.setPrefWidth(150);
		this.tfCRational.setEditable(false);
		Label lblA = new Label("A");
		lblA.setStyle(COMPONENTSTYLE);
		Label lblB = new Label("B");
		lblB.setStyle(COMPONENTSTYLE);
		Label lblC = new Label("C");
		lblC.setStyle(COMPONENTSTYLE);

		this.operation = new ComboBox<String>();
		this.operation.getItems().addAll(new String[] { "+", "-", "*", "/" });
		this.operation.setStyle(COMPONENTSTYLE);
		this.operation.setValue("+");

		this.btnCalculate = new Button(" = ");
		this.btnCalculate.setStyle(COMPONENTSTYLE);
		this.btnCalculate.setOnAction(e -> doCalculation());

		FlowPane fp = new FlowPane(15, 5);
		fp.setAlignment(Pos.CENTER);
		fp.setPadding(new Insets(5));
		Label lblInstructions = new Label("Enter Rational Numbers for A and B; Select Operation; Press =");
		lblInstructions.setStyle("-fx-font-weight: bold; -fx-font-size: 12pt");
		lblInstructions.setPrefWidth(APPWIDTH);
		lblInstructions.setAlignment(Pos.CENTER);
		fp.getChildren().addAll(lblInstructions, lblA, tfARational, this.operation, lblB, tfBRational,
				this.btnCalculate, lblC, tfCRational);

		Label lblStatus = new Label(TITLE);
		FlowPane bpane = new FlowPane(5, 5);
		bpane.setAlignment(Pos.BASELINE_CENTER);
		bpane.setPadding(new Insets(5));
		bpane.setStyle("-fx-font-weight: bold; -fx-font-size: 12pt");
		bpane.getChildren().addAll(lblStatus);

		BorderPane bp = new BorderPane();
		bp.setCenter(fp);
		bp.setBottom(bpane);
		return bp;

	}

//**********************************************************************	

	@Override
	public void start(Stage primaryStage) {

		BorderPane bp = setupGUI();
		Scene scene = new Scene(bp, APPWIDTH, APPHEIGHT);
		primaryStage.setTitle(TITLE);
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setResizable(true);

	}

//**********************************************************************	

	public static void main(String[] args) {

		launch(args);

	}

}
