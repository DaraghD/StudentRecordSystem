package Person;

import Grading.Grade;
import Grading.Module;
import Grading.Programme;
import Grading.Semester;
import csvUtils.CSVFormat;

import java.util.ArrayList;

public class Student extends Person implements CSVFormat {
    //need grades arraylist or something here
    private ArrayList<Grade> grades = new ArrayList<>();
    private Programme currentProgramme;
    private ArrayList<String> messages = new ArrayList<>();

    public void setProgramme(Programme programme){
        this.currentProgramme = programme;
    }
    public Student(String name, int id, String password) {
        super(name, id, password);
    }

    public Student(String name, int id, String password, Programme programme) {
        super(name, id, password);
        this.currentProgramme = programme;
    }

    public void addGrade(Grade grade) {
        grades.add(grade);
    }

    public void ViewTranscript() {

    }

    public void addMessage(String message){
        messages.add(message);
    }
    public ArrayList<String> getMessages(){
        return messages;
    }


    public Programme getCurrentProgramme() {
        return currentProgramme;
    }

    public ArrayList<Grade> getGrades() {
        return grades;
    }


    public double QCA(String module) {
        //calculates QCA for given semester module and year
        double total = 0;
        int counter = 0;
        for (Grade grade : this.grades) {
            if (grade.getModule().equals(module)) {
                total += grade.convertGradeToNumber();
                counter++;
            }
        }
        return total / counter;
    }

    public double totalQCA() {
        double total = 0.0;
        int counter = 0;
        for (Grade grade : this.grades) {
            total += grade.convertGradeToNumber();
            counter++;
        }
        return total / counter;
    }

    public double qcaPerSemeseter(int year, Semester semester){
        double total = 0.0;
        int counter = 0;
        for (Grade grade : this.grades) {
            if(grade.getModule().getYear() == year && grade.getModule().getSemester() == semester){
                total += grade.convertGradeToNumber();
                counter++;
            }
        }
        return total / counter;
    }

    public double qcaPerYear(int year){
        double total = 0.0;
        int counter = 0;
        for (Grade grade : this.grades) {
            if(grade.getModule().getYear() == year){
                total += grade.convertGradeToNumber();
                counter++;
            }
        }
        return total / counter;
    }


    @Override
    public String csvFormat() {
        String progName = "null";
        if(this.currentProgramme != null){
            progName = this.currentProgramme.getName();
        }
        String s = this.getName() + "," + this.getId() + "," + this.getPassword() + "," + progName;

        return s;
    }
    @Override
    public String csvHeader() {
        return "Name,ID,Password,Programme";
    }

    public Module getModuleG(String moduleName){
        for(Module module : currentProgramme.getModules()){
            if(module.getName().equals(moduleName)){
                return module;
            }
        }
        return null;
    }
}
