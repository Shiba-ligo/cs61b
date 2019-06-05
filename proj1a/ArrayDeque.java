public class ArrayDeque <T>{
    private int size;
    private int nextLast;
    private int nextFirst;
    private T[] items;

    public ArrayDeque(T x){
        size=1;
        items=(T[]) new Object[8];
        items[7]=x;
        nextFirst=6;
        nextLast=0;
    }
    public ArrayDeque(){
        size=0;
        items=(T[]) new Object[8];
        nextFirst=7;
        nextLast=0;
    }
    public void Resize(int capacity){
        T[] a=(T[]) new Object[capacity];
        System.arraycopy(items,0,a,0,nextLast);
        System.arraycopy(items,nextFirst+1,a,a.length-(items.length-1-nextFirst),items.length-1-nextFirst);
        nextFirst=nextFirst+(capacity-items.length);
        items=a;
    }
    public void addFirst(T x){
        if(items.length==size){
            Resize(2*size);
        }
        items[nextFirst]=x;
        size +=1;
        nextFirst -=1;
    }
    public void addLast(T x){
        if(items.length==size){
            Resize(2*size);
        }
        items[nextLast]=x;
        size +=1;
        nextLast +=1;
    }
    public boolean isEmpty(){
        return size==0;
    }
    public int size(){
        return size;
    }
    public T removeFirst(){
        if(size==0){
            return null;
        }
        if(size==0.25*items.length){
            Resize(items.length/2);
        }

        T valueToReturn=items[nextFirst + 1];
        items[nextFirst + 1] = null;
        size -= 1;
        nextFirst += 1;
        return valueToReturn;

    }
    public T removeLast() {
        if(size==0){
            return null;
        }
        if(size==0.25*items.length){
            Resize(items.length/2);
        }

        T valueToReturn=items[nextLast - 1];
        items[nextLast - 1] = null;
        size -= 1;
        nextLast -= 1;
        return valueToReturn;

    }
    public void printDeque(){
        for(int i=nextFirst+1;i<items.length;i+=1){
            System.out.print(items[i]+" ");
        }
        for(int i=0;i<nextLast;i+=1){
            System.out.print(items[i]+" ");
        }
    }
    public T get(int index){
        if(index>items.length-1){
            return null;
        }
        else if((index+nextFirst+1)<=items.length-1){
            return items[index+nextFirst+1];
        }else{
            return items[index+nextFirst-7];
        }
    }
/*
    public static void main(String[] args){
        ArrayDeque<Integer> a= new ArrayDeque<>();
        a.addFirst(14);
        a.addFirst(17);
        a.addFirst(4);
        a.addFirst(4);
        a.addFirst(19);
        a.addFirst(4);
        a.addFirst(15);
        a.addFirst(7);
        a.addLast(6);
        a.addFirst(9);
        System.out.println(a.size());
        a.printDeque();
        System.out.println(a.get(1));
        a.removeFirst();
        a.removeFirst();
        a.removeFirst();
        a.removeFirst();
        a.removeFirst();
        a.removeFirst();
        a.removeFirst();
        a.removeLast();
        a.printDeque();
    }

*/






















}
