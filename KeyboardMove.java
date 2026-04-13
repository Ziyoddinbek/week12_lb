package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class KeyboardMove extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        Rectangle rect = new Rectangle(220, 180, 60, 40);
        rect.setFill(Color.LIGHTBLUE);

        TextField posField = new TextField("X: 220  Y: 180");
        posField.setEditable(false);
        posField.setPrefWidth(500);
        posField.setLayoutY(360);

        Pane pane = new Pane(rect, posField);
        pane.setPrefSize(500, 400);

        Scene scene = new Scene(pane);

        scene.setOnKeyPressed(event -> {
            double x = rect.getX();
            double y = rect.getY();

            if (event.getCode() == KeyCode.UP)    y -= 10;
            if (event.getCode() == KeyCode.DOWN)  y += 10;
            if (event.getCode() == KeyCode.LEFT)  x -= 10;
            if (event.getCode() == KeyCode.RIGHT) x += 10;

            x = Math.max(0, Math.min(x, 500 - 60));
            y = Math.max(0, Math.min(y, 400 - 40));
            rect.setX(x);
            rect.setY(y);

            posField.setText(String.format("X: %.0f  Y: %.0f", x, y));
        });

        stage.setTitle("Keyboard Move");
        stage.setScene(scene);
        stage.show();

        scene.getRoot().requestFocus();
    }
}