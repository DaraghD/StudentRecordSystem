import java.util.ArrayList;

import Grading.Grade;
import Person.*;
import University.University;

public class Department {

    private University university;

    public void calculateAndDisplayAverageQCA() {
        System.out.println("Class average QCA:");

        double totalSum = 0.0;
        int totalGradesCount = 0;

        for (Student student : this.university.getStudents()) {

           // System.out.println("Student " + student.getStudentId() + " QCA:");

            for (Grade grade : student.getGrades()) {
                System.out.println("  QCA: " + grade.getGrade() + "|" + grade.convertGradeToNumber());
                totalSum += grade.convertGradeToNumber();
                totalGradesCount++;
            }
        }

        // Calculate and display the average of the entire class
        if (totalGradesCount > 0) {
            double classAverage = totalSum / totalGradesCount;
            System.out.println("Class Average QCA: " + classAverage);
        } else {
            System.out.println("No grades available for the class.");
        }
    }
}
