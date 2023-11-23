package Person;
import University.University;

import java.util.ArrayList;

public class Teacher extends Person {
    private String Department;
    private String studentName;
    protected String studentGrade;
    private ArrayList<String> studentGrades;

    public Teacher(String name, int id, String department, String password) {
        super(name, id, password);
        this.Department = department;
    }

    public void addStudentGrade(String studentGrade) {
        this.studentGrades.add(studentGrade);
    }

    public void viewDepartmentBoard() {

    }
    public void addDepartment() {

    }

    public String getDepartment() {
        return Department;
    }
}
