package contructor;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by zhouyiwei on 2018/1/6.
 */
public class MyArrayList<AnyType> implements Iterable<AnyType>{

    private static final int DEFAULT_CAPACITY = 10;

    private int theSize;
    private AnyType[] anyTypes;

    public MyArrayList(){
        doClear();
    }

    public void clear(){
        doClear();
    }

    private void doClear(){
        theSize = 0;
        ensureCapacity(DEFAULT_CAPACITY);
    }

    public void trimToSize(){
        ensureCapacity(theSize);
    }

    public int size(){
        return theSize;
    }

    public boolean isEmpty(){
        return theSize == 0;
    }

    public AnyType get(int index){
        if(index>theSize || index<0){
            throw new RuntimeException("out of index");
        }
        return anyTypes[index];
    }

    public AnyType set(int index,AnyType newVal){
        if(index>theSize || index<0){
            throw new RuntimeException("out of index");
        }
        AnyType old = anyTypes[index];
        anyTypes[index] = newVal;
        return old;
    }

    public void add(AnyType x){
        add(theSize,x);
    }

    public void add(int index,AnyType x){
        if(theSize == anyTypes.length){
            ensureCapacity(2*theSize +1);
        }
        if(index>theSize || index<0){
            throw new RuntimeException("out of index");
        }
        for(int i = theSize;i>index;i--){
            anyTypes[i] = anyTypes[i-1];
        }
        anyTypes[index] = x;
        theSize++;
    }

    public AnyType remove(int index){
        if(index>theSize || index<0){
            throw new RuntimeException("out of index");
        }
        AnyType one =  anyTypes[index];
        for(int i = index;i<theSize-1;i++){
            anyTypes[i]=anyTypes[i+1];
        }
        theSize--;
        return one;
    }

    public void ensureCapacity(int newCapacity){
        if(newCapacity<0){
            return;
        }
        AnyType[] old = anyTypes;
        anyTypes = (AnyType[])new Object[newCapacity];
        for(int i =0;i<theSize;i++){
            anyTypes[i] = old[i];
        }
    }

    @Override
    public Iterator<AnyType> iterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements Iterator{

        private int current = 0;

        @Override
        public boolean hasNext() {
            return current<size();
        }

        @Override
        public AnyType next() {
            if(!hasNext()){
                throw new RuntimeException("");
            }
            return anyTypes[current++];
        }

        @Override
        public void remove() {
            MyArrayList.this.remove(--current);
        }
    }


    public static void main(String[] args) {
        MyArrayList<String> list = new MyArrayList<String>();
        System.out.println(list.size());
        list.add("1");
        System.out.println(list.size());
        System.out.println(list.get(0));
        list.add(0,"2");
        list.add("3");
        System.out.println(Arrays.toString(list.anyTypes));
        list.trimToSize();
        System.out.println(Arrays.toString(list.anyTypes));
        for(String str : list){
            System.out.println(str);
        }
        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
