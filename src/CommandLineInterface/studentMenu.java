package CommandLineInterface;

import java.util.ArrayList;
import java.util.Scanner;

import Department.Department;
import Grading.Grade;
import Grading.Module;
import Grading.Programme;
import Person.Student;
import University.University;

public class studentMenu {
    static Scanner input = new Scanner(System.in);
    private Student currentUser;
    private University uni;

    studentMenu(Student student, University uni) {
        this.currentUser = student;
        this.uni = uni;
    }

    public void run() {
        boolean exit = false;

        while (!exit) {
            //TODO: need transcript option, maybe should replace qca or grades
            System.out.println("(Q)CA, (G)rades, (M)odules, (L)ogout, (T)ranscript, (P)rogramme");
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
                    break;
                case "P":
                    //2 menus one for if programme the other if not
                    if(currentUser.getCurrentProgramme() != null){
                        System.out.println("Current Programme: " + currentUser.getCurrentProgramme().getName());
                        System.out.println("Would you like to leave this programme? (Y/n)");
                        String choice2 = input.nextLine().toUpperCase();
                        if(choice2.equals("Y")){
                            currentUser.setProgramme(null);
                        }
                        else{
                            System.out.println("Programme not removed");
                        }
                        break;
                    }
                    else{
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
                    while(uni.getProgramme(programmeName) == null){
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