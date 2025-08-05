import java.util.ArrayList;
import java.util.Collection;

public class CollectionExample {
    public static void main(String[] args) {
        Collection<String> fruits = new ArrayList<>();
        
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Mango");
        
        System.out.println("Size of collection: " + fruits.size());
        
        if(fruits.contains("Banana")) {
            System.out.println("Banana is in the collection");
        }

        fruits.remove("Apple");
        System.out.println("After removal: " + fruits);
        
        System.out.println("Is the collection empty? " + fruits.isEmpty());
        
        fruits.clear();
        System.out.println("Size after clearing: " + fruits.size());
    }
}