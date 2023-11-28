package Grading;

import csvUtils.CSVFormat;

public class Module implements CSVFormat {

    private String name;
    private int cutoff;
    private int year;
    private Semester semester;
    private Programme programme;


    public Module(String name, int cutoff, int year, Semester semester, Programme programme) {
        this.name = name;
        this.cutoff = cutoff;
        this.year = year;
        this.semester = semester;
        this.programme = programme;
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

    @Override
    public String csvFormat() {
        return this.name + "," + this.cutoff + "," + this.year + "," + this.semester + "," + this.programme.getName();
    }

    @Override
    public String csvHeader() {
        return "Name,Cutoff,Year,Semester,Programme";
    }
}
