package org.example;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;



public class SimpleCalc extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Label label1=new Label("Number 1: ");
        Label label2=new Label("Number 2: ");
        Label labelresult=new Label("Result: ");

        TextField text1=new TextField();
        TextField text2=new TextField();
        TextField result=new TextField();
        result.setEditable(false);

        Button button=new Button("Calculate");
        button.setOnAction(event -> {
            try{
                double num1=Double.parseDouble(text1.getText());
                double num2=Double.parseDouble(text2.getText());
                double sum=num1+num2;
                result.setText(String.format("Sum: %.2f",sum));

            }
            catch (NumberFormatException e){
                result.setText("Invalid Input!");
            }
        });
            Button clbut=new Button("Clear");
            clbut.setOnAction(event1 -> {
                text1.clear();
                text2.clear();
                result.clear();
            });

        GridPane gp=new GridPane();
        gp.setHgap(10);
        gp.setVgap(10);
        gp.setPadding(new Insets(20));
        gp.setAlignment(Pos.CENTER);

        gp.add(label1, 0,0);
        gp.add(text1, 0, 1);
        gp.add(label2, 1,0);
        gp.add(text2,1,1);
        gp.add(labelresult,2,0);
        gp.add(result,2,1);
        gp.add(button,3,1);
        gp.add(clbut,4,1);


        Scene scene=new Scene(gp, 320,220);
        stage.setTitle("Simple Calculator");
        stage.setScene(scene);
        stage.show();
    }
}