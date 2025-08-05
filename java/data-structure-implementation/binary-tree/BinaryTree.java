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
