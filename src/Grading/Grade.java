package Grading;

import Person.Student;

import java.util.ArrayList;

public class Grade {
    private String grade;
    private String courseName;
    private int semester;
    private String module;
    private int year;

    public Grade(String coursename, String grade, int semester, String module, int year) {
        this.grade = grade;
        this.semester = semester;
        this.module = module;
        this.courseName = coursename;
        this.year = year;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getGrade() {
        return grade;
    }

    public String toString() {
        return "Course: " + courseName + " Grade: " + grade + " Semester: " + semester + " module: " + module + " Year: " + year;
    }

    public void addGrade(int StudentID, String courseName, String grade, int semester, String module, int year) {
        Grade newGrade = new Grade(courseName, grade, semester, module, year);
        try {
            Student.getStudent(StudentID).addGrade(newGrade);
        } catch (NullPointerException e) {
            System.out.println("Student does not exist");
            return;
        }
        System.out.println("Grade added successfully");
    }

    public double convertGradeToNumber() {
        if (this.grade.equals("A1")) {
            return 4.0;
        } else if (this.grade.equals("A2")) {
            return 3.6;
        } else if (this.grade.equals("B1")) {
            return 3.2;
        } else if (this.grade.equals("B2")) {
            return 3.0;
        } else if (this.grade.equals("B3")) {
            return 2.8;
        } else if (this.grade.equals("C1")) {
            return 2.6;
        } else if (this.grade.equals("C2")) {
            return 2.4;
        } else if (this.grade.equals("C3")) {
            return 2.0;
        } else if (this.grade.equals("D1")) {
            return 1.6;
        } else if (this.grade.equals("D2")) {
            return 1.2;
        } else if (this.grade.equals("F")) {
            return 0;
        }
        return 0;
    }

    public double QCA(int id, int semester, String module, int year) {
        Student student = Student.getStudent(id);
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


}
