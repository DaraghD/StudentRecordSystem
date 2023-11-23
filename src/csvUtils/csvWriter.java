package csvUtils;

import Grading.Grade;
import Person.Student;
import Person.Teacher;
import University.University;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class csvWriter {

    private PrintWriter writeStudents;
    private PrintWriter writeTeachers;
    private PrintWriter writeDepartments;

    private University university;


    public csvWriter(University university) throws FileNotFoundException {
        this.university = university;
        this.writeStudents = new PrintWriter(university.getStudentsPath());
        //writeDepartments = new PrintWriter(departments);
        this.writeTeachers = new PrintWriter(university.getTeacherPath());
    }

    public void writeStudents() throws FileNotFoundException {
        for (Student student : university.getStudents()) {
            //basic info
            System.out.println("Saving data : Student " + student.getName());
            String studentString = student.getName() + "," + student.getId() + "," + student.getPassword();
            //appending grades
            if (!student.getGrades().isEmpty()) {
                for (Grade grade : student.getGrades()) {
                    System.out.println("Saving grade :" + grade.toString());
                    studentString += ","; //separating grades with commas
                    studentString += grade.csvFormat();
                }
            }

            writeStudents.println(studentString);
        }
        writeStudents.close();
    }

    public void writeTeachers() throws FileNotFoundException {
        for (Teacher teacher : university.getTeachers()) {
            System.out.println("Saving data : Student " + teacher.getName());

            writeTeachers.println(teacher.getName() + "," + teacher.getId() + "," + teacher.getPassword() + "," + teacher.getDepartment());
        }
        writeTeachers.close();
    }


    // idea is to write everything that is needed to construct an object into the csv file, so we can later
    // reconstruct it upon loading the program to get back to the previous state

    //go through each arraylist under University static variables and then write them to the csv file(s)


}
