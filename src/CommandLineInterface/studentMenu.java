package CommandLineInterface;

import java.util.ArrayList;
import java.util.Scanner;

import Grading.Grade;
import Grading.Module;
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
            System.out.println("(Q)CA, (G)rades, (M)odules, (L)ogout");
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

                default:
                    System.out.print("Invalid Input");
                    break;
            }

        }
    }
}

//Display QCA, Display QCA,

