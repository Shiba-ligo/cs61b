public class ArrayDeque<T> {
    private int size;
    private int nextLast;
    private int nextFirst;
    private T[] items;


    public ArrayDeque() {
        size = 0;
        items = (T[]) new Object[8];
        nextFirst = 3;
        nextLast = 4;
    }
    private void resize(int capacity) {
        T[] a = (T[]) new Object[capacity];
        if (rightShift(nextFirst) + size <= items.length) {
            System.arraycopy(items, rightShift(nextFirst), a, 0, size);
        } else {
            System.arraycopy(items, nextFirst + 1, a, 0, items.length - nextFirst - 1);
            System.arraycopy(items, 0, a, items.length - nextFirst - 1, nextLast);
        }
        nextFirst = a.length - 1;
        nextLast = size;
        items = a;
    }
    private int rightShift(int pos) {
        if (pos < items.length - 1) {
            return pos + 1;
        } else {
            return 0;
        }
    }
    private int leftShift(int pos) {
        if (pos > 0) {
            return pos - 1;
        } else {
            return items.length - 1;
        }
    }
    public void addFirst(T x) {
        if (items.length == size) {
            resize(2 * items.length);
        }
        items[nextFirst] = x;
        size += 1;
        nextFirst = leftShift(nextFirst);
    }
    public void addLast(T x) {
        if (items.length == size) {
            resize(2 * items.length);
        }
        items[nextLast] = x;
        size += 1;
        nextLast = rightShift(nextLast);
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public int size() {
        return size;
    }
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        int newPos = rightShift(nextFirst);
        T valueToReturn = items[newPos];
        items[newPos] = null;
        size -= 1;
        nextFirst = newPos;
        if (size <= 0.25 * items.length && items.length > 8) {
            resize(items.length / 2);
        }
        return valueToReturn;

    }
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        int newPos = leftShift(nextLast);
        T valueToReturn = items[newPos];
        items[newPos] = null;
        size -= 1;
        nextLast = newPos;
        if (size <= 0.25 * items.length && items.length > 8) {
            resize(items.length / 2);
        }
        return valueToReturn;

    }
    public void printDeque() {
        int pos = rightShift(nextFirst);
        for (int i = 1; i <= size; i += 1) {
            System.out.print(items[pos] + " ");
            pos = rightShift(pos);
        }
    }
    public T get(int index) {
        if (index > size - 1) {
            return null;
        } else if ((index + nextFirst + 1) <= items.length - 1) {
            return items[index + nextFirst + 1];
        } else {
            return items[index + nextFirst - (items.length - 1)];
        }
    }






}
























