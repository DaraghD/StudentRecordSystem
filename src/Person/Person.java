package Person;

import University.University;

public class Person {

    private String name;
    private int id;
    private String password;
    private int semester;
    private String module;
    private int year;

    University university;

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

    public int getSemester() {
        return semester;
    }

    public String getModule() {
        return module;
    }

    public int getYear() {
        return year;
    }
}