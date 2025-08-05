import java.util.NavigableMap;
import java.util.TreeMap;

public class JavaNavigableMap {
    public static void main(String[] args) {
        NavigableMap<String,Integer>numbers=new TreeMap<>();
        numbers.put("a",1);
        numbers.put("b",2);
        numbers.put("c",3);
        System.out.println("Initial Map: "+numbers.descendingMap());
        //lowerEntry() - Returns a key-value mapping with the least value in ascending order. If no elements are present, returns
        System.out.println(numbers.firstEntry());
        System.out.println(numbers.pollFirstEntry());

    }
}
