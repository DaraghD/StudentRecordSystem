package CommandLineInterface;
import Person.Teacher;
import Grading.Grade;

import java.util.Scanner;

public class teacherMenu extends Teacher {
    private final Scanner scannerTeacherMenu = new Scanner(System.in);

    public teacherMenu(String name, int id, String department, String password) {
        super(name, id, department, password);
    }

    public void display() {
        System.out.println("Teacher Menu" + "\n");

        System.out.println("(G)Add Student Grades, (C)Calculate Student QCA, (V)View Department Board, (D)Add Department, (L)Logout");
    }

    public void run() {
        String choice;
        do {

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
                case"L":
                    System.out.println("Logging Out...");
                    break;
                default:
                    System.out.println("Invalid Choice");
            }
        } while (!choice.equals("L"));
    }
    public static void main (String[] args) {
        teacherMenu teacherMenu = new teacherMenu("Joe Considine", 23, "Computer Science", "TestPassword");
        teacherMenu.run();
    }
}
