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

    public static String getPassword(int id){
        for(Teacher teacher : University.getTeachers()){
            if(teacher.getId() == id){
                return teacher.getPassword();
            }
        }
        return null; //exception here , invalid id login -> maybe no exception use this as null to checkk if can register?
    }

    public static Teacher getTeacher(int id){
        for(Teacher teacher : University.getTeachers()){
            if(teacher.getId() == id){
                return teacher;
            }
        }
        return null; //exception here , invalid id login
    }

    public void addStudentGrade(String studentGrade) {
        this.studentGrades.add(studentGrade);
    }

    public void viewDepartmentBoard() {

    }
    public void addDepartment() {

    }

    public static void register(String name, int id, String department, String password) {
        Teacher newTeacher = new Teacher(name, id, department, password);
        //check if teacher already exists -> maybe do this for ID earlier in the above method
        University.addTeacher(newTeacher);
        System.out.println("You have successfully registered as a teacher");

    }


    public String getDepartment() {
        return Department;
    }
}
