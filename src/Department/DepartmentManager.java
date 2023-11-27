package Department;

import java.util.ArrayList;
import java.util.List;

public class DepartmentManager {
    private String departmentManager;
    private List<String> departmentList;
    public DepartmentManager() {
        this.departmentManager = departmentManager;
        departmentList = new ArrayList<>();
    }

    public void viewDepartmentBoard() {
        System.out.println("Department Board:");
        for (String department : departmentList) {
            System.out.println(department);
        }
    }

    public void addDepartment(String newDepartment) {
        departmentList.add(newDepartment);
        System.out.println("Added new department: " + newDepartment);
    }
    public static void main (String[] args) {
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
