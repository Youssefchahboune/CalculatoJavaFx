package com.example.lab10java;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.kordamp.bootstrapfx.BootstrapFX;


public class HelloApplication extends Application {

    ListView<String> history;
    Label expression;
    boolean cPressed = false;

    public static void main(String[] args){ launch();}

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Calculator");
        stage.setMaxWidth(500);
        stage.setMaxHeight(427);
        stage.setMinWidth(500);
        stage.setMinHeight(427);

        history = new ListView<>();
        history.setStyle("-fx-background-color: #5c5c5c");
        history.setMinWidth(200);
        history.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                if (!(expression.getText().isEmpty())){
                    expression.setText("");
                }
                expression.setText(t1);
                cPressed = false;
                styleLabel();
            }
        });

        expression = new Label();
        expression.setAlignment(Pos.CENTER);
        expression.setMinHeight(100);
        expression.setMinWidth(300);
        expression.setStyle(" -fx-font-size: 20px;");

        GridPane calculatorButtons = new GridPane();

        int num =0;
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                calculatorButtons.add(createCalculatorButton(Integer.toString(num+1)), j,i);
                num++;
            }
        }
        calculatorButtons.add(createCalculatorButton2("+"),4,0);
        calculatorButtons.add(createCalculatorButton2("-"),4,1);
        calculatorButtons.add(createCalculatorButton2("*"),4,2);
        calculatorButtons.add(createCalculatorButton2("="),4,4);
        calculatorButtons.add(createCalculatorButton2("/"),2,4);
        calculatorButtons.add(createCalculatorButton("0"),1,4);
        calculatorButtons.add(createCalculatorButton2("c"),0,4);

        VBox calculator = new VBox(expression,calculatorButtons);
        calculator.setMinWidth(300);

        HBox container = new HBox(history,calculator);
        container.setStyle("-fx-background-color: black");

        Scene scene = new Scene(container);
        scene.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());
        String css = getClass().getResource("/css/style.css").toExternalForm();
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.show();

    }

    private Button createCalculatorButton(String character) {

        Button newButton = new Button(character);
        newButton.setTextFill(Color.WHITE);
        newButton.setStyle("-fx-color: #5c5c5c");
        newButton.setMinWidth(75);
        newButton.setMinHeight(75);
        newButton.setOnAction(actionEvent ->  {

            if (newButton.getText().equalsIgnoreCase("c"))
            {
                expression.setText("");
                expression.getStyleClass().clear();
            }
            else if (newButton.getText().equalsIgnoreCase("=") && !(expression.getText().isEmpty()) ){

                if (isExpressionCorrect(expression.getText())){
                    //Evaluate expression

                    history.getItems().add(expression.getText());
                    cPressed = true;
                    styleLabel();
                }
            }
            else if (newButton.getText().equalsIgnoreCase("=") && expression.getText().isEmpty()){
                return;
            }
            else {
                if (isExpressionCorrect(expression.getText())){

                    if(cPressed){
                        cPressed = false;
                        expression.setText("");
                    }
                }
                expression.setText(expression.getText() + newButton.getText());
                styleLabel();

            }

        });

        return newButton;
    }

    private Button createCalculatorButton2(String character) {

        Button newButton = new Button(character);
        newButton.setTextFill(Color.WHITE);
        newButton.setStyle("-fx-color: orange");
        newButton.setMinWidth(75);
        newButton.setMinHeight(75);
        newButton.setOnAction(actionEvent ->  {

            if (newButton.getText().equalsIgnoreCase("c"))
            {
                expression.setText("");
                expression.getStyleClass().clear();
            }
            else if (newButton.getText().equalsIgnoreCase("=") && !(expression.getText().isEmpty()) ){

                if (isExpressionCorrect(expression.getText())){
                    //Evaluate expression

                    history.getItems().add(expression.getText());
                    cPressed = true;
                    styleLabel();
                }
            }
            else if (newButton.getText().equalsIgnoreCase("=") && expression.getText().isEmpty()){
                return;
            }
            else {
                if (isExpressionCorrect(expression.getText())){

                    if(cPressed){
                        cPressed = false;
                        expression.setText("");
                    }
                }
                expression.setText(expression.getText() + newButton.getText());
                styleLabel();

            }

        });

        return newButton;
    }

    private boolean isExpressionCorrect(String expression){
        if (expression.matches("^(\\d+[\\+\\-\\*\\/]{1})+\\d+$")){
            return true;
        }
        else {
            return false;
        }
    }

    private void styleLabel(){
        if (isExpressionCorrect(expression.getText())){
            expression.getStyleClass().clear();
            expression.getStyleClass().addAll("lbl","lbl-success");
        }
        else {
            expression.getStyleClass().clear();
            expression.getStyleClass().addAll("lbl","lbl-danger");
        }
    }
}