package application;

import java.io.FileNotFoundException;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Driver extends Application {
	private DoublyLinkedList1 doublyLinkedList1 = new DoublyLinkedList1();
	private LinkedListQueue linkedListQueue = new LinkedListQueue();
	private Stack1 stack1 = new Stack1();

	@Override
	public void start(Stage primaryStage) {
		// Create buttons
		ImageView imageView = new ImageView("software-engineer.png");
		ImageView imageView2 = new ImageView("rating.png");
		imageView.setFitWidth(40);
		imageView2.setFitWidth(40);
		imageView.setFitHeight(40);
		imageView2.setFitHeight(40);
		Font font = new Font(40);
		Label label = new Label("please sdelect your choice :");
		label.setStyle("-fx-font-size:24;-fx-font-Weight:Bold;-fx-Color-fill:BROWN;-fx-Color-setBackground:BROWN");
		Button adminButton = new Button("Admin", imageView);
		adminButton.setFont(font);
		adminButton.setStyle("-fx-border-color: Black;-fx-background-color:red");
		adminButton.setPrefWidth(300);
		adminButton.setPrefHeight(100);
		Button customerButton = new Button("Customer", imageView2);
		customerButton.setFont(font);
		customerButton.setStyle("-fx-border-color: Black;-fx-background-color:red");
		customerButton.setPrefWidth(300);
		customerButton.setPrefHeight(100);
		// Create a layout
		VBox layout = new VBox(30); // 10 is the spacing between elements
		layout.setAlignment(Pos.CENTER); // Center the buttons in the layout
		layout.getChildren().addAll(label, adminButton, customerButton);
		// Create a scene
		Scene scene = new Scene(layout, 400, 400);
		RadialGradient nR = new RadialGradient(0, 0, 0, 0, 1, true, // sizing
				CycleMethod.NO_CYCLE, // cycling
				new Stop(0, Color.web("#81c483")), // colors
				new Stop(1, Color.web("#fcc200")));

		// Change to your desired color
		BackgroundFill backgroundFill = new BackgroundFill(nR, CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY);
		Background background = new Background(backgroundFill);
		layout.setBackground(background);
		// Set the scene to the stage
		primaryStage.setScene(scene);
		primaryStage.setFullScreen(true);
		primaryStage.setTitle("Agency application");
		// Show the stage
		primaryStage.show();
		adminButton.setOnAction(e -> {

			Password pass = new Password(doublyLinkedList1, primaryStage, scene, linkedListQueue, stack1);
		});
		customerButton.setOnAction(e -> {
			try {
				CustStages custStages = new CustStages(primaryStage, doublyLinkedList1, linkedListQueue, stack1);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
	}

	public static void main(String[] args) {
		launch(args);
	}
}
