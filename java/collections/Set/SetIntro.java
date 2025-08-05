// package 7_Set;

import java.util.*;
public class SetIntro {
    public static void main(String[] args) {
        // create a set of integers
        Set<Integer> myset = new HashSet<>();
        myset.add(100);
        myset.add(200);
        myset.add(300);
        myset.add(400);
        myset.add(400);
        System.out.println("Original Set: " + myset);
        Iterator<Integer> iterate=myset.iterator();
        while (iterate.hasNext()) {
            Integer val = iterate.next();
            System.out.println(val);
        }

    }
}
