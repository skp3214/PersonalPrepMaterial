
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
