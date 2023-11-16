package CommandLineInterface;

import java.util.Scanner;

public class CommandLineInterface {

    //maybe we should use a static scanner scanner here?

    public void init() {
        // set data up here , csv to variables etc
        // Student arraylist : csv convert to hashmap, student id -> transcript
        // department ?

    }

    public void run() {
        Scanner input = new Scanner(System.in);
        boolean LoggedIn = false;
        while (!LoggedIn) {
            System.out.println("Welcome to the Student Record System!" + "\n");
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
                    System.out.println("Login");
                    Login.Login(); // Login brings them to "main menu"
                    LoggedIn = true;
                    break;
                case "R":
                    System.out.println("Register"); // Register brings them back to this loop where they can now login
                    Register.Register();            // this is done through the LoggedIn variable with a while loop
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


    }


}
