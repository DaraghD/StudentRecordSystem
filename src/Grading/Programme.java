package Grading;

import University.University;

import java.util.ArrayList;

public class Programme {
    //Modules are a part of the programme
    //Programme is like a course
    //Maybe add arraylist of students taking this programme?

    private ArrayList<Module> modules = new ArrayList<Module>();
    private String name;
    private boolean research;
    private University university;
    private int durationYears;
    private String level;


    public void addModule(Module module){
        modules.add(module);
    }

    public String csvFormat(){ //TODO: CSV formatting , do it when all the design is done
        String s = this.getName() + ",";
        for (Module module : modules) {
            s += module.csvFormat();
        }
        return s;
    }

    public Programme(String name, boolean research, University university, int duration, String level) {
        this.name = name;
        this.research = research;
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
}
