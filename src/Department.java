import java.util.ArrayList;
import Grading.Grade;
import Person.Student;
import University.University;

public class Department {

    private University university;

    public void calculateAndDisplayAverageQCAForModule(String moduleCode) {
        System.out.println("Class average QCA for module " + moduleCode + ":");

        double totalSum = 0.0;
        int totalGradesCount = 0;

        // Iterate over students
        for (Student student : this.university.getStudents()) {
            // Iterate over grades of each student
            for (Grade grade : student.getGrades()) {
                // Check if the module matches the specified moduleCode
                if (grade.getModule().equals(moduleCode)) {
                    // Check the grade using if loops and convertGradeToNumber method
                    if (grade.getGrade().equals("A1")) {
                        totalSum += 4.0;
                    } else if (grade.getGrade().equals("A2")) {
                        totalSum += 3.6;
                    } else if (grade.getGrade().equals("B1")) {
                        totalSum += 3.2;
                    } else if (grade.getGrade().equals("B2")) {
                        totalSum += 3.0;
                    } else if (grade.getGrade().equals("B3")) {
                        totalSum += 2.8;
                    } else if (grade.getGrade().equals("C1")) {
                        totalSum += 2.6;
                    } else if (grade.getGrade().equals("C2")) {
                        totalSum += 2.4;
                    } else if (grade.getGrade().equals("C3")) {
                        totalSum += 2.0;
                    } else if (grade.getGrade().equals("D1")) {
                        totalSum += 1.6;
                    } else if (grade.getGrade().equals("D2")) {
                        totalSum += 1.2;
                    } else if (grade.getGrade().equals("F")) {
                        // For "F" grade, no addition to the totalSum
                    }
                    totalGradesCount++;
                }
            }
        }

        // Calculate and display the average of the specified module
        if (totalGradesCount > 0) {
            double moduleAverage = totalSum / totalGradesCount;
            System.out.println("Average QCA for module " + moduleCode + ": " + moduleAverage);
        } else {
            System.out.println("No grades available for the specified module.");
        }
    }
}
