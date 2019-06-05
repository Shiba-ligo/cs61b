public class LinkedListDeque <UndeType>{
    private class StuffNode {
        public StuffNode prev;
        public StuffNode next;
        public UndeType item;

        public StuffNode(StuffNode pr,StuffNode ne,UndeType it){
            prev=pr;
            next=ne;
            item=it;
        }
    }
    public int size;
    public StuffNode sentinel;
    public LinkedListDeque(UndeType x){
        sentinel= new StuffNode(null,null,null);
        sentinel.next=new StuffNode(sentinel,sentinel,x);
        sentinel.prev=sentinel.next;
        size=1;
    }
    public LinkedListDeque(){
        //sentinel=new StuffNode(sentinel,sentinel,63);
        sentinel=new StuffNode(null,null,null);
        sentinel.next=sentinel;
        sentinel.prev=sentinel;
        size=0;
    }

    public void addFirst(UndeType T){
        sentinel.next=new StuffNode(sentinel,sentinel.next,T);
        sentinel.next.next.prev=sentinel.next;
        size +=1;
    }

    public void addLast(UndeType T){
        sentinel.prev=new StuffNode(sentinel.prev,sentinel,T);
        sentinel.prev.prev.next=sentinel.prev;
        size +=1;
    }

    public UndeType removeFirst(){
        if (size==0){
            return null;
        }else{
            UndeType return_value;
            return_value=sentinel.next.item;
            sentinel.next=sentinel.next.next;
            sentinel.next.prev=sentinel;
            size -=1;
            return return_value;
        }
    }

    public UndeType removeLast(){
        if (size==0){
            return null;
        }else{
            UndeType return_value;
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

    public UndeType get(int index){
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

    public UndeType getRecursive_helper(StuffNode p,int index){
        if(index==0){
            return p.next.item;
        }else{
            return getRecursive_helper(p.next,index-1);
        }
    }

    public UndeType getRecursive(int index){
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