//--== CS400 File Header Information ==--
//Name: Eric Zhou
//Email: ezhou22@wisc.edu
//Team: IG
//TA: Mu Cai
//Lecturer: Florian Heimerl
//Notes to Grader: Hello there! :)

import java.util.NoSuchElementException;
import java.util.LinkedList;

/**
* HashTableMap class. Creates a hash table, and implemenets the MapADT 
* interface. Generic typing KeyType and ValueType.
* @author Eric Zhou
*
* @param <KeyType> KeyType - generic type of the key.
* @param <ValueType> ValueType - generic type of the value.
*/
public class HashTableMap<KeyType, ValueType> implements MapADT<KeyType, ValueType>{
 // fields
 private LinkedList<HashNode<KeyType, ValueType>>[] hashTable;
 private double loadCapacity;
 private int size;
 
 /**
  * Default constructor. Sets initial size of the hash table array to be 10.
  */
 public HashTableMap() {
     this.hashTable = 
         (LinkedList<HashNode<KeyType, ValueType>>[]) new LinkedList[10];
     this.size = 0;
     this.loadCapacity = 0;
 }
 
 /**
  * Constructor where the user defines the size of the hash table array.
  * @param capacity int - the size of the array.
  */
 public HashTableMap(int capacity) {
     // Checks if capacity is valid. 
     if (capacity <= 0) {
         capacity = 10;
     }
     this.hashTable = 
         (LinkedList<HashNode<KeyType, ValueType>>[]) new LinkedList[capacity];
     this.size = 0;
     this.loadCapacity = 0;
 }
 
 /**
  * Private helper method that stores calculates the index. If the index
  * is negative, we get the absolute value of that index.
  * @param key - key that are calculating the hash index of
  * @return index - integer value of the index.
  */
 private int calcIndex(KeyType key) {
     int index = key.hashCode() % this.hashTable.length;
     index = Math.abs(index);
     return index;
 }
 
 /**
  * Doubles the hash table array and then rehashes all of the elements.
  */
 private void resize() {
     // Make new hash table, save old hash table, set the current hashtable
     // to be the newTable of the new length.
     LinkedList<HashNode<KeyType, ValueType>>[] newTable =
         (LinkedList<HashNode<KeyType, ValueType>>[]) 
             new LinkedList[2 * this.hashTable.length];
     LinkedList<HashNode<KeyType, ValueType>>[] oldTable = this.hashTable;
     this.hashTable = newTable;
     
     for (int i = 0; i < oldTable.length; ++i) {
         if (oldTable[i] != null) {
             LinkedList<HashNode<KeyType,ValueType>> list = oldTable[i];
             for (int j = 0; j < list.size(); ++j) {
                 // Be careful of using indices: from here on out, it'll be j.
                 KeyType key = list.get(j).getKey();
                 ValueType value = list.get(j).getValue();
                 this.put(key, value);
             }
         }
     }
     // size wil stay the same, but we will have to change load capacity.
     this.loadCapacity = this.size / (double)this.hashTable.length;
 }

 @Override
 /**
  * put method, essentially adding the specific key and value to the
  * hash table if the key-value pair does not already exist.
  * @param key KeyType - the key to be stored
  * @param value ValueType - the value to be stored.
  * @return boolean - true if successfully added key-value pair to the
  * hash table. False if the key already exists in hash table.
  */
 public boolean put(KeyType key, ValueType value) {
     // Create initial node to store.
     HashNode<KeyType, ValueType> node = new HashNode<>(key, value);
     // Create index var for simplicity in future
     int index = calcIndex(key);
     // Obtain hashcode at that index by using hashcode and modulo.
     LinkedList<HashNode<KeyType,ValueType>> list = 
         this.hashTable[index];
     
     // If list is not null, we have encountered a collision.
     if (list != null) {
         if (containsKey(key)) {
             return false;
         }
         
         // This will only run if there node does not exist. Therefore, we 
         // just add the node to the list and return true.
         list.add(node);
     } else {
         this.hashTable[index] = 
             new LinkedList<HashNode<KeyType, ValueType>>();
         this.hashTable[index].add(node);
     }
     
     // update size, and then load capacity
     this.size++;
     this.loadCapacity = this.size /  (double)this.hashTable.length;
     if (this.loadCapacity >= .80) {
         this.resize();
     }
     return true;
 }

 @Override
 /**
  * Returns the specified value upon user search of a specific key.
  * @param KeyType key - key user wants to search for.
  * @return ValueType - returns the value of the key.
  * @throws NoSuchElementException - thrown if key does not exist.
  */
 public ValueType get(KeyType key) throws NoSuchElementException {
     if (containsKey(key)) {
         int index = calcIndex(key);
         LinkedList<HashNode<KeyType,ValueType>> list= this.hashTable[index];
         // Search for the key.
         for (int i = 0; i < list.size(); ++i) {
             if (list.get(i).getKey().equals(key)) {
                 return list.get(i).getValue();
             }
         }
     }
     throw new NoSuchElementException("Error! Key does not exist in table.");
 }

 @Override
 /**
  * returns the size of the hash table
  * @return int size - the size of hash table.
  */
 public int size() {
     return this.size;
 }

 @Override
 /**
  * Searches through current hash table and returns if the key already exists
  * If the key exists --> true
  * If the key does not exist --> false
  * @param KeyType key - the key to search for
  * @return boolean - true if key exists, false if not.
  */
 public boolean containsKey(KeyType key) {
     int index = calcIndex(key);
     // First check if list at that index is null.
     if (this.hashTable[index] != null) {
         LinkedList<HashNode<KeyType,ValueType>> list= this.hashTable[index];
         // Search for the key.
         for (int i = 0; i < list.size(); ++i) {
             if (list.get(i).getKey().equals(key)) {
                 return true;
             }
         }
         return false;
     } else {
         return false;
     }
 }

 @Override
 /**
  * Remove method of the hash table. Removes the specific key if it exists
  * and returns the value of that key just removed
  * If the key does not exist in the hash table, we return null.
  * @param KeyType key - key to search for
  * @return ValueType val - returns the val of the deleted key. Null if
  * does not exist.
  */
 public ValueType remove(KeyType key) {
     if (containsKey(key)) {
         int index = calcIndex(key);
         LinkedList<HashNode<KeyType,ValueType>> list= this.hashTable[index];
         for (int i = 0; i < list.size(); ++i) {
             if (list.get(i).getKey().equals(key)) {
                 ValueType val = list.get(i).getValue();
                 list.remove(i);
                 // Have to update the size and load capacity of the table
                 // after deleting.
                 this.size--;
                 this.loadCapacity = this.size / (double) this.hashTable.length;
                 return val;
             }
         }
     }
     return null;
 }

 @Override
 /**
  * Clears the hash table. Sets size to 0, the load capacity to 0, and
  * initializes a new hash table of the current size.
  */
 public void clear() {
     this.size = 0;
     this.loadCapacity = 0;
     this.hashTable = this.hashTable = 
         (LinkedList<HashNode<KeyType, ValueType>>[])
          new LinkedList[this.hashTable.length];
     
 }
 
 @Override
 /**
  * toString implementation for visualization of the table
  * @return String - the representation of the nodes stored.
  */
 public String toString() {
     String s = "Available Degrees:\n";
     for (LinkedList<HashNode<KeyType, ValueType>> list: this.hashTable) {
         if (list == null) {
             continue;
         }
         for (HashNode<KeyType,ValueType> degree: list) {
             if (degree == null) {
                 continue;
             }
             s+="\t" + degree.getValue().toString() + "\n";
         }
     }
     return s;
 }
 
 /**
  * Returns the capacity of the hash table.
  * @return int - capacity of the array (length)
  */
 public int getCapacity() {
     return this.hashTable.length;
 }
}
