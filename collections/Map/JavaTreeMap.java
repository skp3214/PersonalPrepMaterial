import java.util.TreeMap;

public class JavaTreeMap {
    public static void main(String[] args) {
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        // Add elements to the TreeMap
        treeMap.put(45, "Forty Five");
        treeMap.put(12, "Twelve");
        treeMap.put(67, "Sixty Seven");
        System.out.println("Original TreeMap: "+treeMap);
        Integer smallestKey = treeMap.firstKey();
        System.out.println(smallestKey);
        
    }
}
