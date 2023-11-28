package CommandLineInterface;

import java.util.ArrayList;
import java.util.Scanner;

import Department.Department;
import Grading.Grade;
import Grading.Module;
import Grading.Programme;
import Grading.Semester;
import Person.Student;
import University.University;

/**
 * Provides a menu displaying all potential student actions.
 *
 * Variables "currentUser"(current logged-in user) and "uni" of type "Student" and "University" respectively are initialised.
 */

public class studentMenu {
    static Scanner input = new Scanner(System.in);
    private Student currentUser;
    private University uni;

    /**
     * Creates an instance of studentMenu.
     *
     * @param student refers to the student logged into the system.
     * @param uni the university which the student belongs to.
     */
    studentMenu(Student student, University uni) {
        this.currentUser = student;
        this.uni = uni;
    }

    /**
     * Runs the student menu.
     *
     * Prompts the user to view QCA, grades, modules etc.
     */
    public void run() {
        boolean exit = false;

        while (!exit) {
            System.out.println();
            System.out.println();
            System.out.println();
            //TODO: need transcript option, maybe should replace qca or grades
            System.out.println("Logged in as " + currentUser.getName() + " (Student)");
            if (currentUser.getCurrentProgramme() == null) {
                System.out.println("Not enrolled in a programme");
            } else if (currentUser.getCurrentProgramme() != null) {
                System.out.println("Enrolled in " + currentUser.getCurrentProgramme().getName());
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
            //TODO MAKE THIS LIKE THE OTHERS ^^
            String choice = input.nextLine().toUpperCase();
            switch (choice) {
                case "Q":
                    //Getting unique modules, but not fully working caue of string references?
                    ArrayList<Module> temp2 = new ArrayList<>();
                    for (Grade grade : currentUser.getGrades()) {
                        if (!temp2.contains(grade.getModule())) {
                            temp2.add(grade.getModule());
                        }
                        for (Module m : temp2) {
                            System.out.println(m.getName());
                        }
                    }
                    System.out.println("Input module to check QCA:");
                    String module = input.nextLine();
                    System.out.println("QCA:" + currentUser.QCA(module));
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
                    System.out.println("--------------------");
                    break;

                case "M":
                    temp2 = new ArrayList<>();
                    for (Grade grade : currentUser.getGrades()) {
                        if (!temp2.contains(grade.getModule())) {
                            temp2.add(grade.getModule());
                        }
                        for (Module m : temp2) {
                            System.out.println(m.getName());
                        }
                    }
                    break;
                case "L":
                    exit = true;
                    System.out.println("Logging Out...");
                    break;
                case "T":
                    if(currentUser.getCurrentProgramme() == null){
                        System.out.println("Not enrolled in a programme");
                        break;
                    }
                    Semester a = Semester.AUTUMN;
                    Semester b = Semester.SPRING;
                    System.out.println("--------------------");
                    System.out.println("STUDENT TRANSCRIPT");
                    System.out.println("NAME : "+ currentUser.getName() +"\n ID : " + currentUser.getId() +" \n PROGRAMME : " + currentUser.getCurrentProgramme().getName());
                    System.out.println("--------------------");
                    System.out.println("OVERALL QCA :" + currentUser.totalQCA());
                    System.out.println("--------------------");
                    System.out.println("QCA PER YEAR");
                    System.out.println("YEAR 1 : " + currentUser.qcaPerYear(1));
                    System.out.println("YEAR 2 : " + currentUser.qcaPerYear(2));
                    System.out.println("YEAR 3 : " + currentUser.qcaPerYear(3));
                    System.out.println("YEAR 4 : " + currentUser.qcaPerYear(4));
                    System.out.println("--------------------");
                    System.out.println("QCA PER SEMESTER");
                    System.out.println("YEAR 1 AUTUMN : " + currentUser.qcaPerSemeseter(1,a));
                    System.out.println("YEAR 1 SPRING : " + currentUser.qcaPerSemeseter(1,b));
                    System.out.println("YEAR 2 AUTUMN : " + currentUser.qcaPerSemeseter(2,a));
                    System.out.println("YEAR 2 SPRING : " + currentUser.qcaPerSemeseter(2,b));
                    System.out.println("YEAR 3 AUTUMN : " + currentUser.qcaPerSemeseter(3,a));
                    System.out.println("YEAR 3 SPRING : " + currentUser.qcaPerSemeseter(3,b));
                    System.out.println("YEAR 4 AUTUMN : " + currentUser.qcaPerSemeseter(4,a));
                    System.out.println("YEAR 4 SPRING : " + currentUser.qcaPerSemeseter(4,b));
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