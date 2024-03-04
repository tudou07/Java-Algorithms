package main.java.StackAndQueues.UsingLinkedList;

//*Last is First Out
public class Stacks {
    //First thing we need in stack class is head node which will start the stack.
    //If the head node is empty we know that the stack is empty.
    //Have a constructor of this class which will declare the head as null, hence we are only starting the stack.
    //To make a stack we not only need a head but also a tail node.
    //Just keep changing the tail only so you don't need to traverse through the whole linkedList everytime.

    //*Every function in this class is done in O(1) complexity. Except the commented push function.
    Node head;

    //If we gonna use tail the complexity wll be 0(n) but rn we 0(1)
    Node tail;

    int size = 0;

    //Once the stack element is made the head and both should be null. As it's a new a stack
    Stacks(){
        head = null;
        tail = null;
    }

    //Create a new node, increment the size, and make the new node, a head node
    //Hence in stack the last element should be the first element out, the last element is the head.
    void push(int data){
        Node node = new Node(data);
        node.next = null;
        size++;

        if(head == null){
            head = node;
            return;
        }
        node.next = head;
        head = node;
    }

    //As we know the peek element is head, hence return head data
    int peek(){
        if(size == 0) return 0;
        return head.data;
    }

    //Store the head node in temp node, make head->next node head node and delete the temp node. Also decrement the size
    void pop(){
        if(size == 0) {
            System.out.println("Stack is Empty");
            return;
        }
        Node temp = head;
        head = head.next;
        temp.next = null;
        size--;
    }

    boolean isEmpty(){
        if(size == 0) return true;
        else return false;
    }

    public static void main(String[] args){
        Stacks stack = new Stacks();
        stack.push(4);
        stack.push(3);
        stack.push(60);
        stack.push(10);
        stack.push(11);
        stack.pop();
        System.out.println(stack.peek());
        System.out.println(stack.size);
    }
}

//* Push function but with the use of tail, Hence it has complexity of O(n)
//    void push(int data){
//        Node node = new Node();
//        node.data = data;
//        node.next =null;
//
//        if(head == null){
//            head = node;
//            tail = node;
//            return;
//        }
//        tail.next = node;
//        tail = tail.next;
//    }
