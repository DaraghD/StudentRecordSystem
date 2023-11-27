package Grading;

//TODO: add module class ? so modules can have individual cutoff points for departments? programme?
//TODO: Implement a  general grading interface so if it changes its easier to adapat the c ode - project spec hinted at this
//TODO: move datafields into module class ?
public class Grade {
    private String grade;
    private Module module;

    public Grade(String grade,Module module) {
        this.grade = grade;
        this.module = module;
    }

    //TODO: grade constructor for percentage?

    public String getGrade() {
        return grade;
    }

    public String csvFormat() {
        return grade + this.module.csvFormat();
    }


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

}
