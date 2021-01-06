//--== CS400 File Header Information ==--
//Name: Eric Zhou
//Email: ezhou22@wisc.edu
//Team: IG
//Role: Test Engineer 1
//TA: Mu Cai
//Lecturer: Florian Heimerl
//Notes to Grader: Will add more tests if needed.

import static org.junit.jupiter.api.Assertions.*;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.LinkedList;

class testGraph {
 private MajorGraph<CourseNode> degree;
 private LinkedList<CourseNode> prereqs;
 
 @BeforeEach
 public void resetFields() {
     this.degree = new MajorGraph<CourseNode>();
     this.prereqs = new LinkedList<CourseNode>();
     CourseNode CS200 = new CourseNode("CS200");
     CourseNode CS300 = new CourseNode("CS300");
     CourseNode CS240 = new CourseNode("CS240");
     CourseNode CS252 = new CourseNode("CS252");
     prereqs.push(CS200);
     prereqs.push(CS300);
     prereqs.push(CS252);
     prereqs.push(CS240);
 }
 
 /**
  * Will test the basic functionality of the graph. Will add very basic
  * vertices and edges, just seeing if the graph functions as intended.
  * Code in this test is not accurate, it is just meant to test the 
  * base functionality.
  */
 @Test
 public void basicGraphTest() {
     CourseNode CS200 = new CourseNode("CS200");
     CourseNode CS300 = new CourseNode("CS300");
     CourseNode CS240 = new CourseNode("CS240");
     CourseNode CS252 = new CourseNode("CS252");
     for (CourseNode course: this.prereqs) {
         if (!degree.insertVertex(course)) {
             fail("Error! Check line 33 of testGraphs. This results when "
                 + "either the course itself is null or the vertex"
                 + " already exists in the graph.");
         };
     }
     
     if (!this.degree.insertEdge(CS200, CS300, 7)) {
         fail("Error! Check line 44-50, where we are adding edges to the "
             + "graph itself. Expected to add edge, however it did not.");
     };
     if (!this.degree.insertEdge(CS200, CS240, 3)) {
         fail("Error! Check line 44-50, where we are adding edges to the "
             + "graph itself. Expected to add edge, however it did not.");
     };
     if (!this.degree.insertEdge(CS200, CS252, 5)) {
         fail("Error! Check line 44-50, where we are adding edges to the "
             + "graph itself. Expected to add edge, however it did not.");
     };
 }
 
 /**
  * Test duplicate vertices (course nodes). Should cause a failure when
  * adding duplicate vertices (prevent overlap)
  */
 @Test
 public void testDuplicateCourses() {
     CourseNode CS200 = new CourseNode("CS200"); // duplicate node
     for (int i = 0; i < 2; ++i) {
         if (this.degree.insertVertex(CS200) && i == 1) {
             fail("Error! Check line 66 of tests. Adding a duplicate node"
                 + " should fail.");
         };
     }
     
     CourseNode CS300 = new CourseNode("CS300"); // second duplicate node
     for (int i = 0; i < 2; ++i) {
         if (this.degree.insertVertex(CS300) && i == 1) {
             fail("Error! Check line 75 of tests. Adding a duplicate node"
                 + " should fail.");
         };
     }
 }
 
 /**
  * Test duplicate edges (course weight/edge weight, should cause a failure
  * when adding duplicate edges)
  */
 @Test
 public void testDuplicateEdges() {
     CourseNode CS200 = new CourseNode("CS200");
     CourseNode CS300 = new CourseNode("CS300");
     CourseNode CS240 = new CourseNode("CS240");
     CourseNode CS252 = new CourseNode("CS252");
     
     for (CourseNode course: this.prereqs) {
         this.degree.insertVertex(course);
     }
     
     // First edge, should fail.
     for (int i = 0; i < 2; ++i) {
         if (this.degree.insertEdge(CS200, CS300, 7) && i == 1) {
             fail("Error! Check line 99 of tests. Adding a duplicate edge"
                 + " should fail.");
         }
     }
     
     // Second edge, should fail.
     for (int i = 0; i < 2; ++i) {
         if (this.degree.insertEdge(CS200, CS240, 6) && i == 1) {
             fail("Error! Check line 107 of tests. Adding a duplicate edge"
                 + " should fail.");
         }
     }
 }
 
 /**
  * Search for nonexistent vertices and edges test.
  */
 @Test
 public void testSeachNonexistentVerticesAndEdges() {
     CourseNode CS200 = new CourseNode("CS200");
     CourseNode CS300 = new CourseNode("CS300");
     CourseNode CS240 = new CourseNode("CS240");
     CourseNode CS252 = new CourseNode("CS252");
     
     for (CourseNode course: this.prereqs) {
         this.degree.insertVertex(course);
     }
     
     if (this.degree.containsVertex(new CourseNode("CS577"))) {
         fail("Error! CS577 should not already exist in the degree."
             + " Therefore, check your insertion/deletion checks.");
     }
     
     if (!this.degree.containsVertex(CS200)) {
         fail("Error! CS200 is already in the degree. Therefore, check "
             + "insertion/deletion algorith.");
     }
     
     // Search for edges that do not exist.
     if (this.degree.containsEdge(CS200, new CourseNode("CS400"))) {
         fail("Error! CS200 is already in the degree. Therefore, check "
             + "insertion/deletion algorith.");
     }
 }
 
 /**
  * Deletes nonexistent node/edge should return false. 
  */
 @Test
 public void testNonexistentDeletes() {
     CourseNode CS200 = new CourseNode("CS200");
     CourseNode CS300 = new CourseNode("CS300");
     CourseNode CS240 = new CourseNode("CS240");
     CourseNode CS252 = new CourseNode("CS252");
     
     for (CourseNode course: this.prereqs) {
         this.degree.insertVertex(course);
     }
     
     // Two deletion of vertices that do not exist.
     if (this.degree.removeVertex(new CourseNode("CS576"))) {
         fail("Error! Line 161. Removing a nonexistent course from the degree."
             + " Check the deletion algorithm.");
     }
     
     if (this.degree.removeVertex(new CourseNode("CS577"))) {
         fail("Error! Line 166. Removing a nonexistent course from the degree."
             + " Check the deletion algorithm.");
     }
     
     // Deletion of edges that do not exist between two existent nodes,
     // deletion of an edge between one node that exists and one that doesn't,
     // and deletion of an edge between two nonexistent nodes.
     this.degree.insertVertex(new CourseNode("CS400"));
     if (this.degree.removeEdge(CS200, new CourseNode("CS400"))) {
         fail("Error! Line 175, removing an edge between two existent courses"
             + " that does not exist has caused an error. Check deletion"
             + " algorithm.");
     }
     
     try {
         this.degree.removeEdge(CS200, new CourseNode("CS577"));
         fail("Error! Line 181, removing an edge between an existent course"
             + " and another nonexistent course that does not exist has caused"
             + " an error. Check deletion algorithm.");
     } catch (IllegalArgumentException e) {
         
     }
     
     try {
         this.degree.removeEdge(new CourseNode("CS576"), new CourseNode("CS577"));
         fail("Error! Line 187, removing an edge between an nonexistent course"
             + " and another nonexistent course that does not exist has caused"
             + " an error. Check deletion algorithm.");
     } catch (IllegalArgumentException e) {
         
     }
 }
 
 /**
  * ValidDifficulty/Weight test. Will try to add negative weights to an edge.
  */
 @Test
 public void testValidDifficulty() {
     CourseNode CS200 = new CourseNode("CS200");
     CourseNode CS300 = new CourseNode("CS300");
     CourseNode CS240 = new CourseNode("CS240");
     CourseNode CS252 = new CourseNode("CS252");
     
     for (CourseNode course: this.prereqs) {
         this.degree.insertVertex(course);
     }
     
     try {
         this.degree.insertEdge(CS200, CS300, -20);
         fail("Error! Line 208. Inserting an invalid weight should return"
             + " an error. Check insertion of edge algorithm!");
     } catch(IllegalArgumentException e) {
         
     }
 }
 
 /**
  * Test search/delete on empty degree plan.
  */
 @Test
 public void testSearchDeleteEmptyDegree() {
     if (this.degree.removeVertex(new CourseNode("CS400"))) {
         fail("Error! Line 218. Removed a node that doesn't exist in the "
             + "graph (no nodes exist in graph) and this should return false,"
             + " but it was not the case.");
     }
     
     if (this.degree.containsVertex(new CourseNode("CS400"))) {
         fail("Error! Line 225. Searched a node that doesn't exist in the "
             + "graph (no nodes exist in graph) and this should return false,"
             + " but it was not the case.");
     }
 }
 
 /**
  * Test print via DFS. Just prints out vertices
  */
 @Test
 public void testDFSPrint() {
     CourseNode CS200 = new CourseNode("CS200");
     CourseNode CS300 = new CourseNode("CS300");
     CourseNode CS240 = new CourseNode("CS240");
     CourseNode CS252 = new CourseNode("CS252");
     
     for (CourseNode course: this.prereqs) {
         this.degree.insertVertex(course);
     }
     
     this.degree.insertEdge(CS200, CS300, 7);
     this.degree.insertEdge(CS200, CS240, 6);
     this.degree.insertEdge(CS200, CS252, 5);
     
     if(!this.degree.depthFirstSearch(new CourseNode("CS200")).toString()
             .equals("[CS200, CS300, CS240, CS252]")) {
         fail("Error! Check the edges inserted. DFS failed, line 269.");
     }
     
     try {
         this.degree.depthFirstSearch(new CourseNode("CS354"));
         fail("Error! Searching for a course node that doesn't exist should "
             + " return an error, but it was not the case. Line 275.");
     } catch (IllegalArgumentException e) {
         
     }
 }
}
