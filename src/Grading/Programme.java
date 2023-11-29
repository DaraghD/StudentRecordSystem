package Grading;

import Department.Department;
import University.University;
import Grading.ProgrammeType;
import csvUtils.CSVFormat;

import java.util.ArrayList;

/**
 * Represents a programme(course) in the system.
 */
public class Programme implements CSVFormat {
    //Modules are a part of the programme
    //Programme is like a course
    //Maybe add arraylist of students taking this programme?

    private final ArrayList<Module> modules = new ArrayList<Module>();
    private final String name;
    private final University university;
    private final int durationYears;
    private final ProgrammeType level;
    private Department department;
    private double cutoffQCA;

    /**
     * Adds a specified module to the programme.
     *
     * @param module The module to be added.
     */
    public void addModule(Module module){
        modules.add(module);
    }
    /**
     * Formats the programme information as a string to be stored in the CSV.
     *
     * @return The programme information as a string.
     */
    @Override
    public String csvFormat(){ //TODO: CSV formatting , do it when all the design is done
        return this.getName() + "," + this.getDurationYears() + "," + this.getLevel() + "," + this.cutoffQCA + "," + this.department.getName();
    }

    /**
     * Returns a header for the programme information.
     *
     * This header includes: Name, Duration and Level.
     *
     * @return The header as a string.
     */

    @Override
    public String csvHeader(){
        return "Name,Duration,Level,Cutoff,Department";
    }

    /**
     * Creates an instance of programme.
     *
     * @param name The programme name.
     * @param university The university name.
     * @param duration The duration of the programme.
     * @param level The level of the programme.
     * @param cutoffQCA The minimum QCA needed to pass the programme.
     */

    public Programme(String name,  University university, int duration, ProgrammeType level, double cutoffQCA, Department department) {
        this.name = name;
        this.university = university;
        this.durationYears = duration;
        this.level = level;
        this.cutoffQCA = cutoffQCA;
        this.department = department;
    }

    /**
     * Returns the array list of all modules associated with a programme.
     *
     * @return The array list of all modules associated with a programme.
     */
    public ArrayList<Module> getModules(){
        return modules;
    }

    /**
     * Returns the specified module name if the module belongs to a specific course otherwise it returns null.
     * @param moduleName The name of the module.
     * @return The specified module name or null.
     */
    public Module getModule(String moduleName){
        for(Module module : modules){
            if(module.getName().equals(moduleName)){
                return module;
            }
        }
        return null;
    }

    public void setDepartment(Department department){
        this.department = department;
    }

    public Department getDepartment(){
        return this.department;
    }

    /**
     * Returns the name of the programme.
     *
     * @return The name of the programme.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the duration of the programme.
     *
     * @return The duration of the programme.
     */
    public int getDurationYears() {
        return durationYears;
    }

    /**
     * Returns the level of the programme.
     *
     * @return The level of the programme.
     */
    public ProgrammeType getLevel() {
        return level;
    }
}
