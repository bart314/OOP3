package osiris;

public class Course {
    private final String name;
    private final String description;

    public Course(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Course(String name) {
        this(name, "Beschrijving ontbreekt nog");
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("Course %s\n==============\n\n%s", this.name, this.description);
    }
}
