package Grading;

import University.University;
import Grading.ProgrammeType;
import csvUtils.CSVFormat;

import java.util.ArrayList;

public class Programme implements CSVFormat {
    //Modules are a part of the programme
    //Programme is like a course
    //Maybe add arraylist of students taking this programme?

    private final ArrayList<Module> modules = new ArrayList<Module>();
    private final String name;
    private final University university;
    private final int durationYears;
    private final ProgrammeType level;


    public void addModule(Module module){
        modules.add(module);
    }

    public String csvFormat(){ //TODO: CSV formatting , do it when all the design is done
        String s = this.getName() + "," + this.getDurationYears() + "," + this.getLevel();
        if(modules.isEmpty()){
            return s;
        }
        else{
            for(Module module : modules){
                s += "," + module.csvFormat();
            }
        }
        return s;
    }


    public Programme(String name,  University university, int duration, ProgrammeType level) {
        this.name = name;
        this.university = university;
        this.durationYears = duration;
        this.level = level;

    }

    public ArrayList<Module> getModules(){
        return modules;
    }

    public Module getModule(String moduleName){
        for(Module module : modules){
            if(module.getName().equals(moduleName)){
                return module;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public int getDurationYears() {
        return durationYears;
    }

    public ProgrammeType getLevel() {
        return level;
    }
}
