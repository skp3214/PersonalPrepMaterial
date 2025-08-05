// It is an interface that implements the mathematical set.
// This interface contains the methods inherited from the Set interface.

import java.util.*;
public class SortedSetJava {
    public static void main(String[] args) {
        SortedSet<String> set=new TreeSet<>();
        set.add("india");
        set.add("india");
        set.add("australia");
        set.add("south-africa");
        set.add("japan");
        System.out.println("Original Set: "+set);
        
        Iterator<String> it=set.iterator();
        while(it.hasNext()) {
            String element = it.next();
            System.out.println(element);
        }
    }
}
