import Person.Student;
public interface GradingSystem {

    // Currently QCA -> UL method , should be able to adapt easily(Maybe interface can allow it to change easier? stable contract?)

    public double calculateGrade(Student student);



    //public static double calculateQCA(Student student){
    //     return 0.0;
    //}
}
