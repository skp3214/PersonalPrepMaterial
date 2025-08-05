### **Collection Interface in Java**

The **Collection** interface is the root interface of the **Java Collections Framework**. It defines common methods for all collection types (such as `List`, `Set`, and `Queue`). It provides a way to work with groups of objects, called collections, and defines methods for basic collection operations like adding, removing, and iterating elements.

### **Key Features**:
- **Part of java.util package**.
- Defines the most basic methods for handling groups of objects (like `add`, `remove`, `size`).

### **Important Methods**:
1. **add(E element)**: Adds an element to the collection.
2. **remove(Object element)**: Removes a specified element from the collection.
3. **size()**: Returns the number of elements in the collection.
4. **clear()**: Removes all elements from the collection.
5. **isEmpty()**: Checks if the collection is empty.
6. **contains(Object element)**: Checks if the collection contains a specific element.
7. **iterator()**: Returns an iterator to traverse through the collection.

### **Code Example**:

```java
import java.util.ArrayList;
import java.util.Collection;

public class CollectionExample {
    public static void main(String[] args) {
        // Create a Collection (ArrayList implements Collection)
        Collection<String> fruits = new ArrayList<>();
        
        // Adding elements
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Mango");
        
        // Display the size of the collection
        System.out.println("Size of collection: " + fruits.size());
        
        // Check if collection contains a specific element
        if(fruits.contains("Banana")) {
            System.out.println("Banana is in the collection");
        }

        // Remove an element
        fruits.remove("Apple");
        System.out.println("After removal: " + fruits);
        
        // Check if collection is empty
        System.out.println("Is the collection empty? " + fruits.isEmpty());
        
        // Clear the collection
        fruits.clear();
        System.out.println("Size after clearing: " + fruits.size());
    }
}
```
