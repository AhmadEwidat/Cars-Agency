package application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.image.ImageView;
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

//customer stages
public class CustStages {
	private TextArea textArea;
	private Button next, Back;
	private HBox hBox;
	private VBox vBox;
	private ImageView imageView, imageView2;
	private ObservableList observableList;

	public CustStages(Stage stage, DoublyLinkedList1 doublyLinkedList1, LinkedListQueue linkedListQueue,
			Stack1 stack1) throws FileNotFoundException {
		String filePath = "C:\\Users\\Dell\\Downloads\\cars.txt"; // Replace with the actual file path

		try (Scanner scanner = new Scanner(new File(filePath))) {
			scanner.nextLine(); // Skip the first line

			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String[] list = line.split(",");
				if (list[4].contains("K")) {
					list[4] = list[4].substring(0, list[4].length() - 1);
					list[4] = list[4] + ("000");
				}
				doublyLinkedList1.insertOrUpdateCar(list[0].strip(), new Car(list[0].strip(), list[1].strip(),
						Integer.valueOf(list[2].strip()), list[3].strip(), Double.valueOf(list[4].strip())));
			}
		} catch (NumberFormatException ex) {
			System.out.println(ex.getMessage());
		}
		String filePath2 = "C:\\Users\\Dell\\Downloads\\orders.txt"; // Replace with the actual file path

		try (Scanner scanner = new Scanner(new File(filePath2))) {
			scanner.nextLine(); // Skip the first line

			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String[] list = line.split(",");
				if (list[6].contains("K")) {
					list[6] = list[6].substring(0, list[6].length() - 1);
					list[6] = list[6] + ("000");
				}
				String[] DateList = list[7].split("/");
				if (list[8].strip().equals("Finished")) {
					stack1.push(new Order(
							new Car(list[2].strip(), list[3].strip(), Integer.valueOf(list[4].strip()), list[5].strip(),
									Double.valueOf(list[6].strip())),
							new Customer(list[0].strip(), Integer.valueOf(list[1].strip())),
							new Date(Integer.valueOf(DateList[2].strip()) - 1900,
									Integer.valueOf(DateList[0].strip()) - 1, Integer.valueOf(DateList[1].strip())),
							list[8].strip()));
				} else if (list[8].strip().equals("InProcess")) {
					linkedListQueue.enqueue(new Order(
							new Car(list[2].strip(), list[3].strip(), Integer.valueOf(list[4].strip()), list[5].strip(),
									Double.valueOf(list[6].strip())),
							new Customer(list[0].strip(), Integer.valueOf(list[1].strip())),
							new Date(Integer.valueOf(DateList[2].strip()) - 1900,
									Integer.valueOf(DateList[0].strip()) - 1, Integer.valueOf(DateList[1].strip())),
							list[8].strip()));
				}
			}
		} catch (NumberFormatException ex) {

		}
		doublyLinkedList1.display();
		observableList = FXCollections.observableArrayList(doublyLinkedList1.getArrayList());
		
		Label l = new Label("show the avilibale cars :");
		l.setStyle("-fx-font-size:24;-fx-font-Weight:Bold;-fx-Color-fill:BROWN;-fx-Color-setBackground:BROWN");
		imageView = new ImageView("next.png");
		textArea = new TextArea();
		next = new Button("", imageView);
		imageView2 = new ImageView("previous.png");
		Back = new Button("", imageView2);
		hBox = new HBox(10);
		hBox.getChildren().addAll(Back, textArea, next);
		imageView.setFitWidth(40);
		imageView.setFitHeight(40);
		imageView2.setFitWidth(40);
		imageView2.setFitHeight(40);
		Label nameLabel = new Label("Name:");
		TextField nameTextField = new TextField();
		nameTextField.setMaxWidth(150);
		Label brandLabel = new Label("Brand:");
		ComboBox brandComboBox = new ComboBox();
		brandComboBox.getItems().addAll(observableList);

		Label modelLabel = new Label("Model:");
		TextField modelTextField = new TextField();
		modelTextField.setMaxWidth(150);
		Label yearLabel = new Label("Year:");
		TextField yearTextField = new TextField();
		yearTextField.setMaxWidth(150);
		Button placeOrderButton = new Button("Place Order");

		// Create a grid pane and add the form controls
		GridPane gridPane = new GridPane();
		gridPane.setPadding(new Insets(10));
		gridPane.setHgap(10);
		gridPane.setVgap(10);
		gridPane.add(l, 0, 1);
		gridPane.add(brandComboBox, 1, 1);

		gridPane.add(placeOrderButton, 1, 2);
//		gridPane.add(hBox, 1, 5);
		VBox vb = new VBox(20);
		vb.getChildren().addAll(gridPane, hBox);
		hBox.setAlignment(Pos.CENTER);
		gridPane.setAlignment(Pos.CENTER);
		RadialGradient nR = new RadialGradient(0, 0, 0, 0, 1, true, // sizing
				CycleMethod.NO_CYCLE, // cycling
				new Stop(0, Color.web("#81c483")), // colors
				new Stop(1, Color.web("#fcc200")));

		// Change to your desired color
		BackgroundFill backgroundFill = new BackgroundFill(nR, CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY);
		Background background = new Background(backgroundFill);
		vb.setBackground(background);
		vb.setAlignment(Pos.CENTER);
		// Create a scene with the grid pane
		Scene scene = new Scene(vb, 800, 600);
		stage.setScene(scene);
		stage.setFullScreen(true);
		brandComboBox.setOnAction(e -> {
			if (brandComboBox.getValue() != null) {
				doublyLinkedList1.displayAllCarsByBrand((String) brandComboBox.getValue());
				textArea.setText(doublyLinkedList1.getString());

			}
		});
		next.setOnAction(e -> {
			brandComboBox.getSelectionModel().selectNext();
		});
		Back.setOnAction(e -> {
			brandComboBox.getSelectionModel().selectPrevious();
		});
		placeOrderButton.setOnAction(e -> {
			stage.close();
			PlaceOrder orde = new PlaceOrder(brandComboBox, stage, doublyLinkedList1);
			stage.setFullScreen(true);

		});
	}
}

class PlaceOrder {
	private Label label, name, phone;
	private TextField textField, textField2;
	private GridPane gridPane;
	private Stage stage;
	private Scene scene;
	private Button button, Back;
	private HBox hBox;
	private VBox bigBox;
	private int phonenum = 0;
	private String userName = "";
	private Customer customer;

	public int getPhonenum() {
		return phonenum;
	}

	public void setPhonenum(int phonenum) {
		this.phonenum = phonenum;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public VBox getBigBox() {
		return bigBox;
	}

	public void setBigBox(VBox bigBox) {
		this.bigBox = bigBox;
	}

	public Button getBack() {
		return Back;
	}

	public void setBack(Button back) {
		Back = back;
	}

	public Label getLabel() {

		return label;
	}

	public void setLabel(Label label) {
		this.label = label;
	}

	public Label getName() {
		return name;
	}

	public void setName(Label name) {
		this.name = name;
	}

	public Label getPhone() {
		return phone;
	}

	public void setPhone(Label phone) {
		this.phone = phone;
	}

	public TextField getTextField() {
		return textField;
	}

	public void setTextField(TextField textField) {
		this.textField = textField;
	}

	public TextField getTextField2() {
		return textField2;
	}

	public void setTextField2(TextField textField2) {
		this.textField2 = textField2;
	}

	public GridPane getGridPane() {
		return gridPane;
	}

	public void setGridPane(GridPane gridPane) {
		this.gridPane = gridPane;
	}

	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
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

	public PlaceOrder(ComboBox comboBox, Stage stag2, DoublyLinkedList1 doublyLinkedList1) {
		hBox = new HBox(10);
		Back = new Button("Back");
		button = new Button("next");
		label = new Label("please enter the personal information :");
		label.setStyle("-fx-font-size:24;-fx-font-Weight:Bold;-fx-Color-fill:BROWN;-fx-Color-setBackground:BROWN");
		textField = new TextField();
		textField2 = new TextField();
		textField.setMaxWidth(150);
		textField2.setMaxWidth(150);
		name = new Label("Name");
		phone = new Label("Phone");
		name.setStyle("-fx-font-size:24;-fx-font-Weight:Bold;-fx-Color-fill:BROWN;-fx-Color-setBackground:BROWN");
		phone.setStyle("-fx-font-size:24;-fx-font-Weight:Bold;-fx-Color-fill:BROWN;-fx-Color-setBackground:BROWN");
		hBox.getChildren().addAll(Back, button);
		gridPane = new GridPane();
		gridPane.add(label, 1, 0);
		gridPane.add(name, 0, 1);
		gridPane.add(phone, 0, 2);
		gridPane.add(textField, 1, 1);
		gridPane.add(textField2, 1, 2);
		gridPane.add(hBox, 1, 3);
		gridPane.setAlignment(Pos.CENTER);
		gridPane.setVgap(10);
		gridPane.setHgap(10);
		RadialGradient nR = new RadialGradient(0, 0, 0, 0, 1, true, // sizing
				CycleMethod.NO_CYCLE, // cycling
				new Stop(0, Color.web("#81c483")), // colors
				new Stop(1, Color.web("#fcc200")));

		// Change to your desired color
		BackgroundFill backgroundFill = new BackgroundFill(nR, CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY);
		Background background = new Background(backgroundFill);
		Label lcoment = new Label("");
		bigBox = new VBox(10);
		bigBox.setBackground(background);
		stage = new Stage();
		bigBox.getChildren().addAll(gridPane, lcoment);
		bigBox.setAlignment(Pos.CENTER);
		scene = new Scene(bigBox, 800, 600);
		stage.setFullScreen(true);
		stage.setScene(scene);
		stage.show();
		button.setOnAction(e -> {
			boolean check = true;
			if (textField.getText().length() == 0) {
				lcoment.setText("the text feild is empty");
				check = false;
			} else {
				for (int i = 0; i < textField.getText().length(); i++) {
					char c = textField.getText().charAt(i);
					if (!Character.isLetter(c)) {
						check = false;
						lcoment.setText("use just charctar in name feild");
						break;
					}

				}
			}
			if (textField2.getText().length() == 0) {
				lcoment.setText("The text field is empty");
				check = false;
			} else {
				for (int i = 0; i < textField2.getText().length(); i++) {
					char c = textField2.getText().charAt(i);
					if (!Character.isDigit(c)) {
						check = false;
						lcoment.setText("Use only letters in the phone field");
						break;
					}
				}
			}

			try {
				if (check == true) {
					phonenum = Integer.valueOf(textField2.getText());
					userName = textField.getText();
					customer = new Customer(textField.getText(), Integer.valueOf(textField2.getText()));
					stage.close();
					CarInfo carInfo = new CarInfo(comboBox, stage, doublyLinkedList1);
				}
			} catch (NumberFormatException ex) {

			}

		});
		Back.setOnAction(e -> {
			stage.close();
			stag2.show();
			stag2.setFullScreen(true);
		});
	}
}

class CarInfo extends PlaceOrder {
	private Label year, color, price, minYear, minPrice;
	private TextField textField, textField2, textField3, minfeild, minPriceFeild;
	private Button filter;
	private TextArea area;
	private VBox vBox, bigvBox;

	public CarInfo(ComboBox comboBox, Stage stage2, DoublyLinkedList1 doublyLinkedList1) {
		super(comboBox, stage2, doublyLinkedList1);
		getLabel().setText("Car information :");
		getGridPane().getChildren().remove(5);
		year = new Label("Max Year");
		minYear = new Label("MinYear");
		minYear.setStyle("-fx-font-size:24;-fx-font-Weight:Bold;-fx-Color-fill:BROWN;-fx-Color-setBackground:BROWN");
		minfeild = new TextField();
		minPriceFeild = new TextField();
		color = new Label("Color");
		price = new Label("Max Price");
		minPrice = new Label("Min Price");
		minPrice.setStyle("-fx-font-size:24;-fx-font-Weight:Bold;-fx-Color-fill:BROWN;-fx-Color-setBackground:BROWN");
		year.setStyle("-fx-font-size:24;-fx-font-Weight:Bold;-fx-Color-fill:BROWN;-fx-Color-setBackground:BROWN");
		color.setStyle("-fx-font-size:24;-fx-font-Weight:Bold;-fx-Color-fill:BROWN;-fx-Color-setBackground:BROWN");
		price.setStyle("-fx-font-size:24;-fx-font-Weight:Bold;-fx-Color-fill:BROWN;-fx-Color-setBackground:BROWN");
		getName().setText("Brand");
		getPhone().setText("Model");
		textField = new TextField();
		textField2 = new TextField();
		textField3 = new TextField();
		filter = new Button("filter");
		area = new TextArea();
		area.setMaxWidth(400);
		vBox = new VBox(10);
		vBox.getChildren().addAll(area, filter, getButton());
		TextFormatter<String> textFormatter = new TextFormatter<>(change -> {
			if (!change.getControlNewText().matches("[a-zA-Z]*")) {
				change.setText("");
			}
			return change;
		});
		TextFormatter<String> textFormatter1 = new TextFormatter<>(change -> {
			if (!change.getControlNewText().matches("[a-zA-Z]*")) {
				change.setText("");
			}
			return change;
		});
		TextFormatter<String> textFormatter2 = new TextFormatter<>(change -> {
			if (!change.getControlNewText().matches("\\d*")) {
				change.setText("");
			}
			return change;
		});

		textField.setTextFormatter(textFormatter2);
		TextFormatter<String> textFormatter3 = new TextFormatter<>(change -> {
			if (!change.getControlNewText().matches("\\d*")) {
				change.setText("");
			}
			return change;
		});
		TextFormatter<String> textFormatter4 = new TextFormatter<>(change -> {
			if (!change.getControlNewText().matches("\\d*")) {
				change.setText("");
			}
			return change;
		});
		TextFormatter<String> textFormatter5 = new TextFormatter<>(change -> {
			if (!change.getControlNewText().matches("\\d*")) {
				change.setText("");
			}
			return change;
		});
		textField3.setTextFormatter(textFormatter5);

		minPriceFeild.setTextFormatter(textFormatter4);

		minfeild.setTextFormatter(textFormatter3);
		textField2.setTextFormatter(textFormatter1);

		getGridPane().add(year, 0, 4);
		getGridPane().add(minYear, 2, 4);
		getGridPane().add(minfeild, 3, 4);
		getGridPane().add(color, 0, 5);
		getGridPane().add(price, 0, 6);
		getGridPane().add(minPrice, 2, 6);
		getGridPane().add(minPriceFeild, 3, 6);
		getGridPane().add(textField, 1, 4);
		getGridPane().add(textField2, 1, 5);
		getGridPane().add(textField3, 1, 6);
		getGridPane().getChildren().set(3, comboBox);
//		getGridPane().add(getButton(), 2, 7);
		getGridPane().add(getBack(), 1, 7);
		getBigBox().getChildren().add(vBox);
		vBox.setAlignment(Pos.CENTER);
		getButton().setText("buy");
		textField.setMaxWidth(150);
		textField2.setMaxWidth(150);
		textField3.setMaxWidth(150);
		getStage().setFullScreen(true);
//		getButton().setDisable(true);
		filter.setOnAction(e -> {
			try {
				if (minfeild.getText().isEmpty()) {
					minfeild.setText("0");
				}
				if (textField.getText().isEmpty()) {
					textField.setText("2023");
				}
				if (minPriceFeild.getText().isEmpty()) {
					minPriceFeild.setText("0");
				}
				if (textField3.getText().isEmpty()) {
					textField3.setText("1000000");
				}

				doublyLinkedList1.filter((String) comboBox.getValue(), getTextField2().getText(), textField2.getText(),
						Integer.valueOf(minfeild.getText()), Integer.valueOf(textField.getText()),
						Double.valueOf(minPriceFeild.getText()), Double.valueOf(textField3.getText()));

				area.setText(doublyLinkedList1.getString());
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
			}
		});
		Date currentDate = new Date();
		int year = currentDate.getYear() + 1900; // Add 1900 to get the actual year
		int month = currentDate.getMonth() + 1; // Add 1 to get the actual month (0-indexed)
		int day = currentDate.getDate();
		getButton().setOnAction(e -> {
			try (FileWriter writer = new FileWriter("C:\\Users\\Dell\\Downloads\\orders.txt", true)) {
				String carInformation = "\n" + getUserName() + ", " + getPhone() + ", "
						+ doublyLinkedList1.getCar().toString1() + ", " + year + "/" + month + "/" + day + ", "
						+ "InProcess" + "\n";
				writer.write(carInformation);
				getLabel().setText("Thank you for dealing with us\r\n"
						+ "The purchase is being verified");
			} catch (IOException ex) {
				getLabel().setText("Wrong , not complete");
			}

		});

//	

	}
}
//  bufferedWriter.write(getUserName()+","+getPhone().toString()+","+ doublyLinkedList1.getCar().getBrand()+","+ doublyLinkedList1.getCar().getmodel()+","+ doublyLinkedList1.getCar().getYear());