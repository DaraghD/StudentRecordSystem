package University;

import Grading.Grade;
import Person.Teacher;
import Person.Student;

import java.util.ArrayList;

public class University {
    private String studentsPath;
    private String teachersPath;
    private ArrayList<Teacher> teachers = new ArrayList<Teacher>();
    private ArrayList<Student> students = new ArrayList<Student>();


    public void setStudentsPath(String studentsPath) {
        this.studentsPath = studentsPath;
    }

    public void setTeachersPath(String teachersPath) {
        this.teachersPath = teachersPath;
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
        if(this.getTeacher(id) != null || this.getStudent(id) != null) {
            return false;
        }
        return true;
    }

        public void addGrade(int StudentID, String courseName, String grade, int semester, String module, int year) {
        Grade newGrade = new Grade(courseName, grade, semester, module, year);
        try {
            getStudent(StudentID).addGrade(newGrade);
        } catch (NullPointerException e) {
            System.out.println("Student does not exist");
            return;
        }
        System.out.println("Grade added successfully");
    }
}
