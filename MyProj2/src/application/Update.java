package application;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Update extends Search {
	private Scene scene1;
	private TextField textField;
	private Button Delete, update;
	private Label l1, lmassege;

	int x = 0;

	public Update(DoublyLinkedList1 doublyLinkedList1, Stage stage) {
		super(doublyLinkedList1, stage);
		lmassege = new Label("");
		l1 = new Label("please enter the Updeted Brand :");
		l1.setStyle("-fx-font-size:24;-fx-font-Weight:Bold;-fx-Color-fill:BROWN;-fx-Color-setBackground:BROWN");
		textField = new TextField();
		textField.setPrefWidth(200);
		update = new Button("Update");
		Delete = new Button("Delete");

		getComboBox().setOnAction(e -> {
			if (x == 0) {
				if (getComboBox().getValue() == null) {

				} else {
					gethBox3().getChildren().addAll(update, Delete);
					gethBox2().getChildren().add(l1);
					gethBox().getChildren().add(textField);
					getvBox().getChildren().add(lmassege);
					x = x + 1;
				}
			}
		});
		update.setOnAction(e -> {
			boolean check = true;
			if (textField.getText().length() == 0) {
				lmassege.setText("the text feild is empty");
				check = false;
			} else {
				for (int i = 0; i < textField.getText().length(); i++) {
					char c = textField.getText().charAt(i);
					if (!Character.isLetter(c)) {
						lmassege.setText("use charctars just");
						check = false;
						break;
					}

				}
			}
			if (check == true) {
				doublyLinkedList1.updateBrand((String) (getComboBox().getValue()), textField.getText());
//			getComboBox().setValue(textField.getText());
//			doublyLinkedList1.deleteBrand( ((String)(getComboBox().getValue())));
				lmassege.setText("its Done");

			}

		});
		Delete.setOnAction(e -> {
			try {
				WrongStage wrongStage = new WrongStage();

				wrongStage.getButton1().setOnAction(ex -> {
					doublyLinkedList1.deleteBrand((String) getComboBox().getValue());
					wrongStage.getStage().close();
				});
				wrongStage.getButton2().setOnAction(ex -> {
					wrongStage.getStage().close();
				});

			} catch (NumberFormatException ex) {

			}
		});

	}
}

class WrongStage {
	private Stage stage;
	private Scene scene;
	private Label label;
	private HBox box;
	private Button button1, button2;
	private VBox box2;

	public Label getLabel() {
		return label;
	}

	public void setLabel(Label label) {
		this.label = label;
	}

	public Button getButton1() {
		return button1;
	}

	public void setButton1(Button button1) {
		this.button1 = button1;
	}

	public Button getButton2() {
		return button2;
	}

	public void setButton2(Button button2) {
		this.button2 = button2;
	}

	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	public WrongStage() {

		stage = new Stage();
		label = new Label("are you sure you need to delete this Location??");
		button1 = new Button("yes");
		button2 = new Button("No");
		box = new HBox(40);
		box.getChildren().addAll(button1, button2);
		box2 = new VBox(5);
		box2.getChildren().addAll(label, box);
		box2.setAlignment(Pos.CENTER);
		scene = new Scene(box2, 250, 150);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();

	}
}