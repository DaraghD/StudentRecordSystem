package CommandLineInterface;

import Person.Teacher;
import Person.Student;

import java.util.Scanner;

public class Login {

    public static void Login() {
        System.out.println("Type T for teacher or S for student");
        Scanner in = new Scanner(System.in);
        switch (in.nextLine().toUpperCase()) {
            case "T":
                teacherLogin();
                break;
            case "S":
                studentLogin();
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
    }

    private static void teacherLogin() {
        System.out.println("Please enter your id");
        int id = Integer.parseInt(CommandLineInterface.input.nextLine());
        String actualPassword = Teacher.getPassword(id);

        System.out.println("Please enter your password");
        String password = CommandLineInterface.input.nextLine();
        if (password.equals(actualPassword)) {
            System.out.println("Logged in ID : " + id);
            System.out.println("Welcome " + Teacher.getTeacher(id).getName());

            CommandLineInterface.currentUser = Teacher.getTeacher(id);
        } else {
            System.out.println("Incorrect password");
        }
    }

    private static void studentLogin() {
        System.out.println("Please enter your id");
        int id = Integer.parseInt(CommandLineInterface.input.nextLine());
        String actualPassword = Student.getPassword(id);

        System.out.println("Please enter your password");
        String password = CommandLineInterface.input.nextLine();
        if (password.equals(actualPassword)) {
            System.out.println("Logged in ID : " + id);
            System.out.println("Welcome " + Student.getStudent(id).getName());
            CommandLineInterface.currentUser = Student.getStudent(id);
        } else {
            System.out.println("Incorrect password");
        }
    }


}
