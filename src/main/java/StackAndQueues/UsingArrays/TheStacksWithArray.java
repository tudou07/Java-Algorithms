package main.java.StackAndQueues.UsingArrays;

import java.util.Arrays;

//!Ask Paul if is there a way to not give stack size
public class TheStacksWithArray<T>{

    private T[] stackArray;

    private int stackSize;

    private int topOfStack = -1;

    TheStacksWithArray(int size){
        stackSize = size;
        stackArray = (T[]) new Object[stackSize];
        Arrays.fill(stackArray, "-1");
    }

    public void push(T input){
        if(topOfStack + 1 < stackSize){
            topOfStack++;
            stackArray[topOfStack] = input;
        } else System.out.println("Sorry");

        displayTheStack();

        System.out.println("PUSH " + input + " was added to the stack");
    }

    public T pop(){
        if(topOfStack >= 0){
            displayTheStack();
            System.out.println("POP " + stackArray[topOfStack] + " was removed from the stack");
            stackArray[topOfStack] = (T)"-1";

            return stackArray[topOfStack--];
        } else{
            displayTheStack();
            System.out.println("Sorry the stack is empty");
            return (T)"-1";
        }
    }

    public void popAt(int index){
        if(topOfStack >= 0){
                stackArray[index] = (T)"-1";
            displayTheStack();
        }else{
            displayTheStack();
            System.out.println("Sorry the stack is empty");
        }
    }

    public T peek(){
        displayTheStack();
        System.out.println("PEEK " + stackArray[topOfStack] + " is at the top of the stack");
        return stackArray[topOfStack];
    }

    public void pushMany(String multi){
        String[] tempString = multi.split(" ");

        for (int i = 0; i< tempString.length; i++){
            push((T) tempString[i]);
        }
    }

    public void popAll(){
        for (int i = topOfStack; i >= 0; i--){
            pop();
        }
        displayTheStack();
    }
    public void displayTheStack(){
        for (int n = 0; n < 61; n++){System.out.print("-");}
        System.out.println();

        for (int n = 0; n < stackSize; n++){
            System.out.format("| %2s " + " ", n);
        }

        System.out.println("|");
        for (int n = 0; n < 61; n++){System.out.print("-");}
        System.out.println();

        for (int n = 0; n < stackSize; n++){
            if(stackArray[n].equals("-1")) System.out.print("|     ");
            else System.out.print(String.format("| %2s " + " ", stackArray[n]));
        }

        System.out.println("|");
        for (int n = 0; n < 61; n++){System.out.print("-");}
        System.out.println();
    }

    public static void main(String[] args){

        TheStacksWithArray<String> stack = new TheStacksWithArray<>(10);
        stack.push("10");
        stack.push("15");
        stack.pushMany("2 45 65 76 89");
        stack.peek();
        //stack.popAll();
        stack.popAt(2);

    }
}
