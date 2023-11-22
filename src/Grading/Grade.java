package Grading;

import Person.Student;

public class Grade {
    private String grade;
    private String courseName;
    private int semester;
    private String programme;
    private int year;

    public Grade(String coursename, String grade, int semester, String programme, int year) {
        this.grade = grade;
        this.semester = semester;
        this.programme = programme;
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
        return "Course: " + courseName + " Grade: " + grade + " Semester: " + semester + " Programme: " + programme + " Year: " + year;
    }

    public void addGrade(int StudentID, String courseName, String grade, int semester, String programme, int year) {
        Grade newGrade = new Grade(courseName, grade, semester, programme,year);
        try {
            Student.getStudent(StudentID).addGrade(newGrade);
        }
        catch (NullPointerException e) {
            System.out.println("Student does not exist");
            return;
        }
        System.out.println("Grade added successfully");
    }

    public double convertGradeToNumber(){
        if(this.grade.equals("A1")){
            return 4.0;
        }
        else if(this.grade.equals("A2")){
            return 3.6;
        }
        else if(this.grade.equals("B1")){
            return 3.2;
        }
        else if(this.grade.equals("B2")){
            return 3.0;
        }
        else if(this.grade.equals("B3")){
            return 2.8;
        }
        else if(this.grade.equals("C1")){

        }
        else if(this.grade.equals("C2")){

        }
        else if(this.grade.equals("C3")){

        }
        else if(this.grade.equals("D1")){

        }
        else if(this.grade.equals("D2")){

        }
        else if(this.grade.equals("F")){
            return 0;
        }
        return 0;
    }



}
