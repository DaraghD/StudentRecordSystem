package Grading;

import csvUtils.CSVFormat;

//TODO: add module class ? so modules can have individual cutoff points for departments? programme?
//TODO: Implement a  general grading interface so if it changes its easier to adapat the c ode - project spec hinted at this
//TODO: move datafields into module class ?
public class Grade implements Grading, CSVFormat {
    private final String grade;
    private final Module module;
    private final int ID;

    public Grade(String grade, Module module, int id) {
        this.grade = grade;
        this.module = module;
        ID = id;
    }

    //TODO: grade constructor for percentage?

    public String getGrade() {
        return grade;
    }

    @Override
    public String csvFormat() {
        return this.grade + "," + this.module.getName() + "," + this.ID;
    }

    @Override
    public String csvHeader() {
        return "Grade,Module,ID";
    }

    public String toString() {
        return "Grade : " + this.grade + " Module : " + this.module.getName() + " Year : " + this.module.getYear() + " Semester : " + this.module.getSemester() + "\n";
    }


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


    public Module getModule() {
        return this.module;
    }

    @Override
    public String convertNumberToGrade() {
        return null;
    }

}
