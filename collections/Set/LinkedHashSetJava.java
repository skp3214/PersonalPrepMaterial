// package 7_Set;
// The LinkedHashSet is an ordered version of HashSet that maintains a doubly-linked List across all elements.
// When the iteration order is needed to be maintained this class is used.
// When iterating through a HashSet the order is unpredictable.
import java.util.*;
public class LinkedHashSetJava {
    public static void main(String[] args) {
        ArrayList<Integer> evenNum=new ArrayList<>();
        evenNum.add(2);
        evenNum.add(4);
        evenNum.add(6);
        System.out.println("ArrayList:"+evenNum);

        LinkedHashSet<Integer> number=new LinkedHashSet<>(evenNum);
        System.out.print("LinkedHashSet:");
        Iterator<Integer> itr1 = number.iterator();
        while (itr1.hasNext()) {
            Integer n = itr1.next();
            System.out.println(n);
        }
    }
}
