package Grading;

public class Grade {
    private String grade;

    private int semester;

    private String programme;




    public Grade(String coursename, String grade, int semester, String programme) {
        this.grade = grade;
        this.semester = semester;
        this.programme = programme;

    }

    public String getCourseName() {
        return courseName;
    }

    public int getGrade() {
        return grade;
    }



}
