package main.java.FilterMapReduce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class BasicReducing {


    public static void main(String[] args){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 6, 5);

        //Lets evaluate max char in string. Find the string which have max char
        ArrayList<String> words = new ArrayList<>();
        words.add("hello");
        words.add("Worlds");
        words.add("Buddy");

        //* This is bad way of coding
        int sum = 0;
        for (int no:numbers){
            sum = sum + no;
        }
        System.out.println(sum);

        //*This is average.
        int sum1 = numbers.stream().mapToInt(i -> i).sum();
        System.out.println(sum1);

        //* Book it
        int reduceSum = numbers.stream().reduce(1, (a, b) -> a + b);
        System.out.println(reduceSum);

        //*This is really good. Book it...
        //this method doesn't take any identities only 1 parameters.
        Optional<Integer> reduceWithMethodSum = numbers.stream().reduce(Integer::sum);
        System.out.println(reduceWithMethodSum.get());
        //! What is Optional?

        //wanna get the max value from the whole list? you have
        //int maxValue = numbers.stream().reduce(0, (a, b) -> a > b ? a : b);
        int maxValue = numbers.stream().reduce(Integer::max).get();
        System.out.println(maxValue);

        //TODO REDUCE METHOD FOR LIST OF STRINGS
        //Always wrap the values coming out of reduce in String using String.valueOf(), as it will not output, only for string
        String s = String.valueOf(words.stream().reduce((word1, word2) -> word1.length() > word2.length() ? word1 : word2));
        System.out.println(s);
    }
}
