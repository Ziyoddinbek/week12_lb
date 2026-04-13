package org.example;
import javafx.application.Application;
import javafx.scene.control.Label;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.awt.*;

public class MouseCoords extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        StackPane stackPane=new StackPane();
        stackPane.setPrefSize(400,300);
        stackPane.setStyle("-fx-background-color: lightblue");

        Label label=new Label("Move the mouse over the pane");
        stackPane.setOnMouseMoved(event -> {
            label.setText("X: "+event.getX()+"   ||    Y:"+event.getY());

        });

        stackPane.setOnMouseClicked(event -> {
            int r=(int)(Math.random()*256);
            int g=(int)(Math.random()*256);
            int b=(int)(Math.random()*256);
            stackPane.setStyle(String.format("-fx-background-color: rgb(%d,%d,%d);", r, g, b));

        });
        stackPane.setOnMouseExited(event -> {
            label.setText("Move the mouse over the pane");
        });
        BorderPane bp=new BorderPane();
        bp.setCenter(stackPane);
        bp.setBottom(label);
        BorderPane.setMargin(label, new Insets(8));

        Scene scene = new Scene(bp);
        stage.setTitle("Mouse Coordinates");
        stage.setScene(scene);


        stage.show();
    }
}