package csvUtils;

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
        writeStudents.println("Name,ID,Password,Programme,Grade,ModuleName");
        for (Student student : university.getStudents()) {
            System.out.println("Saving data : Student " + student.getName());
            String s = student.csvFormat();
            writeStudents.println(s);
        }
        writeStudents.close();
    }

    public void writeTeachers() throws FileNotFoundException {
        writeTeachers.println("Name,ID,Password,Department");
        for (Teacher teacher : university.getTeachers()) {
            System.out.println("Saving data : Teacher " + teacher.getName());
            writeTeachers.println(teacher.csvFormat());
        }
        writeTeachers.close();
    }

    public void writeDepartments() throws FileNotFoundException {
        writeDepartments.println("Name,ProgrammeNames");
        for (Department department : university.getDepartments()) {
            System.out.println("Saving data : Department " + department.getName());
            writeDepartments.println(department.csvFormat());
        }
        writeDepartments.close();
    }

    public void writeProgrammes() throws FileNotFoundException {
        writeProgrammes.println("Name,Duration,Level,ModuleName,Cutoff,Year,Semester");
        for (Department department : university.getDepartments()) {
            for (Programme programme : department.getProgrammes()) {
                System.out.println("Saving data : Programme " + programme.getName());
                writeProgrammes.println(programme.csvFormat());
            }
        }
        writeProgrammes.close();
    }
}
