package Person;

import University.University;

public class Person {

    private String name;
    private int id;
    private String password;

    private University university;

    public Person(String name, int id, String password, University uni) {
        this.name = name;
        this.id = id;
        this.password = password;
        this.university = uni;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

}