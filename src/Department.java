import java.util.ArrayList;

public class Department {

    public void calculateAndDisplayAverageQCA(ArrayList<Student> students) {
        System.out.println("Class average QCA:");

        double totalSum = 0.0;
        int totalGradesCount = 0;

        for (Student student : students) {
            System.out.println("Student " + student.getStudentId() + " QCA:");

            for (Double grade : student.getGrades()) {
                System.out.println("  QCA: " + grade);
                totalSum += grade;
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
