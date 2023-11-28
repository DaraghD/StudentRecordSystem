package University;

import Grading.Programme;
import Person.Teacher;
import Person.Student;
import Department.Department;

import java.util.ArrayList;

public class University {
    private String studentsPath;
    private String teachersPath;
    private String departmentsPath;
    private String programmesPath;
    private String modulesPath;
    private String gradesPath;
    private ArrayList<Teacher> teachers = new ArrayList<Teacher>();
    private ArrayList<Student> students = new ArrayList<Student>();
    private ArrayList<Department> departments = new ArrayList<Department>();

    private ArrayList<Programme> programmes = new ArrayList<Programme>();

    public void setTeachersPath(String teachersPath) {
        this.teachersPath = teachersPath;
    }

    public void addDepartment(Department department) {
        this.departments.add(department);
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

    public ArrayList<Department> getDepartments() {
        return departments;
    }

    public String getStudentsPath() {
        return studentsPath;
    }

    public void setStudentsPath(String studentsPath) {
        this.studentsPath = studentsPath;
    }

    public String getTeacherPath() {
        return teachersPath;
    }

    public String getDepartmentsPath() {
        return departmentsPath;
    }

    public void setDepartmentsPath(String departmentsPath) {
        this.departmentsPath = departmentsPath;
    }

    public String getProgrammesPath() {
        return programmesPath;
    }

    public void setProgrammesPath(String programmesPath) {
        this.programmesPath = programmesPath;
    }

    public String getModulesPath() {
        return modulesPath;
    }

    public void setModulesPath(String modulesPath) {
        this.modulesPath = modulesPath;
    }

    public String getGradesPath() {
        return gradesPath;
    }

    public void setGradesPath(String gradesPath) {
        this.gradesPath = gradesPath;
    }

    public Programme getProgramme(String programmeName) {
        for (Department department : departments) {
            for (Programme programme : department.getProgrammes()) {
                if (programme.getName().equals(programmeName)) {
                    return programme;
                }
            }
        }
        return null;
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

    public Programme getProgrammeE(String name){
        for(Programme programme : programmes){
            if(programme.getName().equals(name)){
                return programme;
            }
        }
        return null;
    }

    public Department getDepartment(String name) {
        for (Department department : departments) {
            if (department.getName().equals(name)) {
                return department;
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
        return this.getTeacher(id) == null && this.getStudent(id) == null;
    }

    public void addProgramme(Programme programme) {
        this.programmes.add(programme);
    }
}
