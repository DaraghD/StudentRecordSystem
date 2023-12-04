package Department;

import Grading.Grade;
import University.Programme;
import Person.Student;
import University.University;
import csvUtils.csvFormat;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class for a department in a university.
 */
public class Department implements csvFormat {

    /**
     * The university of which the department belongs to.
     */
    private final University university;

    /**
     * The list of programmes offered by the department.
     */
    private final ArrayList<Programme> programmes = new ArrayList<Programme>();

    /**
     * The name of the department.
     */
    private final String name;

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
    public ArrayList<Programme> getProgrammes() {
        return programmes;
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
            if (programme.getName().equalsIgnoreCase(programmeName)) {
                programmes.remove(programme);
                System.out.println("Programme removed");
                return;
            }
        }
        System.out.println("Programme not found");
    }

    @Override
    public String csvFormat() {
        ;
        return this.name;
    }

    @Override
    public String csvHeader() {
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



    public void reviewTotalProgression() {
        System.out.println("Reviewing progression for Department : " + name);
        System.out.println("---------------------");
        for (Programme prog : programmes) {
            int studentsPassing = 0;
            int studentsFailing = 0;

            int totalStudents = prog.getStudents().size();

            double cutoff = prog.getCutoffQCA();
            double totalQCA = 0.0;
            for (Student student : prog.getStudents()) {
                if (student.getGrades().isEmpty()) {
                    continue;
                }
                double QCA = student.totalQCA();
                totalQCA += QCA;
                if (QCA >= cutoff) {
                    studentsPassing++;
                } else {
                    studentsFailing++;
                }
            }
            double failPercentage = 0.0;
            double passPercentage = 0.0;

            if (totalStudents > 0 && studentsFailing > 0) {
                failPercentage = ((double) studentsFailing / totalStudents) * 100;
            }
            if (totalStudents > 0 && studentsPassing > 0) {
                passPercentage = ((double) studentsPassing / totalStudents) * 100;
            }
            System.out.println("---------------------");
            System.out.println("Programme : " + prog.getName());
            System.out.println("Total Students : " + totalStudents);
            System.out.println("Students passing : " + studentsPassing);
            System.out.println("Pass Percentage : " + passPercentage);
            System.out.println("Fail Percentage : " + failPercentage);
            System.out.println("Students failing : " + studentsFailing);
            System.out.println("Average QCA : " + totalQCA / totalStudents);
        }
    }

    public void reviewYearProgression() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter year to review : ");
        int year = Integer.parseInt(scan.nextLine());
        System.out.println("Reviewing progression for Department : " + name + "\n Year : " + year);
        System.out.println("---------------------");
        int totalStudents = 0;
        for (Programme prog : programmes) {
            // counting students for the year
            ArrayList<Integer> studentIDs = new ArrayList<Integer>();
            for (Student student : prog.getStudents()) {
                for (Grade grade : student.getGrades()) {
                    if (grade.getModule().getYear() == year && !studentIDs.contains(student.getId())) {
                        studentIDs.add(student.getId());
                        totalStudents++;
                    }
                }
            }
            int studentsPassing = 0;
            int studentsFailing = 0;
            double totalQCA = 0.0;
            double cutoff = prog.getCutoffQCA();

            for (Student student : prog.getStudents()) {
                for (Grade grade : student.getGrades()) {
                    if (grade.getModule().getYear() == year) {
                        double QCA = grade.convertGradeToNumber();
                        totalQCA += QCA;
                        if (QCA >= cutoff) {
                            studentsPassing++;
                        } else {
                            studentsFailing++;
                        }
                    }
                }
            }
            double failPercentage = 0.0;
            double passPercentage = 0.0;
            if (totalStudents > 0 && studentsFailing > 0) {
                failPercentage = ((double) studentsFailing / totalStudents) * 100;
            }
            if (totalStudents > 0 && studentsPassing > 0) {
                passPercentage = ((double) studentsPassing / totalStudents) * 100;
            }
            System.out.println("---------------------");
            System.out.println("Programme : " + prog.getName());
            System.out.println("Year : " + year);
            System.out.println("Total Students : " + totalStudents);
            System.out.println("Students passing : " + studentsPassing);
            System.out.println("Pass Percentage : " + passPercentage);
            System.out.println("Fail Percentage : " + failPercentage);
            System.out.println("Students failing : " + studentsFailing);
            System.out.println("Average QCA : " + totalQCA / totalStudents);

        }


    }
}


