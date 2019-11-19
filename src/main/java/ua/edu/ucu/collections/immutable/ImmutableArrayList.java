package ua.edu.ucu.collections.immutable;


public final class ImmutableArrayList implements ImmutableList{
    private Object[] ArrayList;
    private int size;

    public ImmutableArrayList() {
        this.size = 0;
        this.ArrayList = new Object[1];
    }

    public ImmutableArrayList(Object[] source) {

        this.ArrayList = source.clone();
        this.size = source.length;
    }

    @Override
    public ImmutableArrayList add(Object e) {
        return this.add(this.size, e);
    }

    @Override
    public ImmutableArrayList add(int index, Object e) {
        this.rangeCheckForAdd(index);

        Object[] newArrayList = new Object[this.size + 1];
        System.arraycopy(ArrayList, 0, newArrayList, 0, index);
        System.arraycopy(ArrayList, index, newArrayList, index + 1, this.size - index);
        newArrayList[index] = e;

        return new ImmutableArrayList(newArrayList);
    }

    @Override
    public ImmutableArrayList addAll(Object[] c) {
        return this.add(this.size, c);
    }

    @Override
    public ImmutableArrayList addAll(int index, Object[] c) {
        this.rangeCheckForAdd(index);

        Object[] newArrayList = new Object[this.size + c.length];
        System.arraycopy(this.ArrayList, 0, newArrayList, 0, index);
        System.arraycopy(c, 0, newArrayList, index, c.length);
        System.arraycopy(this.ArrayList, index, newArrayList, index + c.length,
                this.size - index);
        return new ImmutableArrayList(newArrayList);
    }

    @Override
    public Object get(int index){
        this.rangeCheck(index);
        return this.ArrayList[index];
    }

    @Override
    public ImmutableArrayList set(int index, Object e) {
        this.rangeCheck(index);
        Object[] newArrayList = this.ArrayList.clone();
        newArrayList[index] = e;
        return new ImmutableArrayList(newArrayList);
    }

    @Override
    public ImmutableArrayList remove(int index){
        this.rangeCheck(index);

        Object[] newArrayList = new Object[this.size - 1];
        System.arraycopy(this.ArrayList, 0, newArrayList, 0, index);
        System.arraycopy(this.ArrayList, index + 1, newArrayList, index,
                this.size - index - 1);
        return new ImmutableArrayList(newArrayList);
    }

    @Override
    public int indexOf(Object e) {
        for (int i = 0; i < size; i++) {
            if (this.ArrayList[i] == null)
                continue;
            if ((this.ArrayList[i]).equals(e)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size(){
        return this.size;
    }

    @Override
    public ImmutableArrayList clear() {
        return new ImmutableArrayList();
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public Object[] toArray() {
        Object[] newArr = new Object[this.size];
        for (int i = 0; i < this.size(); i++)
            newArr[i] = this.ArrayList[i];
        return newArr;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        if (this.size == 0)
            return res.toString();

        for (Object el:this.ArrayList){
            res.append(el.toString()).append(" ");
        }
        return res.toString();
    }

    private void rangeCheck(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("Out of range " + index);
        }
    }

    private void rangeCheckForAdd(int index) {
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException("Out of range " + index);
        }
    }

}
