package teacher;

import group.Group;
import osiris.Course;

import java.util.*;

public class Teacher implements Observer{
    private List<Group> projectgroepen;
    private String name;
    private String email;
    private String vierlettercode;
    private List<Course> courses;

    public Teacher(String name, String email, String vierlettercode) {
        this.name = name;
        this.email = email;
        this.vierlettercode =  vierlettercode.toUpperCase(Locale.ROOT);
        this.courses = new ArrayList<>();
    }

    public void addCourse(Course c) {
        this.courses.add(c);
        System.out.println(String.format("Course %s toegevoegd aan docent %s", c.getName(), this.name));
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getVierlettercode() {
        return vierlettercode;
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println(o);
    }

    @Override
    public String toString() {
        String rv = String.format("Docent %s <%s> heeft de volgende cursussen:\n\n", this.name, this.email);
        for (Course c:this.courses) {
            rv += c.getName();
        }
        return rv;
    }
}
