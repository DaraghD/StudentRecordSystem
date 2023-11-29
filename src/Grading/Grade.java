package Grading;

import csvUtils.CSVFormat;

//TODO: add module class ? so modules can have individual cutoff points for departments? programme?
//TODO: Implement a  general grading interface so if it changes its easier to adapat the c ode - project spec hinted at this
//TODO: move datafields into module class ?

/**
 * Represents a grade given to a student for a module.
 */
public class Grade implements Grading, CSVFormat {
    private final String grade;
    private final Module module;
    private final int ID;

    /**
     * Creates an instance of Grade.
     *
     * @param grade The grade given to the student.
     * @param module The module that this grade was given for.
     * @param id The ID of the student who received this grade.
     */

    public Grade(String grade, Module module, int id) {
        this.grade = grade;
        this.module = module;
        ID = id;
    }

    //TODO: grade constructor for percentage?

    /**
     * Returns the grade of the Grade object.
     *
     * @return
     */
    public String getGrade() {
        return grade;
    }

    /**
     * Formats the grade information as a string to be stored in the CSV.
     *
     * @return The grade information as a string.
     */
    @Override
    public String csvFormat() {
        return this.grade + "," + this.module.getName() + "," + this.ID;
    }

    /**
     * Returns a header for the grade information.
     *
     * This header includes: Grade, Module and ID.
     *
     * @return The header as a string.
     */
    @Override
    public String csvHeader() {
        return "Grade,Module,ID";
    }

    /**
     * Converts Grade to a string in order to display all its information.
     *
     * @return The grade information as a string.
     */
    public String toString() {
        return "Grade : " + this.grade + " Module : " + this.module.getName() + " Year : " + this.module.getYear() + " Semester : " + this.module.getSemester() + "\n";
    }

    /**
     * Converts the grade to a number.
     *
     * This number is used when calculating QCA.
     *
     * @return The number converted from the grade.
     */
    @Override
    public double convertGradeToNumber() {
        return switch (this.grade) {
            case "A1" -> 4.0;
            case "A2" -> 3.6;
            case "B1" -> 3.2;
            case "B2" -> 3.0;
            case "B3" -> 2.8;
            case "C1" -> 2.6;
            case "C2" -> 2.4;
            case "C3" -> 2.0;
            case "D1" -> 1.6;
            case "D2" -> 1.2;
            default -> 0;
        };
    }

    /**
     * Returns the module that the grade was given for.
     *
     * @return The module that the grade was given for.
     */
    public Module getModule() {
        return this.module;
    }

    @Override
    public String convertNumberToGrade() {
        //assumes  grade is a number in a string
        return switch(this.grade){
            case "4.0" -> "A1";
            case "3.6" -> "A2";
            case "3.2" -> "B1";
            case "3.0" -> "B2";
            case "2.8" -> "B3";
            case "2.6" -> "C1";
            case "2.4" -> "C2";
            case "2.0" -> "C3";
            case "1.6" -> "D1";
            case "1.2" -> "D2";
            default -> "F";
        };

    }

}
