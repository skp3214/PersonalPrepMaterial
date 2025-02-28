import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DirectedUnweighted {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int vertices=sc.nextInt();
        int edges=sc.nextInt();
        List<List<Integer>>adjList=new ArrayList<>();
        for(int i=0;i<vertices;i++){
            adjList.add(new ArrayList<>());
        }
        for(int i=0;i<edges;i++){
            int u=sc.nextInt();
            int v=sc.nextInt();
            adjList.get(u).add(v);
        }
        for(int i=0;i<vertices;i++){
            for(int j=0;j<adjList.get(i).size();j++){
                System.out.print(adjList.get(i).get(j)+" ");
            }
            System.out.println();
        }
        sc.close();
    }
}
