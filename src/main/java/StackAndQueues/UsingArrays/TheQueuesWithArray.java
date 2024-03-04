package main.java.StackAndQueues.UsingArrays;

import java.util.Arrays;

/**
 * Queues allows us to access the first person inserted in the array
 */
public class TheQueuesWithArray<V> {

    private V[] queueArray;

    private int queueSize;

    private int front, rear, numberOfItems = 0;

    TheQueuesWithArray(int size){
        queueSize = size;
        queueArray = (V[]) new Object[queueSize];
        Arrays.fill(queueArray, "-1");
    }

    public void insert(V input){
        if(numberOfItems + 1 <= queueSize) {
            queueArray[rear] = input;
            rear++;
            numberOfItems++;
            System.out.println("INSERT " + input + " was added to the queue");
        } else System.out.println("Sorry cannot add the input");
    }

    public void removeItems(){
        if (numberOfItems > 0){
            System.out.println("REMOVE " + queueArray[front]);
            queueArray[front] = (V)"-1";
            front--;
            numberOfItems--;
        } else{
            System.out.println("Sorry Queue is empty");
        }
    }

    public V peek(){
        System.out.println("The first item is " + queueArray[front]);
        V value = queueArray[front];
        return value;
    }

    public void priorityInsert(V input){
        int i;
        if(numberOfItems == 0){
            insert(input);
        } else{
            for(i = numberOfItems -1; i >= 0; i--){
                //! Ask paul why to cast String
                if(Integer.parseInt((String) input) > Integer.parseInt((String) queueArray[i])){
                    queueArray[i+1] = queueArray[i];
                } else break;
            }
            queueArray[i+1] = input;
            rear++;
            numberOfItems++;
        }
    }

    public void displayTheStack(){
        for (int n = 0; n < 61; n++){System.out.print("-");}
        System.out.println();

        for (int n = 0; n < queueSize; n++){
            System.out.format("| %2s " + " ", n);
        }

        System.out.println("|");
        for (int n = 0; n < 61; n++){System.out.print("-");}
        System.out.println();

        for (int n = 0; n < queueSize; n++){
            if(queueArray[n].equals("-1")) System.out.print("|     ");
            else System.out.print(String.format("| %2s " + " ", queueArray[n]));
        }

        System.out.println("|");
        for (int n = 0; n < 61; n++){System.out.print("-");}
        System.out.println();
    }

    public static void main(String[] args){
        TheQueuesWithArray queue = new TheQueuesWithArray(10);
        queue.insert("10");
        queue.insert("11");
        queue.insert("12");
        queue.insert("9");

        queue.peek();

        queue.displayTheStack();
        queue.removeItems();
        queue.displayTheStack();
    }
}
