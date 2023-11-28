package Person;

import Grading.Module;
import University.University;

/**
 * Represents a person in the system.
 *
 * Person is a superclass to both Student and Teacher.
 */
public class Person {

    private String name;
    private int id;
    private String password;
    private int semester;
    private String module;
    private int year;
    private University university;

    /**
     * Creates an instance of Person.
     *
     * @param name The name associated with the person.
     * @param id The identification number associated with the person.
     * @param password The password associated with the person.
     */
    public Person(String name, int id, String password) {
        this.name = name;
        this.id = id;
        this.password = password;
    }

    /**
     * Returns the name of the person.
     *
     * @return The name of the person.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the ID of the person.
     *
     * @return The ID of the person.
     */
    public int getId() {
        return id;
    }

    /**
     * Returns the password of a person.
     *
     * @return The password of a person.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Returns the semester associated with the person.
     *
     * @return The semester associated with the person.
     */
    public int getSemester() {
        return semester;
    }

    /**
     * Returns the year associated with the person.
     *
     * @return The year associated with the person.
     */
    public int getYear() {
        return year;
    }
}