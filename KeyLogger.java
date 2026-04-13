package org.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class KeyLogger extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        Label inputLabel = new Label("Type here:");
        TextField inputField = new TextField();

        Label logLabel = new Label("Event Log:");
        TextArea logArea = new TextArea();
        logArea.setPrefRowCount(5);
        logArea.setEditable(false);

        inputField.setOnKeyPressed(event -> {
            String line = String.format("PRESSED  | Code: %-10s | Shift: %-5s | Ctrl: %s%n",
                    event.getCode(),
                    event.isShiftDown(),
                    event.isControlDown());
            logArea.appendText(line);
        });

        inputField.setOnKeyReleased(event -> {
            String line = String.format("RELEASED | Code: %s%n",
                    event.getCode());
            logArea.appendText(line);
        });

        inputField.setOnKeyTyped(event -> {
            String line = String.format("TYPED    | Char: %s%n",
                    event.getCharacter());
            logArea.appendText(line);
        });

        Button clearButton = new Button("Clear Log");
        clearButton.setOnAction(event -> logArea.clear());


        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(20));
        vbox.getChildren().addAll(inputLabel, inputField, logLabel, logArea, clearButton);

        Scene scene = new Scene(vbox, 420, 320);
        stage.setTitle("Key Event Logger");
        stage.setScene(scene);
        stage.show();
    }
}