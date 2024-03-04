package main.java.StackAndQueues.UsingLibraries;

import java.util.LinkedList;
import java.util.Queue;

//First element is first
public class QueuesWithLib<K> {

    public static void main(String[] args){
        //! Whenever i try to add queues using new queue it doesn't work.
        Queue<Integer> queue = new LinkedList<>();
        queue.add(14);
        queue.add(32);
        queue.add(38);
        queue.add(98);
        queue.add(100);

        //*What is in our queue
        System.out.println(queue);

        //*Prints the last element in the queue
        System.out.println(queue.peek());

        //*Is the iven element present in out queue
        System.out.println(queue.contains(54));

        //*get the size of the queue
        System.out.println(queue.size());

        //*Is the queue empty
        System.out.println(queue.isEmpty());
    }
}
