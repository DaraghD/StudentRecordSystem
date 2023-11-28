package Department;

import java.util.ArrayList;
import java.util.List;

/**
 * Manages departments and allows teachers to view and add departments to the department board.
 */
public class DepartmentManager {
    /**
     * The name of the department manager.
     */
    private String departmentManager;

    /**
     * The list of departments managed by the department manager.
     */
    private List<String> departmentList;

    /**
     * Constructs a new DepartmentManager.
     */
    public DepartmentManager() {
        departmentList = new ArrayList<>();
    }

    /**
     * Displays the names of departments and allows users to view the department board.
     */
    public void viewDepartmentBoard() {
        System.out.println("Department Board:");
        for (String department : departmentList) {
            System.out.println(department);
        }
    }

    /**
     * Adds a new department to the department board.
     *
     * @param newDepartment The name of the new department to be added.
     */
    public void addDepartment(String newDepartment) {
        departmentList.add(newDepartment);
        System.out.println("Added new department: " + newDepartment);
    }

    /**
     * The entry point for the DepartmentManager application.
     *
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        DepartmentManager departmentManager = new DepartmentManager();

        // Adding departments
        departmentManager.addDepartment("Faculty of Arts");
        departmentManager.addDepartment("Faculty of Health Sciences");
        departmentManager.addDepartment("Faculty of Business");
        departmentManager.addDepartment("Faculty of Science and Engineering");
        departmentManager.addDepartment("Faculty of Music");

        // Viewing the department board
        departmentManager.viewDepartmentBoard();
    }
}
