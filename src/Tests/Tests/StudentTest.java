package Tests;

import Department.Department;
import Grading.Programme;
import Grading.ProgrammeType;
import Person.Student;
import University.University;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
Student student = new Student("Caylum", 22356363, "Password123");

University UL = new University();

ProgrammeType level = new ProgrammeType();

Department Science = new Department("Science", UL);

Programme LM121 = new Programme("Foundations of Computer Science", UL, 4, 8, 2.0, Science);
    @Test
    void setProgramme() {
        assertEquals(student.setProgramme(LM121);
    }

    @Test
    void addGrade() {
    }

    @Test
    void addMessage() {
    }

    @Test
    void getMessages() {
    }

    @Test
    void getCurrentProgramme() {
    }

    @Test
    void getGrades() {
    }

    @Test
    void QCA() {
    }

    @Test
    void totalQCA() {
    }

    @Test
    void qcaPerSemeseter() {
    }

    @Test
    void qcaPerYear() {
    }

    @Test
    void getModuleG() {
    }
}