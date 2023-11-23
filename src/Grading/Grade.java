package Grading;

import Person.Student;

import java.util.ArrayList;

//TODO: add module class ? so modules can have individual cutoff points for departments? programme?
public class Grade {
    private String grade;
    private String courseName;
    private int semester;
    private String module;
    private int year;

    public Grade(String coursename, String grade, int semester, String module, int year) {
        this.courseName = coursename;
        this.grade = grade;
        this.semester = semester;
        this.module = module;
        this.year = year;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getGrade() {
        return grade;
    }

    public String csvFormat(){
        return courseName + "," + grade + "," + semester + "," + module + "," + year;
    }

    public String toString() {
        return "Course: " + courseName + " Grade: " + grade + " Semester: " + semester + " module: " + module + " Year: " + year;
    }


    public double convertGradeToNumber() {
        return switch (this.grade) {
            case "A1" -> 4.0;
            case "A2" -> 3.6;
            case "B1" -> 3.2;
            case "B2" -> 3.0;
            case "B3" -> 2.8;
            case "C1" -> 2.6;
            case "C2" -> 2.4;
            case "C3" -> 2.0;
            case "D1" -> 1.6;
            case "D2" -> 1.2;
            default -> 0;
        };
    }

    public static double QCA(Student student, int semester, String module, int year) {
        //calculates QCA for given semester module and year 
        ArrayList<Grade> grades = student.getGrades();
        double total = 0;
        int counter = 0;
        for (Grade grade : grades) {
            if (grade.year == year && grade.module.equals(module) && grade.semester == semester) {
                total += grade.convertGradeToNumber();
                counter++;
            }
        }
        return total / counter;
    }
public String getModule(){
        return this.module;
}

}
