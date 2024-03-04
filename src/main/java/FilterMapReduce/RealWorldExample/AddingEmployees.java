package main.java.FilterMapReduce.RealWorldExample;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AddingEmployees {

    public static ArrayList<Employees> multiple(){
        return (ArrayList<Employees>) Stream.of(
                new Employees("John", 1, 'A', 80000),
                new Employees("Verm", 2, 'B', 80000),
                new Employees("Doe", 3, 'C', 80000),
                new Employees("Sahil", 4, 'A', 80000))
                .collect(Collectors.toList());//! What does it do?
    }
}
