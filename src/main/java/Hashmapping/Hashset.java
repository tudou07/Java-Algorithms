package main.java.Hashmapping;

import java.sql.SQLOutput;
import java.util.*;

public class Hashset {
    public static void main(String[] args){
        String[] array = {"hello", "world", "hello"};
        List<String> list = Arrays.asList(array);

        System.out.printf("%s ", list);
        System.out.println();

        Set<String> set = new HashSet<>(list);
        System.out.printf("%s ", set);

        HashSet<Integer> hash = new HashSet<>();
        hash.add(1);
        hash.add(2);
        hash.add(101);

        for (int i = 100; i < 106 && hash.contains(i); i++){
            hash.add(i);
        }

        System.out.println(hash.contains(101));
    }
}
