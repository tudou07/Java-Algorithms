package main.java.LinkedListImplementation.DoublyLLT;

public class DoublyLinkedList {

    Node head;
    Node tail;

    void insertAtHead(int data){
        Node node = new Node(data);

        if (head == null){
            head = node;
            tail = node;
            return;
        }
        node.next = head;
        head.prev = node;
        head = node;
    }

    void insertAt(int index, int data){
        Node node = new Node(data);

        if(index ==0 || head == null){
            insertAtHead(data);
            return;
        }
        Node n = head;
        for (int i = 0; i < index -1; i++){
            n = n.next;
        }
        Node temp = n.next;
        temp.prev = node;
        node.prev = n;
        n.next = node;
        node.next = temp;

    }

    void insertAtTail(int data){
        Node node = new Node(data);

        if(tail == null){
            insertAtHead(data);
            return;
        }
        tail.next = node;
        node.prev = tail;
        tail = node;

    }

    public static void main(String[] args){

        DoublyLinkedList llt = new DoublyLinkedList();

        llt.insertAtHead(12);
        llt.insertAtHead(87);
        llt.insertAtHead(23);
        llt.insertAtHead(73);
        llt.insertAtHead(9);

        llt.insertAt(2, 43);

        llt.insertAtTail(98);

        llt.traverse();

    }

    void traverse(){
        Node n = head;
        while(n != null){
            System.out.println(n.data);
            n = n.next;
        }
    }
}
