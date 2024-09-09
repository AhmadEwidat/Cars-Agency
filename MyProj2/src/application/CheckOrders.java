package application;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;
import javafx.stage.Stage;

//this stage to check orders and accept or reject or delay them 
public class CheckOrders {
	private Button agreeButton, rejectButton, delayButton, back, save;
	private TextArea label;
	private Scene scene;
	private HBox hBox;
	private VBox vbox;
	private Stage stage;

	public CheckOrders(Stage stage1, LinkedListQueue linkedListQueue, Stack1 stack1,
			DoublyLinkedList1 doublyLinkedList1) {
		Font font = new Font(40);
		save = new Button("Save");
		save.setFont(font);
		save.setPrefWidth(200);
		save.setPrefHeight(100);
		agreeButton = new Button("Agree");
		rejectButton = new Button("Reject");
		delayButton = new Button("Delay");
		back = new Button("Back");
		back.setFont(font);
		back.setPrefWidth(200);
		back.setPrefHeight(100);
		agreeButton.setFont(font);
		agreeButton.setPrefWidth(200);
		agreeButton.setPrefHeight(100);
		rejectButton.setFont(font);
		rejectButton.setPrefWidth(200);
		rejectButton.setPrefHeight(100);
		delayButton.setFont(font);
		delayButton.setPrefWidth(200);
		delayButton.setPrefHeight(100);
		hBox = new HBox(20);
		hBox.getChildren().addAll(back, agreeButton, rejectButton, delayButton, save);
		label = new TextArea();
		label.setStyle("-fx-font-size:24;-fx-font-Weight:Bold;-fx-Color-fill:BROWN;-fx-Color-setBackground:BROWN");
		vbox = new VBox(30);
		vbox.setAlignment(Pos.CENTER);
		vbox.getChildren().addAll(label, hBox);
		hBox.setAlignment(Pos.CENTER);
		scene = new Scene(vbox, 800, 600);
		stage = new Stage();
		stage.setScene(scene);
		stage.show();
		stage.setFullScreen(true);
		RadialGradient nR = new RadialGradient(0, 0, 0, 0, 1, true, // sizing
				CycleMethod.NO_CYCLE, // cycling
				new Stop(0, Color.web("#81c483")), // colors
				new Stop(1, Color.web("#fcc200")));

		// Change to your desired color
		BackgroundFill backgroundFill = new BackgroundFill(nR, CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY);
		Background background = new Background(backgroundFill);
		vbox.setBackground(background);
		back.setOnAction(e -> {
			stage.close();
			stage1.setFullScreen(true);
		});
		agreeButton.setDisable(true);
		if (!linkedListQueue.isEmpty()) {
			label.setText(linkedListQueue.front().toString());
			if (doublyLinkedList1.Find(linkedListQueue.front().getCar())) {
				agreeButton.setDisable(false);
			}

		}
		agreeButton.setOnAction(e -> {
			if (!linkedListQueue.isEmpty()) {
				linkedListQueue.front().setOrderStatus("Finished");
				stack1.push(linkedListQueue.dequeue());

			}

			if (!linkedListQueue.isEmpty()) {

				label.setText(linkedListQueue.front().toString());
				if (doublyLinkedList1.Find(linkedListQueue.front().getCar())) {
					agreeButton.setDisable(false);
				}

			} else {
				label.setText("All requests have been processed");
			}

		});
		rejectButton.setOnAction(e -> {
			if (!linkedListQueue.isEmpty()) {
				linkedListQueue.dequeue();
			}
			if (!linkedListQueue.isEmpty()) {
				label.setText(linkedListQueue.front().toString());
				if (doublyLinkedList1.Find(linkedListQueue.front().getCar())) {
					agreeButton.setDisable(false);
				}
			} else {
				label.setText("All requests have been processed");
			}
		});
		delayButton.setOnAction(e -> {
			if (!linkedListQueue.isEmpty()) {
				linkedListQueue.enqueue(linkedListQueue.dequeue());
			}
			if (!linkedListQueue.isEmpty()) {
				label.setText(linkedListQueue.front().toString());

			} else {
				label.setText("All requests have been processed");
			}
		});
		save.setOnAction(e -> {
			FileWriter fileWriter;
			try {
				fileWriter = new FileWriter("C:\\Users\\Dell\\Downloads\\orders.txt");
				BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
				bufferedWriter.write(
						"CustomerName, CustomerMobile, Brand, Model, Year, Color, Price, OrderDate, OrderStatus");
				while (!stack1.isEmpty()) {
					bufferedWriter.newLine();
					bufferedWriter.write(stack1.pop().toString1());

				}
				while (!linkedListQueue.isEmpty()) {
					bufferedWriter.newLine();
					bufferedWriter.write(linkedListQueue.dequeue().toString1());
				}
				bufferedWriter.close();
			} catch (IOException e1) {

				e1.printStackTrace();
			}

		});

	}
}
