package main;

import group.Group;
import group.GroupFactory;
import osiris.Course;
import services.Osiris;
import services.StudentService;
import student.Student;
import teacher.Teacher;

import java.util.ArrayList;
import java.util.List;

public class Runner {

    private static StudentService studentSerive = StudentService.getInstance();
    private static Osiris osiris =  Osiris.getInstance();
    public static void main(String[] args) {
        Course oop2 = new Course("OOP2", "Awesome dingen die je kunt doen met ingewikkelde patterns...");
        Teacher bart = new Teacher("Bart", "bart@host.com", "BABA");
        bart.addCourse(oop2);
        List<Group> groepen = new GroupFactory(studentSerive).createStudentGroups(3);
        System.out.println(groepen.size()+" groepen aangemaakt.");
        for (Group g: groepen) {
            g.addObserver(bart);
        }

        groepen.get(1).work();
        groepen.get(1).commit();
    }
}