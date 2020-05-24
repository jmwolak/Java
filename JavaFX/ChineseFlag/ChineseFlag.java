package flagFX;

/*
 * James Wolak
 * 3/13/2020
 * CSC-112
 * Java 2
 * HW4 Chinese Flag
 * jmwolak0001@student.stcc.edu
 * 
 * This program displays the Chinese Flag
 */

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ChineseFlag extends Application {

	private int width = 600;
	private int height = 400;
	private int size = 40;

//**********************************************************************

	@SuppressWarnings("exports")
	public Node smallStars(Image image, Pane pane) {

		for (int i = 1; i < 5; i++) {

			ImageView star = new ImageView(image);
			star.setFitWidth(size);
			star.setFitHeight(size);

			if (i < 3) {
				star.xProperty().bind(pane.widthProperty().divide(3.333));
				star.setRotate(20);
				if (i == 2) {
					star.yProperty().bind(pane.heightProperty().divide(2.5));
				} else {
					star.yProperty().bind(pane.heightProperty().divide(20));
				}
			}

			if (i >= 3) {
				star.xProperty().bind(pane.widthProperty().divide(2.727));
				if (i == 4) {
					star.yProperty().bind(pane.heightProperty().divide(3.333));
					star.setRotate(-2);
				} else {
					star.yProperty().bind(pane.heightProperty().divide(6.667));
					star.setRotate(43);
				}
			}

			pane.getChildren().addAll(star);
		}

		return pane;

	}

//**********************************************************************

	@SuppressWarnings("exports")
	public Node bigStar(Image image, Pane pane) {

		ImageView bigStar = new ImageView(image);
		bigStar.setFitWidth(120);
		bigStar.setFitWidth(120);
		bigStar.xProperty().bind(pane.widthProperty().divide(15));
		bigStar.yProperty().bind(pane.heightProperty().divide(10));
		bigStar.setPreserveRatio(true);

		pane.getChildren().add(bigStar);

		return pane;

	}

//**********************************************************************

	@SuppressWarnings("exports")
	public void start(Stage primaryStage) {

		Pane pane = new Pane();
		pane.setStyle("-fx-background-color: RED");

		Image image = new Image("https://cs.stcc.edu/wp-content/uploads/2020/03/chineseflagstar.png");

		bigStar(image, pane);
		smallStars(image, pane);

		Scene scene = new Scene(pane, width, height);

		primaryStage.setTitle("Chinese Flag");
		primaryStage.setScene(scene);
		primaryStage.setResizable(true);
		primaryStage.show();

	}

//**********************************************************************

	public static void main(String[] args) {
		launch(args);
	}

}
