package Person;
import University.University;

import java.util.ArrayList;
import Department.Department;

public class Teacher extends Person {
    private Department Department;
    private String studentName;
    protected String studentGrade;
    private ArrayList<String> studentGrades;

    public Teacher(String name, int id, String department, String password) {
        super(name, id, password);
        this.Department = null;
    }

    public Teacher(String name, int id, Department department, String password) {
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

    public Department getDepartment() {
        return Department;
    }
}
