package ua.edu.ucu.collections.immutable;

import org.junit.Test;


import static org.junit.Assert.*;

public class ImmutableArrayListTest {


    @Test
    public void testToArray(){
        ImmutableArrayList ex = new ImmutableArrayList(new Object[]{100, 102});
        ImmutableArrayList ex2 = new ImmutableArrayList(new Object[]{});

        assertArrayEquals(ex.toArray(), new Object[]{100, 102});
        assertArrayEquals(ex2.toArray(), new Object[]{});
    }
    @Test
    public void testImmutable() throws Exception {
        ImmutableArrayList ex = new ImmutableArrayList(new Object[]{100, 102});
        ImmutableArrayList ex2 = ex.addAll(new Object[]{1, 2, 4, 5, 8, 9, 11});
        ex2 = ex.add(1, 1000);
        assertArrayEquals(ex.toArray(), new Object[]{100, 102});
    }

    @Test
    public void testAdd() throws Exception {
        ImmutableArrayList ex = new ImmutableArrayList(new Object[]{100, 102});
        ImmutableArrayList ex2 = ex.addAll(new Object[]{1, 2, 4, 5, 8, 9, 11});
        ImmutableArrayList ex3 = ex.addAll(1, new Object[]{-1, -2});
        ImmutableArrayList ex4 = ex.add(0, 5);
        ImmutableArrayList ex5 = new ImmutableArrayList();
        ex5 = ex5.add(3);

        assertArrayEquals(ex2.toArray(), new Object[]{100, 102, 1, 2, 4, 5, 8, 9, 11});
        assertArrayEquals(ex3.toArray(), new Object[]{100, -1, -2, 102});
        assertArrayEquals(ex4.toArray(), new Object[]{5, 100, 102});
        assertArrayEquals(ex5.toArray(), new Object[]{3});
    }

    @Test
    public void testToString() throws Exception {
        ImmutableArrayList ex = new ImmutableArrayList(new Object[]{100, 102});
        ImmutableArrayList ex2 = new ImmutableArrayList(new Object[]{100});
        ImmutableArrayList ex3 = ex2.remove(0);

        assertEquals(ex.toString(), "100 102 ");
        assertEquals(ex2.toString(), "100 ");
        assertEquals(ex3.toString(), "");
    }


    @Test
    public void testRemove() throws Exception {
        ImmutableArrayList ex = new ImmutableArrayList(new Object[]{1, 2, 3, 4});
        assertArrayEquals(ex.toArray(), new Object[]{1, 2, 3, 4});
        ImmutableArrayList ex2 = ex.remove(2);

        assertArrayEquals(ex.toArray(), new Object[]{1, 2, 3, 4});
        assertArrayEquals(ex2.toArray(), new Object[]{1, 2, 4});
    }

    @Test
    public void testIsEmpty() throws Exception {
        ImmutableArrayList ex = new ImmutableArrayList();
        ImmutableArrayList ex2 = new ImmutableArrayList(new Object[]{1, 2});
        ImmutableArrayList ex3 = ex2.remove(1);
        ex3 = ex3.remove(0);

        assertTrue(ex.isEmpty());
        assertFalse(ex2.isEmpty());
        assertTrue(ex3.isEmpty());
    }
    @Test
    public void testClear(){
        ImmutableArrayList ex = new ImmutableArrayList(new Object[]{});
        ImmutableArrayList ex2 = new ImmutableArrayList(new Object[]{1, 2, 3});
        ex = ex.clear();
        ex2 = ex2.clear();

        assertTrue(ex.isEmpty());
        assertTrue(ex2.isEmpty());
    }

    public void testSize() throws Exception {
        ImmutableArrayList ex = new ImmutableArrayList();
        assertEquals(ex.size(), 0);
        ex = ex.add(4);
        assertEquals(ex.size(), 1);
        ex = ex.addAll(new Object[]{1, 2, 3});
        assertEquals(ex.size(), 4);

        ex = ex.clear();
        assertEquals(ex.size(), 0);
    }
    @Test
    public void testGet() throws Exception {
        ImmutableArrayList ex = new ImmutableArrayList(new Object[]{1, 2, 3, 4});

        assertEquals(ex.get(0), 1);
        assertEquals(ex.get(2), 3);
        assertEquals(ex.get(3), 4);
    }
    @Test
    public void testSet() throws Exception {
        ImmutableArrayList ex = new ImmutableArrayList(new Object[]{1, 2, 3, 4});
        ex = ex.set(0, -1);
        ex = ex.set(2, -3);
        ex = ex.set(3, -4);

        assertEquals(ex.get(0), -1);
        assertEquals(ex.get(2), -3);
        assertEquals(ex.get(3), -4);
    }
    @Test
    public void testIndexOf(){
        ImmutableArrayList ex = new ImmutableArrayList(new Object[]{1, 2, 3, 4, 5});

        assertEquals(ex.indexOf(-2), -1);
        assertEquals(ex.indexOf(2), 1);
    }
    
}
