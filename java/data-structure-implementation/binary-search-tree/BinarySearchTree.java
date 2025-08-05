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
                return root.right;
            }
            else if(root.right==null){
                return root.left;
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
