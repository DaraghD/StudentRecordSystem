import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Gradebook {
    private List<String> grades;

    public Gradebook() {
        this.grades = new ArrayList<>();
    }

    public void addGrade(String grade) {
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
                    addGrade(scanner, gradebook);
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

    private static void addGrade(Scanner scanner, Gradebook gradebook) {
        System.out.println("Enter the grade:");
        String grade = scanner.nextLine();
        gradebook.addGrade(grade);
        System.out.println("Grade added successfully.");
    }

    private static void deleteGrades(Scanner scanner, Gradebook gradebook) {
        System.out.println("Deleting all grades.");
        gradebook.deleteGrades();
        System.out.println("Grades deleted successfully.");
    }
}
