package main.java.DynamicProgramming;

import java.util.Arrays;

public class Fibonacci {

    int number;
    int[] array;

    Fibonacci(int number) {
        this.number = number;
        this.array = new int[number];
    }

    public int generate_new_fib(){
        if(number <= 1){ return number; }
        array[0] = 0;
        array[1] = 1;

        for (int i = 2; i < number; i++){
            array[i] = array[i - 1] + array[i - 2];
        }

        return array[number - 1];
    }

    public int[] getArray() { return array; }

    public static void main(String[] args) {
        Fibonacci fib = new Fibonacci(5);
        System.out.println(fib.generate_new_fib());
        System.out.println(Arrays.toString(fib.getArray()));
    }

}
