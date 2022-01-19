package student;

public abstract class DecoratedStudent implements Studentable {
      Studentable student;

    public DecoratedStudent(Studentable student) {
        this.student = student;
    }

    @Override
    public void study() {
        this.student.study();
    }

    @Override
    public String programCode() {
        return this.student.programCode();
    }

    @Override
    public void getOut() {
        this.student.getOut();
    }
}
