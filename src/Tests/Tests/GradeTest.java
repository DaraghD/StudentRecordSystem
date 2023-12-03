package Tests;

import Department.Department;
import Grading.*;
import Grading.Module;
import Person.Student;
import University.University;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class GradeTest {

    Student student;
    University UL;
    ProgrammeType level;
    Department Science;
    Programme LM121;
    Module CS4013;
    Grade grade;

    @BeforeEach
    void setup() {
        student = new Student("Joe", 22, "Password123");

        UL = new University();

        level = ProgrammeType.UNDERGRADUATE;

        Science = new Department("Science", UL);

        LM121 = new Programme("Mathematics", UL, 4, level, 2.0, Science);

        student.setProgramme(LM121);

        CS4013 = new Module("CS4013", 1, Semester.AUTUMN, LM121);
        grade = new Grade(GradeType.A2, CS4013,22);

    }

    @Test
    void convertPercentageToGrade() {
        Grade percentageGrade = new Grade(70,CS4013,22);
        assertEquals(percentageGrade.getGrade(),GradeType.A2);

    }

    @Test
    void csvFormat() {
        String csvFormat = "A2,CS4013,22";
        assertEquals(csvFormat,grade.csvFormat());

    }

    @Test
    void csvHeader() {
        assertEquals(grade.csvHeader(),"Grade,Module,ID");
    }

    @Test
    void convertGradeToNumber() {
        assertEquals(grade.convertGradeToNumber(),3.6);
    }


}