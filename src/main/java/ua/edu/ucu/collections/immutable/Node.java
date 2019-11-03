package ua.edu.ucu.collections.immutable;

public class Node {
    private Object data;
    private Node next;

    Node(){}

    Node(Object data, Node next){
        this.data = data;
        this.next = next;
    }

    Node (Object data){
        this.data = data;
    }

    public Node copyNode(){
        return new Node(this);
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;

    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
