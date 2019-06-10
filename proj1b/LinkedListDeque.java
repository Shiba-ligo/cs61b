public class LinkedListDeque<T> implements Deque<T> {
    private class StuffNode {
        private StuffNode prev;
        private StuffNode next;
        private T item;

        private StuffNode(StuffNode pr, StuffNode ne, T it) {
            prev = pr;
            next = ne;
            item = it;
        }
    }
    private int size;
    private StuffNode sentinel;
    /*public LinkedListDeque(T x){
        sentinel= new StuffNode(null,null,null);
        sentinel.next=new StuffNode(sentinel,sentinel,x);
        sentinel.prev=sentinel.next;
        size=1;
    }*/
    public LinkedListDeque() {
        //sentinel=new StuffNode(sentinel,sentinel,63);
        sentinel = new StuffNode(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    @Override
    public void addFirst(T x) {
        sentinel.next = new StuffNode(sentinel, sentinel.next, x);
        sentinel.next.next.prev = sentinel.next;
        size += 1;
    }

    @Override
    public void addLast(T x) {
        sentinel.prev = new StuffNode(sentinel.prev, sentinel, x);
        sentinel.prev.prev.next = sentinel.prev;
        size += 1;
    }

    @Override
    public T removeFirst() {
        if (size == 0) {
            return null;
        } else {
            T returnValue;
            returnValue = sentinel.next.item;
            sentinel.next = sentinel.next.next;
            sentinel.next.prev = sentinel;
            size -= 1;
            return returnValue;
        }
    }

    @Override
    public T removeLast() {
        if (size == 0) {
            return null;
        } else {
            T returnValue;
            returnValue = sentinel.prev.item;
            sentinel.prev = sentinel.prev.prev;
            sentinel.prev.next = sentinel;
            size -= 1;
            return returnValue;
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        StuffNode p = sentinel;
        while (p.next != sentinel) {
            System.out.print(p.next.item + " ");
            p = p.next;
        }
    }

    @Override
    public T get(int index) {
        StuffNode p = sentinel;
        if (index > size - 1) {
            return null;
        } else {
            for (int i = 0; i < index; i += 1) {
                p = p.next;
            }
            return p.next.item;
        }
    }

    private T getRecursivehelper(StuffNode p, int index) {
        if (index == 0) {
            return p.next.item;
        } else {
            return getRecursivehelper(p.next, index - 1);
        }
    }

    public T getRecursive(int index) {
        if (index > size - 1) {
            return null;
        } else {
            return getRecursivehelper(sentinel, index);
        }
    }













}
