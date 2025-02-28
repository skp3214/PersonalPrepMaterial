import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DirectedWeighted {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int vertices=sc.nextInt();
        int edges=sc.nextInt();
        List<List<int[]>>adjList=new ArrayList<>();
        for(int i=0;i<vertices;i++){
            adjList.add(new ArrayList<>());
        }
        for(int i=0;i<edges;i++){
            int u=sc.nextInt();
            int v=sc.nextInt();
            int w=sc.nextInt();
            adjList.get(u).add(new int[]{v,w});
        }
        for(int i=0;i<vertices;i++){
            for(int j=0;j<adjList.get(i).size();j++){
                System.out.print(adjList.get(i).get(j)[0]+"("+adjList.get(i).get(j)[1]+") ");
            }
            System.out.println();
        }
        sc.close();
    }
}
