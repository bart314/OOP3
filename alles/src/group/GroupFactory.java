package group;

import services.StudentService;
import student.Student;

import java.util.ArrayList;
import java.util.List;

public class GroupFactory {
    private StudentService service;

    public GroupFactory(StudentService service) {
        this.service = service;
    }

    public List<Group> createStudentGroups(int groupSize) {
        List<Group> rv = new ArrayList<>();
        List<Student> students = this.service.getAllStudentsRandom();
        int ctr = 0;

        while(ctr + groupSize < students.size()) {
            List<Student> tmp = students.subList(ctr, ctr+groupSize);
            rv.add(new Group(this.service, ctr, tmp));
            ctr++;
        }

        // add last slice of array
        if (ctr<students.size()) {
            List<Student> tmp = students.subList(ctr, students.size()-1);
            rv.add(new Group(this.service, ctr, tmp));
        }

        return rv;
    }
}
