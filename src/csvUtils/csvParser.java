package csvUtils;


import University.University;
import Person.Student;
import Person.Teacher;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class csvParser {

    private static BufferedReader studentReader;
    private static BufferedReader teacherReader;
    private static BufferedReader departmentReader;
    static {
        try {
            studentReader = new BufferedReader(new FileReader(University.studentsPath));
            teacherReader = new BufferedReader(new FileReader(University.teachersPath));
            departmentReader = new BufferedReader(new FileReader(University.departmentsPath));
        } catch (FileNotFoundException e) {
            System.out.print(e);
        }
    }




    public static void parseStudents() throws IOException {
        while(studentReader.readLine() != null){ // every line is a new student
            StringTokenizer st = new StringTokenizer(studentReader.readLine(), ",");
            String name = st.nextToken();
            int id = Integer.parseInt(st.nextToken());
            String password = st.nextToken();
            Student.register(name, id, password);
        }
        studentReader.close();
    }

    public static void parseTeachers() throws IOException {
        while(teacherReader.readLine() != null){
            StringTokenizer st = new StringTokenizer(teacherReader.readLine(), ",");
            String name = st.nextToken();
            int id = Integer.parseInt(st.nextToken());
            String password = st.nextToken();
            String department = st.nextToken();
            Teacher.register(name, id, department, password);
        }
        teacherReader.close();
    }




}
