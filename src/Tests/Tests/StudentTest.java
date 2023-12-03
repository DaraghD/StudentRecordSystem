package Tests;

import Department.Department;
import Grading.*;
import Grading.Module;
import Person.Student;
import University.University;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    Student student;
    University UL;
    ProgrammeType level;
    Department Science;
    Programme LM121;

    @BeforeEach
    void setup() {
        student = new Student("Caylum", 22356363, "Password123");

        UL = new University();

        level = ProgrammeType.UNDERGRADUATE;

        Science = new Department("Science", UL);

        LM121 = new Programme("Foundations of Computer Science", UL, 4, level, 2.0, Science);

        student.setProgramme(LM121);

        Module CS4013 = new Module("CS4013", 1, Semester.AUTUMN, LM121);
        Module CS4222 = new Module("CS4222", 1, Semester.SPRING, LM121);


        LM121.addModule(CS4222);
        LM121.addModule(CS4013);
    }


    @Test
    void QCA() {
        Module CS4013 = student.getModuleG("CS4013");

        Grade B2 = new Grade(GradeType.B2, CS4013, student.getId());
        Grade A1 = new Grade(GradeType.A1, CS4013, student.getId());
        Grade B1 = new Grade(GradeType.B1, CS4013, student.getId());
        Grade C3 = new Grade(GradeType.C3, CS4013, student.getId());

        student.addGrade(B2);
        student.addGrade(A1);
        student.addGrade(B1);
        student.addGrade(C3);

        double actualQCA = 3.05;
        assertEquals(actualQCA, student.QCA("CS4013"));
    }

    @Test
    void totalQCA() {
        Module CS4013 = student.getModuleG("CS4013");
        Module CS4222 = student.getModuleG("CS4222");
        Grade B2 = new Grade(GradeType.B2, CS4013, student.getId());
        Grade A1 = new Grade(GradeType.A1, CS4013, student.getId());
        Grade B1 = new Grade(GradeType.B1, CS4013, student.getId());
        Grade C3 = new Grade(GradeType.C3, CS4013, student.getId());

        Grade A2 = new Grade(GradeType.A2, CS4222, student.getId());
        Grade C2 = new Grade(GradeType.C2, CS4222, student.getId());
        Grade B3 = new Grade(GradeType.B3, CS4222, student.getId());
        Grade C1 = new Grade(GradeType.C1, CS4222, student.getId());

        student.addGrade(B2);
        student.addGrade(A1);
        student.addGrade(B1);
        student.addGrade(C3);
        student.addGrade(A2);
        student.addGrade(B3);
        student.addGrade(C1);
        student.addGrade(C2);

        double actualQCA = 2.95;

        assertEquals(actualQCA,student.totalQCA(),0.005);

    }

    @Test
    void qcaPerSemester() {

        Module CS4013 = student.getModuleG("CS4013");
        Grade B2 = new Grade(GradeType.B2, CS4013, student.getId());
        Grade A1 = new Grade(GradeType.A1, CS4013, student.getId());
        Grade B1 = new Grade(GradeType.B1, CS4013, student.getId());
        Grade C3 = new Grade(GradeType.C3, CS4013, student.getId());

        student.addGrade(B2);
        student.addGrade(A1);
        student.addGrade(B1);
        student.addGrade(C3);

        double actualQCA = 3.05;
        assertEquals(actualQCA,student.qcaPerSemeseter(1, Semester.AUTUMN),0.005);
    }

    @Test
    void qcaPerYear() {
        Module CS4013 = student.getModuleG("CS4013");
        Module CS4222 = student.getModuleG("CS4222");
        Grade B2 = new Grade(GradeType.B2, CS4013, student.getId());
        Grade A1 = new Grade(GradeType.A1, CS4013, student.getId());
        Grade B1 = new Grade(GradeType.B1, CS4013, student.getId());
        Grade C3 = new Grade(GradeType.C3, CS4013, student.getId());

        Grade A2 = new Grade(GradeType.A2, CS4222, student.getId());
        Grade C2 = new Grade(GradeType.C2, CS4222, student.getId());
        Grade B3 = new Grade(GradeType.B3, CS4222, student.getId());
        Grade C1 = new Grade(GradeType.C1, CS4222, student.getId());

        student.addGrade(B2);
        student.addGrade(A1);
        student.addGrade(B1);
        student.addGrade(C3);
        student.addGrade(A2);
        student.addGrade(B3);
        student.addGrade(C1);
        student.addGrade(C2);

        double actualQCA = 2.95;

        assertEquals(actualQCA,student.qcaPerYear(1),0.005);

    }

}