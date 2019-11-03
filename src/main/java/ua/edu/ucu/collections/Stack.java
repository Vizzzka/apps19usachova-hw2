package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Stack {
    private ImmutableLinkedList LinkedList;

    public Stack(){
        this.LinkedList = new ImmutableLinkedList();
    }

    Object peek() {
        return LinkedList.getFirst();
    }
    Object pop() throws Exception {
        Object ex = LinkedList.getFirst();
        LinkedList = LinkedList.removeFirst();
        return ex;
    }
    void push(Object e) throws Exception {
        LinkedList = LinkedList.addFirst(e);
    }

}
