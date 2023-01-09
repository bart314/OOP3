package nl.hanze.modelviewcontroller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

public class Controller implements Observer {
    private Model model;

    public Controller() {
        this.model = new Model();
        this.model.addObserver(this);
    }

    @FXML
    private Label displayResults;

    @FXML
    private TextField nameField;

    @FXML
    private TextField codeField;

    @FXML
    private Label feedbackField;

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
        displayResults.setText("nog niet geïmplementeerd");

    }

    @FXML
    protected void onAddStudentButtonClick() {
        String name = nameField.getText();
        String code = codeField.getText();
        this.model.addStudent(name, code);
    }


    @Override
    public void update(Observable o, Object arg) {
        feedbackField.setText((String)arg);
        System.out.println("huih");
    }
}