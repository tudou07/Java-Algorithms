package GnericsandLinkedList;

import java.util.ArrayList;
import java.util.LinkedList;

public class LinkedList_vs_ArrayList {
    public static void main(String[] args){
        //TODO creating a linkedList
        LinkedList<String> name = new LinkedList<>();
        name.add("hello");
        name.add("Paul");
        name.add("world");
        name.add(1, "hiiii");
        //{Hello, hiii, paul, world}
        //*Now linked list is just gonna change some wiring and add that new name in the list but...
        //Faster in terms of adding and removing items in list


        //TODO Creating ArrayList
        ArrayList<String> nameArray = new ArrayList<>();
        nameArray.add("hello");
        nameArray.add("Paul");
        nameArray.add("world");
        name.add(1, "hiiii");
        //{Hello, hiii, paul, world}
        //*Array list is gonna make a new array and then transfer the whole data to new array with added name.
    }

}
