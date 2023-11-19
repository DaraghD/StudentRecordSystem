package csvUtils;

import Person.Student;
import Person.Teacher;
import University.University;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class csvWriter {

    static File students = new File("src/data/students.csv");
    static File teachers = new File("src/data/teachers.csv");
    static File departments = new File("src/data/departments.csv");

    static PrintWriter writeStudents;
    static PrintWriter writeTeachers;
    static PrintWriter writeDepartments;


    static public void writeStudents() throws FileNotFoundException{
        writeStudents = new PrintWriter(students);
        for(Student student : University.getStudents()){
            writeStudents.println(student.getName() + "," + student.getId() + "," + student.getPassword());
        }
        writeStudents.close();
    }

    static public void writeTeachers() throws FileNotFoundException{
        writeTeachers = new PrintWriter(teachers);
        for(Teacher teacher : University.getTeachers()){
            writeTeachers.println(teacher.getName() + "," + teacher.getId() + "," + teacher.getPassword());
        }
        writeTeachers.close();
    }



    // idea is to write everything that is needed to construct an object into the csv file, so we can later
    // reconstruct it upon loading the program to get back to the previous state

    //go through each arraylist under University static variables and then write them to the csv file(s)


}
