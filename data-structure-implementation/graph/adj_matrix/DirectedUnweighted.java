import java.util.Scanner;

public class DirectedUnweighted {
    public static void main(String[] args) {
        int vertices, edges;
        Scanner scanner = new Scanner(System.in);
        vertices = scanner.nextInt();
        edges = scanner.nextInt();

        int[][] adjMatrix = new int[vertices][vertices];
        for (int i = 0; i < edges; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            adjMatrix[u][v] = 1;
        }
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
        scanner.close();
    }
}
