import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class ListPerformanceComparison {

    public static void main(String[] args) {
        // Number of elements to test
        int numElements = 100000;
        
        // Comparing add operation
        compareAddPerformance(new ArrayList<>(), "ArrayList", numElements);
        compareAddPerformance(new LinkedList<>(), "LinkedList", numElements);
        compareAddPerformance(new Vector<>(), "Vector", numElements);

        // Comparing get operation
        compareGetPerformance(new ArrayList<>(), "ArrayList", numElements);
        compareGetPerformance(new LinkedList<>(), "LinkedList", numElements);
        compareGetPerformance(new Vector<>(), "Vector", numElements);

        // Comparing remove operation
        compareRemovePerformance(new ArrayList<>(), "ArrayList", numElements);
        compareRemovePerformance(new LinkedList<>(), "LinkedList", numElements);
        compareRemovePerformance(new Vector<>(), "Vector", numElements);
    }

    // Method to compare add operation
    private static void compareAddPerformance(List<Integer> list, String listType, int numElements) {
        long startTime = System.currentTimeMillis();
        
        for (int i = 0; i < numElements; i++) {
            list.add(i);
        }

        long endTime = System.currentTimeMillis();
        System.out.println(listType + " add: " + (endTime - startTime) + " ms");
    }

    // Method to compare get operation
    private static void compareGetPerformance(List<Integer> list, String listType, int numElements) {
        // Pre-fill the list
        for (int i = 0; i < numElements; i++) {
            list.add(i);
        }

        long startTime = System.currentTimeMillis();
        
        for (int i = 0; i < numElements; i++) {
            list.get(i);
        }

        long endTime = System.currentTimeMillis();
        System.out.println(listType + " get: " + (endTime - startTime) + " ms");
    }

    // Method to compare remove operation
    private static void compareRemovePerformance(List<Integer> list, String listType, int numElements) {
        // Pre-fill the list
        for (int i = 0; i < numElements; i++) {
            list.add(i);
        }

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < numElements; i++) {
            list.remove(0); // Removing the first element repeatedly
        }

        long endTime = System.currentTimeMillis();
        System.out.println(listType + " remove: " + (endTime - startTime) + " ms");
    }
}
