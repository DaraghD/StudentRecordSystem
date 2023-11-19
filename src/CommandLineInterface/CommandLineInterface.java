package CommandLineInterface;

import Person.Person;
import csvUtils.csvWriter;
import csvUtils.csvParser;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


public class CommandLineInterface {

    static Scanner input = new Scanner(System.in);
    static Person currentUser; // when login set this to the reference of the logged in object


    public static void init() throws IOException {
        csvParser.parseTeachers();
        csvParser.parseStudents();

        // set data up here , csv to variables etc --->> CSV PARSER
        // Student arraylist : csv convert to hashmap, student id -> transcript
        // department ?


    }

    public static void run() {
        boolean LoggedIn = false;
        boolean exit = false;
        System.out.println("Welcome to the Student Record System!" + "\n");

        while ((!LoggedIn) || exit) {
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
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }

        //here LoggedIn is over, implement main menu
        boolean mainMenu = true;
        if (exit) {
            mainMenu = false;
        }

        while (mainMenu) { //different one for teacher and student?

        }


    }


    public static void shutdown() throws FileNotFoundException {
        csvWriter.writeTeachers();
        csvWriter.writeStudents();

        // save data here CSVWRITER
    }

}
