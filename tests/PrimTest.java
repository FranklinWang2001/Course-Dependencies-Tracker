//--== CS400 File Header Information ==--
//Name: Eric Zhou
//Email: ezhou22@wisc.edu
//Team: IG
//TA: Mu Cai
//Lecturer: Florian Heimerl
//Notes to Grader: Franklin Wang helped the implementation of tests

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.NoSuchElementException;

/**
* Test class for Prims
* 
* @author Eric Zhou and Franklin Wang
*/
public class PrimTest {
 public MajorGraph<CourseNode> degree;
 public Backend testBackend;

 @BeforeEach
 /**
  * Basic setup function, creating the initial CS degree for simplistic prim
  * testing.
  */
 public void setup() {
     this.testBackend = new Backend();
     this.degree = new MajorGraph<>();
     CourseNode MATH240 = new CourseNode("MATH240");
     CourseNode CS200 = new CourseNode("CS200");
     CourseNode CS300 = new CourseNode("CS300");
     CourseNode CS400 = new CourseNode("CS400");
     CourseNode CS577 = new CourseNode("CS577");
     this.degree.insertVertex(MATH240);
     this.degree.insertVertex(CS200);
     this.degree.insertVertex(CS300);
     this.degree.insertVertex(CS400);
     this.degree.insertVertex(CS577);
     this.degree.insertEdge(CS300, CS200, 3);
     this.degree.insertEdge(CS400, CS300, 3);
     this.degree.insertEdge(CS577, CS400, 3);
     this.degree.insertEdge(CS577, MATH240, 3);

     this.degree.insertEdge(CS200, CS300, 3);
     this.degree.insertEdge(CS300, CS400, 3);
     this.degree.insertEdge(CS400, CS577, 3);
     this.degree.insertEdge(MATH240, CS577, 3);
     
     this.testBackend.table.put("Computer Science", this.degree);
 }

 @Test
 /**
  * First prim test, checking the CS577 minimum spanning tree. Basic example
  */
 public void testPrim() {
     CourseNode CS577 = new CourseNode("CS577");
     MajorGraph<CourseNode> minSpanningTree = this.degree.primsSpanningTree(degree.vertices.get(CS577).data);

     if (!minSpanningTree.depthFirstSearch(CS577).toString().equals("[CS577, CS400, CS300, CS200, MATH240]")) {
         System.out.println(minSpanningTree.depthFirstSearch(CS577).toString());
         fail("Error! Minimum spanning tree did not return what was expected. Check line 50.");
     }
 }

 @Test
 /**
  * Tests with an extra node that is NOT connected to CS577, should not be
  * included in the minimum spanning tree.
  */
 public void testPrimAdditionalNode() {
     this.degree.insertVertex(new CourseNode("CS320"));
     CourseNode CS577 = new CourseNode("CS577");
     MajorGraph<CourseNode> minSpanningTree = this.degree.primsSpanningTree(degree.vertices.get(CS577).data);

     if (!minSpanningTree.depthFirstSearch(CS577).toString().equals("[CS577, CS400, CS300, CS200, MATH240]")) {
         fail("Error! Minimum spanning tree did not return what was expected. Check line 50.");
     }
 }
}
