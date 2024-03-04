package main.java.LinkedListImplementation.Circular;

import javax.swing.undo.CannotUndoException;

public class DoublyCircular {
    Node head;
    static Node tail;

    void insertHead(int data){
        Node node = new Node(data);
        if(head == null){
            head = node;
            tail = node;
            tail.next = head;
            head.prev = tail;
            return;
        }
        node.next = head;
        head.prev = node;
        head = node;
        head.prev = tail;
        tail.next = head;
    }

    void insertTail(int data){
        Node node = new Node(data);

        if(head == null){
            insertHead(data);
            return;
        }
        tail.next = node;
        node.prev = tail;
        node.next = head;
        head.prev= node;
        tail = node;
    }

    public static void main(String[] args){
        DoublyCircular c = new DoublyCircular();

        c.insertHead(12);
        c.insertHead(90);
        c.insertHead(76);
        c.insertHead(43);

        c.traverse();
    }

    void traverse(){
        Node n = tail;
        while(n != head){
            System.out.println(n.data);
            n = n.prev;
        }
        System.out.println(n.data);
    }
}
