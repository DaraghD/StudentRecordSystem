import java.util.ArrayList;
import Grading.Grade;
import Grading.Module;
import Grading.Programme;
import Person.Student;
import University.University;

public class Department {

    private University university;

    private ArrayList<Programme> programmes = new ArrayList<Programme>();


    public void addProgramme(Programme programme){
        this.programmes.add(programme);
    }

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
                    totalSum += grade.convertGradeToNumber();
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
