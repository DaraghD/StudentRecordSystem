package University;

import Person.Teacher;
import Person.Student;

import java.util.ArrayList;

public class University {

    public String studentsPath;
    public final String teachersPath = "src/data/teachers.csv";
    //public static final String departmentsPath = "src/data/departments.csv";


    private ArrayList<Teacher> teachers = new ArrayList<Teacher>();
    private ArrayList<Student> students = new ArrayList<Student>();

    //static ArrayList<Department> departments = new ArrayList<Department>();

    //private ArrayList<Student> students;
    //private Teacher teachers;
    //private Departments departments;
    public void setStudentsPath(String studentsPath) {
        this.studentsPath = studentsPath;
    }

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    public void addStudent(Student student) {
        students.add(student);
    }


    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setTeachersPath(String s) {
    }

    public String getStudentsPath() {
        return studentsPath;
    }

    public String getTeacherPath() {
        return teachersPath;
    }

    public Student getStudent(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    public Teacher getTeacher(int id) {
        for (Teacher teacher : teachers) {
            if (teacher.getId() == id) {
                return teacher;
            }
        }
        return null;
    }

    public String getPassword(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student.getPassword();
            }
        }
        for (Teacher teacher : teachers) {
            if (teacher.getId() == id) {
                return teacher.getPassword();
            }
        }
        return null;

    }

    public boolean uniqueID(int id) { // id is unique between teacher and students
        if(this.getTeacher(id) != null || Student.getStudent(id) != null) {
            return false;
        }
        return true;
    }
}
