package nl.hanze.modelviewcontroller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

public class Controller {
    private Model model = new Model();

    @FXML
    private Label displayResults;

    @FXML
    private TextField nameField;

    @FXML
    private TextField codeField;

    @FXML
    private Label feedbackField;

    @FXML
    private TextField searchField;

    @FXML
    protected void onDocentButtonClick() {
        displayResults.setText("nog niet geïmplementeerd");
    }

    @FXML
    protected void onStudentButtonClick() {
        ArrayList<Displayable> studenten = model.getAllStudents();
        String result = "";
        Iterator<Displayable> itr = studenten.iterator();
        Displayable tmp;
        while (itr.hasNext()) {
            tmp = itr.next();
            result += String.format("%s: %s\n", tmp.getName(), tmp.getCode());
        }
        displayResults.setText(result);
    }

    @FXML
    protected void onAddDocentButtonClick() {
        feedbackField.setText("nog niet geïmplementeerd");
    }

    @FXML
    protected void onAddStudentButtonClick() {
        // live demo 1
        feedbackField.setText("nog niet geïmplementeerd");
    }

    @FXML
    protected void onSearchButtonClicked() {
        // live demo 3
        feedbackField.setText("nog niet geïmplementeerd");

    }
}