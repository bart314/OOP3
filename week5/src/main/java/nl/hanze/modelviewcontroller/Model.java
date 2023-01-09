package nl.hanze.modelviewcontroller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Observable;

public class Model extends Observable {

    protected static ArrayList<Displayable> studenten;

    public Model() {
        this.studenten = new ArrayList<>(Arrays.asList(
                new Student(new SimplePerson("Karel", "406234")),
                new Student(new SimplePerson("Hendrika", "246890")),
                new Student(new SimplePerson("Omar", "231423")),
                new Student(new SimplePerson("Françoise", "871013")),
                new Student(new SimplePerson("Fenna", "140808"))
        ));
    }

    public ArrayList<Displayable> getAllStudents() {
        return this.studenten;
    }

    public void addStudent(String name, String code) {
        this.studenten.add(new Student(new SimplePerson(name, code)));
        setChanged();
        notifyObservers(String.format("Student %s (%s) toegevoegd", name, code));
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

class Person implements Displayable {
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
