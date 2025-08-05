
class Queue{
    int front,rear,size;
    int[] arr;
    Queue(int size){
        this.front=-1;
        this.rear=-1;
        this.size=size;
        arr=new int[size];
    }

    public void push(int data){
        if(rear==size-1){
            System.out.println("Overflow");
        }
        else{
            arr[++rear]=data;
        }
    }

    public int pop(){
        if(front==rear){
            System.out.println("Under Flow");
            return -1;
        }
        else{
            return arr[++front];
        }
    }

    public boolean isEmpty(){
        return rear!=size-1;
    }
}
public class QueueUsingArray {
    public static void main(String[] args) {
        Queue queue=new Queue(5);
        int k=0;
        queue.push(++k);
        queue.push(++k);
        queue.push(++k);
        queue.push(++k);
        queue.push(++k);
        queue.pop();
        queue.pop();
        queue.pop();
        queue.pop();
        System.out.println(queue.isEmpty());
    }
}
