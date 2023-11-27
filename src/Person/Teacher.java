package Person;

import Department.Department;

public class Teacher extends Person {
    private Department Department;

    public Teacher(String name, int id, String department, String password) {
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
}
