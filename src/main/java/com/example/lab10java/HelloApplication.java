package com.example.lab10java;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    public static void main(String[] args){ launch();}

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Calculator");
        stage.setMaxWidth(500);
        stage.setMaxHeight(427);
        stage.setMinWidth(500);
        stage.setMinHeight(427);

        ListView<String> history = new ListView<>();
        history.setMinWidth(200);


        Label expression = new Label("3214+65-98");
        expression.setAlignment(Pos.CENTER);
        expression.setMinHeight(100);

        GridPane calculatorButtons = new GridPane();

        int num =0;
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                calculatorButtons.add(createCalculatorButton(Integer.toString(num+1)), j,i);
                num++;
            }
        }
        calculatorButtons.add(createCalculatorButton("+"),4,0);
        calculatorButtons.add(createCalculatorButton("-"),4,1);
        calculatorButtons.add(createCalculatorButton("*"),4,2);
        calculatorButtons.add(createCalculatorButton("="),4,4);
        calculatorButtons.add(createCalculatorButton("/"),2,4);
        calculatorButtons.add(createCalculatorButton("0"),1,4);
        calculatorButtons.add(createCalculatorButton("c"),0,4);


        VBox calculator = new VBox(expression,calculatorButtons);
        calculator.setAlignment(Pos.CENTER);
        calculator.setMinWidth(300);


        HBox container = new HBox(history,calculator);



        Scene scene = new Scene(container);
        stage.setScene(scene);
        stage.show();

    }

    private Button createCalculatorButton(String character) {
        Button newButton = new Button(character);
        newButton.setMinWidth(75);
        newButton.setMinHeight(75);
        //newButton.setOnAction();

        return newButton;
    }
}