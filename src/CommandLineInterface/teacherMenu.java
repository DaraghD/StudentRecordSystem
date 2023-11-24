package CommandLineInterface;

import Department.Department;
import Person.*;
import Grading.Grade;
import University.University;

import java.util.Scanner;

public class teacherMenu {

    private Department department;
    private final Scanner scannerTeacherMenu = new Scanner(System.in);
    private Teacher currentUser;
    private University uni;


    public teacherMenu(Teacher currentUser, University uni) {
        this.currentUser = currentUser;
        this.uni = uni;
        this.department = new Department(uni);
    }

    public void display() {
        System.out.println("Teacher Menu" + "\n");
    }

    public void run() {
        boolean logout = false;
        while (!logout) {
            String choice;

            display();
            System.out.println("""
                    Please enter an option
                    G - Add Student Grade
                    C - Calculate Student QCA
                    V - View Department.Department Board
                    D - Add Department.Department
                    M - Average QCA for a module
                    L - Logout
                    """);
            choice = scannerTeacherMenu.nextLine().toUpperCase();

            switch (choice) {
                case "G":
                    addStudentGrade();
                    break;
                case "V":
                    //viewDepartmentBoard();
                    break;
                case "C":
                    System.out.println("Enter Student ID:");
                    int id = scannerTeacherMenu.nextInt();
                    Student student = uni.getStudent(id);
                    System.out.println("QCA: " + student.totalQCA());
                    //Grade.QCA(getId(), getSemester(), getModule(), getYear());
                    break;
                case "D":
                    //addDepartment();
                    break;
                case "M":
                    //Print out all modules here
                    System.out.println("Enter module code");
                    String m = scannerTeacherMenu.nextLine();
                    department.calculateAndDisplayAverageQCAForModule(m);
                case "L":
                    System.out.println("Logging Out...");
                    logout = true;
                    break;
                default:
                    System.out.println("Invalid Choice");
            }
        }
    }

    private void addStudentGrade() {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the student's ID");
        int studentId = Integer.parseInt(input.nextLine());

        System.out.println("Please enter the student's grade");
        String studentGrade = input.nextLine();

        System.out.println("Please enter the student's course");
        String studentCourse = input.nextLine();

        System.out.println("Please enter the student's module");
        String studentModule = input.nextLine();

        System.out.println("Please enter the student's year");
        int studentYear = input.nextInt();

        System.out.println("Please enter the student's semester- 1 or 2");
        int studentSemester = input.nextInt();

        Grade grade = new Grade(studentCourse, studentGrade, studentSemester, studentModule, studentYear);
        Student student = uni.getStudent(studentId);
        student.addGrade(grade);
        System.out.println("Grade: +" +grade.toString()+ ", added to " + student.getName());

    }
}
