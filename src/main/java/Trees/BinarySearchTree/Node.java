package main.java.Trees.BinarySearchTree;

public class Node <K, V> {

    K key;
    V name;

    Node leftChild;
    Node rightChild;

    public Node (K key, V name){
        this.key = key;
        this.name = name;
    }

    public String toString(){
        return name + " has a key " + key;
    }
}
