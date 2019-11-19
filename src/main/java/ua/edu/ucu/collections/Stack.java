package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Stack {
    private ImmutableLinkedList LinkedList;

    public Stack(){
        this.LinkedList = new ImmutableLinkedList();
    }

    public Object peek() {
        return LinkedList.getFirst();
    }
    public Object pop() throws Exception {
        Object ex = LinkedList.getFirst();
        LinkedList = LinkedList.removeFirst();
        return ex;
    }
    public void push(Object e) throws Exception {
        LinkedList = LinkedList.addFirst(e);
    }

}
