package CommandLineInterface;

import Person.Person;
import csvUtils.csvWriter;
import csvUtils.csvParser;
import University.University;
import Department.Department;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import Person.*;

import static java.lang.System.exit;

//TODO: SAVE AFTER REGISTERING
public class CommandLineInterface {

    private static Scanner input = new Scanner(System.in);
    private Person currentUser; // when login set this to the reference of the logged in object

    private University UL;


    public CommandLineInterface() {
        this.UL = new University();
    }

    public void init() throws IOException {
        System.out.println("Enter path for data to be saved to");
        System.out.println("D for default");
        String optionPath = input.nextLine().toUpperCase();
        if (!(optionPath.equals("D"))) {
            //TODO: Simplify this logic using optionPath = src/data/ if D
            UL.setStudentsPath(optionPath + "students.csv");
            UL.setTeachersPath(optionPath + "teachers.csv");
            UL.setDepartmentsPath(optionPath + "departments.csv");
            UL.setProgrammesPath(optionPath + "programmes.csv");
        } else {
            UL.setStudentsPath("src/data/students.csv");
            UL.setTeachersPath("src/data/teachers.csv");
            UL.setDepartmentsPath("src/data/departments.csv");
            UL.setProgrammesPath("src/data/programmes.csv");
        }
        csvParser data = new csvParser(UL);
        //if there is already data , this will load it into University
        data.parseTeachers();
        data.parseStudents();
    }


    public void run() throws FileNotFoundException {
        //testing
        System.out.println("TESTING");
        for (Student s : UL.getStudents()) {
            System.out.println("Student: " + s.getName() + " " + s.getId() + " " + s.getPassword() + " " + s.getGrades());
            System.out.println();
        }


        //testing
        boolean LoggedIn = false;
        boolean exit = false;
        System.out.println("Welcome to the Student Record System!" + "\n");
        outer:
        while (true) {
            System.out.println(
                    """
                            Please choose an option:
                            L)ogin
                            R)egister
                            S)ave & Quit
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

    public void shutdown() throws FileNotFoundException {
        csvWriter csvWriter = new csvWriter(UL);
        //saves data to csv
        csvWriter.writeTeachers();
        csvWriter.writeStudents();
        exit(0);
    }

    private void saveData() throws FileNotFoundException {
        csvWriter csvWriter = new csvWriter(UL);
        //saves data to csv
        csvWriter.writeTeachers();
        csvWriter.writeStudents();
    }


    private void Register() throws FileNotFoundException {
        System.out.println(
                """
                        Please choose to register as student or teacher
                        S)tudent
                        T)eacher
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

    private void Login() {
        System.out.println(
                """
                        Please choose to login as student or teacher
                        S)tudent
                        T)eacher
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

    private void teacherLogin() {
        System.out.println("Please enter your id");
        int id = Integer.parseInt(CommandLineInterface.input.nextLine());
        String actualPassword = UL.getPassword(id);
        checkPassword(id, actualPassword);
        System.out.println("Welcome " + UL.getTeacher(id).getName());
        currentUser = UL.getTeacher(id);
    }

    private void studentLogin() {
        System.out.println("Please enter your id");
        int id = Integer.parseInt(CommandLineInterface.input.nextLine());
        String actualPassword = UL.getPassword(id);
        checkPassword(id, actualPassword);
        System.out.println("Welcome " + UL.getStudent(id).getName());
        currentUser = UL.getStudent(id);
    }

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
        UL.addStudent(new Student(name, id, password));
        System.out.println("You have successfully registered as a student");
        saveData();

        currentUser = UL.getStudent(id);


        studentMenu studentMenu = new studentMenu((Student) currentUser, UL);
        studentMenu.run();
    }

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
            String password = input.nextLine();
            System.out.println("Please confirm your password ");
            String password2 = input.nextLine();
        }
        System.out.println("Please enter your department");
        for(Department dep : UL.getDepartments()){
            System.out.println(dep.getName());
        }

        String department = input.nextLine();
        if(UL.getDepartment(department) == null){
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
