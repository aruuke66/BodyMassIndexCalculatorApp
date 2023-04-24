package com.example.bodymassindexcalculatorapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class BMIController implements Initializable {
    double bmi;
    String status;
    String checking;


    @FXML
    private TextField BMITextField;

    @FXML
    private Label bmiLabel;

    @FXML
    private Button calculateButton;

    @FXML
    private Label heightLabel;

    @FXML
    private TextField heightTextField;

    @FXML
    private Label statusLabel;

    @FXML
    private TextField statusTextField;

    @FXML
    private TextField totalTextField;

    @FXML
    private ChoiceBox<String> unitsChoiceBox;

    private String[] units = {"Metric Units", "English Units"};

    @FXML
    private Label unitsLabel;

    @FXML
    private Label weightLabel;

    @FXML
    private TextField weightTextField;

    @FXML
    void calculateButtonPressed(ActionEvent event) {
        try {
            double weight = Double.parseDouble(weightTextField.getText());
            double height = Double.parseDouble(heightTextField.getText());

            if(checking.equals("Metric Units")) {
                bmi = weight / Math.pow(height, 2);
            }
            else{
                bmi = 703 * (weight / Math.pow(height, 2));
            }

            if(bmi < 18.5){
                status = "Underweight";
                statusTextField.setText(status);
            } else if (18.5 <= bmi && bmi <= 24.9) {
                status = "Normal";
                statusTextField.setText(status);
            } else if (25 <= bmi && bmi <= 29.9) {
                status = "Overweight";
                statusTextField.setText(status);
            } else{
                status = "Obese";
                statusTextField.setText(status);
            }

            BMITextField.setText(String.valueOf(bmi));


        } catch (Exception ex) {
            this.weightTextField.setText("Enter amount");
            this.weightTextField.selectAll();
            this.weightTextField.requestFocus();

            this.heightTextField.setText("Enter amount");
            this.heightTextField.selectAll();
            this.heightTextField.requestFocus();

        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        unitsChoiceBox.getItems().addAll(units);

    }
    @FXML
    void getUnits(ActionEvent event){
        String newUnits = unitsChoiceBox.getValue();
        if (newUnits.equals("Metric Units")) {
            checking = "Metric Units";


        } else {
            checking = "English Units";


        }

    }
}