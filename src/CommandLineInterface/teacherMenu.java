package CommandLineInterface;
import Person.Teacher;
import Grading.Grade;

import java.util.Scanner;

public class teacherMenu extends Teacher {

    public teacherMenu() {
        super(name, id, password);
        this.scannerTeacherMenu = new Scanner(System.in);
    }
    private Scanner scannerTeacherMenu;
    static Scanner input = new Scanner(System.in);

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

            switch (input.nextLine().toUpperCase()) {
                case "G":
                    addStudentGrade(studentGrade);
                    break;
                case "V":
                    viewDepartmentBoard();
                    break;
                case "C":
                    Grade.QCA(int id, int semester, String module, int year);
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
        teacherMenu teacherMenu = new teacherMenu();
        teacherMenu.run();
    }
}
