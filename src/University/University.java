package University;

import Person.Teacher;
import Person.Student;

import java.util.ArrayList;

public class University {

    private static ArrayList<Teacher> teachers = new ArrayList<Teacher>();
    private static ArrayList<Student> students = new ArrayList<Student>();

    //static ArrayList<Department> departments = new ArrayList<Department>();

    //private ArrayList<Student> students;
    //private Teacher teachers;
    //private Departments departments;

    public static void addTeacher(Teacher teacher){
        teachers.add(teacher);
    }
    public static void addStudent(Student student){
        students.add(student);
    }
    //public static void addDepartment(Department department){
        //departments.add(department);
    //}

    public static ArrayList<Teacher> getTeachers(){
        return teachers;
    }

    public static ArrayList<Student> getStudents(){
        return students;
    }

}
