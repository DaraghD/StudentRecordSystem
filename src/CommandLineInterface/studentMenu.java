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
        System.out.println("(Q)CA, (G)rades, (M)odules, (L)ogout");
        String choice = input.nextLine().toUpperCase();

        if (choice.equals("Q")) {

            System.out.println("INPUT YEAR:");
            int year = Integer.parseInt(input.nextLine());
            System.out.println("INPUT SEMESTER:");
            int semester = Integer.parseInt(input.nextLine());
            System.out.println("INPUT MODULE:");
            String module = input.nextLine();

            int id = 22356363; //Test; To be removed

            double qca;
            qca = Grade.QCA(uni.getStudent(id), semester, module, year);
            System.out.println(qca);

        } else if (choice.equals("G")) {
            ArrayList<Grade> studentGrades = currentUser.getGrades();
            for (Grade grade : studentGrades) {
                System.out.print(grade + "\n");
            }

        } else if (choice.equals("M")) {
            ArrayList<String> temp = new ArrayList<String>();
            for (Grade grade : currentUser.getGrades()) {
                String module = grade.getModule();
                if (!temp.contains(module)) {
                    temp.add(module);
                }
                for (String m : temp) {
                    System.out.println(m);
                }
            }
        } else if (choice.equals("L")) {

        } else {
            System.out.print("Invalid Input");
        }


    }}

//Display QCA, Display QCA,

