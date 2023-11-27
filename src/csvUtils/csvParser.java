package csvUtils;

import Grading.Semester;
import University.University;
import Person.Student;
import Person.Teacher;
import Grading.Grade;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class csvParser {

    private final BufferedReader studentReader;
    private final BufferedReader teacherReader;
    private BufferedReader departmentReader;

    private final University uni;

    public csvParser(University university) throws FileNotFoundException {
        this.uni = university;
        String studentsPath = university.getStudentsPath();
        String teachersPath = university.getTeacherPath();

        this.studentReader = new BufferedReader(new FileReader(studentsPath));
        this.teacherReader = new BufferedReader(new FileReader(teachersPath));
        //this.departmentReader = university.getDepartmentReader();
    }

    public void parseStudents() throws IOException {
        //TODO REDO ALL OF THIS
        String studentLine;
        while ((studentLine = studentReader.readLine()) != null) {

            StringTokenizer st = new StringTokenizer(studentLine, ",");
            // parsing student info
            String name = st.nextToken();
            System.out.println("Parsing students, adding : " + name);
            int id = Integer.parseInt(st.nextToken());
            String password = st.nextToken();

            Student student = new Student(name, id, password);
            uni.addStudent(student);

            while (st.hasMoreTokens()) { // parsing grades
                String nameM = st.nextToken();
                String grade = st.nextToken();
                Semester sem = st.nextToken().equals("AUTUMN") ? Semester.AUTUMN : Semester.SPRING;
                String module = st.nextToken();
                int year = Integer.parseInt(st.nextToken());
                Grading.Module newModule = new Grading.Module(nameM,1,year,sem);
                student.addGrade(new Grade(grade, newModule));
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
                String department = st.nextToken();//TODO MAKE THIS DEPARTMENT OBJECT
                uni.addTeacher(new Teacher(name, id, department, password));
            }
        }
        teacherReader.close();
    }

    public void parseDepartments() throws IOException { //TODO: split more csvs for module and programme
        String departmentLine;

    }
}
