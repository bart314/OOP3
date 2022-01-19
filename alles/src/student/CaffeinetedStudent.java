package student;

public class CaffeinetedStudent extends DecoratedStudent implements Studentable {
    public CaffeinetedStudent(Studentable student) {
        super(student);
    }

    @Override
    public void study() {
        this.student.study();
        System.out.println("Echt zin in, na die lekkere koffie!");
    }

    @Override
    public String programCode() {
        String tmp = "Allemaal goede code, snel geschreven dankzij de caffeïne!";
        return tmp + this.student.programCode();
    }

    @Override
    public void getOut() {
        System.out.println("Eerst een kop koffie voordat we uitgaan.");
        this.student.getOut();
    }
}
