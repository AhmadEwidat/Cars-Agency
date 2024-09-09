package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
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

public class Search {
	private Label label1;
	private ComboBox comboBox;
	private VBox vBox;
	private Scene scene1;
	private Stage stage1;
	private HBox hBox, hBox2, hBox3;
	private Button b;

	public Button getB() {
		return b;
	}

	public void setB(Button b) {
		this.b = b;
	}

	public Label getLabel1() {
		return label1;
	}

	public void setLabel1(Label label1) {
		this.label1 = label1;
	}

	public ComboBox getComboBox() {
		return comboBox;
	}

	public void setComboBox(ComboBox comboBox) {
		this.comboBox = comboBox;
	}

	public VBox getvBox() {
		return vBox;
	}

	public void setvBox(VBox vBox) {
		this.vBox = vBox;
	}

	public Scene getScene1() {
		return scene1;
	}

	public void setScene1(Scene scene1) {
		this.scene1 = scene1;
	}

	public Stage getStage1() {
		return stage1;
	}

	public void setStage1(Stage stage1) {
		this.stage1 = stage1;
	}

	public HBox gethBox() {
		return hBox;
	}

	public void sethBox(HBox hBox) {
		this.hBox = hBox;
	}

	public HBox gethBox2() {
		return hBox2;
	}

	public void sethBox2(HBox hBox2) {
		this.hBox2 = hBox2;
	}

	public HBox gethBox3() {
		return hBox3;
	}

	public void sethBox3(HBox hBox3) {
		this.hBox3 = hBox3;
	}

	public Search(DoublyLinkedList1 doublyLinkedList1, Stage stage) {
		hBox = new HBox(100);
		hBox2 = new HBox(50);
		hBox3 = new HBox(30);
		RadialGradient nR = new RadialGradient(0, 0, 0, 0, 1, true, // sizing
				CycleMethod.NO_CYCLE, // cycling
				new Stop(0, Color.web("#81c483")), // colors
				new Stop(1, Color.web("#fcc200")));

		// Change to your desired color
		BackgroundFill backgroundFill = new BackgroundFill(nR, CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY);
		Background background = new Background(backgroundFill);

		ImageView imageView = new ImageView("left-arrow.png");
		imageView.setFitWidth(20);
		imageView.setFitHeight(20);
		b = new Button("back", imageView);
		doublyLinkedList1.display();
		label1 = new Label("search if the Brand you need in\n" + " the brands avilabile :");
		ObservableList observableList = FXCollections.observableArrayList(doublyLinkedList1.getArrayList());
		comboBox = new ComboBox();
		comboBox.setPrefWidth(200);
		comboBox.getItems().addAll(observableList);
		vBox = new VBox(40);
		hBox.getChildren().add(comboBox);
		;
		hBox2.getChildren().add(label1);
		hBox.setAlignment(Pos.CENTER);
		hBox2.setAlignment(Pos.CENTER);
		hBox3.getChildren().add(b);
		hBox3.setAlignment(Pos.CENTER);
		vBox.getChildren().addAll(hBox2, hBox, hBox3);
		scene1 = new Scene(vBox, 400, 250);
		stage1 = new Stage();
		stage1.setScene(scene1);
		stage1.show();
		stage1.setTitle("search stage");
		label1.setStyle("-fx-font-size:24;-fx-font-Weight:Bold;-fx-Color-fill:BROWN;-fx-Color-setBackground:BROWN");
		ColorPicker colorPicker3 = new ColorPicker(Color.web("#ffcce6"));
		vBox.setBackground(background);
		vBox.setAlignment(Pos.CENTER);
		vBox.setBackground(background);
		stage1.setFullScreen(true);
		b.setOnAction(ex -> {
			stage1.close();
			stage.setFullScreen(true);
		});
		comboBox.setOnAction(en -> {
			try {
				if (vBox.getChildren().size() == 3) {

					ImageView imageView4 = new ImageView(((String) comboBox.getValue()).concat(".png"));
					vBox.getChildren().add(imageView4);
					System.out.println(((String) comboBox.getValue()).concat(".png"));
				} else {
					ImageView imageView4 = new ImageView(((String) comboBox.getValue()).concat(".png"));
					vBox.getChildren().set(3, imageView4);
				}
			} catch (Exception ee) {
				Label l3 = new Label("I'm sorry, but I couldn't find a picture");
				vBox.getChildren().add(l3);
			}

		});

	}
}