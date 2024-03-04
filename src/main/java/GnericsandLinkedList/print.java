package GnericsandLinkedList;

import java.util.Scanner;

public class print {

    public static void main(String[] args){
        //TODO Creating Generic Node Variables
        GenericNode gn1 = new GenericNode(23);
        GenericNode gn2 = new GenericNode("Hello");
        GenericNode gn3 = new GenericNode("World");
        GenericNode gn4 = new GenericNode("I'm Sahil Rai");
        GenericNode gn5 = new GenericNode(2);
        GenericNode gn6 = new GenericNode(gn1);
        //* last value of generics should always have first variable as value in linked List

        //TODO creating LinkedList with the variables created at the top
        //LinkedList using generics
        gn2.setNext(gn3);
        gn3.setNext(gn4);
        gn4.setNext(gn5);
        gn5.setNext(gn6);
        gn6.setNext(null);

        //Printing Generic node variables
        GenericNode gn = gn1;
        while(gn.getNext() != null){
            System.out.println(gn.getValue());
            gn = gn.getNext();
        }

        //TODO taking input from the user in form of generic node
        Scanner scan = new Scanner(System.in);
        GenericNode input = new GenericNode(scan.next());

        System.out.println(input.getValue());

        //TODO creating an array
        GenericNode[] elements = new GenericNode[5];


        //! Ask paul how to give values to these array

    }


}
