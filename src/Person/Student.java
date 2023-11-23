package Person;

import Grading.Grade;
import University.University;

import java.util.ArrayList;
import java.util.Scanner;

public class Student extends Person {
    //need grades arraylist or something here
    private ArrayList<Grade> grades = new ArrayList<>();

    public Student(String name, int id, String password, University uni) {
        super(name, id, password, uni);
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

        Grade newGrade =  new Grade(course, grade, semester, module);
        grades.add(newGrade);

    }

    public ArrayList<Grade> getGrades() {
        return grades;
    }

    
}
