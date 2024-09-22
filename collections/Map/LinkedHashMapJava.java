// package 6_MapInterface;
// Linked HashMap: It is like HashMap with the additional feature of maintaining an order of elements inserted into it.

import java.util.*;

public class LinkedHashMapJava {
    public static void main(String[] args) {
        Map<Integer, String> m = new LinkedHashMap<>();
        m.put(1, "A");
        m.put(2, "B");
        m.put(3, "C");
        m.put(4, "D");

        System.out.println("Before Accessing Elements: " + m);
        String s = m.get(3);
        System.out.println("After accessing element with key 3 :" + s + " and map is " + m);

        Map<Integer, String> newNum = new LinkedHashMap<>(m);
        System.out.println("\nNew Map after copying using constructor : " + newNum);

    }
}
