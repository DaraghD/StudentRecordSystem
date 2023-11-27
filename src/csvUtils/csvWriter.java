package csvUtils;

import Grading.Grade;
import Grading.Programme;
import Person.Student;
import Person.Teacher;
import University.University;
import Department.Department;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class csvWriter {

    private final PrintWriter writeStudents;
    private final PrintWriter writeTeachers;
    private final PrintWriter writeDepartments;
    private final PrintWriter writeProgrammes;

    private final University university;


    public csvWriter(University university) throws FileNotFoundException {
        this.university = university;
        this.writeStudents = new PrintWriter(university.getStudentsPath());
        this.writeDepartments = new PrintWriter(university.getDepartmentsPath());
        this.writeTeachers = new PrintWriter(university.getTeacherPath());
        this.writeProgrammes = new PrintWriter(university.getProgrammesPath());
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

    public void writeDepartments() throws FileNotFoundException {
        for (Department department : university.getDepartments()) {
            System.out.println("Saving data : Department " + department);
            writeDepartments.println(department.getName());
        }
        writeDepartments.close();
    } //TODO: maybe split this up into more csv files for programme and module,

    public void writeProgrammes() throws FileNotFoundException {
        for (Department department : university.getDepartments()) {
            for (Programme programme : department.getProgrammes()) {
                System.out.println("Saving data : Programme " + programme);
                writeDepartments.println(programme.csvFormat());
            }
        }
        writeDepartments.close();
    }
}
