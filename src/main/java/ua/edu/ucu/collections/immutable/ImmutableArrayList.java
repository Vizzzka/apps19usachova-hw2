package ua.edu.ucu.collections.immutable;


public class ImmutableArrayList implements ImmutableList{
    private Object[] ArrayList;
    private int size;


    public ImmutableArrayList() {
        this.size = 0;
        this.ArrayList = new Object[1];
    }

    public ImmutableArrayList(Object[] source) {
        this.ArrayList = source.clone();
    }

    @Override
    public ImmutableArrayList add(int index, Object e) throws Exception {
        if (index > this.size)
            throw new Exception();

        Object[] newArrayList = this.ArrayList.clone();
        if (this.size == this.ArrayList.length)
            newArrayList = this.resize();

        System.arraycopy(ArrayList, 0, newArrayList, 0, index);
        System.arraycopy(ArrayList, index, newArrayList, index + 1, this.size - index);
        newArrayList[index] = e;

        return new ImmutableArrayList(newArrayList);
    }

    @Override
    public ImmutableList add(Object e) throws Exception {
        return this.add(this.size, e);
    }

    @Override
    public ImmutableList addAll(Object[] c) throws Exception {
        return this.add(this.size, c);
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) throws Exception {
        if (index > this.size())
            throw new Exception();

        Object[] newArrayList = new Object[this.size + c.length];
        System.arraycopy(this.ArrayList, 0, newArrayList, 0, index);
        System.arraycopy(c, 0, newArrayList, index, c.length);
        System.arraycopy(this.ArrayList, index, newArrayList, index + c.length,
                this.size - index);
        return new ImmutableArrayList(newArrayList);
    }

    @Override
    public ImmutableList remove(int index) throws Exception {
        if (index >= size)
            throw new Exception();

        Object[] newArrayList = new Object[this.size - 1];
        System.arraycopy(this.ArrayList, 0, newArrayList, 0, index);
        System.arraycopy(this.ArrayList, index + 1, newArrayList, index,
                this.size - index - 1);
        return new ImmutableArrayList(newArrayList);
    }


    public int size(){
        return this.size();
    }

    public Object get(int index) throws Exception {
        if (index >= this.size)
            throw new Exception();
        return this.ArrayList[index];
    }


    @Override
    public ImmutableList set(int index, Object e) {
        Object[] newArrayList = this.ArrayList.clone();
        newArrayList[index] = e;
        return new ImmutableArrayList(newArrayList);
    }

    public int indexOf(Object e) {
        for (int i = 0; i < size; i++) {
            if (this.ArrayList[i] == e) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public ImmutableList clear() {
        return new ImmutableArrayList();
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public Object[] toArray() {
        return this.ArrayList.clone();
    }

    public String toString() {
        StringBuilder res = new StringBuilder();
        if (this.size == 0)
            return res.toString();

        for (Object el:this.ArrayList){
            res.append(el.toString()).append(" ");
        }
        return res.toString();
    }

    public Object[] resize(){
        Object[] newArray = new Object[this.size * 2];
        System.arraycopy(this.ArrayList, 0, newArray, 0, this.size);
        return newArray.clone();
    }

}
