package main.java.GreedyAlgorithm.Dijkstras;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.stream.IntStream;

public class MinimumDistanceSpanningTree {

    int minDistance(ArrayList<Integer> distance, ArrayList<Boolean> visited){
        int min = Integer.MAX_VALUE, index = -1;

        for (int i = 0; i < distance.size(); i++){
            if (!visited.get(i) && distance.get(i) <= min){
                min = distance.get(i);
                index = i;
            }
        }

        return index;
    }

    void dijkstra(int[][] graph, int source){
        ArrayList<Integer> distance = new ArrayList<>();
        ArrayList<Boolean> visited = new ArrayList<>();

        IntStream.range(0, graph.length).forEach(i -> distance.add(Integer.MAX_VALUE));
        distance.set(0, 0);

        for (int i = 0; i < graph.length; i++){
            visited.add(false);
        }

        for (int i = 0; i < graph.length; i++){
            int u = minDistance(distance, visited);
            visited.set(u, true);

            for (int j = 0; j < graph.length; j++){

            }
        }

    }

    public static void main(String[] args) {
        int[][] graph = new int[][] {{0, 4, 0, 0, 7}, {4, 0, 1, 2, 0}, {0, 1, 0, 6, 0}, {0, 2, 6, 0, 0}, {7, 0, 0, 0, 0}};
    }
}
