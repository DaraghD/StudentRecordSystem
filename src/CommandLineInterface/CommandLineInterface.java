package CommandLineInterface;
import Person.Person;
import java.util.Scanner;

public class CommandLineInterface {

    static Scanner input = new Scanner(System.in);
    static Person currentUser; // when login set this to the reference of the logged in object


    public void init() {
        // set data up here , csv to variables etc
        // Student arraylist : csv convert to hashmap, student id -> transcript
        // department ?

    }

    public void run() {
        boolean LoggedIn = false;
        System.out.println("Welcome to the Student Record System!" + "\n");

        while (!LoggedIn) {
            System.out.println(
                    """
                            Please choose an option:
                            L)ogin
                            R)egister
                            Q)Quit
                            """
            );
            switch (input.nextLine().toUpperCase()) {
                case "L":
                    Login.Login();
                    LoggedIn = true;
                    break;
                case "R":
                    // Register brings them back to this loop where they can now login
                    // this is done through the LoggedIn variable with a while loop
                    Register.Register();
                    break;
                case "Q":
                    System.out.println("Closing program...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }

        //here LoggedIn is over, implement main menu
        boolean mainMenu = true;

        while (mainMenu) {

        }


    }


}
