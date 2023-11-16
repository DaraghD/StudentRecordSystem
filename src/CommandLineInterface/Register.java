package CommandLineInterface;
import Person.Person;


import java.util.Scanner;

public class Register {

    public static void Register(){
        Scanner in = new Scanner(System.in);
        System.out.println("Please choose to register as a Student or Teacher");
        System.out.println("Type S for Student or T for Teacher");
        switch(in.nextLine().toUpperCase()){
            case "S":
                Person.registerInfo(false);
                break;
            case "T":
                Person.registerInfo(true);
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }

    }


}
