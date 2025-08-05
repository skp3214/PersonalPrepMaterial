### What is a Binary Search Tree (BST)?

A **Binary Search Tree (BST)** is a type of binary tree where each node adheres to the following properties:
1. **Left Subtree**: All nodes in the left subtree have values less than the root node.
2. **Right Subtree**: All nodes in the right subtree have values greater than the root node.
3. **Each Subtree is a BST**: Both the left and right subtrees must also be binary search trees, meaning the above properties hold recursively for each subtree.

This ordering property of BSTs makes them highly efficient for searching, insertion, and deletion operations compared to unsorted trees or lists.
## BST Code Implementation
```java
public class BinarySearchTree {
    class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    Node root;

    public Node createBST(Node root, int value) {
        if (root == null) {
            Node temp = new Node(value);
            return temp;
        }
        if (value < root.data) {
            root.left = createBST(root.left, value);
        } else if (value > root.data) {
            root.right = createBST(root.right, value);
        }
        return root;
    }

    public void printInOrder(Node root){
        if(root==null){
            return;
        }
        printInOrder(root.left);
        printInOrder(root.right);
        System.out.print(root.data+"->");
    }

    public Node deleteNode(Node root,int value){
        if(root==null){
            return null;
        }
        if(root.data>value){
            root.left=deleteNode(root.left, value);
            return root;
        }
        else if(root.data<value){
            root.right=deleteNode(root.right, value);
            return root;
        }
        else{
            // leaf node
            if(root.left==null && root.right==null){
                return null;
            }
            // single child
            if(root.left==null){
                Node temp=root.right;
                root=null;
                return temp;
            }
            else if(root.right==null){
                Node temp=root.left;
                root=null;
                return temp;
            }
            // both child
            else{
                Node child=root.left;
                Node parent=root;
                while(child.right!=null){
                    parent=child;
                    child=child.right;
                }
                if(root!=parent){
                    parent.right=child.left;
                    // now child is the rightmost node and it will be the new root
                    child.left=root.left;
                    child.right=root.right;

                    root=null;
                    return child;
                }
                else{
                    child.right=root.right;
                    root=null;
                    return child;
                }
            } 
        }
    }

    public static void main(String[] args) {
        int[] arr = { 7, 2, 3, 6, 8, 9, 0, 4, 1, 5 };
        BinarySearchTree tree=new BinarySearchTree();
        for (int i = 0; i < arr.length; i++) {
            tree.root=tree.createBST(tree.root, arr[i]);
        }
        tree.printInOrder(tree.root);
        System.out.println();
        tree.root=tree.deleteNode(tree.root, 7);
        tree.printInOrder(tree.root);
    }
}
```
### Key Terminologies in BST:
1. **Root**: The topmost node of the tree.
2. **Leaf Node**: A node with no children.
3. **Parent Node**: A node that has one or more children.
4. **Child Node**: A node that is a descendant of another node.
5. **Subtree**: A tree consisting of a node and all its descendants.

### Properties of a Binary Search Tree:
1. **Binary Tree Structure**: A BST is a type of binary tree, meaning each node can have at most two children.
2. **Order Preservation**: For any node, the left subtree has nodes with values smaller than the node’s value, and the right subtree has nodes with values larger than the node’s value.
3. **In-order Traversal**: Performing an in-order traversal of a BST (visiting nodes in the left subtree, then the root, then the right subtree) will give the nodes in sorted order (ascending).

### Operations on a BST:

#### 1. **Searching**
- Searching for an element in a BST takes advantage of the tree’s ordering property. At each node, you can compare the target value with the current node:
  - If the target is smaller, search in the left subtree.
  - If the target is larger, search in the right subtree.
  - If the target matches the current node, the search is successful.
- In an ideal (balanced) BST, searching has a time complexity of `O(log n)`, where `n` is the number of nodes. However, in the worst case (unbalanced BST), the time complexity is `O(n)`.

#### 2. **Insertion**
- Inserting an element in a BST also takes advantage of the ordering property:
  - Starting from the root, compare the new value with the current node.
  - If the new value is smaller, move to the left subtree; if larger, move to the right subtree.
  - Continue this process until you find an appropriate empty spot (either left or right of a leaf node) and insert the new value there.
- Like searching, the insertion operation has a time complexity of `O(log n)` for a balanced BST and `O(n)` for an unbalanced BST.

#### 3. **Deletion**
- Deleting a node in a BST is more complex because the tree structure needs to be preserved. There are three cases:
  - **Node with no children (leaf node)**: Simply remove the node.
  - **Node with one child**: Replace the node with its child.
  - **Node with two children**: Replace the node with either:
    - **In-order successor** (the smallest node in the right subtree).
    - **In-order predecessor** (the largest node in the left subtree).
- The time complexity for deletion is similar to insertion and searching: `O(log n)` for a balanced BST and `O(n)` for an unbalanced BST.

### Types of Binary Search Trees:

1. **Balanced BST**: In a balanced BST, the height difference between the left and right subtrees of every node is at most one. This ensures that operations such as search, insertion, and deletion remain efficient (`O(log n)`).
   - **Examples**:
     - **AVL Tree**: A self-balancing BST where the height difference between left and right subtrees of any node is no more than 1. If this balance is disturbed by an insertion or deletion, rotations are performed to restore balance.
     - **Red-Black Tree**: Another self-balancing BST that maintains balance using color properties on nodes. It ensures that the path from the root to the furthest leaf is no more than twice as long as the path from the root to the nearest leaf.
   
2. **Unbalanced BST**: If no balance mechanism is applied, the BST can become skewed (like a linked list), which causes operations to degrade to linear time `O(n)`. This happens if elements are inserted in an already sorted order, for example, inserting 1, 2, 3, 4 in a row.

### Traversal Techniques for BST:

1. **In-order Traversal (Left, Root, Right)**:
   - When performed on a BST, it visits nodes in non-decreasing order (sorted order). This is one of the most important properties of BSTs and is used in many applications.
   
2. **Pre-order Traversal (Root, Left, Right)**:
   - Visits the root node first, then recursively visits the left subtree, followed by the right subtree. This traversal can be used to recreate the tree structure.

3. **Post-order Traversal (Left, Right, Root)**:
   - Visits the left subtree first, then the right subtree, and finally the root. This traversal is useful for deleting or freeing the entire tree in some languages.

4. **Level-order Traversal (Breadth-First)**:
   - Visits nodes level by level from top to bottom. It does not rely on the properties of the BST but is commonly used for tree traversal.

### Advantages of Binary Search Trees:
1. **Efficient Searching**: Due to its ordered structure, searching for an element in a balanced BST takes `O(log n)` time.
2. **Sorted Data**: A BST allows you to easily retrieve elements in sorted order through in-order traversal.
3. **Dynamic Size**: Unlike arrays or lists, BSTs do not require resizing and can grow or shrink dynamically with insertions and deletions.
4. **Efficient Operations**: Insertion, deletion, and search operations all have a time complexity of `O(log n)` in a balanced BST, making it efficient for dynamic datasets.

### Disadvantages of Binary Search Trees:
1. **Unbalanced Trees**: If the tree becomes unbalanced (i.e., all elements are inserted in sorted order), the time complexity of search, insert, and delete operations degrades to `O(n)`, making it as inefficient as a linked list.
2. **Complexity in Balancing**: Maintaining a balanced BST requires additional operations (like rotations in AVL or color adjustments in Red-Black Trees), adding complexity to the implementation.

### Applications of Binary Search Trees:
1. **Searching and Sorting**: Due to the natural ordering property, BSTs are widely used in search algorithms and sorting techniques.
2. **Databases**: Many database indexing mechanisms, like B-trees (a generalization of BST), use tree structures for efficient data retrieval.
3. **Symbol Tables and Dictionaries**: BSTs can store key-value pairs efficiently, supporting fast search, insert, and delete operations.
4. **Auto-Complete and Spell Check**: Tries (prefix trees) are a form of BST used in these applications, where each node stores part of a word.

### Balanced BST Variants:
1. **AVL Tree**:
   - Guarantees balance by maintaining a height difference of at most 1 between the subtrees of any node.
   - Rotations (single and double) are performed to maintain balance after insertions and deletions.
   
2. **Red-Black Tree**:
   - Ensures balance through a coloring system, where nodes are colored either red or black.
   - The tree ensures that no path from the root to a leaf is more than twice as long as any other path.
   - Used in many standard libraries (e.g., C++ STL `map` and `set`).

### Real-World Usage:
- **File Systems**: BSTs are often used in hierarchical file systems, where folders and files are organized in a tree structure.
- **Routing Tables**: In networking, routing tables often use tree structures to quickly look up paths.
- **Data Compression**: Huffman coding trees, used in data compression algorithms, often rely on properties of binary trees.

### Conclusion:
The binary search tree is a fundamental data structure with applications in searching, sorting, and hierarchical data organization. The ordering properties of BSTs make them efficient for dynamic data, but maintaining balance is crucial to ensuring that operations remain efficient. Balanced BST variants like AVL and Red-Black Trees are essential to keeping time complexities in check for real-world applications.