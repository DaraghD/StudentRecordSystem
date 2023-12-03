package University;

import Person.Teacher;
import Person.Student;
import Department.Department;

import java.util.ArrayList;

/**
 * Class for a University and provides methods for managing teachers, students, departments, and programmes.
 * Holds most of the data for the system and is the main interface for accessing it.
 */
public class University {
    /**
     * The path to the file containing information about students.
     */
    private String studentsPath;
    /**
     * The path to the file containing information about teachers.
     */
    private String teachersPath;
    /**
     * The path to the file containing information about departments.
     */
    private String departmentsPath;
    /**
     * The path to the file containing information about programmes.
     */
    private String programmesPath;
    /**
     * The path to the file containing information about modules.
     */
    private String modulesPath;
    /**
     * The path to the file containing information about grades.
     */
    private String gradesPath;

    /**
     * The list of teachers in the university.
     */
    private ArrayList<Teacher> teachers = new ArrayList<Teacher>();
    /**
     * The list of students in the university.
     */
    private ArrayList<Student> students = new ArrayList<Student>();
    /**
     * The list of departments in the university.
     */
    private ArrayList<Department> departments = new ArrayList<Department>();
    /**
     * The list of programmes in the university.
     * Only used temporarily when loading data from programmes.csv, not updated during program run time.
     * For updated storage refer {@link #getProgramme(String)}, which pulls from the departments.
     */
    private ArrayList<Programme> programmes = new ArrayList<Programme>();

    /**
     * Sets the path to the file containing information about teachers.
     *
     * @param teachersPath The path to the file containing information about students.
     */
    public void setTeachersPath(String teachersPath) {
        this.teachersPath = teachersPath;
    }

    /**
     * Sets the path to the file containing information about students.
     *
     * @param studentsPath The path to the file containing information about students.
     */
    public void setStudentsPath(String studentsPath) {
        this.studentsPath = studentsPath;
    }

    /**
     * Adds a department to the list of departments in the university.
     *
     * @param department The department to be added.
     */
    public void addDepartment(Department department) {
        this.departments.add(department);
    }

    /**
     * Adds a teacher to the list of teachers in the university.
     *
     * @param teacher The department to be added.
     */
    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    /**
     * Adds a student to the list of students in the university.
     *
     * @param student The department to be added.
     */
    public void addStudent(Student student) {
        students.add(student);
    }

    /**
     * Gets the list of all teachers in the university.
     *
     * @return The list of teachers in the university.
     */
    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }

    /**
     * Gets the list of all students in the university.
     *
     * @return The list of students in the university.
     */
    public ArrayList<Student> getStudents() {
        return students;
    }

    /**
     * Gets the list of all departments in the university.
     *
     * @return The list of students in the university.
     */
    public ArrayList<Department> getDepartments() {
        return departments;
    }

    /**
     * Gets the path to the file containing information about students.
     *
     * @return The path to the file containing information about students.
     */
    public String getStudentsPath() {
        return studentsPath;
    }

    /**
     * Gets the path to the file containing information about teachers.
     *
     * @return The path to the file containing information about teachers.
     */
    public String getTeacherPath() {
        return teachersPath;
    }

    /**
     * Gets the path to the file containing information about departments.
     *
     * @return The path to the file containing information about departments.
     */
    public String getDepartmentsPath() {
        return departmentsPath;
    }

    /**
     * Gets the path to the file containing information about departments.
     *
     * @param departmentsPath The path to the file containing information about departments.
     */
    public void setDepartmentsPath(String departmentsPath) {
        this.departmentsPath = departmentsPath;
    }

    /**
     * Gets the path to the file containing information about programmes.
     *
     * @return The path to the file containing information about programmes.
     */
    public String getProgrammesPath() {
        return programmesPath;
    }

    /**
     * Gets the path to the file containing information about programmes.
     *
     * @param programmesPath The path to the file containing information about programmes.
     */
    public void setProgrammesPath(String programmesPath) {
        this.programmesPath = programmesPath;
    }

    /**
     * Gets the path to the file containing information about modules.
     *
     * @return The path to the file containing information about modules.
     */
    public String getModulesPath() {
        return modulesPath;
    }

    /**
     * Gets the path to the file containing information about modules.
     *
     * @param modulesPath The path to the file containing information about modules.
     */
    public void setModulesPath(String modulesPath) {
        this.modulesPath = modulesPath;
    }

    /**
     * Gets the path to the file containing information about grades.
     *
     * @return The path to the file containing information about grades.
     */
    public String getGradesPath() {
        return gradesPath;
    }

    /**
     * Gets the path to the file containing information about modules.
     *
     * @param gradesPath The path to the file containing information about modules.
     */
    public void setGradesPath(String gradesPath) {
        this.gradesPath = gradesPath;
    }

    /**
     * Gets a programme by name from the university's list of programmes.
     *
     * @param programmeName The name of the programme to retrieve.
     * @return The programme with the specified name, or null if not found.
     */
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

    /**
     * Gets a student id from the university's list of students.
     *
     * @param id The id of the student to retrieve.
     * @return The student with the specified id, or null if not found.
     */
    public Student getStudent(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    /**
     * Gets a teacher id from the university's list of teachers.
     *
     * @param id The id of the teacher to retrieve.
     * @return The teacher with the specified id, or null if not found.
     */
    public Teacher getTeacher(int id) {
        for (Teacher teacher : teachers) {
            if (teacher.getId() == id) {
                return teacher;
            }
        }
        return null;
    }

    /**
     * Purely used for getting a programme from the programmes arraylist during loading.
     * Don't use for updated data, refer to {@link #getProgramme(String)} instead.
     * @param name The name of the programme to retrieve.
     * @return The programme with the specified name, or null if not found.
     */
    public Programme getProgrammeE(String name) {
        for (Programme programme : programmes) {
            if (programme.getName().equals(name)) {
                return programme;
            }
        }
        return null;
    }

    /**
     * Gets a department by name from the university's list of departments.
     *
     * @param name The name of the department to retrieve.
     * @return The department with the specified name, or null if not found.
     */
    public Department getDepartment(String name) {
        for (Department department : departments) {
            if (department.getName().equals(name)) {
                return department;
            }
        }
        return null;
    }

    /**
     * Gets a password by students or teachers ids from the university's list of students and teachers passwords.
     * IDs are unique so there is no need to check if the password belongs to a student or a teacher.
     * @param id The name of the student or teacher to retrieve.
     * @return The password with the specified student or teacher id, or null if not found.
     */
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

    /**
     * Checks if a given ID is unique among both teachers and students.
     *
     * @param id The ID to check for uniqueness.
     * @return True if the ID is unique, false otherwise.
     */
    public boolean uniqueID(int id) { // id is unique between teacher and students
        return this.getTeacher(id) == null && this.getStudent(id) == null;
    }


    /**
     * Adds a programme to the list of programmes in the university.
     * Only used temporarily when loading data from programmes.csv.
     * For runtime programmes should be added through their department, see {@link Department#addProgramme(Programme)}
     *
     * @param programme The programme to be added.
     */
    public void addProgramme(Programme programme) {
        this.programmes.add(programme);
    }
}
