package Grading;

public class Module {

    private String name;
    private int cutoff;
    private String programmeName;
    private int year;
    private int semester;

    public Module(String name, int cutoff) {
        this.name = name;
        this.cutoff = cutoff;
    }

    public Module(String name, int cutoff, String programmeName, int year, int semester) {
        this.name = name;
        this.cutoff = cutoff;
        this.programmeName = programmeName;
        this.year = year;
        this.semester = semester;
    }

    public String getName() {
        return name;
    }

    public int getCutoff() {
        return cutoff;
    }

    public String getProgrammeName() {
        return programmeName;
    }

    public int getYear() {
        return year;
    }

    public int getSemester() {
        return semester;
    }


    public String csvFormat() {
        return "," + this.name + "," + this.cutoff + "," + this.programmeName + "," + this.year + "," + this.semester;

    }
}
