// package 6_MapInterface;
// Hashmap: It provides the basic implementation of the Map Interface of java.
// it stores data in (key,value) pair.
import java.util.*;
public class HashMapJava {
    public static void main(String[] args) {
        // creating object of HashMap Class
        Map<Integer, String> map = new HashMap<>();
        // Adding elements to the hashmap using put() method
        System.out.println("Before adding element : " + map);
        map.put(101, "A");
        map.put(102, "B");
        map.put(103, "C");
        map.put(104, "D");
        System.out.println("\nAfter adding element : \t" + map);
        // Getting value from the hashmap using get() method
        System.out.println("\nValue for key 101 : " + map.get(101));

        System.out.println(map.keySet());
        System.out.println(map.values());

        for (Map.Entry<Integer,String> m:map.entrySet()) {
            System.out.println("Key : "+m.getKey()+"\t Value : "+m.getValue());
        }
    }
}
