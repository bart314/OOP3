package services;

import student.Student;
import student.StudentModel;

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
                new StudentModel("Bart","bart@host.com", 314159L),
                new StudentModel("Karel","karel@host.com", 219426L),
                new StudentModel("Fenna","fenna@host.com", 314222L),
                new StudentModel("Yfke","yfke@host.com", 3246666L),
                new StudentModel("Herre","herre@host.com", 215923L),
                new StudentModel("Françoise","françoise@host.com", 245987L),
                new StudentModel("Jant","jant@host.com", 322998L),
                new StudentModel("Cyrill","cyrill@host.com", 3412432L),
                new StudentModel("Abdelkader","abdelkader@host.com", 3412212L),
                new StudentModel("Ahmed","ahmed@host.com", 123123L),
                new StudentModel("Pier","pier@host.com", 3412222L),
                new StudentModel("Wing Zhung","wing@host.com", 212333L)
        );
    }


}
