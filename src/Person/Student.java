package Person;

import Grading.Grade;
import Grading.Programme;

import java.util.ArrayList;

/**
 * Represents a student profile in the system. "Student" is a subclass of "Person".
 *
 * Array list 'grades', is initialized, as well as 'currentProgramme' of type 'Programme', representing the program(course) associated with the student.
 */

public class Student extends Person {
    //need grades arraylist or something here
    private ArrayList<Grade> grades = new ArrayList<>();
    private Programme currentProgramme;

    /**
     * Sets the current programme for a particular student.
     *
     * @param programme The programme associated with the student.
     */

    public void setProgramme(Programme programme){
        this.currentProgramme = programme;
    }

    /**
     * Creates an instance of 'Student'.
     *
     * @param name The students name.
     * @param id The students identification number.
     * @param password The students' password.
     */
    public Student(String name, int id, String password) {
        super(name, id, password);
    }

    /**
     * Adds a grade(of type 'Grade') to the grades array list
     *
     * @param grade The grade to be added to the list.
     */
    public void addGrade(Grade grade) {
        grades.add(grade);
    }

    public void ViewTranscript() {

    }


    public Programme getCurrentProgramme() {
        return currentProgramme;
    }

    public ArrayList<Grade> getGrades() {
        return grades;
    }


    public double QCA(String module) {
        //calculates QCA for given semester module and year
        double total = 0;
        int counter = 0;
        for (Grade grade : this.grades) {
            if (grade.getModule().equals(module)) {
                total += grade.convertGradeToNumber();
                counter++;
            }
        }
        return total / counter;
    }

    public double totalQCA() {
        double total = 0.0;
        int counter = 0;
        for (Grade grade : this.grades) {
            total += grade.convertGradeToNumber();
            counter++;
        }
        return total / counter;
    }


}
