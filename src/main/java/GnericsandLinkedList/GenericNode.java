package GnericsandLinkedList;

public class GenericNode<T> {

    T value;

    GenericNode<T> next;

    public GenericNode(T value){this.value = value;}

    public Object getValue(){return value;}

    public void setValue(T value){this.value = value;}

    public void setNext(GenericNode next){this.next = next;}

    public GenericNode getNext(){return next;}

}
