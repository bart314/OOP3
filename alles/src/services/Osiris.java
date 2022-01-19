package services;

import osiris.Course;
import student.Student;

import java.util.HashMap;
import java.util.Map;

public class Osiris {
    private final StudentService service;
    private final Object lock = new Object();
    private final Map<Course, Map<Long, Integer>> data;
    private static Osiris instance;

    private Osiris(StudentService service) {
        this.service = service;
        this.data = new HashMap<>();
    }

    public static Osiris getInstance() {
        if (Osiris.instance == null) Osiris.instance = new Osiris(StudentService.getInstance());
        return Osiris.instance;
    }

    public int setGrades(Course course, Map<Student, Integer> grades) {
        int ctr = 0;
        synchronized (lock) {
            for (Map.Entry<Student, Integer> grade : grades.entrySet()) {
                this.data.put(course, Map.of(grade.getKey().getStudenNumber(), grade.getValue()));
                ctr++;
            }
        }
        return ctr;
    }
}
