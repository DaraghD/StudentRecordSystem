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

    public static String getPassword(int id){
        for(Student student : University.getStudents()){
            if(student.getId() == id){
                return student.getPassword();
            }
        }
        return null;
    }
    public static Student getStudent(int id){
        for(Student student : University.getStudents()){
            if(student.getId() == id){
                return student;
            }
        }
        return null;
    }



    public static void register(String name, int id, String password) {
        Student newStudent = new Student(name, id, password);
        //check if teacher already exists -> maybe do this for ID earlier in the above method
        University.addStudent(newStudent);
        System.out.println("You have successfully registered as a student");

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
        System.out.println("Enter the programme:");
        String programme = input.nextLine();

        Grade newGrade =  new Grade(course, grade, semester, programme);
        grades.add(newGrade);
    }

    public ArrayList<Grade> getGrades() {
        return grades;
    }
}
