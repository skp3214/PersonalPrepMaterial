
class Stack{
    int top;
    int size;
    int [] arr;
    Stack(int size){
        this.top=-1;
        this.size=size;
        arr=new int[size];
    }

    public void push(int data){
        if(top==size-1){
            System.out.println("Overflow");
        }
        else{
            arr[++top]=data;
        }
    }

    public int pop(){
        if(isEmpty()){
            System.out.println("UnderFlow");
            return -1;
        }
        else{
            return arr[top--];
        }
    }

    public boolean isEmpty(){
        return top==-1;
    }
};
public class StackUsingArray {

    public static void main(String[] args) {
        Stack stack=new Stack(5);
        int k=0;
        stack.push(++k);
        stack.push(++k);
        stack.push(++k);
        stack.push(++k);
        stack.push(++k);
        System.out.println(stack.isEmpty());
    }
}
