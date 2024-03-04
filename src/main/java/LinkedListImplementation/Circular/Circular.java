package main.java.LinkedListImplementation.Circular;


public class Circular {
    static Node head;
    Node tail;
    int size = 0;

    void insertHead(int data){
        Node node = new Node(data);
        if(head == null){
            head = node;
            tail = node;
            tail.next = head;
            size++;
            return;
        }
        tail.next = node;
        node.next = head;
        head = node;
        size++;
    }

    void insertTail(int data){
        Node node = new Node(data);
        if(head == null){
            insertHead(data);
            return;
        }
        tail.next = node;
        tail = node;
        tail.next = head;
        size++;
    }

    void insertAt(int index, int data){
        Node node = new Node(data);
        if(head == null || index % size == 0){
            insertHead(data);
            return;
        }
        Node n = head;
        while(index > 1){
            n = n.next;
            index--;
        }
        Node temp = n.next;
        n.next = node;
        node.next = temp;
    }

    void traverse(){
        Node n = head;
        while(n.next != head){
            System.out.println(n.data);
            n = n.next;
        }
        System.out.println(n.data);
    }

    boolean circularCheck(){
        //Start the pointer after head.
        Node temp = head.next;

        //Using for loop keep incremeenting the pointer until it hits either null or head
        while(temp != null && temp != head){
            temp = temp.next;
        }
        //If it hits any one of those
        if (temp == null){
            return false;
        }
        else {
            return true;
        }
    }

    public static void main (String[] args){
        Circular c = new Circular();

        c.insertTail(13);
        c.insertHead(34);
        c.insertTail(193);
        c.insertHead(83);

        c.insertAt(2, 132);

        c.traverse();

    }
}
