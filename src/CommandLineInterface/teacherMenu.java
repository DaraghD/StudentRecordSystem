package CommandLineInterface;

import Person.Teacher;
import Grading.Grade;
import University.University;

import java.util.Scanner;

public class teacherMenu extends Teacher {
    private final Scanner scannerTeacherMenu = new Scanner(System.in);

    public teacherMenu(String name, int id, String department, String password, University uni) {
        super(name, id, department, password, uni);
    }

    public void display() {
        System.out.println("Teacher Menu" + "\n");

        System.out.println("(G)Add Student Grades, (C)Calculate Student QCA, (V)View Department Board, (D)Add Department, (L)Logout");
    }

    public void run() {
        String choice;

        display();
        System.out.println("Please enter an option" + "\n");
        choice = scannerTeacherMenu.nextLine().toUpperCase();

        switch (choice) {
            case "G":
                addStudentGrade(studentGrade);
                break;
            case "V":
                viewDepartmentBoard();
                break;
            case "C":
                Grade.QCA(getId(), getSemester(), getModule(), getYear());
                break;
            case "D":
                addDepartment();
                break;
            case "L":
                System.out.println("Logging Out...");
                break;
            default:
                System.out.println("Invalid Choice");
        }
    }

    public static void main(String[] args) {
        teacherMenu teacherMenu = new teacherMenu("Joe Considine", 23, "Computer Science", "TestPassword", null);
        teacherMenu.run();
    }
}
