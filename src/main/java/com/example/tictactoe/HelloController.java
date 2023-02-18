package com.example.tictactoe;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.ArrayList;

public class HelloController {

    @FXML
    private Button button1;
    @FXML
    private Button button2;
    @FXML
    private Button button3;
    @FXML
    private Button button4;
    @FXML
    private Button button5;
    @FXML
    private Button button6;
    @FXML
    private Button button7;
    @FXML
    private Button button8;
    @FXML
    private Button button9;
    @FXML
    private Label label;
    @FXML
    private Button start;

    ArrayList<Button> buttons = new ArrayList<>();

    @FXML
    void initialize() {
        buttons.add(button1);
        buttons.add(button2);
        buttons.add(button3);
        buttons.add(button4);
        buttons.add(button5);
        buttons.add(button6);
        buttons.add(button7);
        buttons.add(button8);
        buttons.add(button9);

        label.setText("Turn Player O");

        start.setOnAction(actionEvent -> buttons.forEach(button -> {
            button.setText("");
            button.setDisable(false);
        }));

        for (int i = 0; i < 9; i++) {
            final int[] j = {0};
            buttons.forEach(button -> button.setOnAction(actionEvent -> {
                if (j[0] == 0) {
                    button.setStyle("-fx-text-fill: red");
                    label.setText("Turn Player X");
                    button.setText("O");
                    j[0]++;
                    checkGame();
                } else {
                    button.setStyle("-fx-text-fill: green");
                    label.setText("Turn Player O");
                    button.setText("X");
                    j[0]--;
                    checkGame();
                }
                button.setDisable(true);
            }));
        }
    }


    void checkGame() {
        if (button1.getText().equals(button4.getText()) && button1.getText().equals(button7.getText()) && button1.getText().equals("O")
                || button2.getText().equals(button5.getText()) && button5.getText().equals(button8.getText()) && button8.getText().equals("O")
                || button3.getText().equals(button6.getText()) && button6.getText().equals(button9.getText()) && button9.getText().equals("O")
                || button1.getText().equals(button2.getText()) && button1.getText().equals(button3.getText()) && button1.getText().equals("O")
                || button4.getText().equals(button5.getText()) && button5.getText().equals(button6.getText()) && button6.getText().equals("O")
                || button7.getText().equals(button8.getText()) && button8.getText().equals(button9.getText()) && button9.getText().equals("O")
                || button1.getText().equals(button5.getText()) && button1.getText().equals(button9.getText()) && button9.getText().equals("O")
                || button3.getText().equals(button5.getText()) && button3.getText().equals(button7.getText()) && button7.getText().equals("O")) {
            System.out.print("Win player O");
            label.setText("Win player O");
            label.setStyle("-fx-text-fill: red");
            buttons.forEach(x -> x.setDisable(true));
        } else if (button1.getText().equals(button4.getText()) && button1.getText().equals(button7.getText()) && button1.getText().equals("X")
                || button2.getText().equals(button5.getText()) && button5.getText().equals(button8.getText()) && button8.getText().equals("X")
                || button3.getText().equals(button6.getText()) && button6.getText().equals(button9.getText()) && button9.getText().equals("X")
                || button1.getText().equals(button2.getText()) && button1.getText().equals(button3.getText()) && button1.getText().equals("X")
                || button4.getText().equals(button5.getText()) && button5.getText().equals(button6.getText()) && button6.getText().equals("X")
                || button7.getText().equals(button8.getText()) && button8.getText().equals(button9.getText()) && button9.getText().equals("X")
                || button1.getText().equals(button5.getText()) && button1.getText().equals(button9.getText()) && button9.getText().equals("X")
                || button3.getText().equals(button5.getText()) && button3.getText().equals(button7.getText()) && button7.getText().equals("X")) {
            System.out.println("Win player X");
            label.setText("Win player X");
            label.setStyle("-fx-text-fill: red");
            buttons.forEach(x -> x.setDisable(true));
        } else if (buttons.stream().allMatch(x -> x.getText().equals("X") || x.getText().equals("O"))) {
            label.setText("Draw");
            label.setStyle("-fx-text-fill: red");
        }
    }
}
