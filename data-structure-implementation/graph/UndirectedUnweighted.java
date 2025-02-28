import java.util.Scanner;

public class UndirectedUnweighted {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int vertex = scanner.nextInt();
        int edges = scanner.nextInt();
        
        int[][] adjMatrix=new int[vertex][vertex];
        for(int i=0;i<edges;i++){
            int u=scanner.nextInt();
            int v=scanner.nextInt();
            adjMatrix[u][v]=1;
            adjMatrix[v][u]=1;
        }
        for(int i=0;i<vertex;i++){
            for(int j=0;j<vertex;j++){
                System.out.print(adjMatrix[i][j]+" ");
            }
            System.out.println();
        }
        scanner.close();
    }
}