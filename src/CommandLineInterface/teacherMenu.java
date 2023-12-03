package CommandLineInterface;

import Department.Department;
import University.Programme;
import University.ProgrammeType;
import University.Semester;
import Grading.*;
import Grading.Module;
import Person.Student;
import Person.Teacher;
import University.University;
import Department.ExamBoard;

import java.util.Scanner;

/**
 * The teacherMenu class represents the menu and functionality for a teacher user in the command-line interface.
 */
public class teacherMenu {

    private final Scanner scannerTeacherMenu = new Scanner(System.in);
    private final Teacher currentUser;
    private final University uni;
    private Department department;
    private Department currentDepartment;

    /**
     * Constructs a teacherMenu instance with the specified current user and university.
     *
     * @param currentUser The current teacher user.
     * @param uni         The university instance.
     */
    public teacherMenu(Teacher currentUser, University uni) {
        this.currentUser = currentUser;
        this.uni = uni;
    }


    /**
     * Runs the teacher menu.
     */
    public void run() {
        boolean logout = false;
        while (!logout) {
            String choice;
            System.out.println();
            System.out.println();
            System.out.println();
            //TODO: Request student s to repeat, link-in to modules,repeat year , semesster etc
            System.out.println("Logged in as " + currentUser.getName() + " (Teacher)");
            System.out.println("""
                    Please enter an option
                    G - Add Student Grade
                    T - Student transcript
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
                case "T":
                    System.out.println("Enter Student ID:");
                    int id = Integer.parseInt(scannerTeacherMenu.nextLine());
                    uni.getStudent(id).transcript();
                    break;
                case "A":
                    System.out.println("Enter department name");
                    String name = scannerTeacherMenu.nextLine();
                    Department newDepartment = new Department(name, uni);
                    uni.addDepartment(newDepartment);
                    break;
                case "C":
                    System.out.println("Enter Student ID:");
                    int id1 = Integer.parseInt(scannerTeacherMenu.nextLine());
                    Student student = uni.getStudent(id1);
                    System.out.println("QCA: " + student.totalQCA());
                    //
                    break;
                case "S": // to request student to repeat etc.
                    System.out.println("Enter Student ID:");
                    int id2 = Integer.parseInt(scannerTeacherMenu.nextLine());
                    while (uni.getStudent(id2) == null) {
                        System.out.println("Student does not exist, try again");
                        id2 = Integer.parseInt(scannerTeacherMenu.nextLine());
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

    /**
     * Adds a grade for a student.
     */
    private void addStudentGrade() {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the student's ID");
        int studentId = Integer.parseInt(input.nextLine());
        Student student = uni.getStudent(studentId);


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
        int id = student.getId();

        System.out.println("""
                P - Percentage value"
                G - Grade value e.g A1,B2,C3 etc
                """);
        switch (input.nextLine()) {
            case "P" -> {
                System.out.println("Enter percentage value");
                String grade = input.nextLine();
                if (grade.charAt(grade.length() - 1) == '%') {
                    grade = grade.substring(0, grade.length() - 1);
                }
                Grade newGrade = new Grade(Grade.convertPercentageToGrade(Integer.parseInt(grade)), mod, id);
                student.addGrade(newGrade);
                System.out.println("Grade: +" + grade + ", added to " + student.getName());
            }
            case "G" -> {
                System.out.println("Enter grade value");
                GradeType grade = GradeType.valueOf(input.nextLine());
                Grade newGrade = new Grade(grade, mod, id);
                student.addGrade(newGrade);
                System.out.println("Grade: +" + grade + ", added to " + student.getName());
            }
        }


    }

    /**
     * Displays and handles the department menu options.
     */
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
                    H - Hold exam board
                    P - Add programme to current department
                    RP - Remove programme from current department
                    M - Add module to a programme
                    RM - Remove module from programme
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
                case "H":
                    System.out.println("Enter exam board name:");
                    String examBoardName = scannerTeacherMenu.nextLine();
                    if (currentDepartment.getExamBoard(examBoardName) != null) {
                        System.out.println("Exam board with the same name already exists. Please choose a different name.");
                        break;
                    }
                    ExamBoard examBoard = new ExamBoard(examBoardName);
                    currentDepartment.addExamBoard(examBoard);
                    System.out.println("Exam board '" + examBoardName + "' added to " + currentDepartment.getName());
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
                    int duration = Integer.parseInt(scannerTeacherMenu.nextLine());

                    System.out.println("Enter programme cutoff e.g 2.0, 1.5 (QCA)");
                    double cutoff = Double.parseDouble(scannerTeacherMenu.nextLine());


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


                    Programme newProgramme = new Programme(programmeName, uni, duration, type, cutoff, currentDepartment);
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
                    int year = Integer.parseInt(scannerTeacherMenu.nextLine());

                    Module newModule = new Module(moduleName, year, sem, programme);
                    System.out.println("Adding module " + newModule.getName() + " to " + programme.getName());
                    programme.addModule(newModule);
                    break;
                case "RM":
                    for (Programme prog : currentDepartment.getProgrammes()) {
                        System.out.println(prog.getName());
                    }
                    if (currentDepartment.getProgrammes().isEmpty()) {
                        System.out.println("No programmes to remove module from, add one through the department menu");
                        break;
                    }
                    System.out.println("Enter name of programme to remove module from");
                    String programmeName3 = scannerTeacherMenu.nextLine();
                    if (currentDepartment.getProgramme(programmeName3) == null) {
                        System.out.println("Programme does not exist");
                        break;
                    }
                    Programme programme2 = currentDepartment.getProgramme(programmeName3);
                    for (Module mod : programme2.getModules()) {
                        System.out.println(mod.getName());
                    }
                    if (programme2.getModules().isEmpty()) {
                        System.out.println("No modules to remove");
                        break;
                    }

                    System.out.println("Enter module name");
                    String moduleName2 = scannerTeacherMenu.nextLine();
                    if (programme2.getModule(moduleName2) == null) {
                        System.out.println("Module does not exist");
                        break;
                    }
                    programme2.getModules().remove(programme2.getModule(moduleName2));
                    System.out.println(moduleName2 + " removed from" + programme2.getName());
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
