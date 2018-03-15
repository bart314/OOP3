package iterator;

/*
Basically een data-object die wat data vasthoudt en uitprint.
*/

public class Person {
    private String naam;
    private String woonplaats;
    private char gender;

    public Person(String naam, String woonplaats, char gender) {
        this.naam = naam;
        this.woonplaats = woonplaats;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return this.naam;
    }

}