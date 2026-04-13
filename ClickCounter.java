package org.example;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class ClickCounter extends Application {
    int counter = 0;

    @Override
    public void start(Stage stage) throws Exception {
        Label label= new Label("Clicks: 0");
        label.setFont(Font.font("System", FontWeight.BOLD, 24));

        Button button=new Button("Click me!");
        button.setOnAction(event -> {
            counter++;
            label.setText("Clicks: "+counter);
        });

        VBox vbox=new VBox(20);
        vbox.setPadding(new Insets(30));
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(label, button);

        Scene sc=new Scene(vbox,300,200);
        stage.setScene(sc);
        stage.setTitle("Click Counter");





        stage.show();
    }
}