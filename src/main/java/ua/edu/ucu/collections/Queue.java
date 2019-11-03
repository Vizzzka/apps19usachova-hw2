package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Queue {

    private ImmutableLinkedList LinkedList;

    public Queue(){
        this.LinkedList = new ImmutableLinkedList();
    }

    Object peek() {
        return LinkedList.getFirst();
    }
    Object dequeue() throws Exception {
        Object ex = LinkedList.getFirst();
        LinkedList = LinkedList.removeFirst();
        return ex;
    }
    void enqueue(Object e) throws Exception {
        LinkedList = LinkedList.addLast(e);
    }

}
