package CommandLineInterface;

import Person.Person;
import csvUtils.csvWriter;
import csvUtils.csvParser;
import University.University;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import Person.*;


public class CommandLineInterface {

    static Scanner input = new Scanner(System.in);
    static Person currentUser; // when login set this to the reference of the logged in object

    private University UL;


    public CommandLineInterface() {
        this.UL = new University();
    }

    public void init() throws IOException {
        UL.setStudentsPath("src/data/students.csv");
        UL.setTeachersPath("src/data/teachers.csv");


        csvParser data = new csvParser(UL);
        data.parseTeachers();
        data.parseStudents();

        // set data up here , csv to variables etc --->> CSV PARSER.
        // Student arraylist : csv convert to hashmap, student id -> transcript
        // department


    }


    public void run() {
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
                    System.out.println("Type T for teacher or S for student");
                    Scanner in = new Scanner(System.in);
                    switch (in.nextLine().toUpperCase()) {
                        case "T":
                            System.out.println("Please enter your id");
                            int id = Integer.parseInt(CommandLineInterface.input.nextLine());
                            String actualPassword = UL.getPassword(id);
                            checkPassword(id, actualPassword);
                            System.out.println("Welcome " + UL.getTeacher(id).getName());
                            CommandLineInterface.currentUser = UL.getTeacher(id);
                            break;
                        case "S":
                            System.out.println("Please enter your id");
                            id = Integer.parseInt(CommandLineInterface.input.nextLine());
                            actualPassword = UL.getPassword(id);
                            checkPassword(id, actualPassword);
                            System.out.println("Welcome " + UL.getStudent(id).getName());
                            CommandLineInterface.currentUser = UL.getStudent(id);
                            break;
                        default:
                            System.out.println("Invalid choice");
                            break;
                    }
                case "R": // register
                    System.out.println("Please choose to register as a Student or Teacher");
                    System.out.println("Type S for Student or T for Teacher");
                    switch (input.nextLine().toUpperCase()) {
                        case "S":
                            System.out.println("You are now registering as a student\n");
                            System.out.println("Please enter your name");
                            String name = input.nextLine();
                            System.out.println("Please enter your id");
                            int id = Integer.parseInt(input.nextLine());
                            while (UL.uniqueID(id) != true) {
                                System.out.println("This id is already taken");
                                System.out.println("Please enter a new id");
                                id = Integer.parseInt(input.nextLine());
                            }
                            System.out.println("Please enter your password");
                            String password = input.nextLine();
                            System.out.println("Please confirm your password ");
                            String password2 = input.nextLine();
                            while (!(password.equals(password2))) {
                                System.out.println("Your passwords do not match");
                                System.out.println("Please enter your password");
                                password = input.nextLine();
                                System.out.println("Please confirm your password ");
                                password2 = input.nextLine();
                            }
                            UL.addStudent(new Student(name, id, password, UL));
                            System.out.println("You have successfully registered as a student");
                            break;
                        case "T":
                            System.out.println("You are now registering as a teacher\n");
                            System.out.println("Please enter your name");
                            String nameT = input.nextLine();
                            System.out.println("Please enter your id");
                            int idT = Integer.parseInt(input.nextLine());
                            while (UL.uniqueID(idT) != true) {
                                System.out.println("This id is already taken");
                                System.out.println("Please enter a new id");
                                idT = Integer.parseInt(input.nextLine());
                            }
                            System.out.println("Please enter your password");
                            String passwordT = input.nextLine();
                            System.out.println("Please confirm your password ");
                            String passwordT2 = input.nextLine();
                            while (!(passwordT.equals(passwordT2))) {
                                System.out.println("Your passwords do not match");
                                System.out.println("Please enter your password");
                                password = input.nextLine();
                                System.out.println("Please confirm your password ");
                                password2 = input.nextLine();
                            }
                            System.out.println("Please enter your department");
                            String department = input.nextLine();
                            UL.addTeacher(new Teacher(nameT, idT, department, passwordT, UL));
                            System.out.println("You have successfully registered as a teacher");
                            break;
                        default:
                            System.out.println("Invalid choice");
                            break;
                    }
                    break;
                case "Q":
                    System.out.println("Closing program...");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;

            }

            //here LoggedIn is over, implement main menu
            boolean mainMenu = true;
            if (exit) {
                mainMenu = false;
            }

            while (mainMenu) { //different one for teacher and student?

            }


        }
    }

    private static void checkPassword(int id, String actualPassword) {
        System.out.println("Please enter your password");
        String password = CommandLineInterface.input.nextLine();
        while (!(password.equals(actualPassword))) {
            System.out.println("Incorrect password");
            System.out.println("Please enter your password");
            password = CommandLineInterface.input.nextLine();
        }
        System.out.println("Logged in ID : " + id);

    }

    public void shutdown() throws FileNotFoundException {
        //saves data to csv files
        csvWriter csvWriter= new csvWriter(UL);
        csvWriter.writeTeachers();
        csvWriter.writeStudents();
    }
}
