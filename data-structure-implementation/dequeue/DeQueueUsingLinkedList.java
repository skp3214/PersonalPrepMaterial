class Node {
    int data;
    Node next;
    Node prev;
    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
public class DeQueueUsingLinkedList {
    int size;
    int capacity;
    Node front;
    Node rear;
    DeQueueUsingLinkedList(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.front = null;
        this.rear = null;
    }

    void insertFront(int data){
        if(isFull()){
            return ;
        }
        Node newNode=new Node(data);
        if(isEmpty()){
            front=rear=newNode;
        }
        else{
            newNode.next=front;
            front.prev=newNode;
            front=newNode;
        }
        size++;
    }
    void deleteFront(){
        if(isEmpty()){
            return;
        }
        front=front.next;
        if(front!=null){
            front.prev=null;
        }
        else{
            rear=null;
        }
        size--;
    }
    void insertLast(int data){
        if(isFull()){
            return ;
        }
        Node newNode=new Node(data);
        if(isEmpty()){
            front=rear=newNode;
        }
        else{
            rear.next=newNode;
            newNode.prev=rear;
            rear=newNode;
        }
        size++;
    }

    void deleteLast(){
        if(isEmpty()){
            return;
        }
        else{
            rear=rear.prev;
            if(rear!=null){
                rear.next=null;
            }
            else{
                front=null;
            }
        }
        size--;
    }
    boolean isFull() {
        return size == capacity;
    }
    boolean isEmpty() {
        return size == 0;
    }
    int getFirst(){
        return isEmpty()?-1:front.data;
    }
    int getLast(){
        return isEmpty()?-1:rear.data;
    }
    public static void main(String[] args) {
        DeQueueUsingLinkedList deQueue=new DeQueueUsingLinkedList(5);
        deQueue.insertFront(10);
        deQueue.insertFront(20);
        deQueue.insertLast(30);
        deQueue.insertLast(40);
        deQueue.insertFront(50);
        System.out.println(deQueue.getFirst());
        System.out.println(deQueue.getLast());
        deQueue.deleteFront();
        deQueue.deleteLast();
        System.out.println(deQueue.getFirst());
        System.out.println(deQueue.getLast());
    }
}