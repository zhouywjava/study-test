package contructor;

import java.util.Iterator;

/**
 * Created by zhouyiwei on 2018/1/7.
 */
public class MyLinkedList<AnyType> implements Iterable<AnyType> {

    private static class Node<AnyType> {
        public Node<AnyType> prev;
        public Node<AnyType> next;
        public AnyType data;

        public Node(AnyType data,Node<AnyType> prev, Node<AnyType> next) {
            this.prev = prev;
            this.next = next;
            this.data = data;
        }
    }

    private int theSize;
    private int modCount = 0;
    private Node<AnyType> beginMarker;
    private Node<AnyType> endMarker;

    public MyLinkedList(){
        doClear();
    }

    public void clear(){
        doClear();
    }

    public int size(){
        return theSize;
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    public void doClear(){
        beginMarker = new Node<AnyType>(null,null,null);
        endMarker = new Node<AnyType>(null,beginMarker,null);
        beginMarker.next = endMarker;
        theSize = 0;
        modCount ++;
    }

    public void add(AnyType x){
        add(size(),x);
    }

    public void add(int index,AnyType x){
      addBefore(getNode(index,0,size()),x);
    }

    public void addBefore(Node<AnyType> node,AnyType x){
        Node<AnyType> newOne = new Node<AnyType>(x,node.prev,node);
        node.prev.next = newOne;
        node.prev = newOne;
        theSize++;
        modCount++;
    }

    public AnyType get(int index){
        return getNode(index).data;
    }

    public Node<AnyType> getNode(int index){
        return getNode(index,0,size()-1);
    }

    public Node<AnyType> getNode(int index,int low,int upper){
        Node<AnyType> p;
        if(index<low || index>upper){
            throw new IndexOutOfBoundsException();
        }
        if(index < size()/2){
            p = beginMarker.next;
            for(int i = 0;i<index;i++){
               p = p.next;
            }
        }else{
            p = endMarker;
            for(int i = theSize;i>index;i--){
                p = p.prev;
            }
        }
        return p;
    }

    public AnyType set(int idx,AnyType newVal){
        Node<AnyType> old = getNode(idx);
        AnyType olda = old.data;
        old.data = newVal;
        return olda;
    }

    public AnyType remove(int idx){
        Node<AnyType> old = getNode(idx);
        old.prev.next = old.next;
        old.next.prev = old.prev;
        theSize--;
        modCount++;
        return old.data;
    }

    public AnyType remove(Node<AnyType> one){
        one.prev.next = one.next;
        one.next.prev = one.prev;
        theSize--;
        modCount++;
        return one.data;
    }

    @Override
    public Iterator<AnyType> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<AnyType>{

        private Node<AnyType> current = beginMarker.next;
        private int expectedModCount = modCount;
        private boolean okToRemove = false;

        @Override
        public boolean hasNext() {
            return current != endMarker;
        }

        @Override
        public AnyType next() {
            if(modCount != expectedModCount){
                throw new java.util.ConcurrentModificationException();
            }
            if(!hasNext()){
                throw new java.util.NoSuchElementException();
            }
            AnyType nextItem = current.data;
            current = current.next;
            okToRemove = true;
            return nextItem;
        }

        @Override
        public void remove() {
            if(modCount != expectedModCount){
                throw new java.util.ConcurrentModificationException();
            }
            if(!okToRemove){
                throw new IllegalStateException();
            }
            MyLinkedList.this.remove(current.prev);
            expectedModCount++;
            okToRemove=false;
        }
    }
}
