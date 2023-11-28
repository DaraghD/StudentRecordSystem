package Person;

import Department.Department;
import csvUtils.CSVFormat;

public class Teacher extends Person implements CSVFormat {
    private final Department Department;

    public Teacher(String name, int id, Department department, String password) {
        super(name, id, password);
        this.Department = department;
    }

    public Department getDepartment() {
        return Department;
    }

    @Override
    public String csvFormat() {
        return this.getName() + "," + this.getId() + "," + this.getPassword() + "," + this.getDepartment().getName();
    }
    @Override
    public String csvHeader() {
        return "Name,ID,Password,Department";
    }
}
