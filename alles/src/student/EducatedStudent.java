package student;

import java.util.List;

public class EducatedStudent extends DecoratedStudent implements Studentable {
    private final String subject;

    public EducatedStudent(Studentable student, String subject) {
        super(student);
        this.subject = subject;
    }

    @Override
    public void study() {
        System.out.println(String.format("Student %s beheerst %s", this.student, this.subject));
        this.student.study();
    }

    @Override
    public String programCode() {
        String tmp = String.format("Programmacode geschreven in %s.", this.subject);
        return tmp + this.student.programCode();
    }

    @Override
    public void getOut() {
        System.out.println(String.format("student.Student maakt goede sier door zijn goede kennis van %s.", this.subject));
        this.student.getOut();
    }
}
