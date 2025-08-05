// package 7_Set;
// Enum represents a group of named constants in a programming language.
// It extends abstractClass class and implement Set Interface in Java.
// It's a high-performance set implelementation, much faster than hashset
import java.util.*;

public class EnumSetJava {
    enum Size{
        SMALL, MEDIUM, LARGE
    }
    public static void main(String[] args) {
        EnumSet<Size> sizes=EnumSet.allOf(Size.class);
        System.out.println("Initially: "+sizes);
        EnumSet<Size> size2=EnumSet.noneOf(Size.class);
        System.out.println("Initially: "+size2);
        EnumSet<Size> size3=EnumSet.range(Size.MEDIUM,Size.LARGE);
        System.out.println("Initially: "+size3);
        EnumSet<Size> size4=EnumSet.of(Size.MEDIUM,Size.LARGE);
        System.out.println("Initially: "+size4);

        Iterator<Size> iterator=sizes.iterator();
        while (iterator.hasNext()){
            Size s = iterator.next();
            System.out.println(s);
        }
        
    }
}
