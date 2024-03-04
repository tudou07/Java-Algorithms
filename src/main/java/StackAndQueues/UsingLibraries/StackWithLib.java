package main.java.StackAndQueues.UsingLibraries;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * We can do many operations using stack like push(), pop(), isEmpty() or peek()
 */
public class StackWithLib {

    //Last Element is first
    public static void main(String[] args){
        Stack<Integer> stack = new Stack<>();
        stack.push(14);
        stack.push(25);
        stack.push(74);
        stack.push(54);

        //* pop will remove and print last element in the stack
        System.out.println(stack.pop());

        //*What is in our stack
        System.out.println(stack);

        //*Prints the last element in the stack
        System.out.println(stack.peek());

        //*Is the iven element present in out stack
        System.out.println(stack.contains(54));

        //*get the size of the stack
        System.out.println(stack.size());

        //*Is the stack empty
        System.out.println(stack.isEmpty());
    }
}
