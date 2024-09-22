import java.util.Iterator;
import java.util.ArrayList;

public class MyCollection<T> implements Iterable<T> {
    private ArrayList<T> list = new ArrayList<>();
    
    public void add(T element) {
        list.add(element);
    }
    
    @Override
    public Iterator<T> iterator() {
        return list.iterator(); 
    }

    public static void main(String[] args) {
        MyCollection<String> myList = new MyCollection<>();
        myList.add("Apple");
        myList.add("Banana");
        myList.add("Orange");
        Iterator<String> it=myList.iterator();
        while (it.hasNext()) {
            String value=it.next();
            System.out.println(value);
        }

        for (String fruit : myList) {
            System.out.println(fruit);
        }
    }
}