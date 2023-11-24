package Person;

import Grading.Grade;
import University.University;

import java.util.ArrayList;
import java.util.Scanner;

public class Student extends Person {
    //need grades arraylist or something here
    private ArrayList<Grade> grades = new ArrayList<>();

    public Student(String name, int id, String password) {
        super(name, id, password);
    }

    public void addGrade(Grade grade) {
        grades.add(grade);
    }

    public void ViewTranscript() {

    }

    public void addGrade() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter student id of student to add grade to:");
        String id = input.nextLine();
        System.out.println("Enter the course");
        String course = input.nextLine();
        System.out.println("Enter the grade e.g A1,A2 etc:");
        String grade = input.nextLine();
        System.out.println("Enter the semester, 1 or 2:");
        int semester = Integer.parseInt(input.nextLine());
        System.out.println("Enter the module:");
        String module = input.nextLine();
        System.out.println("Enter the year:");
        int year = Integer.parseInt(input.nextLine());

        Grade newGrade =  new Grade(course, grade, semester, module,year);
        grades.add(newGrade);

    }

    public ArrayList<Grade> getGrades() {
        return grades;
    }


    public double QCA(String module) {
        //calculates QCA for given semester module and year
        double total = 0;
        int counter = 0;
        for (Grade grade : this.grades) {
            if (grade.getModule().equals(module)) {
                total += grade.convertGradeToNumber();
                counter++;
            }
        }
        return total / counter;
    }

    
}
