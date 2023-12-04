package CommandLineInterface;

import University.Programme;
import Person.Person;
import csvUtils.csvWriter;
import csvUtils.csvParser;
import University.University;
import Department.Department;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import Person.*;
import static java.lang.System.exit;


/**
 * The command-line interface for the Student Record System.
 */
public class CommandLineInterface {

    private static final Scanner input = new Scanner(System.in);
    private final University UL;
    private Person currentUser; // when login set this to the reference of the logged in object

    /**
     * Constructor for CommandLineInterface. Initializes the University class.
     */
    public CommandLineInterface() {
        this.UL = new University();
    }

    /**
     * Checks if the entered password matches the actual password for a given ID.
     *
     * @param id             The ID of the user.
     * @param actualPassword The actual password associated with the ID.
     */
    private static void checkPassword(int id, String actualPassword) {
        System.out.println("Please enter your password");
        String password = CommandLineInterface.input.nextLine();
        while (!(password.equals(actualPassword))) {
            System.out.println("Incorrect password");
            System.out.println("Please enter your password");
            password = CommandLineInterface.input.nextLine();
        }
        System.out.println("Logged in ID : " + id);
    }

    /**
     * Initializes the system by prompting the user to enter a path for data to be saved to.
     *
     * @throws IOException If an I/O error occurs.
     */
    public void init() throws IOException {
        boolean defaultPath = true;
        System.out.println("Enter absolute path for data to be saved to. \n");
        System.out.println("D - default - this will be src/data/...");
        String dataPath = input.nextLine().toUpperCase();
        if (!(dataPath.equals("D"))) {
            defaultPath = false;
            if (!dataPath.endsWith("\\")) {
                dataPath += "\\";
            }
            StringBuilder pathString = new StringBuilder();
            for (int i = 0; i < dataPath.length(); i++) {
                char currentChar = dataPath.charAt(i);
                if (currentChar == '\\') {
                    pathString.append("\\\\");
                } else {

                    pathString.append(currentChar);
                }
            }
            dataPath = pathString.toString();
            File students = new File(dataPath + "students.csv");
            File teachers = new File(dataPath + "teachers.csv");
            File departments = new File(dataPath + "departments.csv");
            File programmes = new File(dataPath + "programmes.csv");
            File modules = new File(dataPath + "modules.csv");
            File grades = new File(dataPath + "grades.csv");
            if (!students.exists()) {
                students.createNewFile();
            }
            if (!teachers.exists()) {
                teachers.createNewFile();
            }
            if (!departments.exists()) {
                departments.createNewFile();
            }
            if (!programmes.exists()) {
                programmes.createNewFile();
            }
            if (!modules.exists()) {
                modules.createNewFile();
            }
            if (!grades.exists()) {
                grades.createNewFile();
            }
        }
        if(defaultPath){
            dataPath = "src/data/";
        }
        UL.setStudentsPath(dataPath + "students.csv");
        UL.setTeachersPath(dataPath + "teachers.csv");
        UL.setDepartmentsPath(dataPath + "departments.csv");
        UL.setProgrammesPath(dataPath + "programmes.csv");
        UL.setModulesPath(dataPath + "modules.csv");
        UL.setGradesPath(dataPath + "grades.csv");
        csvParser data = new csvParser(UL);

        //if there is already data , this will load it into University
        //order of these methods matter
        data.parseDepartments();
        data.parseProgrammes();
        data.parseTeachers();
        data.parseStudents();
        data.parseModules();
        data.parseGrades();
    }

    /**
     * Runs the command-line interface.
     *
     * @throws FileNotFoundException If a file is not found.
     */
    public void run() throws FileNotFoundException {
        boolean LoggedIn = false;
        System.out.println("Welcome to the Student Record System!" + "\n");
        while (true) {
            System.out.println(
                    """
                            Please choose an option:
                            L - Login
                            R - Register
                            S - Save & Quit
                            """
            );
            switch (input.nextLine().toUpperCase()) {
                case "L":
                    Login();
                    LoggedIn = true;
                    break;
                case "R":
                    Register();
                    saveData();
                    break;
                case "S":
                    shutdown();
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }


            if (LoggedIn) {
                if (currentUser instanceof Student) {
                    studentMenu studentMenu = new studentMenu((Student) currentUser, UL);
                    studentMenu.run();
                } else if (currentUser instanceof Teacher) {
                    teacherMenu teacherMenu = new teacherMenu((Teacher) currentUser, UL);
                    teacherMenu.run();
                }
            }
        }

    }

    /**
     * Saves data to CSV files and exits the program.
     *
     * @throws FileNotFoundException If a file is not found.
     */
    public void shutdown() throws FileNotFoundException {
        saveData();
        exit(0);
    }

    /**
     * Saves data to CSV files.
     *
     * @throws FileNotFoundException If a file is not found.
     */
    private void saveData() throws FileNotFoundException {
        csvWriter csvWriter = new csvWriter(UL);
        //saves data to csv
        csvWriter.writeDepartments();
        csvWriter.writeProgrammes();
        csvWriter.writeTeachers();
        csvWriter.writeStudents();
        csvWriter.writeGrades();
        csvWriter.writeModules();
    }

    /**
     * Registers the students and teachers.
     *
     * @throws FileNotFoundException If a file is not found.
     */
    private void Register() throws FileNotFoundException {
        System.out.println(
                """
                        Please choose to register as student or teacher
                        S - Student
                        T - Teacher
                        """
        );
        switch (input.nextLine().toUpperCase()) {
            case "S":
                studentRegister();
                break;
            case "T":
                teacherRegister();
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }

    }

    /**
     * Login process for students and teachers.
     */
    private void Login() {
        System.out.println(
                """
                        Please choose to login as student or teacher
                        S - Student
                        T - Teacher
                        """
        );
        Scanner in = new Scanner(System.in);
        String upperCase = in.nextLine().toUpperCase();
        switch (upperCase) {
            case "T":
                teacherLogin();
                break;
            case "S":
                studentLogin();
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }

    }

    /**
     * Login process for teachers.
     */
    private void teacherLogin() {
        System.out.println("Please enter your id");
        int id = Integer.parseInt(CommandLineInterface.input.nextLine());
        String actualPassword = UL.getPassword(id);
        checkPassword(id, actualPassword);
        System.out.println("Welcome " + UL.getTeacher(id).getName());
        currentUser = UL.getTeacher(id);
    }

    /**
     * Login process for students.
     */
    private void studentLogin() {
        System.out.println("Please enter your id");
        int id = Integer.parseInt(CommandLineInterface.input.nextLine());
        String actualPassword = UL.getPassword(id);
        checkPassword(id, actualPassword);
        System.out.println("Welcome " + UL.getStudent(id).getName());
        currentUser = UL.getStudent(id);
    }

    /**
     * Registering process for students.
     *
     * @throws FileNotFoundException If a file is not found.
     */
    private void studentRegister() throws FileNotFoundException {
        System.out.println("You are now registering as a student\n");
        System.out.println("Please enter your name");
        String name = input.nextLine();
        System.out.println("Please enter your id");
        int id = Integer.parseInt(input.nextLine());
        while (!UL.uniqueID(id)) {
            System.out.println("This id is already taken");
            System.out.println("Please enter a new id");
            id = Integer.parseInt(input.nextLine());
        }
        System.out.println("Please enter your password");
        String password = input.nextLine();
        System.out.println("Please confirm your password ");
        String password2 = input.nextLine();
        while (!(password.equals(password2))) {
            System.out.println("Your passwords do not match");
            System.out.println("Please enter your password");
            password = input.nextLine();
            System.out.println("Please confirm your password ");
            password2 = input.nextLine();
        }
        Student newStudent = new Student(name, id, password);
        UL.addStudent(newStudent);
        int count = 0;
        for (Department department : UL.getDepartments()) {
            for (Programme prog : department.getProgrammes()) {
                System.out.println(prog.getName());
                count++;
            }
        }
        if (count != 0) {
            System.out.println("Select a programme");
            String programme = input.nextLine();
            while (UL.getProgramme(programme) == null) {
                System.out.println("Programme does not exist");
                System.out.println("Please enter a valid programme");
                programme = input.nextLine();
            }
            newStudent.setProgramme(UL.getProgramme(programme));
        }

        System.out.println("No programmes to join, a member of faculty must add one");
        System.out.println("You can join a program through the student main menu later");

        System.out.println("You have successfully registered as a student");

        currentUser = newStudent;
        studentMenu studentMenu = new studentMenu((Student) currentUser, UL);
        saveData();
        studentMenu.run();
    }

    /**
     * Registering process for teachers.
     *
     * @throws FileNotFoundException If a file is not found.
     */
    private void teacherRegister() throws FileNotFoundException {
        System.out.println("You are now registering as a teacher\n");
        System.out.println("Please enter your name");
        String nameT = input.nextLine();
        System.out.println("Please enter your id");
        int idT = Integer.parseInt(input.nextLine());
        while (!UL.uniqueID(idT)) {
            System.out.println("This id is already taken");
            System.out.println("Please enter a new id");
            idT = Integer.parseInt(input.nextLine());
        }
        System.out.println("Please enter your password");
        String passwordT = input.nextLine();
        System.out.println("Please confirm your password ");
        String passwordT2 = input.nextLine();
        while (!(passwordT.equals(passwordT2))) {
            System.out.println("Your passwords do not match");
            System.out.println("Please enter your password");
            passwordT = input.nextLine();
            System.out.println("Please confirm your password ");
            passwordT2 = input.nextLine();
        }
        System.out.println("Please enter your department");
        for (Department dep : UL.getDepartments()) {
            System.out.println(dep.getName());
        }

        String department = input.nextLine();
        if (UL.getDepartment(department) == null) {
            UL.addDepartment(new Department(department, UL));
            System.out.println("Department doesnt exist adding it now");
        }
        Teacher newTeacher = new Teacher(nameT, idT, UL.getDepartment(department), passwordT);
        UL.addTeacher(newTeacher);

        System.out.println("You have successfully registered as a teacher");
        saveData();

        //Set newly registered teacher as the current user
        currentUser = newTeacher;

        //Directly call the teacher menu
        teacherMenu teacherMenu = new teacherMenu(newTeacher, UL);
        teacherMenu.run();
    }
}
