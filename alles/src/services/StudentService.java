package services;

import osiris.Course;
import student.Student;
import java.util.List;

public class StudentService {
    private static StudentService instance;
    private List<Student> data;

    private StudentService() {
        this.createStudents();
    }

    public static StudentService getInstance() {
        if (StudentService.instance==null) StudentService.instance = new StudentService();
        return StudentService.instance;
    }

    public Student getStudentById(Long id) {
        for (Student st: this.data) {
            if (st.getStudenNumber()==id) return st;
        }
        return null;
    }


    private void createStudents()  {
        this.data = List.of (
                new Student("Bart","bart@host.com", 314159L),
                new Student("Karel","karel@host.com", 219426L),
                new Student("Fenna","fenna@host.com", 314222L),
                new Student("Yfke","yfke@host.com", 3246666L),
                new Student("Herre","herre@host.com", 215923L),
                new Student("Françoise","françoise@host.com", 245987L),
                new Student("Jant","jant@host.com", 322998L),
                new Student("Cyrill","cyrill@host.com", 3412432L),
                new Student("Abdelkader","abdelkader@host.com", 3412212L),
                new Student("Ahmed","ahmed@host.com", 123123L),
                new Student("Pier","pier@host.com", 3412222L),
                new Student("Wing Zhung","wing@host.com", 212333L)
        );
    }


}
