package CommandLineInterface;
import java.util.Scanner;
import java.util.Scanner.*;

public class teacherMenu {
    private Scanner scannerTeacherMenu;
    static Scanner input = new Scanner(System.in);

    public teacherMenu() {
        this.scannerTeacherMenu = new Scanner(System.in);
    }

    public void display() {
        System.out.println("Teacher Menu" + "\n");

        System.out.println("(G)Add Student Grades, (V)View Department Board, (D)Add Department, (L)ogout");
    }

    public void run() {
        String choice;
        do {

            display();
            System.out.println("Please enter an option" + "\n");
            choice = scannerTeacherMenu.nextLine().toUpperCase();

            switch (input.nextLine().toUpperCase()) {
                case "G":
                    addStudentGrade();
                    break;
                case "V":
                    viewDepartmentBoard();
                    break;
                case "D":
                    addDepartment;
                    break;
                case"L":
                    System.out.println("Logging Out...");
                    break;
                default:
                    System.out.println("Invalid Choice");
            }
        } while (choice != L);
    }
    public static void main (String[] args) {
        teacherMenu teacherMenu = new teacherMenu;
        teacherMenu.run();
    }
}
