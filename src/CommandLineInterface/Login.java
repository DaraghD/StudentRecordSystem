package CommandLineInterface;
import java.util.Scanner;

public class Login {

    public static void Login(){
        System.out.println("Type T for teacher or S for student");
        Scanner in = new Scanner(System.in);
        switch(in.nextLine().toUpperCase()){
            case "T":
                System.out.println("Teacher login");
                break;
            case "S":
                System.out.println("Student login");
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
    }



    private static void teacherLogin(){

    }

    private static void studentLogin(){

    }
}
