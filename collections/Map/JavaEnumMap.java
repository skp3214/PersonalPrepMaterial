// Java EnumMap Class is the specialized Map implementation for enum keys.
// it inherits Enum and AbstractMapClass
// It is fuaster than HashMap
// it doesnot allow null value and throw null pointer exceptions.

import java.util.EnumMap;

public class JavaEnumMap {
    enum Size{
        SMALL, MEDIUM, LARGE,EXTRALARGE;
    }
    public static void main(String[] args) {
        EnumMap<Size,Integer> sizes=new EnumMap<>(Size.class);
        sizes.put(Size.SMALL, 20);
        sizes.put(Size.MEDIUM, 40);
        sizes.put(Size.LARGE, 60);
        sizes.put(Size.EXTRALARGE, 80);
        System.out.println(sizes);
        System.out.println("Value of Small : "+sizes.get(Size.SMALL));

    }
}
