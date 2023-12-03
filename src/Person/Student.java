package Person;

import Grading.Grade;
import Grading.Module;
import Grading.Programme;
import Grading.Semester;
import csvUtils.CSVFormat;

import java.util.ArrayList;

/**
 * Represents a student in the system.
 * <p>
 * Student is a subclass of Person.
 */

public class Student extends Person implements CSVFormat {
    private final ArrayList<Grade> grades = new ArrayList<>();
    private Programme currentProgramme;
    private final ArrayList<String> messages = new ArrayList<>();

    /**
     * Creates an instance of Student.
     *
     * @param name     The name associated with the student.
     * @param id       The identification number associated with the student.
     * @param password The password associated with the student.
     */

    public Student(String name, int id, String password) {
        super(name, id, password);
    }

    /**
     * Creates an instance of Student with a programme.
     *
     * @param name      The name associated with the student.
     * @param id        The identification number associated with the student.
     * @param password  The password associated with the student.
     * @param programme The programme which the student belongs to.
     */
    public Student(String name, int id, String password, Programme programme) {
        super(name, id, password);
        this.currentProgramme = programme;
        programme.addStudent(this);
    }

    /**
     * Sets a programme(course) for a particular student.
     *
     * @param programme The programme that the student belongs to.
     */
    public void setProgramme(Programme programme) {
        this.currentProgramme = programme;
        programme.addStudent(this);
    }

    /**
     * Adds a grade to the student's grades array list.
     *
     * @param grade The specified grade to be added.
     */

    public void addGrade(Grade grade) {
        grades.add(grade);
    }


    /**
     * Adds a message to the student's messages array list.
     *
     * @param message The specified message to be added.
     */
    public void addMessage(String message) {
        messages.add(message);
    }

    /**
     * Returns the messages array list that is associated with the student.
     *
     * @return The messages array list for a student.
     */
    public ArrayList<String> getMessages() {
        return messages;
    }

    /**
     * Returns the programme of a particular student.
     *
     * @return The programme of the student.
     */
    public Programme getCurrentProgramme() {
        return currentProgramme;
    }

    /**
     * Returns the grades array list associated with a student.
     *
     * @return The grades array list for a student.
     */
    public ArrayList<Grade> getGrades() {
        return grades;
    }

    /**
     * Calculates the QCA for a specific module.
     *
     * @param module The module for which the QCA is to be calculated.
     * @return The calculated QCA.
     */
    public double QCA(String module) {
        double total = 0;
        int counter = 0;
        for (Grade grade : this.grades) {
            if (grade.getModule().getName().equals(module)) {
                //if (grade.getModule().equals(currentProgramme.getModule(module))) {
                total += grade.convertGradeToNumber();
                counter++;
            }
        }
        return total / counter;
    }

    /**
     * Calculates the total QCA for all modules of a student.
     *
     * @return The calculated QCA.
     */
    public double totalQCA() {
        double total = 0.0;
        int counter = 0;
        for (Grade grade : this.grades) {
            total += grade.convertGradeToNumber();
            counter++;
        }
        return total / counter;
    }

    /**
     * Calculates the QCA for a specific semester and year.
     *
     * @param year     The year for which the QCA is to be calculated.
     * @param semester The semester for which the QCA is to be calculated.
     * @return The calculated QCA.
     */
    public double qcaPerSemeseter(int year, Semester semester) {
        double total = 0.0;
        int counter = 0;
        for (Grade grade : this.grades) {
            if (grade.getModule().getYear() == year && grade.getModule().getSemester() == semester) {
                total += grade.convertGradeToNumber();
                counter++;
            }
        }
        return total / counter;
    }

    /**
     * Calculates the QCA for a specific year.
     *
     * @param year The year for which the QCA is to be calculated.
     * @return The calculated QCA.
     */
    public double qcaPerYear(int year) {
        double total = 0.0;
        int counter = 0;
        for (Grade grade : this.grades) {
            if (grade.getModule().getYear() == year) {
                total += grade.convertGradeToNumber();
                counter++;
            }
        }
        return total / counter;
    }

    /**
     * Formats the student's information as a string to be stored in the CSV.
     *
     * @return The student's information as a string.
     */
    @Override
    public String csvFormat() {
        String progName = "null";
        if (this.currentProgramme != null) {
            progName = this.currentProgramme.getName();
        }

        return this.getName() + "," + this.getId() + "," + this.getPassword() + "," + progName;
    }

    /**
     * Returns a header for the student's information.
     * <p>
     * This header includes: Name, ID, Password and programme.
     *
     * @return The header as a string.
     */
    @Override
    public String csvHeader() {
        return "Name,ID,Password,Programme";
    }

    /**
     * @param moduleName name of the module
     * @return The module of the student.
     */
    public Module getModuleG(String moduleName) {
        for (Module module : currentProgramme.getModules()) {
            if (module.getName().equals(moduleName)) {
                return module;
            }
        }
        return null;
    }
    /**
     * Prints the student's transcript.
     */

    public void transcript() {
        System.out.println("--------------------");
        System.out.println("STUDENT TRANSCRIPT");
        System.out.println("NAME : " + this.getName() + "\n ID : " + this.getId() + " \n PROGRAMME : " + this.getCurrentProgramme().getName());
        System.out.println("--------------------");
        System.out.println("OVERALL QCA :" + this.totalQCA());
        System.out.println("--------------------");
        System.out.println("QCA PER YEAR");
        System.out.println("YEAR 1 : " + this.qcaPerYear(1));
        System.out.println("YEAR 2 : " + this.qcaPerYear(2));
        System.out.println("YEAR 3 : " + this.qcaPerYear(3));
        System.out.println("YEAR 4 : " + this.qcaPerYear(4));
        System.out.println("--------------------");
        System.out.println("QCA PER SEMESTER");
        System.out.println("YEAR 1 AUTUMN : " + this.qcaPerSemeseter(1, Semester.AUTUMN));
        System.out.println("YEAR 1 SPRING : " + this.qcaPerSemeseter(1, Semester.SPRING));
        System.out.println("--------------------");
        System.out.println("YEAR 2 AUTUMN : " + this.qcaPerSemeseter(2, Semester.AUTUMN));
        System.out.println("YEAR 2 SPRING : " + this.qcaPerSemeseter(2, Semester.SPRING));
        System.out.println("--------------------");
        System.out.println("YEAR 3 AUTUMN : " + this.qcaPerSemeseter(3, Semester.AUTUMN));
        System.out.println("YEAR 3 SPRING : " + this.qcaPerSemeseter(3, Semester.SPRING));
        System.out.println("--------------------");
        System.out.println("YEAR 4 AUTUMN : " + this.qcaPerSemeseter(4, Semester.AUTUMN));
        System.out.println("YEAR 4 SPRING : " + this.qcaPerSemeseter(4, Semester.SPRING));
        System.out.println("--------------------");

    }

}
