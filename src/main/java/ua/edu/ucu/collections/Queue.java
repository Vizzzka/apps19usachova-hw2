package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Queue {

    private ImmutableLinkedList LinkedList;

    public Queue() {
        this.LinkedList = new ImmutableLinkedList();
    }

    public Object peek() {
        return LinkedList.getFirst();
    }

    public Object dequeue() {
        Object ex = LinkedList.getFirst();
        LinkedList = LinkedList.removeFirst();
        return ex;
    }
    public void enqueue(Object e) {
        LinkedList = LinkedList.addLast(e);
    }

}
