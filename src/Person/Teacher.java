package Person;

import Department.Department;

public class Teacher extends Person implements csvUtils.CSVFormat {
    private final Department Department;

    public Teacher(String name, int id, String password) {
        super(name, id, password);
        this.Department = null;
    }

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
}
