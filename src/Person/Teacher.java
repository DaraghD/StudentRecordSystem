package Person;

import Department.Department;

/**
 * Class for a Teacher in the system, extending the Person class.
 */
public class Teacher extends Person {
    private Department Department;

    /**
     * Constructs a Teacher with the specified name, ID, department name, and password.
     *
     * @param name      The name of the teacher.
     * @param id        The ID of the teacher.
     * @param department The name of the department to which the teacher belongs.
     * @param password  The password associated with the teacher.
     */
    public Teacher(String name, int id, String department, String password) {
        super(name, id, password);
        this.Department = null;
    }

    /**
     * Constructs a Teacher with the specified name, ID, department, and password.
     *
     * @param name       The name of the teacher.
     * @param id         The ID of the teacher.
     * @param department The department to which the teacher belongs.
     * @param password   The password associated with the teacher.
     */
    public Teacher(String name, int id, Department department, String password) {
        super(name, id, password);
        this.Department = department;
    }

    /**
     * Returns the department to which the teacher belongs.
     *
     * @return The department of the teacher.
     */
    public Department getDepartment() {
        return Department;
    }
}
