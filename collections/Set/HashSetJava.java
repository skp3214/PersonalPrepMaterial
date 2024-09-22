// package 7_Set;
// Java hashset class is used to create a collection that uses a hash table for storage.
// It inherits the Abstract class and implements Set interfaace.
// Hashset stores the elements by using a mechanism called hashing.

import java.util.*;
public class HashSetJava {
    public static void main(String[] args) {
        HashSet<Integer> numbers=new HashSet<>();
        System.out.println("Before adding any element:");
        numbers.add(100);
        numbers.add(100);
        numbers.add(200);
        numbers.add(300);
        System.out.println("\nElements in set after addition of duplicates : ");
        numbers.forEach((number)->System.out.print(number + " "));

    }
}
