package Department;

import java.util.ArrayList;

import Grading.Grade;
import Grading.Module;
import Grading.Programme;
import Person.Student;
import University.University;
import csvUtils.CSVFormat;

public class Department implements CSVFormat {

    private final University university;

    private ArrayList<Programme> programmes = new ArrayList<Programme>();

    private String name;

    public String getName() {
        return name;
    }
    public ArrayList<Programme> getProgrammes(){
        return programmes;
    }

    public Department(University uni) { //TODO: change all constructors to be use name arg
        this.university = uni;
    }

    public Department(String name, University uni) {
        this.name = name;
        this.university = uni;
    }

    public void addProgramme(Programme programme) {
        this.programmes.add(programme);
    }

    public Programme getProgramme(String programmeName) {
        for (Programme programme : programmes) {
            if (programme.getName().equals(programmeName)) {
                return programme;
            }
        }
        return null;
    }

    public void removeProgramme(String programmeName) {
        for (Programme programme : programmes) {
            if (programme.getName().equals(programmeName)) {
                programmes.remove(programme);
                System.out.println("Programme removed");
                return;
            }
        }
        System.out.println("Programme not found");
    }

    @Override
    public String csvFormat(){;
        return this.name;
    }
    @Override
    public String csvHeader(){
        return "Name";
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


    public void displayFailedStudentsForModule(String moduleCode) {
        System.out.println("Students who failed module " + moduleCode + ":");

        //Iterate over students
        for (Student student : this.university.getStudents()) {
            double totalSum = 0.0;
            int totalGradesCount = 0;

            // Iterate over grades of each student
            for (Grade grade : student.getGrades()) {
                // Check if the module matches the specified moduleCode
                if (grade.getModule().equals(moduleCode)) {
                    // Check the grade using if loops and convertGradeToNumber method
                    totalSum += grade.convertGradeToNumber();
                    totalGradesCount++;
                }
            }

            //Calculate the QCA for the module
            double moduleQCA = (totalGradesCount > 0) ? (totalSum / totalGradesCount) : 0.0;

            //Check if the moduleQCA is less than 2.0 (failure)
            if (moduleQCA < 2.0) {
                System.out.println("Student ID: " + student.getId() + ", Name: " + student.getName());
            }
        }
    }

}


