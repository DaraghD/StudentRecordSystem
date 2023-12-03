package Grading;

import University.Programme;
import University.Semester;
import csvUtils.CSVFormat;

/**
 * Represents a module in the system.
 */
public class Module implements CSVFormat {

    private final String name;

    private final int year;
    private final Semester semester;
    private final Programme programme;

    /**
     * Creates an instance of Module.
     *
     * @param name The module name.
     * @param year The year of the module.
     * @param semester The semester of the module.
     * @param programme The programme that the module belongs to.
     */
    public Module(String name,  int year, Semester semester, Programme programme) {
        this.name = name;
        this.year = year;
        this.semester = semester;
        this.programme = programme;
    }

    /**
     * Returns the name of the module.
     *
     * @return The name of the module.
     */
    public String getName() {
        return name;
    }



    /**
     * Returns the academic year associated with the module.
     *
     * @return The academic year associated with the module.
     */
    public int getYear() {
        return year;
    }

    /**
     * Returns the semester associated with the module.
     *
     * @return The semester associated with the module.
     */
    public Semester getSemester() {
        return semester;
    }

    /**
     * Formats the module information as a string to be stored in the CSV.
     *
     * @return The module information as a string.
     */

    @Override
    public String csvFormat() {
        return this.name + "," + this.year + "," + this.semester + "," + this.programme.getName();
    }

    /**
     * Returns a header for the module information.*
     * This header includes: Name, Cutoff, Year, Semester, Programme.
     *
     * @return The header as a string.
     */

    @Override
    public String csvHeader() {
        return "Name,Year,Semester,Programme";
    }
}
