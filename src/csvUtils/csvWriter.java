package csvUtils;

import Grading.Grade;
import University.Programme;
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
    private final PrintWriter writeModules;
    private final PrintWriter writeGrades;
    private final University university;


    public csvWriter(University university) throws FileNotFoundException {
        this.university = university;
        this.writeStudents = new PrintWriter(university.getStudentsPath());
        this.writeDepartments = new PrintWriter(university.getDepartmentsPath());
        this.writeTeachers = new PrintWriter(university.getTeacherPath());
        this.writeProgrammes = new PrintWriter(university.getProgrammesPath());
        this.writeModules = new PrintWriter(university.getModulesPath());
        this.writeGrades = new PrintWriter(university.getGradesPath());
    }

    public void writeStudents() {
        boolean header = false;
        for (Student student : university.getStudents()) {
            if (!header) {
                writeStudents.println(student.csvHeader());
                header = true;
            }
            System.out.println("Saving data : Student " + student.getName());
            String s = student.csvFormat();
            writeStudents.println(s);
        }
        writeStudents.close();
    }

    public void writeTeachers() {
        boolean header = false;
        for (Teacher teacher : university.getTeachers()) {
            if (!header) {
                writeTeachers.println(teacher.csvHeader());
                header = true;
            }
            System.out.println("Saving data : Teacher " + teacher.getName());
            writeTeachers.println(teacher.csvFormat());
        }
        writeTeachers.close();
    }

    public void writeDepartments() {
        boolean header = false;
        for (Department department : university.getDepartments()) {
            if (!header) {
                writeDepartments.println(department.csvHeader());
                header = true;
            }
            System.out.println("Saving data : Department " + department.getName());
            writeDepartments.println(department.csvFormat());
        }
        writeDepartments.close();
    }

    public void writeProgrammes() {
        boolean header = false;
        for (Department department : university.getDepartments()) {
            for (Programme programme : department.getProgrammes()) {
                if (!header) {
                    writeProgrammes.println(programme.csvHeader());
                    header = true;
                }
                System.out.println("Saving data : Programme " + programme.getName());
                writeProgrammes.println(programme.csvFormat());
            }
        }
        writeProgrammes.close();
    }

    public void writeModules() {
        boolean header = false;
        for (Department department : university.getDepartments()) {
            for (Programme programme : department.getProgrammes()) {
                for (Grading.Module module : programme.getModules()) {
                    if (!header) {
                        writeModules.println(module.csvHeader());
                        header = true;
                    }
                    System.out.println("Saving data : Module " + module.getName());
                    writeModules.println(module.csvFormat());
                }
            }
        }
        writeModules.close();
    }

    public void writeGrades() {
        boolean header = false;
        for (Student student : university.getStudents()) {
            for (Grade grade : student.getGrades()) {
                if (!header) {
                    writeGrades.println(grade.csvHeader());
                    header = true;
                }
                System.out.println("Saving data : Grades " + grade.getModule().getName());
                writeGrades.println(grade.csvFormat());
            }
        }
        writeGrades.close();
    }

}
