package Person;

import Grading.Grade;
import Grading.Programme;

import java.util.ArrayList;

public class Student extends Person {
    //need grades arraylist or something here
    private ArrayList<Grade> grades = new ArrayList<>();
    private Programme currentProgramme;

    public Student(String name, int id, String password) {
        super(name, id, password);
    }

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
