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

    private final University uni;

    public csvParser(University university) throws FileNotFoundException {
        this.uni = university;
        String studentsPath = university.getStudentsPath();
        String teachersPath = university.getTeacherPath();

        this.studentReader = new BufferedReader(new FileReader(studentsPath));
        this.teacherReader = new BufferedReader(new FileReader(teachersPath));
        this.departmentReader = new BufferedReader(new FileReader(university.getDepartmentsPath()));
        this.programmeReader = new BufferedReader(new FileReader(university.getProgrammesPath()));
    }

    public void parseStudents() throws IOException {
        //TODO REDO ALL OF THIS
        String studentLine;
        while ((studentLine = studentReader.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(studentLine, ",");

            String name = st.nextToken();
            int id = Integer.parseInt(st.nextToken());
            String password = st.nextToken();
            String programmeName = st.nextToken();

            Student student = new Student(name, id, password);
            uni.addStudent(student);
            if(!Objects.equals(programmeName, "null")){
                student.setProgramme(uni.getProgramme(programmeName));
            }
            while (st.hasMoreTokens() && !Objects.equals(programmeName, "null")) { // parsing grades
                String grade = st.nextToken();
                String moduleName = st.nextToken();
                Module newModule = uni.getProgramme(programmeName).getModule(moduleName);
                //Getting module from programme name, modules must be in the students programme.
                Grade newGrade = new Grade(grade, newModule);
                student.addGrade(newGrade);
            }
        }
        studentReader.close();
    }

    public void parseTeachers() throws IOException {
        String teacherLine;
        while ((teacherLine = teacherReader.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(teacherLine, ",");
            while (st.hasMoreTokens()) {
                String name = st.nextToken();
                int id = Integer.parseInt(st.nextToken());
                String password = st.nextToken();
                String departmentName = st.nextToken();
                Teacher teacher = new Teacher(name, id,uni.getDepartment(departmentName), password);
                uni.addTeacher(teacher);
            }
        }
        teacherReader.close();
    }

    public void parseDepartments() throws IOException { //relies on programe , programmes firt then this the nteacher the nstudent,
        String departmentLine;
        while ((departmentLine = departmentReader.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(departmentLine, ",");
            String name = st.nextToken();
            Department department = new Department(name, uni);
            uni.addDepartment(department);
            while (st.hasMoreTokens()) {
                String programmeName = st.nextToken();
                department.addProgramme(uni.getProgramme(programmeName));
            }
        }
        departmentReader.close();
    }

    public void parseProgrammes() throws IOException {
        String programmeLine;
        while ((programmeLine = programmeReader.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(programmeLine, ",");


            String name = st.nextToken();
            int duration = Integer.parseInt(st.nextToken());
            String level = st.nextToken();
            ProgrammeType programmeType = ProgrammeType.valueOf(level);

            Programme programme = new Programme(name, uni, duration, programmeType);
            uni.addProgramme(programme);


            while (st.hasMoreTokens()) {

                String moduleName = st.nextToken();
                String cutoff = st.nextToken();
                String year = st.nextToken();
                Semester semester = Semester.valueOf(st.nextToken());

                Module module = new Module(moduleName, Integer.parseInt(cutoff), Integer.parseInt(year), semester);

                programme.addModule(module);
            }
        }
        programmeReader.close();
    }
}
