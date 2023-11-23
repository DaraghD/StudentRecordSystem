package CommandLineInterface;

import java.util.ArrayList;
import java.util.Scanner;

import Grading.Grade;
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
        loop:
        while (!exit) {
            System.out.println("(Q)CA, (G)rades, (M)odules, (L)ogout");
            String choice = input.nextLine().toUpperCase();
            switch (choice) {
                case "Q":
                    System.out.println("INPUT YEAR:");
                    int year = Integer.parseInt(input.nextLine());
                    System.out.println("INPUT SEMESTER:");
                    int semester = Integer.parseInt(input.nextLine());
                    System.out.println("INPUT MODULE:");
                    String module = input.nextLine();
                    int id = 22356363; //Test; To be removed

                    double qca;
                    qca = Grade.QCA(uni.getStudent(id), semester, module, year);
                    // above doesnt work need to make Grade non static and use grade object form student grades
                    System.out.println(qca);
                case "G":
                    ArrayList<Grade> studentGrades = currentUser.getGrades();
                    for (Grade grade : studentGrades) {
                        System.out.print(grade + "\n");
                    }
                    System.out.println("--------------------");
                    break;

                case "M":
                    ArrayList<String> temp = new ArrayList<String>();
                    for (Grade grade : currentUser.getGrades()) {
                        if (!temp.contains(grade.getModule())) {
                            temp.add(grade.getModule());
                        }
                        for (String m : temp) {
                            System.out.println(m);
                        }
                    }
                    break loop;
                case "L":
                    exit = true;
                    break loop;

                default:
                    System.out.print("Invalid Input");
                    break;
            }

        }
    }
}

//Display QCA, Display QCA,

