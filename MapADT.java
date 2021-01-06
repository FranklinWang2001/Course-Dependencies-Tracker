//--== CS400 File Header Information ==--
//Name: Eric Zhou
//Email: ezhou22@wisc.edu
//Team: IG
//TA: Mu Cai
//Lecturer: Florian Heimerl
//Notes to Grader: Hello there! :D

import java.util.NoSuchElementException;

public interface MapADT<KeyType, ValueType> {

 public boolean put(KeyType key, ValueType value);
 public ValueType get(KeyType key) throws NoSuchElementException;
 public int size();
 public boolean containsKey(KeyType key);
 public ValueType remove(KeyType key);
 public void clear();
 
}