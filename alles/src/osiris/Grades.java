package osiris;

import services.Osiris;
import student.Student;

import java.util.HashMap;
import java.util.Map;

public class Grades {
    private final Map<Student, Integer> grades;
    private final Course course;

    public Grades(final String course) {
        this.course = new Course(course);
        this.grades = new HashMap<>();
    }

    public void addGrade(Student student, Integer grade) {
        this.grades.put(student, grade);
    }

    public int execute() {
        return Osiris.getInstance().setGrades(this.course, this.grades);
    }


}
