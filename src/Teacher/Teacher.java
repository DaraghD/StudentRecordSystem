package Teacher;
import University.University;
import java.util.Scanner;

public class Teacher {
    private String Department;
    private String name;
    private int id;
    private String password;



    public Teacher(String name, int id, String department, String password) {
        this.Department = department;
        this.name = name;
        this.id = id;
        this.password = password;
    }

    public static void registerInfo(){
        Scanner in = new Scanner(System.in);
        System.out.println("You are now registering as a teacher");

        System.out.println("Please enter your name");
        String name = in.nextLine();

        System.out.println("Please enter your id");
        int id = Integer.parseInt(in.nextLine());

        System.out.println("Please enter your department");
        String department = in.nextLine();

        System.out.println("Please enter your password");
        String password = in.nextLine();

        System.out.println("Please confirm your password ");
        String password2 = in.nextLine();

        while(!(password.equals(password2))){
            System.out.println("Your passwords do not match");
            System.out.println("Please enter your password");
            password = in.nextLine();
            System.out.println("Please confirm your password ");
            password2 = in.nextLine();
        }
        //if out of while loop password is now confirmed

        registerTeacherDetails(name, id, department,password);
    }

    private static void registerTeacherDetails(String name, int id, String department, String password){
        Teacher newTeacher = new Teacher(name, id, department, password);
        //check if teacher already exists -> maybe do this for ID earlier in the above method
        University.addTeacher(newTeacher);
        System.out.println("You have successfully registered as a teacher");
    }
    public void addStudentGrade() {

    }

    public int getID() {
        return id;
    }


    public void viewDepartmentBoard() {

    }

    public void addDepartment(){

    }


}
