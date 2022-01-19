package student;

public abstract class DecoratedStudent implements Student {
    Student student;

    public DecoratedStudent(Student student) {
        this.student = student;
    }

    @Override
    public String getName() { return this.student.getName(); }

    @Override
    public String getEmail() { return this.student.getEmail(); }

    @Override
    public Long getStudenNumber() { return this.student.getStudenNumber(); }

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
