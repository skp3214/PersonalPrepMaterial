// The NavigableSet Interface inherits from the SortedSet interface.

// It may be accessed and traversed in either ascending or descending order.

import java.util.*;
public class JavaNavigableHashSet {
    public static void main(String[] args) {
        NavigableSet<Integer> set=new TreeSet<>();
        set.add(10);
        set.add(20);
        set.add(30);
        set.add(40);

        NavigableSet<Integer> reversed=set.descendingSet();
        System.out.println("Original Set:");
        System.out.println(set);
        System.out.println("\nReversed Set:");
        System.out.println(reversed);
    }
}
