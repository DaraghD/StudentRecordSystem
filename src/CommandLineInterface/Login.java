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

        checkPassword(id, actualPassword);
        System.out.println("Welcome " + Teacher.getTeacher(id).getName());
        CommandLineInterface.currentUser = Teacher.getTeacher(id);
    }

    private static void studentLogin() {
        System.out.println("Please enter your id");
        int id = Integer.parseInt(CommandLineInterface.input.nextLine());
        String actualPassword = Student.getPassword(id);
        checkPassword(id, actualPassword);
        System.out.println("Welcome " + Student.getStudent(id).getName());
        CommandLineInterface.currentUser = Student.getStudent(id);
    }

    private static void checkPassword(int id, String actualPassword) {
        System.out.println("Please enter your password");
        String password = CommandLineInterface.input.nextLine();
        while(!(password.equals(actualPassword))){
            System.out.println("Incorrect password");
            System.out.println("Please enter your password");
            password = CommandLineInterface.input.nextLine();
        }
        System.out.println("Logged in ID : " + id);
    }


}
