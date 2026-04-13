package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class DraggableCircle extends Application {

    private double offsetX;
    private double offsetY;

    @Override
    public void start(Stage stage) throws Exception {

        Circle circle = new Circle(250, 200, 40, Color.CORAL);

        circle.setOnMousePressed(event -> {
            offsetX = event.getSceneX() - circle.getCenterX();
            offsetY = event.getSceneY() - circle.getCenterY();
            circle.setFill(Color.TOMATO);
        });

        circle.setOnMouseDragged(event -> {
            circle.setCenterX(event.getSceneX() - offsetX);
            circle.setCenterY(event.getSceneY() - offsetY);
        });

        circle.setOnMouseReleased(event -> {
            circle.setFill(Color.CORAL);
        });

        Pane pane = new Pane(circle);
        pane.setPrefSize(500, 400);

        Scene scene = new Scene(pane);
        stage.setTitle("Draggable Circle");
        stage.setScene(scene);
        stage.show();
    }
}