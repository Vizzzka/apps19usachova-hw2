package ua.edu.ucu.collections;

import org.junit.Test;
import static org.junit.Assert.*;

public class StackTest {

    @Test
    public void testPeek() throws Exception {
        Stack myStack = new Stack();
        myStack.push(2);
        myStack.push(3);

        assertEquals(myStack.peek(), 3);

        myStack.push(5);
        myStack.push(7);

        assertEquals(myStack.peek(), 7);
    }

    @Test
    public void testEnqueue() throws Exception {
        Stack myStack = new Stack();
        myStack.push(2);
        assertEquals(myStack.peek(), 2);

        myStack.push(3);
        myStack.pop();
        assertEquals(myStack.peek(), 2);

    }

    @Test
    public void testDequeue() throws Exception {
        Stack myStack = new Stack();
        myStack.push(2);
        assertEquals(myStack.peek(), 2);
        myStack.push(3);
        assertEquals(myStack.peek(), 3);

        myStack.push(5);
        myStack.push(6);
        myStack.pop();
        myStack.push(3);

        myStack.pop();
        myStack.pop();
        myStack.pop();
        myStack.pop();
        myStack.push(1);
        assertEquals(myStack.peek(), 1);

    }
}
