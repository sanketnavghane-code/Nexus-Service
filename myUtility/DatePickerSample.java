package myUtility;

import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DatePickerSample {

    private Stage stage;
    private DatePicker checkInDatePicker;

    public DatePickerSample(Stage stage) {
        this.stage = stage;
        stage.setTitle("DatePickerSample");
        initUI();
    }

    private void initUI() {
        VBox vbox = new VBox(20);
        vbox.setStyle("-fx-padding: 10;");
        Scene scene = new Scene(vbox, 400, 400);
        stage.setScene(scene);

        checkInDatePicker = new DatePicker();

        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        Label checkInlabel = new Label("Check-In Date:");
        gridPane.add(checkInlabel, 0, 0);

        GridPane.setHalignment(checkInlabel, HPos.LEFT);
        gridPane.add(checkInDatePicker, 0, 1);
        vbox.getChildren().add(gridPane);
    }

    public DatePicker getDatePicker() {
        return checkInDatePicker;
    }

    public void show() {
        stage.show();
    }

}