package com.adrianpk.baristalab.javafxworkshop.bindings;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class BindingsTask extends Application {

    @Override
    public void start(Stage primaryStage) {
        TextField firstNumberField = new TextField();
        firstNumberField.setPromptText("Enter first number");
        TextField secondNumberField = new TextField();
        secondNumberField.setPromptText("Enter second number");

        Label sumLabel = new Label("Sum: ");

        IntegerProperty firstNumber = new SimpleIntegerProperty();
        IntegerProperty secondNumber = new SimpleIntegerProperty();

        firstNumber.bind(Bindings.createIntegerBinding(() -> {
            try {
                return Integer.parseInt(firstNumberField.getText());
            } catch (NumberFormatException e) {
                return 0;
            }
        }, firstNumberField.textProperty()));

        secondNumber.bind(Bindings.createIntegerBinding(() -> {
            try {
                return Integer.parseInt(secondNumberField.getText());
            } catch (NumberFormatException e) {
                return 0;
            }
        }, secondNumberField.textProperty()));

        sumLabel.textProperty().bind(Bindings.convert(firstNumber.add(secondNumber)));

        // Layout
        VBox root = new VBox(10, firstNumberField, secondNumberField, sumLabel);
        root.setPadding(new javafx.geometry.Insets(10));

        Scene scene = new Scene(root, 300, 250);
        primaryStage.setTitle("Properties and Bindings");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
