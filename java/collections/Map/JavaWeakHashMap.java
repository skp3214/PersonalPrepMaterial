// package 6_MapInterface;
import java.util.*;
public class JavaWeakHashMap {
    public static void main(String[] args) {
        WeakHashMap<Integer, String> map = new WeakHashMap<>();
        map.put(1, "Sachin");

        System.out.println("After adding element: "+map);
        String val=new String("Sameer");
        Integer k=4;
        map.put(k,val);
        System.out.println(map);
        val=null;
        System.gc();
        System.out.println(map);


    }
}
