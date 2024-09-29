# Deque (Double-Ended Queue) Overview

A **deque** (pronounced "deck") is a data structure that allows insertion and deletion of elements from both ends — the front and the rear. It is a generalized version of a queue with the following properties:

### Dequeue Implementation Using LinkedList

```Java
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
```
### Dequeue Implementation Using Array
```java

public class DequeueUsingArrray {
    int size;
    int rear, front;
    int[] arr;

    DequeueUsingArrray(int n) {
        this.size = n;
        this.front = -1;
        this.rear = -1;
        this.arr = new int[n];
    }

    boolean isFull() {
        return (rear + 1) % size == front;
    }

    boolean isEmpty() {
        return front == -1;
    }

    void insertFront(int data) {
        if (isEmpty()) {
            front = rear = 0;
            arr[0] = data;
        }
        if (isFull()) {
            return;
        } else {
            front = (front - 1 + size) % size;
            arr[front] = data;
        }
    }

    void insertBack(int data){
        if(isEmpty()){
            front=rear=0;
            arr[0]=data;
        }
        if(isFull()){
            return;
        }
        else{
            rear=(rear+1)%size;
            arr[rear]=data;
        }
    }

    void popBack(){
        if(isEmpty()){
            return;
        }
        if(rear==front){
            rear=front=-1;
            arr[rear]=0;
        }
        else{
            arr[rear]=0;
            rear=(rear-1+size)%size;
        }
    }

    void popFront(){
        if(isEmpty()){
            return;
        }
        if(rear==front){
            rear=front=-1;
            arr[0]=0;
        }
        else{
            arr[front]=0;
            front=(front+1)%size;
        }
    }

    int getFront(){
        return isEmpty()?-1:arr[front];
    }

    int getRear(){
        return isEmpty()?-1:arr[rear];
    }

    public static void main(String[] args) {
        DequeueUsingArrray dq = new DequeueUsingArrray(5);
        dq.insertFront(1);
        dq.insertFront(2);
        dq.insertBack(3);
        dq.insertBack(4);
        dq.popBack();
        dq.popFront();
        System.out.println(dq.getFront());
        System.out.println(dq.getRear());
    }
}
```
### 1. **Properties of Deque**:
   - Supports operations at both the front and rear ends.
   - Can act as both a stack (LIFO) and a queue (FIFO) depending on the operations performed.
   - Can be either **bounded** (with a fixed size) or **unbounded** (dynamically resizable).

### 2. **Types of Deque**:
   - **Input-restricted deque**: Insertion at one end (rear), deletion from both ends.
   - **Output-restricted deque**: Deletion at one end (front), insertion at both ends.

### 3. **Operations on Deque**:
   Common operations include:
   
   - **Insert at Front**: Adds an element at the front of the deque.
   - **Insert at Rear**: Adds an element at the rear of the deque.
   - **Delete from Front**: Removes an element from the front of the deque.
   - **Delete from Rear**: Removes an element from the rear of the deque.
   - **Peek Front**: Returns the front element without removing it.
   - **Peek Rear**: Returns the rear element without removing it.
   - **isEmpty()**: Checks if the deque is empty.
   - **isFull()**: (For bounded deques) Checks if the deque is full.

### 4. **Applications of Deque**:
   - **Sliding Window Problems**: Efficiently track max or min elements within a window of a certain size.
   - **Palindrome Checking**: Check if a sequence is a palindrome by comparing elements from both ends.
   - **Undo/Redo Operations**: Used in applications like text editors.
   - **Scheduling Algorithms**: Time-sharing and CPU scheduling may use deques.

### 5. **Time Complexity**:
   - **Insert/Remove from Front/Rear**: O(1) (constant time).
   - **Peek Front/Rear**: O(1).
   - **Search**: O(n), as random access isn't supported.

### 6. **Deque Implementations**:
   - **Array-based Deque**: Circular array is used to allow wraparound.
   - **Linked List Deque**: Doubly linked list is used, allowing efficient front and rear operations.

### 7. **Deque in Programming Languages**:
   - **C++**: `std::deque` in STL.
   - **Python**: `collections.deque` is part of the standard library.
   - **Java**: `java.util.Deque` interface, implemented by classes like `ArrayDeque` and `LinkedList`.

### 8. **Advantages of Deque**:
   - Flexibility of operations at both ends.
   - Efficient in managing operations that require access to both the front and rear.
   - Can simulate both stack and queue behaviors.

### 9. **Disadvantages of Deque**:
   - More complex than regular queues and stacks.
   - In array-based deques, resizing may be expensive (for unbounded deques).
   - Search operations are not efficient (O(n)) since random access is not supported.



