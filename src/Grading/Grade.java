package Grading;

import csvUtils.CSVFormat;

//TODO: add module class ? so modules can have individual cutoff points for departments? programme?
//TODO: Implement a  general grading interface so if it changes its easier to adapat the c ode - project spec hinted at this
//TODO: move datafields into module class ?

/**
 * Represents a grade given to a student for a module.
 */
public class Grade implements Grading, CSVFormat {
    private final GradeType grade;
    private final Module module;
    private final int ID;

    /**
     * Creates an instance of Grade.
     *
     * @param grade  The grade given to the student.
     * @param module The module that this grade was given for.
     * @param id     The ID of the student who received this grade.
     */

    public Grade(GradeType grade, Module module, int id) {
        this.grade = grade;
        this.module = module;
        ID = id;
    }

    public Grade(int percentage, Module module, int id){
        this.grade = convertPercentageToGrade(percentage);
        this.module = module;
        this.ID = id;
    }

    /**
     * Converts a given percentage into its grade equivalent.
     * <p>
     * <a href="https://www.ul.ie/media/19388/download?inline="> Reference used </a>
     * </p>
     *
     * @return {@link GradeType}
     */
    public static GradeType convertPercentageToGrade(int grade) {
        if (grade >= 75 && grade <= 100) {
            return GradeType.A1;
        } else if (grade >= 70 && grade <= 74) {
            return GradeType.A2;
        } else if (grade >= 65 && grade <= 69) {
            return GradeType.B1;
        } else if (grade >= 60 && grade <= 64) {
            return GradeType.B2;
        } else if (grade >= 55 && grade <= 59) {
            return GradeType.B3;
        } else if (grade >= 50 && grade <= 54) {
            return GradeType.C1;
        } else if (grade >= 45 && grade <= 49) {
            return GradeType.C2;
        } else if (grade >= 40 && grade <= 44) {
            return GradeType.C3;
        } else if (grade >= 35 && grade <= 39) {
            return GradeType.D1;
        } else if (grade >= 30 && grade <= 34) {
            return GradeType.D2;
        } else {
            return GradeType.F;
        }


    }

    /**
     * Returns the grade of the Grade object.
     *
     * @return gradeType object
     */
    public GradeType getGrade() {
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
     * <p>
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
     * <p>
     * This number is used when calculating QCA.
     *
     * @return The number converted from the grade.
     */
    @Override
    public double convertGradeToNumber() {
        return switch (this.grade) {
            case A1 -> 4.0;
            case A2 -> 3.6;
            case B1 -> 3.2;
            case B2 -> 3.0;
            case B3 -> 2.8;
            case C1 -> 2.6;
            case C2 -> 2.4;
            case C3 -> 2.0;
            case D1 -> 1.6;
            case D2 -> 1.2;
            case F -> 0.0;
        };
    }

    /**
     * Returns the module that the grade was given for.
     *
     * @return {@link Module
     */
    public Module getModule() {
        return this.module;
    }

}
