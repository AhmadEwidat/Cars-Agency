package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

//admin stages
public class AdmStages {

	private Button read, nextBrand, back, readOrd, nextCar, closeAll, ReadOrders, display;
	private HBox hBox, hBox2;
	private Scene scene;
	private ImageView imageView, imageView2, imageView3, imageView4, imView;
	private VBox vBoxs;

	public Button getNextCar() {
		return nextCar;
	}

	public void setNextCar(Button nextCar) {
		this.nextCar = nextCar;
	}

	public Button getRead() {
		return read;
	}

	public void setRead(Button read) {
		this.read = read;
	}

	public Button getNextBrand() {
		return nextBrand;
	}

	public void setNextBrand(Button nextBrand) {
		this.nextBrand = nextBrand;
	}

	public Button getBack() {
		return back;
	}

	public void setBack(Button back) {
		this.back = back;
	}

	public HBox gethBox() {
		return hBox;
	}

	public void sethBox(HBox hBox) {
		this.hBox = hBox;
	}

	public Scene getScene() {
		return scene;
	}

	public void setScene(Scene scene) {
		this.scene = scene;
	}

	public AdmStages(DoublyLinkedList1 dlinkedList, Stage stage, Scene scene1, LinkedListQueue linkedListQueue,
			Stack1 stack1) {
		display = new Button("last 10 buyed cars");
		ImageView im = new ImageView("search.png");
		im.setFitWidth(20);
		im.setFitHeight(20);
		ReadOrders = new Button("cheek orders", im);
		ReadOrders.setOnAction(e -> {
			CheckOrders checkOrders = new CheckOrders(stage, linkedListQueue, stack1, dlinkedList);
		});
		Label labels = new Label("you must read the cars file and read the orders file after any thing :");
		labels.setStyle("-fx-font-size:24;-fx-font-Weight:Bold;-fx-Color-fill:BROWN;-fx-Color-setBackground:BROWN");
		hBox2 = new HBox(30);
		vBoxs = new VBox(20);
		imView = new ImageView("close.png");
		VBox vBox2 = new VBox(50);
		VBox vBox1 = new VBox(50);
		Font font = new Font(40);
		ImageView imageView5 = new ImageView("next.png");
		imageView5.setFitWidth(20);
		imageView5.setFitHeight(20);
		nextCar = new Button("Car", imageView5);
		nextCar.setOnAction(e -> {
			NextCar nextCar = new NextCar(dlinkedList, stage, scene);
		});
		closeAll = new Button("Close", imView);
		closeAll.setFont(font);
		closeAll.setPrefWidth(200);
		closeAll.setPrefHeight(100);
		closeAll.setStyle("-fx-background-color:red");
		imView.setFitWidth(40);
		imView.setFitHeight(40);
		display.setFont(font);
		display.setPrefWidth(450);
		display.setPrefHeight(170);
		display.setStyle("-fx-border-color: white;-fx-background-color:red");
		nextCar.setFont(font);
		nextCar.setPrefWidth(200);
		nextCar.setPrefHeight(100);
		nextCar.setStyle("-fx-background-color:red");
		imageView = new ImageView("carFile.png");
		imageView2 = new ImageView("previous.png");
		imageView3 = new ImageView("next.png");
		imageView4 = new ImageView("file.png");
		imageView.setFitWidth(40);
		imageView.setFitHeight(40);
		imageView2.setFitWidth(20);
		imageView2.setFitHeight(20);
		imageView3.setFitWidth(20);
		imageView3.setFitHeight(20);
		imageView4.setFitHeight(20);
		imageView4.setFitWidth(20);
		ReadOrders.setStyle("-fx-border-color: white;-fx-background-color:red");
		ReadOrders.setFont(font);
		ReadOrders.setPrefWidth(450);
		ReadOrders.setPrefHeight(170);
		readOrd = new Button("Read orders from file", imageView4);
		readOrd.setStyle("-fx-border-color: white;-fx-background-color:red");
		readOrd.setFont(font);
		readOrd.setPrefWidth(450);
		readOrd.setPrefHeight(170);
		read = new Button("Read the cars file", imageView);
		read.setStyle("-fx-border-color: white;-fx-background-color:red");
		read.setFont(font);
		read.setPrefWidth(450);
		read.setPrefHeight(170);
		nextBrand = new Button("Brand", imageView3);
		nextBrand.setFont(font);
		nextBrand.setPrefWidth(200);
		nextBrand.setPrefHeight(100);
		nextBrand.setStyle("-fx-background-color:red");
		vBox1.getChildren().addAll(nextBrand, nextCar);
		back = new Button("Back", imageView2);
		back.setFont(font);
		back.setPrefWidth(200);
		back.setPrefHeight(100);
		back.setStyle("-fx-background-color:red");
		vBox2.getChildren().addAll(closeAll, back);
		hBox = new HBox(30);
		vBox1.setAlignment(Pos.CENTER);
		vBox2.setAlignment(Pos.CENTER);
//		hBox2.getChildren().addAll(read,readOrd);
		vBoxs.getChildren().addAll(labels, read, readOrd, ReadOrders, display);
		vBoxs.setAlignment(Pos.CENTER);
//		hBox2.setAlignment(Pos.CENTER);
		hBox.getChildren().addAll(vBox2, vBoxs, vBox1);
		hBox.setAlignment(Pos.CENTER);
		scene = new Scene(hBox, 400, 400);
		RadialGradient nR = new RadialGradient(0, 0, 0, 0, 1, true, // sizing
				CycleMethod.NO_CYCLE, // cycling
				new Stop(0, Color.web("#81c483")), // colors
				new Stop(1, Color.web("#fcc200")));

		// Change to your desired color
		BackgroundFill backgroundFill = new BackgroundFill(nR, CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY);
		Background background = new Background(backgroundFill);
		hBox.setBackground(background);

		read.setOnAction(e -> {
			try {
				FileChooser fileChooser = new FileChooser();
				File selector = fileChooser.showOpenDialog(stage);
				if (selector != null) {
					BufferedReader scan = new BufferedReader(new FileReader(selector));
					scan.readLine();
					String line;
					while ((line = scan.readLine()) != null) {
						String[] list = line.split(",");
						if (list[4].contains("K")) {
							list[4] = list[4].substring(0, list[4].length() - 1);
							list[4] = list[4] + ("000");

						}
						dlinkedList.insertOrUpdateCar(list[0].strip(), new Car(list[0].strip(), list[1].strip(),
								Integer.valueOf(list[2].strip()), list[3].strip(), Double.valueOf(list[4].strip())));

					}

				}
				labels.setText("The cars file has been read");
			} catch (NumberFormatException | IOException ex) {
				System.out.println(ex.getMessage());
			}
		});
		ReadOrders.setDisable(true);
		display.setDisable(true);
		readOrd.setOnAction(e -> {
			try {
				FileChooser fileChooser = new FileChooser();
				File selector = fileChooser.showOpenDialog(stage);
				if (selector != null) {
					BufferedReader scan = new BufferedReader(new FileReader(selector));
					scan.readLine();
					String line;
					while ((line = scan.readLine()) != null) {
						String[] list = line.split(",");
						if (list[6].contains("K")) {
							list[6] = list[6].substring(0, list[4].length() - 1);
							list[6] = list[6] + ("000");

						}
						String[] DateList = list[7].split("/");
						if (list[8].strip().equals("Finished")) {
							stack1.push(new Order(
									new Car(list[2].strip(), list[3].strip(), Integer.valueOf(list[4].strip()),
											list[5].strip(), Double.valueOf(list[6].strip())),
									new Customer(list[0].strip(), Integer.valueOf(list[1].strip())),
									new Date(Integer.valueOf(DateList[2].strip()) - 1900,
											Integer.valueOf(DateList[0].strip()) - 1,
											Integer.valueOf(DateList[1].strip())),
									list[8].strip()));
						} else if (list[8].strip().equals("InProcess")) {
							linkedListQueue.enqueue(new Order(
									new Car(list[2].strip(), list[3].strip(), Integer.valueOf(list[4].strip()),
											list[5].strip(), Double.valueOf(list[6].strip())),
									new Customer(list[0].strip(), Integer.valueOf(list[1].strip())),
									new Date(Integer.valueOf(DateList[2].strip()) - 1900,
											Integer.valueOf(DateList[0].strip()) - 1,
											Integer.valueOf(DateList[1].strip())),
									list[8].strip()));
						}

					}

				}
				labels.setText("The orders file has been read");
				ReadOrders.setDisable(false);
				display.setDisable(false);
			} catch (NumberFormatException | IOException ex) {
				System.out.println(ex.getMessage());
			}
		});
		back.setOnAction(e -> {
			stage.setScene(scene1);
			stage.setFullScreen(true);
		});
		nextBrand.setOnAction(e -> {
			Next n = new Next(dlinkedList, stage, scene);
		});
		closeAll.setOnAction(e -> {
			try {
				WrongStage wrongStage = new WrongStage();
				wrongStage.getLabel().setText("are you sure ?\n If you press yes, the program will close");
				wrongStage.getButton1().setOnAction(ex -> {
					stage.close();
					wrongStage.getStage().close();
				});
				wrongStage.getButton2().setOnAction(ex -> {
					wrongStage.getStage().close();
				});

			} catch (NumberFormatException ex) {

			}
		});
		display.setOnAction(e -> {
			Display displa = new Display(stack1, stage);
		});

	}
}

class Next {
	private Scene scene;
	private Button add, update, search, Back, close;
	private VBox vBox;
	private Label label;

	public Scene getScene() {
		return scene;
	}

	public void setScene(Scene scene) {
		this.scene = scene;
	}

	public Button getAdd() {
		return add;
	}

	public void setAdd(Button add) {
		this.add = add;
	}

	public Button getUpdate() {
		return update;
	}

	public void setUpdate(Button update) {
		this.update = update;
	}

	public Button getSearch() {
		return search;
	}

	public void setSearch(Button search) {
		this.search = search;
	}

	public Button getBack() {
		return Back;
	}

	public void setBack(Button back) {
		Back = back;
	}

	public Button getClose() {
		return close;
	}

	public void setClose(Button close) {
		this.close = close;
	}

	public VBox getvBox() {
		return vBox;
	}

	public void setvBox(VBox vBox) {
		this.vBox = vBox;
	}

	public Label getLabel() {
		return label;
	}

	public void setLabel(Label label) {
		this.label = label;
	}

	public Next(DoublyLinkedList1 doublyLinkedList1, Stage stage, Scene scene2) {
		Font font = new Font(30);
		Back = new Button("Back");
		close = new Button("Close");
		Back.setStyle("-fx-border-color: Black;-fx-background-color:White");
		Back.setFont(font);
		Back.setPrefWidth(350);
		Back.setPrefHeight(100);
		close.setStyle("-fx-border-color: Black;-fx-background-color:White");
		close.setFont(font);
		close.setPrefWidth(350);
		close.setPrefHeight(100);
		label = new Label("please search for the brand you want\n" + " if you want to delete or update it :");
		label.setStyle("-fx-font-size:24;-fx-font-Weight:Bold;-fx-Color-fill:BROWN;-fx-Color-setBackground:BROWN");

		add = new Button("Add new Brand");
		update = new Button("Update/delete Brand ");
		search = new Button("Searching for Brand");

		add.setStyle("-fx-border-color: Black;-fx-background-color:White");
		add.setFont(font);
		add.setPrefWidth(350);
		add.setPrefHeight(100);
		update.setStyle("-fx-border-color: Black;-fx-background-color:White");
		update.setFont(font);
		update.setPrefWidth(350);
		update.setPrefHeight(100);
		search.setStyle("-fx-border-color: Black;-fx-background-color:White");
		search.setFont(font);
		search.setPrefWidth(350);
		search.setPrefHeight(100);
		vBox = new VBox(20);
		vBox.getChildren().addAll(label, search, add, update, Back, close);
		vBox.setAlignment(Pos.CENTER);
		scene = new Scene(vBox);
		stage.setScene(scene);
		stage.setFullScreen(true);
		RadialGradient nR = new RadialGradient(0, 0, 0, 0, 1, true, // sizing
				CycleMethod.NO_CYCLE, // cycling
				new Stop(0, Color.web("#81c483")), // colors
				new Stop(1, Color.web("#fcc200")));

		// Change to your desired color
		BackgroundFill backgroundFill = new BackgroundFill(nR, CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY);
		Background background = new Background(backgroundFill);
		vBox.setBackground(background);
		search.setOnAction(e -> {
			Search search1 = new Search(doublyLinkedList1, stage);

		});
		add.setOnAction(e -> {
			Insert insert = new Insert(doublyLinkedList1, stage);
		});
		update.setOnAction(e -> {
			Update update = new Update(doublyLinkedList1, stage);
		});
		close.setOnAction(e -> {

			try {
				WrongStage wrongStage = new WrongStage();
				wrongStage.getLabel().setText("are you sure ?\n If you press yes, the program will close");
				wrongStage.getButton1().setOnAction(ex -> {
					stage.close();
					wrongStage.getStage().close();
				});
				wrongStage.getButton2().setOnAction(ex -> {
					wrongStage.getStage().close();
				});

			} catch (NumberFormatException ex) {

			}

		});
		Back.setOnAction(e -> {
			stage.setScene(scene2);
			stage.setFullScreen(true);
		});

	}

}

class NextCar extends Next {

	public NextCar(DoublyLinkedList1 doublyLinkedList1, Stage stage, Scene scene11) {
		super(doublyLinkedList1, stage, scene11);
		getSearch().setText("Searching for car");
		getUpdate().setText("Update/Delete car");
		getAdd().setText("Add new car");
		getAdd().setOnAction(e -> {
			InsertCar insertCar = new InsertCar(doublyLinkedList1, stage, getScene());
		});

	}

}
