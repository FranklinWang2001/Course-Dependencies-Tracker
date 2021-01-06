//--== CS400 File Header Information ==--
//Name: Eric Zhou
//Email: ezhou22@wisc.edu
//Team: IG
//Role: Test Engineer 1
//TA: Mu Cai
//Lecturer: Florian Heimerl
//Notes to Grader: For testing and prod
/**
* CourseNode data structure, will store the course name and has hashcode and
* equals function for the graph.
*/
public class CourseNode {
 private String name;

 /**
  * Getter method
  * @return String - returns name
  */
 public String getName() {
     return name;
 }

 /**
  * Setter method
  * @param name String - sets name
  */
 public void setName(String name) {
     this.name = name;
 }

 /**
  * Constructor requires course name for graph and information purposes.
  * 
  * @param name String - name of course
  */
 public CourseNode(String name) {
     this.name = name;
 }
 
 /**
  * Overridden hashCode() method. For simplicity, returns the hashCode value of
  * the name of the course. Will be used in graph implementation
  * 
  * @return int - returns the value fo the hashcode of the string name.
  */
 @Override
 public int hashCode() {
     return this.name.hashCode();
 }

 /**
  * Overridden equals method. Will just return whether or not the names of the
  * two CourseNodes are equal.
  * 
  * @return boolean - true/false depending on if course nodes are equal.
  */
 @Override
 public boolean equals(Object o) {
     return (o instanceof String ? this.name.equals(name) : this.name.equals(((CourseNode) o).name));
 }

 /**
  * Overridden toString method for print methods.
  */
 @Override
 public String toString() {
     return this.name;
 }

}