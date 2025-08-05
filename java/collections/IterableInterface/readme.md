## Iterable Interface
The **`Iterable`** interface is a part of the Java Collections Framework and is the root interface for all collection classes. It represents a collection of elements that can be traversed (iterated) one by one.

### 1. **`Iterable` Interface Overview:**
- It is the **root interface** for all collection types in Java.
- Any class that implements `Iterable` can be the target of the **enhanced for-loop** (also known as the for-each loop).
- Located in `java.lang` package, so it’s automatically available in every Java program.

### 2. **Key Method in `Iterable`:**
`Iterable` has only **one abstract method**:

#### `Iterator<T> iterator()`
- **Description**: This method returns an `Iterator` over a collection of type `T`.
- **Returns**: An `Iterator` that can be used to traverse the elements of the collection one by one.
- **Usage**: The `Iterator` returned by this method is used to iterate through the elements of a collection.

### 3. **Example of Using `Iterable` in a Class:**
```java
import java.util.Iterator;
import java.util.ArrayList;

public class MyCollection<T> implements Iterable<T> {
    private ArrayList<T> list = new ArrayList<>();
    
    public void add(T element) {
        list.add(element);
    }
    
    @Override
    public Iterator<T> iterator() {
        return list.iterator(); // Returns an iterator over the elements
    }

    public static void main(String[] args) {
        MyCollection<String> myList = new MyCollection<>();
        myList.add("Apple");
        myList.add("Banana");
        myList.add("Orange");

        // Using for-each loop (enhanced for-loop)
        for (String fruit : myList) {
            System.out.println(fruit);
        }

        Iterator<String> it=myList.iterator();
        while (it.hasNext()) {
            String value=it.next();
            System.out.println(value);
        }
    }
}
```

### 4. **`Iterator` Interface:**
The `iterator()` method returns an object of the `Iterator` interface, which provides three main methods:
- **`boolean hasNext()`**: Returns `true` if the iteration has more elements.
- **`T next()`**: Returns the next element in the iteration.
- **`void remove()`**: Removes the last element returned by the iterator (optional operation).

---

### Summary:
- **`Iterable<T>`** is a root interface allowing a collection to be traversed.
- It has a single method, `iterator()`, that returns an `Iterator`.
- You can use the for-each loop on any class that implements `Iterable`.

