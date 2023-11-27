package Grading;

public class Module {

    private String name;
    private int cutoff;
    private int year;
    private Semester semester;

    public Module(String name, int cutoff) {
        this.name = name;
        this.cutoff = cutoff;
    }

    public Module(String name, int cutoff, int year, Semester semester) {
        this.name = name;
        this.cutoff = cutoff;
        this.year = year;
        this.semester = semester;
    }

    public String getName() {
        return name;
    }

    public int getCutoff() {
        return cutoff;
    }


    public int getYear() {
        return year;
    }

    public Semester getSemester() {
        return semester;
    }


    public String csvFormat() {
        return "," + this.name + "," + this.cutoff + "," + this.year + "," + this.semester;

    }
}
