// The map entries are arranged inn ascending order by the keys.

import java.util.SortedMap;
import java.util.TreeMap;

public class SortedMapInterface {
    public static void main(String[] args) {
        SortedMap<String,Integer>numbers=new TreeMap<>();
        numbers.put("Charlie",75);
        numbers.put("Alice",34);
        numbers.put("Bob",12);
        System.out.println(numbers.firstKey());
        System.out.println(numbers.lastKey());
        // System.out.println(numbers.headMap("Bob"));
        for (String name:numbers.keySet()) {
            System.out.println(name + " "+numbers.get(name));
        }

    }
}
