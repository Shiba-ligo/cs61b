public class LinkedListDeque <T>{
    private class StuffNode {
        public StuffNode prev;
        public StuffNode next;
        public T item;

        public StuffNode(StuffNode pr,StuffNode ne,T it){
            prev=pr;
            next=ne;
            item=it;
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
    public LinkedListDeque(){
        //sentinel=new StuffNode(sentinel,sentinel,63);
        sentinel=new StuffNode(null,null,null);
        sentinel.next=sentinel;
        sentinel.prev=sentinel;
        size=0;
    }

    public void addFirst(T x){
        sentinel.next=new StuffNode(sentinel,sentinel.next,x);
        sentinel.next.next.prev=sentinel.next;
        size +=1;
    }

    public void addLast(T x){
        sentinel.prev=new StuffNode(sentinel.prev,sentinel,x);
        sentinel.prev.prev.next=sentinel.prev;
        size +=1;
    }

    public T removeFirst(){
        if (size==0){
            return null;
        }else{
            T return_value;
            return_value=sentinel.next.item;
            sentinel.next=sentinel.next.next;
            sentinel.next.prev=sentinel;
            size -=1;
            return return_value;
        }
    }

    public T removeLast(){
        if (size==0){
            return null;
        }else{
            T return_value;
            return_value=sentinel.prev.item;
            sentinel.prev=sentinel.prev.prev;
            sentinel.prev.next=sentinel;
            size -=1;
            return return_value;
        }
    }

    public boolean isEmpty(){
        return size==0;
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        StuffNode p = sentinel;
        while(p.next!=sentinel){
            System.out.print(p.next.item+" ");
            p=p.next;
        }
    }

    public T get(int index){
        StuffNode p=sentinel;
        if(index>size-1){
            return null;
        }else{
            for(int i=0;i<index;i+=1){
                p=p.next;
            }
            return p.next.item;
        }
    }

    private T getRecursive_helper(StuffNode p,int index){
        if(index==0){
            return p.next.item;
        }else{
            return getRecursive_helper(p.next,index-1);
        }
    }

    public T getRecursive(int index){
        if(index>size-1){
            return null;
        }else{
            return getRecursive_helper(sentinel,index);
        }
    }
/*
    public static void main(String[] args){
        LinkedListDeque<Integer> a= new LinkedListDeque(5);
        a.addFirst(4);
        a.addLast(6);
        System.out.println(a.size());
        a.printDeque();
        System.out.println(a.get(1));
        a.removeFirst();
        a.removeLast();
        a.printDeque();
    }

*/












}
