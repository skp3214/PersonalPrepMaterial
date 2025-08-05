
// Java TreeSet class implements the Set interface that uses aa tree for storage.
// it inherits AbstractSet class and implements the NavigableSet interface.
// The objects of the TreeSet class are stored in ascending order.
import java.util.*;
public class TreeSetJava {
    public static void main(String[] args) {
        Set<String> set=new TreeSet<>();

        set.add("B");
        set.add("D");
        set.add("A");
        set.add("A");
        set.add("C");

        System.out.println(set);
    }
}
