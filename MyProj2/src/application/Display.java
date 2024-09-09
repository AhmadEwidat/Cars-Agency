package application;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.stage.Stage;

//to display last 10 are bayed
public class Display {
	private TextArea label;
	private VBox vbox;
	private Scene scene;
	private Stage stage;
	private int num = 0;
	private Button close;

	public Display(Stack1 stack1, Stage stage1) {
		close = new Button("Close");
		label = new TextArea();
		label.setStyle("-fx-font-size:24;-fx-font-Weight:Bold;-fx-Color-fill:BROWN;-fx-Color-setBackground:BROWN");
		vbox = new VBox(30);
		vbox.setAlignment(Pos.CENTER);
		vbox.getChildren().addAll(label, close);
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
		while (!stack1.isEmpty() && num != 9) {
			label.setText(label.getText().concat(stack1.pop().toString1()) + "\n");
			num++;
		}
		close.setOnAction(e -> {
			stage.close();
			stage1.setFullScreen(true);
		});
	}
}
