package CommandLineInterface;

import java.util.ArrayList;
import java.util.Scanner;

import Department.Department;
import University.Programme;
import Grading.Module;
import Grading.*;
import Person.Student;
import University.University;
import University.*;

/**
 * Provides a menu displaying all potential student actions which the student user can interact with.
 * <p>
 * Variables "currentUser"(current logged-in user) and "uni" of type "Student" and "University" respectively are initialised.
 */

public class studentMenu {
    static Scanner input = new Scanner(System.in);
    private final Student currentUser;
    private final University uni;

    /**
     * Creates an instance of studentMenu.
     *
     * @param student Refers to the student logged into the system.
     * @param uni     The university which the student belongs to.
     */
    studentMenu(Student student, University uni) {
        this.currentUser = student;
        this.uni = uni;
    }

    /**
     * Runs the student menu.*
     * Prompts the user to view QCA, grades, modules, programme, messages, transcript or alternatively, logout.
     */
    public void run() {
        boolean exit = false;

        while (!exit) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("Logged in as " + currentUser.getName() + " (Student)");
            if (currentUser.getCurrentProgramme() == null) {
                System.out.println("Not enrolled in a programme");
            } else if (currentUser.getCurrentProgramme() != null) {
                System.out.println("Enrolled in " + currentUser.getCurrentProgramme().getName());
            }
            double QCA = currentUser.totalQCA();
            if(currentUser.getGrades().isEmpty()){
                System.out.println("You have no grades");
            }
            else{
                System.out.println("Your QCA is " + QCA);
                if(QCA >= currentUser.getCurrentProgramme().getCutoffQCA()){
                    System.out.println("You are meeting the minimum academic requirements for progression");
                }
                else{
                    System.out.println("You are not meeting the minimum academic requirements for progression");
                }
            }
            System.out.println("""
                    Please enter an option
                    Q - QCA
                    G - Grades
                    M - Modules
                    P - Programme
                    V - View Messages
                    T - Transcript
                    L - Logout
                    """);
            String choice = input.nextLine().toUpperCase();
            switch (choice) {
                case "Q":
                    //Getting unique modules, but not fully working caue of string references?

                    System.out.println("QCA:" + currentUser.totalQCA());
                    break;
                case "V":
                    if (currentUser.getMessages().isEmpty()) {
                        System.out.println("No messages");
                        break;
                    }
                    for (String message : currentUser.getMessages()) {
                        System.out.println(message);
                    }
                    break;
                case "G":
                    ArrayList<Grade> studentGrades = currentUser.getGrades();
                    for (Grade grade : studentGrades) {
                        System.out.print(grade + "\n");
                    }
                    if (studentGrades.isEmpty()) {
                        System.out.print("No grades available.\n A teacher must add a grade for you.");
                    }
                    System.out.println("--------------------");
                    break;

                case "M":
                    ArrayList<Module> modules = currentUser.getCurrentProgramme().getModules();
                    for (Module module : modules) {
                        System.out.print(module.getName());
                    }
                    if (modules.isEmpty()) {
                        System.out.print("No grades available.\n A teacher must add a grade for you.");
                    }
                    break;

                case "L":
                    exit = true;
                    System.out.println("Logging Out...");
                    break;
                case "T":
                    if (currentUser.getCurrentProgramme() == null) {
                        System.out.println("Not enrolled in a programme");
                        break;
                    }
                    currentUser.transcript();
                    break;
                case "P":
                    //2 menus one for if programme the other if not
                    if (currentUser.getCurrentProgramme() != null) {
                        System.out.println("Current Programme: " + currentUser.getCurrentProgramme().getName());
                        System.out.println("Would you like to leave this programme? (Y/n)");
                        String choice2 = input.nextLine().toUpperCase();
                        if (choice2.equals("Y")) {
                            currentUser.setProgramme(null);
                        } else {
                            System.out.println("Programme not removed");
                        }
                        break;
                    } else {
                        int count = 0;
                        for (Department department : uni.getDepartments()) {
                            for (Programme prog : department.getProgrammes()) {
                                System.out.println(prog.getName());
                                count++;
                            }
                        }
                        if (count == 0) {
                            System.out.println("No programmes to join, a member of faculty must add one");
                            break;
                        }
                        System.out.println("Enter programme name");
                        String programmeName = input.nextLine();
                        while (uni.getProgramme(programmeName) == null) {
                            System.out.println("Programme does not exist, try again");
                            programmeName = input.nextLine();
                        }
                        Programme programme = uni.getProgramme(programmeName);
                        currentUser.setProgramme(programme);
                    }
                    break;
                default:
                    System.out.print("Invalid Input");
                    break;
            }

        }
    }
}