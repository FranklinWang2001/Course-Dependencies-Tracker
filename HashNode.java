//--== CS400 File Header Information ==--
//Name: Eric Zhou
//Email: ezhou22@wisc.edu
//Team: IG
//TA: Mu Cai
//Lecturer: Florian Heimerl
//Notes to Grader: Hello there! :D
/**
* HashNode class, made for the HashTable. Stores the key and value. Hash Node
* is always placed in a linked list of Hash Nodes. Can access key and value
* by using accessor methods.
* @author Eric Zhou
*
* @param <KeyType> - generic type. Specifies the type of the key.
* @param <ValueType> - generic type. Specifies the type of the value.
*/
public class HashNode<KeyType, ValueType> {
 private KeyType key;
 private ValueType value;
 
 /**
  * Constructor. HashNode requires input of a key and value.
  * @param key KeyType - key of the key-value pair.
  * @param value ValueType - value of the key-value pair.
  */
 public HashNode(KeyType key, ValueType value) {
     this.key = key;
     this.value = value;
 }
 
 /**
  * Accessor method. Returns the key of this hash node when requested.
  * @return KeyType key - returns the key of the key-value type.
  */
 public KeyType getKey() {
     return this.key;
 }
 
 /**
  * Accessor method. Returns the value of this hash node when requested.
  * @return ValueType value - returns the value of the key-value pair.
  */
 public ValueType getValue() {
     return this.value;
 }
 
 /**
  * Equality method. Compares this current Hashnode with another hashnode.
  * If the key and value are equal, then this method returns true. Else, it
  * returns false.
  * @param node HashNode - the hash node to compare "this" hash node to.
  * @return boolean - true if they are equal to each other, false if they are
  * not.
  */
 public boolean equals(HashNode<KeyType, ValueType> node) {
     if (node.getKey().equals(this.key) && node.getValue().equals(this.value)) {
         return true;
     }
     return false;
 }
}
