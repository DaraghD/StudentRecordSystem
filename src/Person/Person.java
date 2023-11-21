package Person;

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

    public static boolean uniqueID(int id) { // id is unique between teacher and students
        if (Teacher.getTeacher(id) != null || Student.getStudent(id) != null) {
            return true;
        }
        return false;
    }
}