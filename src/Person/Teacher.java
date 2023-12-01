package Person;

import Department.Department;
import csvUtils.CSVFormat;

/**
 * Represents a Teacher in the system, extending the Person class.
 */
public class Teacher extends Person implements CSVFormat {
    private final Department Department;

    /**
     * Constructs a new Teacher with the specified name, id, department, and password.
     *
     * @param name       The name of the teacher.
     * @param id         The ID of the teacher.
     * @param department The department to which the teacher belongs.
     * @param password   The password for the teacher.
     */
    public Teacher(String name, int id, Department department, String password) {
        super(name, id, password);
        this.Department = department;
    }

    /**
     * Gets the department of the teacher.
     *
     * @return The department of the teacher.
     */
    public Department getDepartment() {
        return Department;
    }

    /**
     * Returns the CSV format for a teacher.
     *
     * @return A CSV-formatted string representing the teacher's information.
     */
    @Override
    public String csvFormat() {
        return this.getName() + "," + this.getId() + "," + this.getPassword() + "," + this.getDepartment().getName();
    }

    /**
     * Returns the CSV header for the Teacher class.
     *
     * @return The CSV header string specifying the columns in the CSV format.
     */
    @Override
    public String csvHeader() {
        return "Name,ID,Password,Department";
    }
}
