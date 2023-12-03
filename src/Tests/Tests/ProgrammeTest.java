package Tests;

import Grading.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProgrammeTest {

    private Programme programme;
    private Module module;
    private Student student;
    private University university;
    private Department department;

    @Before
    public void setUp() {
        university = new University("Test University");
        department = new Department("Test Department", university);
        programme = new Programme("Test Programme", university, 3, ProgrammeType.UNDERGRADUATE, 60.0, department);
        module = new Module("Test Module", "TM001", 20, department);
        student = new Student("John Doe", "JD001", department);
    }

    @Test
    public void testAddModule() {
        programme.addModule(module);
        assertTrue(programme.getModules().contains(module));
    }

    @Test
    public void testGetModule() {
        programme.addModule(module);
        Module retrievedModule = programme.getModule("Test Module");
        assertNotNull(retrievedModule);
        assertEquals("Test Module", retrievedModule.getName());
    }

    @Test
    public void testAddStudent() {
        programme.addStudent(student);
        assertTrue(programme.getStudents().contains(student));
    }

    @Test
    public void testCsvFormat() {
        String expectedCsvFormat = "Test Programme,3,UNDERGRADUATE,60.0,Test Department";
        assertEquals(expectedCsvFormat, programme.csvFormat());
    }

    @Test
    public void testCsvHeader() {
        String expectedCsvHeader = "Name,Duration,Level,Cutoff,Department";
        assertEquals(expectedCsvHeader, programme.csvHeader());
    }
}
