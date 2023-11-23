import Grading.Grade;
import Person.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Gradebook {
    private List<Grade> grades;
    private int id;

    public Gradebook() {
        this.grades = new ArrayList<>();
    }

    public void addGrade(Grade grade) {
        grades.add(grade);
    }

    public void deleteGrades() {
        grades.clear();
    }

    public void printGrades() {
        System.out.println("Grades: " + grades);
    }
}

public class GradingSystem {
    public static void main(String[] args) {
        Gradebook gradebook = new Gradebook();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("(V)iew Grades, (A)dd Grades, (D)elete Grades, (E)xit");

            String option = scanner.nextLine().toUpperCase();

            switch (option) {
                case "V":
                    gradebook.printGrades();
                    break;
                case "A":
                    addGrade(gradebook);
                    break;
                case "D":
                    deleteGrades(scanner, gradebook);
                    break;
                case "E":
                    System.out.println("Exiting program. Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
    public void showQCA(int studentId) {

    }
    public double calculateQCA(int studentId, String option){
        Student student = Student.getStudent(studentId);
        ArrayList<Grade> grades = student.getGrades();
        double total = 0.0;
        for(Grade grade : grades){
            total += grade.convertGradeToNumber();
        }
        return total/grades.size();
    }











    private static void addGrade(Gradebook gradebook) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter student id of student to add grade to:");
        String id = input.nextLine();
        System.out.println("Enter the course");
        String course = input.nextLine();
        System.out.println("Enter the grade e.g A1,A2 etc:");
        String grade = input.nextLine();
        System.out.println("Enter the semester, 1 or 2:");
        int semester = Integer.parseInt(input.nextLine());
        System.out.println("Enter the :");
        String module = input.nextLine();
        System.out.println("Enter the year:");
        int year = Integer.parseInt(input.nextLine());

        Grade newGrade =  new Grade(course, grade, semester, module, year);
    }

    private static void deleteGrades(Scanner scanner, Gradebook gradebook) {
        System.out.println("Deleting all grades.");
        gradebook.deleteGrades();
        System.out.println("Grades deleted successfully.");
    }
}
