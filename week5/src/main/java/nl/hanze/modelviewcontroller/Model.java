package nl.hanze.modelviewcontroller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Observable;
import java.util.stream.Collectors;

public class Model  {

    protected static ArrayList<Displayable> studenten;

    public Model() {
        Model.studenten = new ArrayList<>(Arrays.asList(
                new Student(new SimplePerson("Karel", "406234")),
                new Student(new SimplePerson("Hendrika", "246890")),
                new Student(new SimplePerson("Omar", "231423")),
                new Student(new SimplePerson("Françoise", "871013")),
                new Student(new SimplePerson("Fenna", "140808"))
        ));
    }

    public ArrayList<Displayable> getAllStudents() {
        return Model.studenten;
    }

    public void addStudent(String name, String code) {
        // Live demo 1
        // live demo 2
    }

    public ArrayList<Displayable> search(String needle) {
        // live demo 3
        return null;
    }
}


interface Displayable {
    String getName();
    String getCode();
}

 class SimplePerson implements Displayable {

    private String name;
    private String code;

    SimplePerson (String name, String code) {
        this.name = name;
        this.code = code;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getCode() {
        return this.code;
    }

}

abstract class Person implements Displayable {
    final Displayable person;

    Person (Displayable p) {
        this.person = p;
    }

    @Override
    public String getName() {
        return person.getName();
    }

    @Override
    public String getCode() {
        return person.getCode();
    }
}

class Student extends Person  {

    Student(Displayable s) {
        super(s);
    }

    @Override
    public String getName() {
        return String.format("Student %s", super.getName());
    }

    @Override
    public String getCode() {
        return String.format("Studentnummer %s", super.getCode());
    }


}
