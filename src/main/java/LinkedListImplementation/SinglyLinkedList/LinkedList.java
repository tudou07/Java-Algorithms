package main.java.LinkedListImplementation.SinglyLinkedList;

public class LinkedList <K>{
    //TODO Every list will have 1 thing which will be Node
    //*First node will always be head.
    Node head;

    //TODO the first method will be insert which insert a value inside linkedlist
    public void insert(K data) {
        //Instantiating a new node.
        Node node = new Node();
        //The data of that new node will be data user provided
        node.data = data;
        //The next data will be null
        node.next = null;

        //If no node is created then make the data as head node.
        if (head == null) {
            head = node;
        }
        //ELse start from the head and give go until the last value is not found
        else {
            Node n = head;
            while (n.next != null) {
                n = n.next;
            }
            //Once the last value is found the nest node should be the node created at the top of the function.
            n.next = node;
        }
    }

    public void show() {
        Node n = new Node();
        n = head;

        while (n.next != null) {
            System.out.println(n.data);
            n = n.next;
        }
        System.out.println(n.data);

    }

    public void insertStart(K data) {
        Node node = new Node();
        node.data = data;
        node.next = head;
        head = node;
    }

    public void insertAt(int index, K data){
        //Create a new node. Its data should be data passed by user and the next value should be null.
        //So it's just one node or one box with data and next value as null
        Node node = new Node();
        node.data = data;
        node.next = null;

        //If index is 0 insert the data at start.
        if(index == 0){
            insertStart(data);
        }
        //Else make a node that has a value head. Using for loop go to the position where you wanna add the node
        else{
            Node n = head;
            for (int i = 0; i < index-1; i++){
                n = n.next;
            }
            //Once reached that position make old created node next as new node next
            node.next = n.next;
            //And insert the node value at next node.
            n.next = node;
        }
    }

    public void deleteAt(int index){
        if (index == 0){
            head = head.next;
        } else{
            Node n = head;
            Node n1;
            for (int i = 0; i < index-1; i++){
                n= n.next;
            }
            n1 = n.next;
            n.next = n1.next;
        }

    }

    Node reverse(){
        Node current = head;
        Node prev = null;

        while(current != null){
            Node forward = current.next;
            current.next = prev;
            prev = current;
            current = forward;
        }
        return prev;
    }

    //Understand this
    Node reverseRecursion(){
        Node current = head;
        Node prev = null;
        recursion(head, current, null);
        return head;
    }

    void recursion(Node head, Node current, Node prev){
        //Base Case
        if(current == null){
            head = prev;
            return;
        }
        Node forward = current.next;
        recursion(head, forward, current);
        current.next = prev;
    }

}
