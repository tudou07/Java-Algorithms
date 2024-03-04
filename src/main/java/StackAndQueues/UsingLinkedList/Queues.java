package main.java.StackAndQueues.UsingLinkedList;

/**
 * First In First Out. means the first element in should be the first element out.
 * The element will be inserted from one end and deleted from other end.
 * The time complexity should only be O(1)
 */

//*The way queues works is like we will make 2 pointers one at the front of the queue and one at the end.
    //* The front will be the one to delete as the first one in should be the first one out.
    //* The rear pointer will be the last one to delete. Hence it will be used to add the elements.
public class Queues {

    Node front;
    Node rear;
    int size = 0;

    Queues(){
        this.front = null;
        this.rear = null;
    }

    void enqueue(int data){
        Node node = new Node(data);
        node.next = null;
        size++;

        if(front == null){
            front = node;
            rear = node;
            return;
        }
        rear.next = node;
        rear = rear.next;
    }

    void dequeue(){
        if(size == 0) {
            System.out.println("Queue is Empty");
            return;
        }
        Node temp = front;
        front = front.next;
        temp.next = null;
        size--;
    }

    int peek(){
        if(size == 0){
            System.out.println("The Stack is Empty...");
            return 0;
        }
        return front.data;
    }

    public static void main(String[] args){
        Queues queues = new Queues();
        queues.enqueue(10);
        queues.enqueue(27);
        queues.enqueue(58);
        queues.enqueue(3);
        queues.enqueue(15);
        queues.enqueue(101);
        queues.dequeue();
        System.out.println(queues.peek());
    }
}
