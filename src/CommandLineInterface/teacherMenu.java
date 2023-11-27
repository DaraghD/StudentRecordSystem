package CommandLineInterface;

import Department.Department;
import Department.DepartmentManager;
import Grading.Grade;
import Grading.Module;
import Grading.Programme;
import Person.Student;
import Person.Teacher;
import University.University;

import java.util.Scanner;

public class teacherMenu {

    private Department department;
    private DepartmentManager departmentManager;
    private final Scanner scannerTeacherMenu = new Scanner(System.in);
    private Department currentDepartment;
    private Teacher currentUser;
    private University uni;


    public teacherMenu(Teacher currentUser, University uni) {
        this.currentUser = currentUser;
        this.uni = uni;
    }

    public void display() {
        System.out.println("Teacher Menu" + "\n");
    }

    public void run() {
        boolean logout = false;
        while (!logout) {
            String choice;

            display();
            //TODO: Request student s to repeat, link-in to modules,repeat year , semesster etc
            System.out.println("""
                    Please enter an option
                    G - Add Student Grade
                    C - Calculate Student QCA
                    A - Add department
                    D - Department Menu
                    M - Average QCA for a module
                    F - Display Failed Students
                    L - Logout
                    """);
            choice = scannerTeacherMenu.nextLine().toUpperCase();

            switch (choice) {
                case "G":
                    addStudentGrade();
                    break;
                case "V":
                    //currentUser.viewDepartmentBoard();
                    break;
                case "C":
                    System.out.println("Enter Student ID:");
                    int id = scannerTeacherMenu.nextInt();
                    Student student = uni.getStudent(id);
                    System.out.println("QCA: " + student.totalQCA());
                    //Grade.QCA(getId(), getSemester(), getModule(), getYear());
                    break;
                case "D":

                    System.out.println("Select a department");
                    if (uni.getDepartments().isEmpty()) {
                        System.out.println("No departments to select, add one through the main menu");
                        break;
                    }
                    for (Department department : uni.getDepartments()) {
                        System.out.println(department.getName());
                    }
                    String departmentName = scannerTeacherMenu.nextLine();
                    if (uni.getDepartment(departmentName) == null) {
                        System.out.println("Department does not exist");
                        break;
                    }
                    currentDepartment = uni.getDepartment(departmentName);
                    DepartmentMenu();

                   // System.out.println("Add Department:");
                   // String newDepartment = scannerTeacherMenu.nextLine();
                   // departmentManager.addDepartment(newDepartment);
                    break;
                case "M":
                    //Print out all modules here
                    System.out.println("Enter module code");
                    String m = scannerTeacherMenu.nextLine();
                    currentDepartment.calculateAndDisplayAverageQCAForModule(m);
                    break;
                case "F":
                    System.out.println("Enter Module Code");
                    String moduleCode = scannerTeacherMenu.nextLine();
                    currentDepartment.displayFailedStudentsForModule(moduleCode);
                    break;
                case "L":
                    System.out.println("Logging Out...");
                    logout = true;
                    break;
                default:
                    System.out.println("Invalid Choice");
            }
        }
    }

    private void addStudentGrade() {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the student's ID");
        int studentId = Integer.parseInt(input.nextLine());
        Student student = uni.getStudent(studentId);

        System.out.println("Please enter the student's grade");
        String studentGrade = input.nextLine();

        System.out.println("Please select the student's module");
        Programme studentProgramme = student.getCurrentProgramme();

        for (Module module : studentProgramme.getModules()) {
            System.out.println(module.getName());
        }
        if (studentProgramme.getModules().isEmpty()) {
            System.out.println("No modules to add grade to");
            return;
        }
        String moduleName = input.nextLine();

        Module mod = studentProgramme.getModule(moduleName);
        Grade grade = new Grade(studentGrade, mod);
        student.addGrade(grade);
        System.out.println("Grade: +" + grade.toString() + ", added to " + student.getName());

    }

    public void DepartmentMenu() {
        boolean running = true;
        while (running) {
            //TODO: REmove reduant options
            //TODO: Maybe make a seperate programme menu?
            System.out.println("Current Department : " + currentDepartment.getName() + "\n");
            System.out.println("""
                    Please enter an option
                    A - Add a department
                    V - View Departments
                    P - Add programme to current department
                    RP - Remove programme from current department
                    M - Add module to a programme
                    E - Exit menu
                    """);
            String choice = scannerTeacherMenu.nextLine().toUpperCase();
            switch (choice) {
                case "A":
                    System.out.println("Enter department name");
                    String name = scannerTeacherMenu.nextLine();
                    Department newDepartment = new Department(name, uni);
                    uni.addDepartment(newDepartment);
                    break;
                case "V":
                    for (Department department : uni.getDepartments()) {
                        System.out.println(department.getName());
                    }
                    break;
                case "RP":
                    System.out.println("Enter programme name");
                    for (Programme programme : currentDepartment.getProgrammes()) {
                        System.out.println(programme.getName());
                    }
                    String programmeNameRemove = scannerTeacherMenu.nextLine();
                    currentDepartment.removeProgramme(programmeNameRemove);
                    break;
                case "P":
                    System.out.println("Enter programme name");
                    String programmeName = scannerTeacherMenu.nextLine();

                    System.out.println("Enter programme duration");
                    int duration = scannerTeacherMenu.nextInt();

                    System.out.println("Enter programme level, UNDERGRADUATE or POSTGRADUATE");
                    String level = scannerTeacherMenu.nextLine();

                    System.out.println("Is programme a research programme? (Y/N)");
                    String research = scannerTeacherMenu.nextLine().toUpperCase();
                    boolean researchBool;

                    if (research.equals("Y")) {
                        researchBool = true;
                    } else {
                        researchBool = false;
                    }

                    Programme newProgramme = new Programme(programmeName, researchBool, uni, duration, level);
                    System.out.println("Adding programme " + newProgramme.getName() + " to " + currentDepartment.getName());
                    currentDepartment.addProgramme(newProgramme);

                    break;
                case "M":
                    System.out.println("Enter name of programme to add module to");
                    for (Programme programme : currentDepartment.getProgrammes()) {
                        System.out.println(programme.getName());
                    }
                    if (currentDepartment.getProgrammes().isEmpty()) {
                        System.out.println("No programmes to add module to, add one through the department menu");
                        break;
                    }
                    String programmeName2;
                    programmeName2 = scannerTeacherMenu.nextLine();
                    if (currentDepartment.getProgramme(programmeName2) == null) {
                        System.out.println("Programme does not exist");
                        break;
                    }
                    Programme programme = currentDepartment.getProgramme(programmeName2);

                    System.out.println("Enter module name");
                    String moduleName = scannerTeacherMenu.nextLine();

                    System.out.println("Enter cutoff for module e.g 50 for 50%");
                    int cutoff = scannerTeacherMenu.nextInt();

                    System.out.println("Enter semester for module");
                    int semester = scannerTeacherMenu.nextInt();

                    System.out.println("Enter year for module");
                    int year = scannerTeacherMenu.nextInt();

                    Module newModule = new Module(moduleName, cutoff, year, semester);
                    System.out.println("Adding module " + newModule.getName() + " to " + programme.getName());
                    programme.addModule(newModule);
                    break;
                case "E":
                    System.out.println("Exiting Department Menu");
                    running = false;
                    break;
                case "debug":
                    for(Programme programm2e : currentDepartment.getProgrammes()){
                        for(Module module : programm2e.getModules()){
                            System.out.println(module.getName());
                        }
                    }
                default:
                    System.out.println("Invalid Choice");
            }

        }
    }
}
