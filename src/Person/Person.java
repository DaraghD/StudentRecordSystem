package Person;

import University.University;

import java.util.Scanner;

public class Person {

    private String name;
    private int id;
    private String password;

    public Person(String name, int id, String password) {
        this.name = name;
        this.id = id;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public static void registerInfo(boolean isTeacher) {
        String department = null;
        Scanner in = new Scanner(System.in);
        System.out.print("You are now registering as a ");
        if(isTeacher) {
            System.out.println("teacher\n");
        } else {
            System.out.println("student\n");
        }

        System.out.println("Please enter your name");
        String name = in.nextLine();

        System.out.println("Please enter your id");
        int id = Integer.parseInt(in.nextLine());

        if (isTeacher) {
            System.out.println("Please enter your department");
            department = in.nextLine();
        }
        
        System.out.println("Please enter your password");
        String password = in.nextLine();

        System.out.println("Please confirm your password ");
        String password2 = in.nextLine();

        while (!(password.equals(password2))) {
            System.out.println("Your passwords do not match");
            System.out.println("Please enter your password");
            password = in.nextLine();
            System.out.println("Please confirm your password ");
            password2 = in.nextLine();
        }
        //if out of while loop password is now confirmed
        if(isTeacher) {
            registerTeacherDetails(name, id, department, password);
        } else {
            registerStudentDetails(name, id, password);
        }
    }
    
    private static void registerStudentDetails(String name, int id, String password) {
        Student newStudent = new Student(name, id, password);
        //check if teacher already exists -> maybe do this for ID earlier in the above method
        University.addStudent(newStudent);
        System.out.println("You have successfully registered as a student");
    }
    
    
    private static void registerTeacherDetails(String name, int id, String department, String password) {
        Teacher newTeacher = new Teacher(name, id, department, password);
        //check if teacher already exists -> maybe do this for ID earlier in the above method
        University.addTeacher(newTeacher);
        System.out.println("You have successfully registered as a teacher");
    }



}
