# Graph Implementation in JAVA

## Introduction to Graphs

A graph is a data structure that consists of a set of nodes (or vertices) and a set of edges that connect pairs of nodes. Graphs can be used to represent various real-world structures such as networks, social connections, and more. There are different types of graphs based on the nature of the edges and the directionality of the connections.

### Types of Graphs

1. **Undirected Graph**: In this type of graph, the edges do not have a direction. The connection between two nodes is bidirectional.
2. **Directed Graph (Digraph)**: In this type of graph, the edges have a direction, indicating a one-way relationship between nodes.
3. **Weighted Graph**: Each edge in the graph has a weight or cost associated with it.
4. **Unweighted Graph**: The edges do not have any weight or cost associated with them.

### Graph Representation

Graphs can be represented in two main ways:

1. **Adjacency Matrix**: A 2D array where the cell at row `i` and column `j` indicates the presence (and possibly the weight) of an edge between vertex `i` and vertex `j`.
2. **Adjacency List**: An array of lists. The index represents a vertex, and the list at that index contains the vertices that are adjacent to it.

## Using Adjacency Matrix

- #### Undirected Unweighted Graph

```java
import java.util.Scanner;

public class UndirectedUnweighted {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int vertex = scanner.nextInt();
        int edges = scanner.nextInt();
        
        int[][] adjMatrix = new int[vertex][vertex];
        for (int i = 0; i < edges; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            adjMatrix[u][v] = 1;
            adjMatrix[v][u] = 1;
        }
        for (int i = 0; i < vertex; i++) {
            for (int j = 0; j < vertex; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
        scanner.close();
    }
}
```

- #### Undirected Weighted Graph

```java
import java.util.Scanner;

public class UndirectedWeighted {
    public static void main(String[] args) {
        int vertices, edges;
        Scanner scanner = new Scanner(System.in);
        vertices = scanner.nextInt();
        edges = scanner.nextInt();

        int[][] adjMatrix = new int[vertices][vertices];
        for (int i = 0; i < edges; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            adjMatrix[u][v] = w;
            adjMatrix[v][u] = w;
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
```

- #### Directed Unweighted Graph

```java
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
```

- #### Directed Weighted Graph

```java
import java.util.Scanner;

public class DirectedWeighted {
    public static void main(String[] args) {
        int vertices, edges;
        Scanner scanner = new Scanner(System.in);
        vertices = scanner.nextInt();
        edges = scanner.nextInt();

        int[][] adjMatrix = new int[vertices][vertices];
        for (int i = 0; i < edges; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            adjMatrix[u][v] = w;
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
```

## Using Adjacency List

- #### Undirected Unweighted Graph

```java
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UndirectedUnweighted {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int vertex = sc.nextInt();
        int edges = sc.nextInt();
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < vertex; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < edges; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        for (int i = 0; i < vertex; i++) {
            for (int j = 0; j < adjList.get(i).size(); j++) {
                System.out.print(adjList.get(i).get(j) + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}
```

- #### Undirected Weighted Graph

```java
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UndirectedWeighted {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int vertices = sc.nextInt();
        int edges = sc.nextInt();
        List<List<int[]>> adjList = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < edges; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            adjList.get(u).add(new int[]{v, w});
            adjList.get(v).add(new int[]{u, w});
        }
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < adjList.get(i).size(); j++) {
                System.out.print(adjList.get(i).get(j)[0] + "(" + adjList.get(i).get(j)[1] + ") ");
            }
            System.out.println();
        }
        sc.close();
    }
}
```

- #### Directed Unweighted Graph

```java
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DirectedUnweighted {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int vertices = sc.nextInt();
        int edges = sc.nextInt();
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < edges; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adjList.get(u).add(v);
        }
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < adjList.get(i).size(); j++) {
                System.out.print(adjList.get(i).get(j) + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}
```

- #### Directed Weighted Graph

```java
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DirectedWeighted {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int vertices = sc.nextInt();
        int edges = sc.nextInt();
        List<List<int[]>> adjList = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < edges; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            adjList.get(u).add(new int[]{v, w});
        }
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < adjList.get(i).size(); j++) {
                System.out.print(adjList.get(i).get(j)[0] + "(" + adjList.get(i).get(j)[1] + ") ");
            }
            System.out.println();
        }
        sc.close();
    }
}
```
