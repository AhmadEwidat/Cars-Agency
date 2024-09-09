package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.stage.Stage;

public class Password {
	private Scene scene;
	private Label l, l2, lmassege;
	private PasswordField passwordField;
	private CheckBox checkBox;
	private HBox hBox, hBox2;
	private VBox vBox;
	private String password = "ahmad-123";
	private Button next, back;
	private TextField field;

	public Password(DoublyLinkedList1 doublyLinkedList1, Stage stage, Scene scene2, LinkedListQueue linkedListQueue,
			Stack1 stack1) {
		ImageView imageView = new ImageView("Rarrow.png");
		ImageView imageView2 = new ImageView("Larrow.png");
		imageView.setFitWidth(20);
		imageView.setFitHeight(20);
		imageView2.setFitWidth(20);
		imageView2.setFitHeight(20);
		next = new Button("next", imageView);
		back = new Button("Back", imageView2);
		hBox2 = new HBox(10);
		hBox2.setAlignment(Pos.CENTER);
		hBox2.getChildren().addAll(back, next);
		lmassege = new Label("passwor is not corect");
		lmassege.setTextFill(Color.RED);
		lmassege.setVisible(false);
		l = new Label("please enter the password :");
		l2 = new Label("password");
		l.setStyle("-fx-font-size:24;-fx-font-Weight:Bold;-fx-Color-fill:BROWN;-fx-Color-setBackground:BROWN");
		l2.setStyle("-fx-font-size:24;-fx-font-Weight:Bold;-fx-Color-fill:BROWN;-fx-Color-setBackground:BROWN");
		passwordField = new PasswordField();
		passwordField.setPrefWidth(200);
		checkBox = new CheckBox("show password");
		checkBox.setStyle("-fx-font-size: 16px;");
		hBox = new HBox(10);
		VBox.setMargin(hBox2, new Insets(0, 0, 0, 85));
		VBox.setMargin(checkBox, new Insets(0, 0, 0, 55));
		VBox.setMargin(lmassege, new Insets(0, 0, 0, 55));
		vBox = new VBox(10);
		hBox.getChildren().addAll(l2, passwordField);
		hBox.setAlignment(Pos.CENTER);
		vBox.getChildren().addAll(l, hBox, checkBox, lmassege, hBox2);
		next.setPrefWidth(80);
		next.setPrefHeight(40);
		back.setPrefWidth(80);
		back.setPrefHeight(40);
		vBox.setAlignment(Pos.CENTER);
		RadialGradient nR = new RadialGradient(0, 0, 0, 0, 1, true, // sizing
				CycleMethod.NO_CYCLE, // cycling
				new Stop(0, Color.web("#81c483")), // colors
				new Stop(1, Color.web("#fcc200")));

		// Change to your desired color
		BackgroundFill backgroundFill = new BackgroundFill(nR, CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY);
		Background background = new Background(backgroundFill);
		vBox.setBackground(background);
		Scene scene1 = stage.getScene();
		scene = new Scene(vBox);
		stage.setScene(scene);
		stage.setFullScreen(true);
		field = new TextField();
		field.setPrefWidth(200);
		checkBox.setOnAction(e -> {
			if (passwordField.getText() != "") {
				if (checkBox.isSelected()) {
					field.setText(passwordField.getText());
					hBox.getChildren().remove(1);
					hBox.getChildren().add(field);
				} else {
					passwordField.setText(field.getText());
					hBox.getChildren().remove(1);
					hBox.getChildren().add(passwordField);
				}

			} else {
				checkBox.setSelected(false);
			}
		});
		next.setOnAction(e -> {
			if (passwordField.getText().equals(password) || field.getText().equals(password)) {
				AdmStages admStages = new AdmStages(doublyLinkedList1, stage, scene1, linkedListQueue, stack1);
				stage.setScene(admStages.getScene());
				stage.setFullScreen(true);
			} else {
				lmassege.setVisible(true);
			}
		});
		back.setOnAction(e -> {
			stage.setScene(scene2);
			stage.setFullScreen(true);
		});

	}

}
