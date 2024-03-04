package main.java.FilterMapReduce.RealWorldExample;

import java.util.ArrayList;

public class MainRunner {


    public static void main(String[] args){
        //? Functional Interface video
        double Average = AddingEmployees.multiple().stream()
                .filter(employees -> employees.Grade == 'A')
                .map(employees -> employees.salary)
                .mapToDouble(i -> i)
                .average().getAsDouble();
        System.out.println(Average);

        double sumOfSalaray = AddingEmployees.multiple().stream()
                .filter(employees -> employees.Grade == 'A')
                .map(employees -> employees.salary)
                .reduce(Integer::sum).get();
        System.out.println(sumOfSalaray);

        String name = AddingEmployees.multiple().stream()
                .filter(employees -> employees.Grade == 'A')
                .map(employees -> employees.Name).toString();
        System.out.println(name);
    }
}
