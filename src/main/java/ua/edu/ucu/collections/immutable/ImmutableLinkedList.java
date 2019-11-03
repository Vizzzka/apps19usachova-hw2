package ua.edu.ucu.collections.immutable;


public class ImmutableLinkedList implements ImmutableList{

    private Node head;
    private int size;

    public ImmutableLinkedList(){
        head = null;
        size = 0;
    }


    public ImmutableLinkedList(Object[] c){
        this.size = c.length;
        if (c.length == 0){
            this.head = null;
            return;
        }
        this.head = new Node(c[0]);
        Node temp = this.head;
        for (int i = 1; i < this.size; ++i){
            temp.setNext(new Node(c[i]));
            temp = temp.getNext();
        }
    }

    public ImmutableLinkedList copy(){
        if (this.size == 0){
            return new ImmutableLinkedList();
        }
        ImmutableLinkedList newLinkedList = new ImmutableLinkedList();
        newLinkedList.size = this.size;
        newLinkedList.head = new Node(this.head.getData());
        Node temp = this.head.getNext();
        Node newTemp = newLinkedList.head;

        for (int i = 1; i < this.size; ++i){
            newTemp.setNext(new Node(temp.getData()));
            newTemp = newTemp.getNext();
            temp = temp.getNext();
        }
        return newLinkedList;
    }

    @Override
    public ImmutableLinkedList add(Object e) throws Exception {
        return addAll(this.size, new Object[]{e});
    }

    @Override
    public ImmutableLinkedList add(int index, Object e) throws Exception{
        if (index > this.size)
            throw new Exception();
        return addAll(index, new Object[]{e});
    }

    @Override
    public ImmutableLinkedList addAll(Object[] c) throws Exception {
        return addAll(this.size, c);
    }

    private Node findNode(int index){
        Node temp = this.head;
        for (int i = 0; i < index; ++i)
            temp = temp.getNext();
        return temp;
    }

    @Override
    public ImmutableLinkedList addAll(int index, Object[] c) throws Exception {
        if (index > this.size)
            throw new Exception();

        ImmutableLinkedList newLinkedList = new ImmutableLinkedList(c);
        ImmutableLinkedList copyLinkedList = this.copy();
        if (index == 0){
            int last_index = newLinkedList.size - 1;
            newLinkedList.findNode(last_index).setNext(copyLinkedList.head);
            newLinkedList.size = c.length + this.size();
            return newLinkedList;
        }
        if (index == this.size){
            int last_index = copyLinkedList.size() - 1;
            copyLinkedList.findNode(last_index).setNext(newLinkedList.head);
            copyLinkedList.size = this.size + c.length;
            return copyLinkedList;
        }
        int last_index = newLinkedList.size() - 1;
        Node temp = copyLinkedList.findNode(index - 1);
        newLinkedList.findNode(last_index).setNext(temp.getNext());
        temp.setNext(newLinkedList.head);
        copyLinkedList.size = this.size + c.length;
        return copyLinkedList;
    }

    public Object get(int index) throws Exception {
        if (index >= this.size)
            throw new Exception();
        return this.findNode(index).getData();
    }

    public ImmutableLinkedList set(int index, Object e) throws Exception {
        if (this.size <= index)
            throw new Exception();
        ImmutableLinkedList newLinkedList = this.copy();
        Node node = newLinkedList.findNode(index);
        node.setData(e);
        return newLinkedList;
    }

    public ImmutableLinkedList remove(int index) throws Exception {
        if (index > this.size())
            throw new Exception();
        ImmutableLinkedList newLinkedList = this.copy();
        newLinkedList.size--;
        if (index == 0) {
            newLinkedList.head = newLinkedList.head.getNext();
            return newLinkedList;
        }
        Node node = newLinkedList.findNode(index - 1);
        node.setNext(node.getNext().getNext());
        return newLinkedList;

    }

    public int indexOf(Object e){
        Node temp = this.head;
        for (int i = 0; i < this.size; ++i){
            if (temp.getData() == e)
                return i;
            temp = temp.getNext();
        }
        return -1;
    }

    public int size(){
        return size;
    }

    public ImmutableLinkedList clear(){
        return new ImmutableLinkedList();
    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    public Object[] toArray(){
        Node temp = this.head;
        Object[] result = new Object [this.size];

        for (int i = 0; i < this.size; ++i){
            result[i] = temp.getData();
            temp = temp.getNext();
        }
        return result;
    }


    public ImmutableLinkedList addFirst(Object e) throws Exception {
        return this.add(0, e);
    }

    public ImmutableLinkedList addLast(Object e) throws Exception {
        return this.add(e);
    }

    public Object getFirst(){
        return this.findNode(0).getData();
    }

    public Object getLast(){
        return this.findNode(size - 1).getData();
    }

    public ImmutableLinkedList removeFirst() throws Exception {
        return this.remove(0);
    }

    public ImmutableLinkedList removeLast() throws Exception {
        return this.remove(size - 1);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        Node temp = this.head;
        for (int i = 0; i < this.size; ++i){
            res.append(temp.getData().toString()).append(" ");
            temp = temp.getNext();
        }
        return res.toString();
    }
}
