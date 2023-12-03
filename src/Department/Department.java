package Department;

import Grading.Grade;
import University.Programme;
import Person.Student;
import University.University;
import csvUtils.CSVFormat;

import java.util.ArrayList;

/**
 * Class for a department in a university.
 */
public class Department implements CSVFormat {

    /** The university of which the department belongs to. */
    private final University university;

    /** The list of programmes offered by the department. */
    private final ArrayList<Programme> programmes = new ArrayList<Programme>();

    /** The name of the department. */
    private final String name;

    /**
     * Gets the name of the department.
     *
     * @return The name of the department.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the list of programmes from the department.
     *
     * @return The list of programmes offered by the department.
     */
    public ArrayList<Programme> getProgrammes(){
        return programmes;
    }

    /**
     * Constructs a new department with the specified name and university.
     *
     * @param name The name of the department.
     * @param uni  The university to which the department belongs.
     */
    public Department(String name, University uni) {
        this.name = name;
        this.university = uni;
    }

    /**
     * Adds a programme to the list of programmes in the department.
     *
     * @param programme The programme to be added.
     */
    public void addProgramme(Programme programme) {
        this.programmes.add(programme);
    }

    /**
     * Gets the programme with the specified name.
     *
     * @param programmeName The name of the programme to return.
     * @return The programme with the specified name, or null if not found.
     */
    public Programme getProgramme(String programmeName) {
        for (Programme programme : programmes) {
            if (programme.getName().equals(programmeName)) {
                return programme;
            }
        }
        return null;
    }

    /**
     * Removes the programme with the specified name from the list of programmes.
     *
     * @param programmeName The name of the programme to remove.
     */
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

    /**
     * Calculates and displays the average QCA for a specified module.
     *
     * @param moduleCode The code of the module for which to calculate the average QCA.
     */
    public void calculateAndDisplayAverageQCAForModule(String moduleCode) {
        System.out.println("Class average QCA for module " + moduleCode + ":");

        double totalSum = 0.0;
        int totalGradesCount = 0;

        // Iterate over students
        for (Student student : this.university.getStudents()) {
            // Iterate over grades of each student
            for (Grade grade : student.getGrades()) {
                // Check if the module matches the specified moduleCode
                if (grade.getModule().getName().equals(moduleCode)) {
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

    /**
     * Displays the students who failed a specified module based on their QCA.
     *
     * @param moduleCode The code of the module for which to display failed students.
     */
    public void displayFailedStudentsForModule(String moduleCode) {
        System.out.println("Students who failed module " + moduleCode + ":");

        //Iterate over students
        for (Student student : this.university.getStudents()) {
            double totalSum = 0.0;
            int totalGradesCount = 0;

            // Iterate over grades of each student
            for (Grade grade : student.getGrades()) {
                // Check if the module matches the specified moduleCode
                if (grade.getModule().getName().equals(moduleCode)) {
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


