package main.java.GreedyAlgorithm.Krushals;

public class DisjointSet {

    static void makeSet(int[] parent, int[] rank, int size){
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    static int findParent(int[] parent, int node){
        if (parent[node] == node) return node;
        // As we don't have the parent of that node so that's why we are fixing it with = sign for future use
        return parent[node] = findParent(parent, parent[node]);
    }

    static void union(int[] parent, int[] rank, int node1, int node2){
        node1 = findParent(parent, node1);
        node2 = findParent(parent, node2);

        if (rank[node1] < rank[node2]){
            parent[node2] = node1;
        }
        else if (rank[node1] > rank[node2]) {
            parent[node1] = node2;
        }
        else {
            parent[node1] = node2;
            rank[node1]++;
        }
    }

    public static void main(String[] args) {
        int size = 10;

        int[] parent = new int[size];
        int[] rank = new int[size];

        makeSet(parent, rank, size);
    }

}
