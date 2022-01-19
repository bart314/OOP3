package student;// Entity class


public class Student implements Studentable {
    private final String name;
    private final String email;
    private final Long studentNumber;

    public Student(String name, String email, Long studentNumber) {
        this.name = name;
        this.email = email;
        this.studentNumber = studentNumber;
    }

    @Override
    public String toString() {
        return String.format("student.Student %s <%s> (%d)", this.name, this.email, this.studentNumber);
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Long getStudenNumber() {
        return studentNumber;
    }

    @Override
    public void study() {
        System.out.println(String.format("%s is studying...", this.name));
    }

    @Override
    public String programCode() {
        return String.format("Code written by %s.", this.name);
    }

    @Override
    public void getOut() {
        System.out.println(String.format("%s is going to the pub!", this.name));
    }
}
