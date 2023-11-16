package CommandLineInterface;
import Teacher.Teacher;


import java.util.Scanner;

public class Register {

    public static void Register(){
        Scanner in = new Scanner(System.in);
        System.out.println("Please choose to register as a Student or Teacher");
        System.out.println("Type S for Student or T for Teacher");
        switch(in.nextLine().toUpperCase()){
            case "S":
                break;
            case "T":
                Teacher.registerInfo();
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }

    }


}
