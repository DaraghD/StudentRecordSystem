package CommandLineInterface;

import Department.Department;
import Department.DepartmentManager;
import Grading.*;
import Grading.Module;
import Person.Student;
import Person.Teacher;
import University.University;

import java.util.Arrays;
import java.util.Scanner;

public class teacherMenu {

    private final Scanner scannerTeacherMenu = new Scanner(System.in);
    private Department department;
    private DepartmentManager departmentManager;
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
                    S - Send student message
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
                case "A":
                    System.out.println("Enter department name");
                    String name = scannerTeacherMenu.nextLine();
                    Department newDepartment = new Department(name, uni);
                    uni.addDepartment(newDepartment);
                    break;
                case "C":
                    System.out.println("Enter Student ID:");
                    int id = scannerTeacherMenu.nextInt();
                    Student student = uni.getStudent(id);
                    System.out.println("QCA: " + student.totalQCA());
                    //Grade.QCA(getId(), getSemester(), getModule(), getYear());
                    break;
                case "S": // to request student to repeat etc.
                    System.out.println("Enter Student ID:");
                    int id2 = scannerTeacherMenu.nextInt();
                    while (uni.getStudent(id2) == null) {
                        System.out.println("Student does not exist, try again");
                        id2 = scannerTeacherMenu.nextInt();
                    }
                    Student student2 = uni.getStudent(id2);
                    System.out.println("Enter message:");
                    String message = scannerTeacherMenu.nextLine();
                    student2.addMessage(message);
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


                    ProgrammeType type = null;
                    while (type == null) {
                        System.out.println("""
                                Enter programme level
                                U - Undergraduate
                                P - Postgraduate
                                R - Research
                                T - Taught
                                """);
                        String level = scannerTeacherMenu.nextLine();
                        switch (level) {
                            case "U" -> type = ProgrammeType.UNDERGRADUATE;
                            case "P" -> type = ProgrammeType.POSTGRADUATE;
                            case "R" -> type = ProgrammeType.RESEARCH;
                            case "T" -> type = ProgrammeType.TAUGHT;
                            default -> System.out.println("Invalid choice");
                        }
                    }

                    Programme newProgramme = new Programme(programmeName, uni, duration, type);
                    System.out.println("Adding programme " + newProgramme.getName() + " to " + currentDepartment.getName());
                    currentDepartment.addProgramme(newProgramme);

                    break;
                case "M":
                    for (Programme programme : currentDepartment.getProgrammes()) {
                        System.out.println(programme.getName());
                    }
                    if (currentDepartment.getProgrammes().isEmpty()) {
                        System.out.println("No programmes to add module to, add one through the department menu");
                        break;
                    }
                    System.out.println("Enter name of programme to add module to");
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

                    Semester sem = null;
                    while (sem == null) {
                        System.out.println("""
                                Enter semester for module
                                A - Autumn
                                S - Spring
                                """);
                        String input = scannerTeacherMenu.nextLine();
                        switch (input) {
                            case "A" -> sem = Semester.AUTUMN;
                            case "S" -> sem = Semester.SPRING;
                            default -> System.out.println("Invalid choice");
                        }
                    }


                    System.out.println("Enter year for module");
                    int year = scannerTeacherMenu.nextInt();

                    Module newModule = new Module(moduleName, cutoff, year, sem);
                    System.out.println("Adding module " + newModule.getName() + " to " + programme.getName());
                    programme.addModule(newModule);
                    break;
                case "E":
                    System.out.println("Exiting Department Menu");
                    running = false;
                    break;
                case "D":
                    for (Programme programm2e : currentDepartment.getProgrammes()) {
                        for (Module module : programm2e.getModules()) {
                            System.out.println(module.getName());
                        }
                    }
                default:
                    System.out.println("Invalid Choice");
            }

        }
    }
}
