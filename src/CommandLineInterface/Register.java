package CommandLineInterface;

import Person.*;
import java.util.Scanner;

public class Register {

    public static void Register(){
        Scanner in = new Scanner(System.in);
        System.out.println("Please choose to register as a Student or Teacher");
        System.out.println("Type S for Student or T for Teacher");
        switch(in.nextLine().toUpperCase()){
            case "S":
                registerInfo(false); // move this to a different class ? maybe this one
                break;
            case "T":
                registerInfo(true);
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }

    }

    private static void registerInfo(boolean isTeacher){
        String department = null;
        Scanner in = new Scanner(System.in);
        System.out.print("You are now registering as a ");
        if (isTeacher) {
            System.out.println("teacher\n");
        } else {
            System.out.println("student\n");
        }

        System.out.println("Please enter your name");
        String name = in.nextLine();

        System.out.println("Please enter your id");
        int id = Integer.parseInt(in.nextLine());
        while(Person.uniqueID(id) != true){
            System.out.println("This id is already taken");
            System.out.println("Please enter a new id");
            id = Integer.parseInt(in.nextLine());
        }

        if (isTeacher) {
            System.out.println("Please enter your department");
            department = in.nextLine();
        }

        System.out.println("Please enter your password");
        String password = in.nextLine();

        System.out.println("Please confirm your password ");
        String password2 = in.nextLine();

        while (!(password.equals(password2))) {
            System.out.println("Your passwords do not match");
            System.out.println("Please enter your password");
            password = in.nextLine();
            System.out.println("Please confirm your password ");
            password2 = in.nextLine();
        }
        //if out of while loop password is now confirmed
        if (isTeacher) {
            Teacher.register(name, id, department, password);
        } else { // else is student
            Student.register(name, id, password);
        }

    }


}
