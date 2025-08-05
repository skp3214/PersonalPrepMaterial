## What is a Binary Tree?

A **binary tree** is a hierarchical data structure in which each node has at most two children, referred to as the **left child** and **right child**. It is called "binary" because each node can have no more than two children. Binary trees are used in a variety of applications such as searching, sorting, and hierarchical data organization.
### Binary Tree Code Implementation

```java
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTree {
    class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            left=null;
            right=null;
        }
    }
    Node root;
    public void insert(int[] arr){
        if(arr.length==0){
            return;
        }
        root=new Node(arr[0]);
        Queue<Node> q=new ArrayDeque<>();
        q.offer(root);
        int i=1;
        while(!q.isEmpty() && i<arr.length){
            Node node=q.poll();
            if(i<arr.length){
                node.left=new Node(arr[i++]);
                q.offer(node.left);
            }
            if(i<arr.length){
                node.right=new Node(arr[i++]);
                q.offer(node.right);
            }
        }
    }

    public void printLevelOrder(Node root) {
        if (root == null) return;
        Queue<Node> q = new ArrayDeque<>();
        q.offer(root);
        while (!q.isEmpty()) {
            Node node = q.poll();
            System.out.print(node.data + "->");
            if (node.left != null) q.add(node.left);
            if (node.right != null) q.add(node.right);
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        BinaryTree bt=new BinaryTree();
        bt.insert(arr);
        bt.printLevelOrder(bt.root);
        sc.close();
    }
}
```
### Key Terminologies:
1. **Node**: The fundamental part of a binary tree. Each node contains data, a reference to the left child, and a reference to the right child.
2. **Root**: The topmost node in the tree. It is the only node without a parent.
3. **Leaf**: A node that does not have any children (both left and right pointers are `null`).
4. **Parent**: A node that has children. It refers to nodes that have connections to other nodes.
5. **Child**: A node that is a descendant of another node. A node can be either a left child or a right child.
6. **Subtree**: A tree consisting of a node and all its descendants. Every node in a binary tree is the root of its own subtree.
7. **Height of a node**: The number of edges on the longest path from the node to a leaf. The height of a binary tree is the height of its root.
8. **Depth of a node**: The number of edges from the root to the node. The root node has a depth of 0.
9. **Level**: The set of nodes at a specific depth. The root is at level 0, its children are at level 1, and so on.

### Types of Binary Trees:
1. **Full Binary Tree**: Every node has either 0 or 2 children. No node has only one child.
2. **Perfect Binary Tree**: All internal nodes have two children, and all leaf nodes are at the same level. Every level of the tree is completely filled.
3. **Complete Binary Tree**: All levels are completely filled except possibly the last one, which is filled from left to right.
4. **Balanced Binary Tree**: A tree where the difference between the heights of the left subtree and the right subtree of any node is at most one.
5. **Skewed Binary Tree**: A binary tree where all the nodes have only one child. This can be either:
   - **Left-Skewed Tree**: Every node has only a left child.
   - **Right-Skewed Tree**: Every node has only a right child.
6. **Degenerate (Pathological) Tree**: A tree where each parent node has only one child, making it look like a linked list.

### Traversal Techniques:
Traversal refers to visiting all the nodes of a binary tree systematically. The common traversal techniques are:
1. **In-order Traversal (Left, Root, Right)**: The left subtree is visited first, followed by the root, and then the right subtree.
2. **Pre-order Traversal (Root, Left, Right)**: The root is visited first, followed by the left subtree, and then the right subtree.
3. **Post-order Traversal (Left, Right, Root)**: The left subtree is visited first, followed by the right subtree, and then the root.
4. **Level-order Traversal**: The nodes are visited level by level from top to bottom, left to right. This is also called Breadth-First Search (BFS).

### Properties of Binary Trees:
1. **Maximum Nodes**: 
   - A binary tree with height `h` has a maximum of `2^(h+1) - 1` nodes.
   - At level `l`, a binary tree can have at most `2^l` nodes.
2. **Minimum Height**: 
   - The minimum height of a binary tree with `n` nodes is `log2(n+1) - 1`.
3. **Minimum Nodes for Height h**: 
   - The minimum number of nodes required to create a binary tree of height `h` is `h + 1`.

### Binary Tree vs Binary Search Tree (BST):
- **Binary Tree**: No ordering is required among elements. The left and right child of any node can have values in any order.
- **Binary Search Tree (BST)**: A special kind of binary tree where for any node, the values in its left subtree are smaller, and the values in its right subtree are larger.

### Applications of Binary Trees:
1. **Binary Heaps**: Binary trees are used in binary heaps, a specialized tree-based data structure used in priority queues and heap sort algorithms.
2. **Expression Trees**: Used to evaluate expressions, where leaves represent operands and internal nodes represent operators.
3. **Huffman Coding Trees**: Used in data compression algorithms like Huffman encoding to assign variable-length codes to input characters.
4. **Trie (Prefix Tree)**: A special form of a binary tree used in string manipulation tasks such as searching for words in a dictionary.

### Advantages:
- **Efficient Searching**: Searching in a binary search tree can be done in `O(log n)` time (if the tree is balanced).
- **Hierarchical Structure**: Binary trees naturally represent hierarchical data, like file systems or organizational structures.

### Disadvantages:
- **Skewed Trees**: If a binary tree becomes skewed (i.e., unbalanced), it behaves like a linked list, leading to inefficient operations with time complexity `O(n)`.
- **Balancing Overhead**: To maintain a balanced binary tree, extra operations like rotations (in AVL or Red-Black Trees) are needed.

Binary trees form the foundation of many advanced data structures and algorithms, making them a core topic in computer science.