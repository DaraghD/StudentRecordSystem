package csvUtils;

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

    private BufferedReader studentReader;
    private BufferedReader teacherReader;
    private BufferedReader departmentReader;

    private String studentsPath;
    private String teachersPath;
    private University uni;

    public csvParser(University university) throws FileNotFoundException {
        this.uni = university;
        this.studentsPath = university.getStudentsPath();
        this.teachersPath = university.getTeacherPath();

        this.studentReader = new BufferedReader(new FileReader(studentsPath));
        this.teacherReader = new BufferedReader(new FileReader(teachersPath));
        //this.departmentReader = university.getDepartmentReader();
    }

    public void parseStudents() throws IOException {
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
                String course = st.nextToken();
                String grade = st.nextToken();
                int semester = Integer.parseInt(st.nextToken());
                String module = st.nextToken();
                int year = Integer.parseInt(st.nextToken());
                student.addGrade(new Grade(course, grade, semester, module, year));
            }
        }
        studentReader.close();
    }

    public void parseTeachers() throws IOException {
        String teacherLine;
        while ((teacherLine = teacherReader.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(teacherLine, ",");
            while (st.hasMoreTokens()){
                String name = st.nextToken();
                int id = Integer.parseInt(st.nextToken());
                String password = st.nextToken();
                String department = st.nextToken();
                uni.addTeacher(new Teacher(name, id, department, password));
            }
        }
        teacherReader.close();
    }

    public void parseDepartments() throws IOException { //TODO: split more csvs for module and programme
        String departmentLine;


}
