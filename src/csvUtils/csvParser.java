package csvUtils;

import Department.Department;
import Grading.*;
import Grading.Module;
import University.University;
import Person.Student;
import Person.Teacher;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
import java.util.StringTokenizer;

public class csvParser {

    private final BufferedReader studentReader;
    private final BufferedReader teacherReader;
    private final BufferedReader departmentReader;
    private final BufferedReader programmeReader;
    private final BufferedReader moduleReader;
    private final BufferedReader gradeReader;

    private final University uni;

    public csvParser(University university) throws FileNotFoundException {
        this.uni = university;

        this.studentReader = new BufferedReader(new FileReader(university.getStudentsPath()));
        this.teacherReader = new BufferedReader(new FileReader(university.getTeacherPath()));
        this.departmentReader = new BufferedReader(new FileReader(university.getDepartmentsPath()));
        this.programmeReader = new BufferedReader(new FileReader(university.getProgrammesPath()));
        this.moduleReader = new BufferedReader(new FileReader(university.getModulesPath()));
        this.gradeReader = new BufferedReader(new FileReader(university.getGradesPath()));
    }

    public void parseStudents() throws IOException {
        String studentLine;
        studentReader.readLine(); // skipping header
        while ((studentLine = studentReader.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(studentLine, ",");

            String name = st.nextToken();
            int id = Integer.parseInt(st.nextToken());
            String password = st.nextToken();
            String programmeName = st.nextToken();
            if (!Objects.equals(programmeName, "null")) {
                Student newStudent = new Student(name, id, password, uni.getProgrammeE(programmeName));
                uni.addStudent(newStudent);
            }
            else {

                Student student = new Student(name, id, password);
                uni.addStudent(student);
            }


        }
        studentReader.close();
    }

    public void parseTeachers() throws IOException {
        teacherReader.readLine(); // skipping header
        String teacherLine;
        while ((teacherLine = teacherReader.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(teacherLine, ",");
            while (st.hasMoreTokens()) {
                String name = st.nextToken();
                int id = Integer.parseInt(st.nextToken());
                String password = st.nextToken();
                String departmentName = st.nextToken();
                Teacher teacher = new Teacher(name, id, uni.getDepartment(departmentName), password);
                uni.addTeacher(teacher);
            }
        }
        teacherReader.close();
    }

    public void parseDepartments() throws IOException { //relies on programe , programmes firt then this the nteacher the nstudent,
        departmentReader.readLine(); // skipping header
        String departmentLine;
        while ((departmentLine = departmentReader.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(departmentLine, ",");
            String name = st.nextToken();
            Department department = new Department(name, uni);
            uni.addDepartment(department);
        }
        departmentReader.close();
    }

    public void parseProgrammes() throws IOException {
        programmeReader.readLine(); // skipping header
        String programmeLine;
        while ((programmeLine = programmeReader.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(programmeLine, ",");

            String name = st.nextToken();
            int duration = Integer.parseInt(st.nextToken());
            String level = st.nextToken();
            ProgrammeType programmeType = ProgrammeType.valueOf(level);
            double cutoff = Double.parseDouble(st.nextToken());

            Programme programme = new Programme(name, uni, duration, programmeType,cutoff);
            uni.addProgramme(programme);

        }
        programmeReader.close();
    }

    public void parseGrades() throws IOException {
        String gradeLine;
        gradeReader.readLine(); // skipping header
        while ((gradeLine = gradeReader.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(gradeLine, ",");
            String name = st.nextToken();
            String moduleName = st.nextToken();
            int id = Integer.parseInt(st.nextToken());
            Student student = uni.getStudent(id);
            System.out.println(student.getModuleG(moduleName).getName());
            Grade grade = new Grade(name, student.getModuleG(moduleName), id);
            student.addGrade(grade);
        }
        gradeReader.close();
    }

    public void parseModules() throws IOException {
        moduleReader.readLine(); // skipping header
        String moduleLine;
        while ((moduleLine = moduleReader.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(moduleLine, ",");

            String name = st.nextToken();
            int year = Integer.parseInt(st.nextToken());
            String semester = st.nextToken();
            String programmeName = st.nextToken();

            Module module = new Module(name, year, Semester.valueOf(semester), uni.getProgramme(programmeName));
            uni.getProgrammeE(programmeName).addModule(module);
        }
        moduleReader.close();
    }
}
