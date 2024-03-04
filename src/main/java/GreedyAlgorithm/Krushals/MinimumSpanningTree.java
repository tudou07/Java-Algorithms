package main.java.GreedyAlgorithm.Krushals;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class MinimumSpanningTree {

//    We need some kinda linear DS to store 3 values - 2 vertices and 1 edge weight
//    and we need to sort that list according to weight

    static int findParent(ArrayList<Integer> parent, int node){
        if (parent.get(node) == node) return node;
        return parent.set(node, findParent(parent, parent.get(node)));
    }

    static void union(ArrayList<Integer> parent, ArrayList<Integer> rank, int node1, int node2){
        node1 = findParent(parent, node1);
        node2 = findParent(parent, node2);

        if (rank.get(node1) < rank.get(node2)){
            parent.set(node1, node2);
        }
        else if (rank.get(node1) > rank.get(node2)) {
            parent.set(node2, node1);
        }
        else {
            parent.set(node2, node1);
            rank.set(node1, node1++);
        }
    }

    // list = [Weight, [edge1, Edge2]]
    static int minimumSpanningTreeSize(LinkedList<Node> edges, int size){

        edges.sort(Comparator.comparingInt(Node::getWeight));

        ArrayList<Integer> parent = new ArrayList<>();
        ArrayList<Integer> rank = new ArrayList<>();

        IntStream.range(0, edges.size()).forEach(parent::add);
        IntStream.range(0, edges.size()).forEach(i -> rank.add(0));

        AtomicInteger totalWeight = new AtomicInteger();

        edges.forEach(temp -> {
            int parentEdge1 = findParent(parent, temp.getEdges1());
            int parentEdge2 = findParent(parent, temp.getEdges2());
            int weight = temp.getWeight();

            if (parentEdge1 != parentEdge2) {
                totalWeight.addAndGet(weight);
                union(parent, rank, parentEdge1, parentEdge2);
            }
        });

        return totalWeight.get();
    }

    public static void main(String[] args) {
        LinkedList<Node> edges = new LinkedList<>();

        Node node1 = new Node(0, 1, 2);
        Node node2 = new Node(0, 2, 3);
        Node node3 = new Node(1, 3, 7);
        Node node4 = new Node(2, 4, 3);
        Node node5 = new Node(3, 5, 1);
        Node node6 = new Node(4, 5, 5);
        Node node7 = new Node(4, 3, 2);
        Node node8 = new Node(1, 2, 1);

        edges.add(node1);
        edges.add(node2);
        edges.add(node3);
        edges.add(node4);
        edges.add(node5);
        edges.add(node6);
        edges.add(node7);
        edges.add(node8);

        System.out.println(minimumSpanningTreeSize(edges, edges.size()));

    }
}


class Node {
    private final int[] Edges = new int[2];
    private int Weight;

    public Node(int edge1, int edge2, int value) {
        this.Edges[0] = edge1;
        this.Edges[1] = edge2;
        this.Weight = value;
    }

    public int getEdges1() {
        return Edges[0];
    }

    public int getEdges2() {
        return Edges[1];
    }

    public int getWeight() {
        return Weight;
    }

    public void setWeight(int weight) {
        this.Weight = weight;
    }
}
