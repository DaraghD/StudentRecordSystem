package csvUtils;

import Person.Student;
import Person.Teacher;
import University.University;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import University.University;

public class csvWriter {

    private static final File students = new File(University.studentsPath);
    private static final File teachers = new File(University.teachersPath);
    private static final File departments = new File(University.departmentsPath);

    static PrintWriter writeStudents;
    static PrintWriter writeTeachers;
    static PrintWriter writeDepartments;

    static {
        try {
            writeStudents = new PrintWriter(students);
            writeDepartments = new PrintWriter(departments);
            writeTeachers = new PrintWriter(teachers);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    static public void writeStudents() throws FileNotFoundException{
        for(Student student : University.getStudents()){
            writeStudents.println(student.getName() + "," + student.getId() + "," + student.getPassword());
        }
        writeStudents.close();
    }

    static public void writeTeachers() throws FileNotFoundException{
        for(Teacher teacher : University.getTeachers()){
            writeTeachers.println(teacher.getName() + "," + teacher.getId() + "," + teacher.getPassword() + "," + teacher.getDepartment());
        }
        writeTeachers.close();
    }



    // idea is to write everything that is needed to construct an object into the csv file, so we can later
    // reconstruct it upon loading the program to get back to the previous state

    //go through each arraylist under University static variables and then write them to the csv file(s)


}
