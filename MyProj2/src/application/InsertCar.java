package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.stage.Stage;

//to insert new car to brand
public class InsertCar extends Search {
	private Scene scene1;
	private Button Add;
	private Label l11, lmassege;
	int x = 0;
	private Stage stage;
	private Label l0, l1, l2, l3, l4, lcoment;
	private TextField t1, t2, t3, t4;
	private HBox h0, h1, h2, h3, h4, h5, h, hbutton, hBox;
	private GridPane gridPane;
	private Scene scene;
	private Button button, cancel;
	private RadioButton radioButton, radioButton2;
	private ToggleGroup group;
	private char gender;

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	public Label getL0() {
		return l0;
	}

	public void setL0(Label l0) {
		this.l0 = l0;
	}

	public Label getL1() {
		return l1;
	}

	public void setL1(Label l1) {
		this.l1 = l1;
	}

	public Label getL2() {
		return l2;
	}

	public void setL2(Label l2) {
		this.l2 = l2;
	}

	public Label getL3() {
		return l3;
	}

	public void setL3(Label l3) {
		this.l3 = l3;
	}

	public Label getL4() {
		return l4;
	}

	public void setL4(Label l4) {
		this.l4 = l4;
	}

	public TextField getT1() {
		return t1;
	}

	public void setT1(TextField t1) {
		this.t1 = t1;
	}

	public TextField getT2() {
		return t2;
	}

	public void setT2(TextField t2) {
		this.t2 = t2;
	}

	public TextField getT3() {
		return t3;
	}

	public void setT3(TextField t3) {
		this.t3 = t3;
	}

	public TextField getT4() {
		return t4;
	}

	public void setT4(TextField t4) {
		this.t4 = t4;
	}

	public HBox getH0() {
		return h0;
	}

	public void setH0(HBox h0) {
		this.h0 = h0;
	}

	public HBox getH1() {
		return h1;
	}

	public void setH1(HBox h1) {
		this.h1 = h1;
	}

	public HBox getH2() {
		return h2;
	}

	public void setH2(HBox h2) {
		this.h2 = h2;
	}

	public HBox getH3() {
		return h3;
	}

	public void setH3(HBox h3) {
		this.h3 = h3;
	}

	public HBox getH4() {
		return h4;
	}

	public void setH4(HBox h4) {
		this.h4 = h4;
	}

	public HBox getH() {
		return h;
	}

	public void setH(HBox h) {
		this.h = h;
	}

	public HBox getHbutton() {
		return hbutton;
	}

	public void setHbutton(HBox hbutton) {
		this.hbutton = hbutton;
	}

	public GridPane getGridPane() {
		return gridPane;
	}

	public void setGridPane(GridPane gridPane) {
		this.gridPane = gridPane;
	}

	public Scene getScene() {
		return scene;
	}

	public void setScene(Scene scene) {
		this.scene = scene;
	}

	public Button getButton() {
		return button;
	}

	public void setButton(Button button) {
		this.button = button;
	}

	public Button getCancel() {
		return cancel;
	}

	public void setCancel(Button cancel) {
		this.cancel = cancel;
	}

	public InsertCar(DoublyLinkedList1 doublyLinkedList1, Stage stage3, Scene scene2) {
		super(doublyLinkedList1, stage3);
		getStage1().close();
		button = new Button("Insert");
		cancel = new Button("cancel");
		hbutton = new HBox(10);
		hbutton.getChildren().addAll(button, cancel);
		cancel.setOnAction(e -> {
			stage3.close();
		});
		lcoment = new Label();
		l0 = new Label("please fill the next information :");
		l1 = new Label("Model");
		l2 = new Label("Year");
		l3 = new Label("Color");
		l4 = new Label("Price");
		t1 = new TextField();
		t2 = new TextField();
		t3 = new TextField();
		t4 = new TextField();
		h0 = new HBox();
		h0.getChildren().add(l0);
		h1 = new HBox(43);
		h1.getChildren().addAll(l1, t1);
		h2 = new HBox(56);
		h2.getChildren().addAll(l2, t2);
		h3 = new HBox(51);
		h3.getChildren().addAll(l3, t3);
		h4 = new HBox(53);
		h4.getChildren().addAll(l4, t4);
		h5 = new HBox(45);
		gridPane = new GridPane();
		gridPane.setVgap(10);
		gridPane.add(h0, 0, 0);
		gridPane.add(h1, 0, 1);
		gridPane.add(h2, 0, 2);
		gridPane.add(h3, 0, 3);
		gridPane.add(h4, 0, 4);
		gridPane.add(h5, 0, 5);
		gridPane.add(lcoment, 0, 6);
		gridPane.add(hbutton, 0, 7);
		hbutton.setAlignment(Pos.CENTER);
		l0.setStyle("-fx-Text-Fill:Black;-fx-font-size:24;-fx-font-weight:BOLD;");
		l1.setStyle("-fx-Text-Fill:Black;-fx-font-size:15;-fx-font-weight:BOLD;");
		l2.setStyle("-fx-Text-Fill:Black;-fx-font-size:15;-fx-font-weight:BOLD;");
		l3.setStyle("-fx-Text-Fill:Black;-fx-font-size:15;-fx-font-weight:BOLD;");
		l4.setStyle("-fx-Text-Fill:Black;-fx-font-size:15;-fx-font-weight:BOLD;");
		lmassege = new Label("");
		l1 = new Label("please enter the Updeted Brand :");
		l1.setStyle("-fx-font-size:24;-fx-font-Weight:Bold;-fx-Color-fill:BROWN;-fx-Color-setBackground:BROWN");
		Add = new Button("Add");
		SplitPane s = new SplitPane();
		s.getItems().addAll(getvBox());
		gridPane.setAlignment(Pos.CENTER);
		Scene cs = new Scene(s);
		stage3.setScene(cs);
		stage3.setFullScreen(true);
		getB().setOnAction(e -> {
			stage3.setScene(scene2);
			stage3.setFullScreen(true);
		});
		RadialGradient nR = new RadialGradient(0, 0, 0, 0, 1, true, // sizing
				CycleMethod.NO_CYCLE, // cycling
				new Stop(0, Color.web("#81c483")), // colors
				new Stop(1, Color.web("#fcc200")));

		// Change to your desired color
		BackgroundFill backgroundFill = new BackgroundFill(nR, CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY);
		Background background = new Background(backgroundFill);
		gridPane.setBackground(background);
		getComboBox().setOnAction(e -> {
			if (x == 0) {
				if (getComboBox().getValue() == null) {

				} else {
					s.getItems().addAll(gridPane);
					x = x + 1;
				}
			}
		});
		button.setOnAction(e -> {

			boolean check = true;
			if (t2.getText().length() == 0) {
				lcoment.setText("the text feild is empty");
				check = false;
			} else {

				for (int i = 0; i < t2.getText().length(); i++) {
					char c = t2.getText().charAt(i);
					if (!Character.isDigit(c)) {
						lcoment.setText("use numbers between 1900-2023 just in text feild 2");
						check = false;
						break;
					}
				}
				if (check == true) {
					if (!(Integer.valueOf(t2.getText()) >= 1900) || !(Integer.valueOf(t2.getText()) <= 2023)) {
						lcoment.setText("use numbers between 1900-2023 just");
						check = false;
					}
				}

			}
			if (t3.getText().length() == 0) {
				lcoment.setText("the text feild is empty");
				check = false;
			} else {
				for (int i = 0; i < t3.getText().length(); i++) {
					char c = t3.getText().charAt(i);
					if (!Character.isLetter(c)) {
						check = false;
						lcoment.setText("use just charctar");
						break;
					}

				}
			}
			if (t4.getText().length() == 0) {
				lcoment.setText("the text feild is empty");
				check = false;
			} else {
				if (t4.getText().charAt(t4.getText().length() - 1) == 'k') {
					t4.setText(t4.getText().substring(0, t4.getText().length() - 1));
					t4.setText(t4.getText().concat("000"));

				}
				for (int i = 0; i < t4.getText().length(); i++) {
					char c = t4.getText().charAt(i);
					if (!Character.isDigit(c)) {
						lcoment.setText("use numbers between 1900-2023 just in text feild 2");
						check = false;
						break;
					}
				}
			}

			if (check == true) {
				try {
					doublyLinkedList1.insertOrUpdateCar((String) getComboBox().getValue(),
							new Car((String) getComboBox().getValue(), t1.getText(), Integer.valueOf(t2.getText()),
									t3.getText(), Double.valueOf(t4.getText())));
					lcoment.setText("Its Done");
				}

				catch (NumberFormatException e2) {
					lcoment.setText(e2.getMessage());
				}
			}
		});
	}

}
