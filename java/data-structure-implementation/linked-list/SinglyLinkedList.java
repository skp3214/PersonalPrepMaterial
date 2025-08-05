import java.util.Scanner;

public class SinglyLinkedList {

    class Node {
        int data;
        Node link;

        Node(int data) {
            this.data = data;
            this.link = null;
        }
    }

    Node start;

    public void createList(int data) {
        Node newNode=new Node(data);
        if(start==null){
            start=newNode;
            return;
        }
        else{
            Node curNode=start;
            while(curNode.link!=null){
                curNode=curNode.link;
            }
            curNode.link=newNode;

        }
    }
    
    public void insertAtIndex(int data, int index) {
        Node newNode=new Node(data);
        Node curNode=start;
        if(index==1){
            if(start==null){
                start=newNode;
                return;
            }
            else{
                newNode.link=start;
                start=newNode;
            }
        }
        else{
            for(int i=1;i<index-1;i++){
                curNode=curNode.link;
            }
            newNode.link=curNode.link;
            curNode.link=newNode;
        }
    }
    public void deleteAtIndex(int index) {
            if(index==1){
                start=start.link;
            }
            else{
                Node curNode=start;
                for(int i=1;i<index-1;i++){
                    curNode=curNode.link;
                }
                curNode.link=curNode.link.link;
            }
    }
    public void printList(){
        if(start==null){
            System.out.println("List is empty.");
        }
        else{
            Node curNode=start;
            while(curNode!=null){
                System.out.print(curNode.data+"->");
                curNode=curNode.link;
            }
            System.out.println("null");
        }
    }
    

    public static void main(String[] args) {

        SinglyLinkedList list = new SinglyLinkedList();
        Scanner sc = new Scanner(System.in);
        System.out.print("How many node you want to add ?: ");
        int noOfNode=sc.nextInt();
        for(int i=0;i<noOfNode;i++){
            System.out.print("Enter the data of "+(i+1)+" Node: ");
            int data=sc.nextInt();
            list.createList(data);
        }
        boolean loop=true;
        list.printList();
        while(loop==true){

            System.out.println("Choose the option below.");
            System.out.println("0.Exit. ");
            System.out.println("1.Insert a node at index.");
            System.out.println("2.Delete a node at index. ");
            System.out.println("3.Print the List.");

            int choice=sc.nextInt();

            if(choice==0){
                loop=false;
            }
            if(choice==1){
                System.out.println("How many nodes you want to insert.");
                int noOfnode=sc.nextInt();
                for(int i=0;i<noOfnode;i++){
                    System.out.print("Enter the data: ");
                    int data=sc.nextInt();
                    System.out.print("Enter the index: ");
                    int index=sc.nextInt();
                    list.insertAtIndex(data,index);
                    System.out.println(" ");

                }
            }
            if(choice==2){
                    System.out.println("How many nodes you want to delete.");
                    int nOfnode=sc.nextInt();
                    for(int i=0;i<nOfnode;i++){
                        System.out.print("Enter the index: ");
                        int index=sc.nextInt();
                        list.deleteAtIndex(index);
                    }
            }
            if(choice==3){
                list.printList();
            }
        }
        
        sc.close();
        
    }


}
