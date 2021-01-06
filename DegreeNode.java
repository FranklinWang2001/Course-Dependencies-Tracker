//--== CS400 File Header Information ==--
//Name: Eric Zhou
//Email: ezhou22@wisc.edu
//Team: IG
//Role: Test Engineer 1
//TA: Mu Cai
//Lecturer: Florian Heimerl
//Notes to Grader: Used in testing and prod

/**
* DegreeNode. Used in hash table of degrees.
*/
public class DegreeNode {
 private String degree;
 
 /**
  * Constructor, just requires degree name for info and comparisons.
  * @param degree String - degree name
  */
 public DegreeNode(String degree) {
     this.degree = degree;
 }
 
 /**
  * Overridden method so can store the key-value pair in hash table using
  * hashCode. This hashCode just returns the hashCode of the degree.
  * @return int - hashcode value of the degree.
  */
 @Override
 public int hashCode() {
     return this.degree.hashCode();
 }
 
 /**
  * Overridden toString method for printing purposes.
  * @return String - returns the degree name.
  */
 @Override
 public String toString() {
     return this.degree;
 }
}
