public class ArrayDeque <T>{
    private int size;
    private int nextLast;
    private int nextFirst;
    private T[] items;

    /*public ArrayDeque(T x){
        size=1;
        items=(T[]) new Object[8];
        items[7]=x;
        nextFirst=6;
        nextLast=0;
    }*/
    public ArrayDeque(){
        size=0;
        items=(T[]) new Object[8];
        nextFirst=3;
        nextLast=4;
    }
    private void Resize(int capacity){
        T[] a=(T[]) new Object[capacity];
        if(RightShift(nextFirst)+size<=items.length){
            System.arraycopy(items,RightShift(nextFirst),a,0,size);
        }else{
            System.arraycopy(items,nextFirst+1,a,0,items.length-nextFirst-1);
            System.arraycopy(items,0,a,items.length-nextFirst-1,nextLast);
        }
        nextFirst=a.length-1;
        nextLast=size;
        items = a;
    }
    private int RightShift(int Pos){
        if(Pos<items.length-1){
            return Pos+1;
        }else{
            return 0;
        }
    }
    private int LeftShift(int Pos){
        if(Pos>0){
            return Pos-1;
        }else{
            return items.length-1;
        }
    }
    public void addFirst(T x){
        if(items.length==size){
            Resize(2*items.length);
        }
        items[nextFirst]=x;
        size +=1;
        nextFirst = LeftShift(nextFirst);
    }
    public void addLast(T x){
        if(items.length==size){
            Resize(2*items.length);
        }
        items[nextLast]=x;
        size +=1;
        nextLast = RightShift(nextLast);
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
        int newPos=RightShift(nextFirst);
        T valueToReturn=items[newPos];
        items[newPos] = null;
        size -= 1;
        nextFirst = newPos;
        if(size<=0.25*items.length&&items.length>8){
            Resize(items.length/2);
        }
        return valueToReturn;

    }
    public T removeLast() {
        if(size==0){
            return null;
        }
        int newPos=LeftShift(nextLast);
        T valueToReturn=items[newPos];
        items[newPos] = null;
        size -= 1;
        nextLast = newPos;
        if(size<=0.25*items.length&&items.length>8){
            Resize(items.length/2);
        }
        return valueToReturn;

    }
    public void printDeque(){
        int Pos=RightShift(nextFirst);
        for(int i=1;i<=size;i+=1){
            System.out.print(items[Pos]+" ");
            Pos=RightShift(Pos);
        }
    }
    public T get(int index){
        if(index>size-1){
            return null;
        }
        else if((index+nextFirst+1)<=items.length-1){
            return items[index+nextFirst+1];
        }else{
            return items[index+nextFirst-(items.length-1)];
        }
    }

    public static void main(String[] args) {
        ArrayDeque<Integer> array = new ArrayDeque<>();

        for (int i = 0; i < 16; i++) {
            if (i % 2 == 0) {
                array.addFirst(i);
            } else {
                array.addLast(i);
            }

        }

        array.printDeque();
        int x;
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                x = array.removeFirst();
            } else {
                x = array.removeLast();
            }

            if ((i + 1) % 8 == 0) {
                array.printDeque();
            }

            // System.out.println("nextFirst: " + array.nextFirst);
            // System.out.println("nextLast: " + array.nextLast);

        }





    }
























}
