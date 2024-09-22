# AVL Tree Overview

## AVL Tree Code Implementation
```java
public class AVLTree {
    class Node {
        int data;
        int height;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.height = 1; // Height of a new node is 1
        }
    }

    Node root;

    // Function to insert a value and return the new root of the subtree
    public Node insert(Node root, int value) {
        if (root == null) {
            return new Node(value);
        }

        // Recursively insert the value in the correct subtree
        if (value < root.data) {
            root.left = insert(root.left, value);
        } else if (value > root.data) {
            root.right = insert(root.right, value);
        } else {
            return root; // Duplicate values are not allowed in the AVL tree
        }

        // Update the height of the current node
        root.height = 1 + Math.max(getHeight(root.left), getHeight(root.right));

        // Get the balance factor to check if this node became unbalanced
        int balance = getBalance(root);

        // Perform rotations to maintain AVL property
        // Case 1: Left Left (LL)
        if (balance > 1 && value < root.left.data) {
            return rightRotate(root);
        }

        // Case 2: Right Right (RR)
        if (balance < -1 && value > root.right.data) {
            return leftRotate(root);
        }

        // Case 3: Left Right (LR)
        if (balance > 1 && value > root.left.data) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        // Case 4: Right Left (RL)
        if (balance < -1 && value < root.right.data) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        // Return the (unchanged) node pointer
        return root;
    }

    public Node deleteNode(Node root, int value) {
        if (root == null) {
            return null;
        }

        if (value < root.data) {
            root.left = deleteNode(root.left, value);
        }
        else if (value > root.data) {
            root.right = deleteNode(root.right, value);
        }
        else {
            // leaf node
            if (root.left == null && root.right == null) {
                root = null;
                return root;
            }
            // only one child exist
            else if (root.left == null) {
                Node temp = root.right;
                root = null;
                return temp;
            }
            else if (root.right == null) {
                Node temp = root.left;
                root = null;
                return temp;
            }
            // both child exist
            else{
                Node child = root.right;
                while(child.left != null){
                    child = child.left;
                }
                root.data = child.data;
                root.right = deleteNode(root.right, root.data);
                return root;
            }
        }

        root.height = 1 + Math.max(getHeight(root.left), getHeight(root.right));
        int balance = getBalance(root);

        // left side unbalance
        if(balance>1){
            // ll
            if(getBalance(root.left) >= 0){
                return rightRotate(root);   
            }
            // lr
            else{
                root.left = leftRotate(root.left);
                return rightRotate(root);
            }
        }
        else if(balance<-1){
            // rr
            if(getBalance(root.right) <= 0){
                return leftRotate(root);
            }
            // rl
            else{
                root.right = rightRotate(root.right);
                return leftRotate(root);
            }
        }
        else{
            return root;
        }
    }

    // Function to perform left rotation
    public Node leftRotate(Node root) {
        Node newRoot = root.right;
        root.right = newRoot.left; // if newRoot.left is null, it will become null
        newRoot.left = root;
        root.height = 1 + Math.max(getHeight(root.left), getHeight(root.right));
        newRoot.height = 1 + Math.max(getHeight(newRoot.left), getHeight(newRoot.right));
        return newRoot;
    }

    // Function to perform right rotation
    public Node rightRotate(Node root) {
        Node newRoot = root.left;
        root.left = newRoot.right; // if newRoot.right is null, it will become null
        newRoot.right = root;
        root.height = 1 + Math.max(getHeight(root.left), getHeight(root.right));
        newRoot.height = 1 + Math.max(getHeight(newRoot.left), getHeight(newRoot.right));
        return newRoot;
    }
  

    // Utility function to get the height of a node
    public int getHeight(Node root) {
        if (root == null) {
            return 0;
        }
        return root.height;
    }

    // Utility function to get the balance factor of a node
    public int getBalance(Node root) {
        if (root == null) {
            return 0;
        }
        return getHeight(root.left) - getHeight(root.right);
    }

    // In-order traversal to print the tree
    public void printInOrder(Node node) {
        if (node != null) {
            printInOrder(node.left);
            System.out.print(node.data + " ");
            printInOrder(node.right);
        }
    }

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        int[] arr = {40,30,35,20};
        for (int value : arr) {
            tree.root = tree.insert(tree.root, value);
        }

        // Print the in-order traversal of the AVL tree
        tree.printInOrder(tree.root);

        // Delete a node from the AVL tree
        tree.root = tree.deleteNode(tree.root, 35);

        // Print the in-order traversal of the AVL tree
        System.out.println();
        tree.printInOrder(tree.root);
    }
}


```
1. **AVL Tree Properties**:
   - Self-balancing binary search tree.
   - **Balance Factor**: Difference between heights of left and right subtrees. Should be {-1, 0, +1}.
   - Ensures O(log n) time complexity for search, insertion, and deletion.

2. **Operations**:
   - **Insertion**: Follows BST rules, rebalances the tree using rotations if needed. Time: O(log n).
   - **Deletion**: Similar to insertion; rebalancing happens if AVL property is violated. Time: O(log n).
   - **Search**: Follows BST structure. Time: O(log n).

3. **Rotations**:
   - **Left Rotation (LL)**: Fixes right-heavy subtree.
   - **Right Rotation (RR)**: Fixes left-heavy subtree.
   - **Left-Right Rotation (LR)**: Right rotate, then left rotate.
   - **Right-Left Rotation (RL)**: Left rotate, then right rotate.

4. **Advantages**:
   - Guarantees O(log n) for operations.
   - Self-balancing after insertions and deletions.

5. **Disadvantages**:
   - Higher overhead due to rotations.
   - Extra space for storing height information.

6. **Use Cases**:
   - Databases, memory management, file systems for efficient data management.

### Time Complexity:
   - **Insertion, Deletion, Search**: O(log n).