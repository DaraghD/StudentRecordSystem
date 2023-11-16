package Person;
import University.University;

public class Student extends Person {


    public Student(String name, int id, String password) {
        super(name, id, password);
    }



    public void ViewTranscript() {

    }

    public static String getPassword(int id){
        for(Student student : University.getStudents()){
            if(student.getId() == id){
                return student.getPassword();
            }
        }
        return null;
    }
    public static Student getStudent(int id){
        for(Student student : University.getStudents()){
            if(student.getId() == id){
                return student;
            }
        }
        return null;
    }



    public void registerInfo() {

    }
}
