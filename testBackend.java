
// --== CS400 File Header Information ==--
// Name: Eric Zhou
// Email: ezhou22@wisc.edu
// Team: IG
// Role: Test Engineer 1
// TA: Mu Cai
// Lecturer: Florian Heimerl
// Notes to Grader: Will add more tests if needed.

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test Backend class. Will run the necessary tests so that backend works as
 * intended.
 * @author Eric Zhou
 *
 */
class testBackend {
    private Backend backend;
    
    @BeforeEach
    /**
     * Initial setup method. Creates new backend class.
     */
    public void setup() {
        this.backend = new Backend();
    }
    
    @Test
    /**
     * testing the add of degrees and individual courses to those degrees.
     */
    public void testBackendAdd() {
        // Adding initial degree.
        if (!this.backend.addMajor("Computer Science")) {
            fail("Error! Backend did not add the major to the hash table as "
                + "expected! Check line 26 of testBackend");
        }
        
        // This should add correctly.
        if (!this.backend.addCourse("Computer Science", "CS200")) {
            fail("Error! Backend did not add the CourseNode as intended!");
        }
        
        // Adding another degree
        if (!this.backend.addMajor("Mathematics")) {
            fail("Error! Backend did not add the mathematics to table of degrees "
                + "as intended.");
        }
        
        // Adding one course to math
        if (!this.backend.addCourse("Mathematics", "MATH221")) {
            fail("Error! Backend did not add the CourseNode as intended!");
        }
    }
    
    @Test
    /**
     * testing the remove course method of backend.
     */
    public void testRemoveCourse() {
        if (!this.backend.addMajor("Computer Science")) {
            fail("Error! Backend did not add the major to the hash table as "
                + "expected!");
        }
        if (!this.backend.addCourse("Computer Science", "CS200")) {
            fail("Error! Backend did not add the CourseNode as intended!");
        }
        
        if (!this.backend.removeCourse("Computer Science", "CS200")) {
            fail("Error! Backend did not remove CS200");
        }
        
        if (this.backend.removeCourse("Computer Science", "CS220")) {
            fail("Error! Backend did remove 220, but it should not have!");
        }
    }
    
    @Test
    /**
     * testing the search course method of backend
     */
    public void testSearchCourse() {
        if (!this.backend.addMajor("Computer Science")) {
            fail("Error! Backend did not add the major to the hash table as "
                + "expected!");
        }
        if (!this.backend.addCourse("Computer Science", "CS200")) {
            fail("Error! Backend did not add the CourseNode as intended!");
        }
        
        if (!this.backend.searchCourse("Computer Science", "CS200")) {
            fail("Error! Backend did not find the course! Check your search"
                + " algorithm");
        }
        
        if (this.backend.searchCourse("Computer Science", "CS220")) {
            fail("Error! Backend should not have found a course that does not"
                + " exist!");
        }
    }
    
    @Test
    /**
     * testing the adding connections between two courses.
     */
    public void testAddingConnections() {
        if (!this.backend.addMajor("Computer Science")) {
            fail("Error! Backend did not add the major to the hash table as "
                + "expected!");
        }
        if (!this.backend.addCourse("Computer Science", "CS200")) {
            fail("Error! Backend did not add the CourseNode as intended!");
        }
        if (!this.backend.addCourse("Computer Science", "CS300")) {
            fail("Error! Backend did not add the CourseNode as intended!");
        }
        
        // Normal adding edge test.
        if (!this.backend.addCourseConnection("Computer Science", "CS200", "CS300", 3)) {
            fail("Error! Adding an edge between 200 and 300 did not work! Check"
                + " the backend or graph edge adding process.");
        }
        
        // Edge addition that already exists, should fail.
        if (this.backend.addCourseConnection("Computer Science", "CS200", "CS300", 3)) {
            fail("Error! Adding an edge between 200 and 300 should not work since"
                + " there is already an edge between the two.");
        }
    }
    
    @Test
    /**
     * Testing remove connection methods
     */
    public void testRemoveConnections() {
        if (!this.backend.addMajor("Computer Science")) {
            fail("Error! Backend did not add the major to the hash table as "
                + "expected!");
        }
        if (!this.backend.addCourse("Computer Science", "CS200")) {
            fail("Error! Backend did not add the CourseNode as intended!");
        }
        if (!this.backend.addCourse("Computer Science", "CS300")) {
            fail("Error! Backend did not add the CourseNode as intended!");
        }
        
        if (!this.backend.addCourseConnection("Computer Science", "CS200", "CS300", 3)) {
            fail("Error! Adding an edge between 200 and 300 did not work! Check"
                + " the backend or graph edge adding process.");
        }
        
        // Should remove edge.
        if (!this.backend.removeCourseConnection("Computer Science", "CS200", "CS300")) {
            fail("Error! Removing the edge between 200 and 300 did not work as"
                + " intended!");
        }
        
        // Removing an edge that doesnt exist should not work.
        if (this.backend.removeCourseConnection("Computer Science", "CS200", "CS300")) {
            fail("Error! Removing the edge between 200 and 300 should not return true"
                + " since there is no longer an edge between the two, but it was"
                + " not the case.");
        }
    }
    
    @Test
    /**
     * Testing the prim/prereq finder.
     */
    public void testPrereqFinder() {
        this.backend.addMajor("Computer Science");
        this.backend.addCourse("Computer Science", "CS200");
        this.backend.addCourse("Computer Science", "CS300");
        this.backend.addCourse("Computer Science", "CS400");
        this.backend.addCourse("Computer Science", "CS240");
        this.backend.addCourse("Computer Science", "CS577");
        this.backend.addCourseConnection("Computer Science", "CS200", "CS300", 3);
        this.backend.addCourseConnection("Computer Science", "CS300", "CS400", 3);
        this.backend.addCourseConnection("Computer Science", "CS577", "CS400", 3);
        this.backend.addCourseConnection("Computer Science", "CS577", "CS240", 3);
        
        // TODO Parse into this string.
        System.out.println(this.backend.findCourseDependencies("Computer Science", "CS577"));
        String s ="Original Course: CS577\n" + 
            "Prequisites: CS400, CS300, CS200, CS240";
        if (!this.backend.findCourseDependencies("Computer Science", "CS577").equals(s)) {
            fail("Error! Did not find the correct prerequisites.");
        }
    }
}