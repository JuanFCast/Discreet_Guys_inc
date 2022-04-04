package util;

import java.util.Arrays;

import util.Interface.IQueue;

@SuppressWarnings("unchecked")
public class PriorityQueue<T> implements IQueue<T>{

    private T[] queue; 
    private final int MAX_SIZE = 11; //11 es un numero primo
    private int size = 0;
    private HeapTYPE type;

    public PriorityQueue(HeapTYPE t){
        queue = (T[]) new Object[MAX_SIZE];
        type = t;
    }

    @Override
    public boolean add(T element) {
        queue[size] = element;
        size++;
        if(size > 1){
            heapify();
        }
        if(size+1 == MAX_SIZE){
            grow();
        }
        return true;
    }

    public void setType(HeapTYPE t) {
        type = t;
        heapify();
    }

    private void heapify(){
        for(int i = size-1; i > 0; i--){
            if(type == HeapTYPE.MAX_HEAP){
                MaxHeapify(queue, i);
            }
            else{
                MinHeapify(queue, i);
            }
        }
    }

    private void MaxHeapify(T[] q, int i){
        int parent = ((i+1)/2)-1;
        int largest;

        NodeH<T> p = new NodeH<>(q[parent]);

        if(p.compareTo(q[i]) < 0){
            //System.out.println("Hijo (" + q[i] + ") mayor al padre (" + q[parent] + ")");
            largest = i;
        } else{
            //System.out.println("Padre (" + q[parent] + ") mayor al hijo (" + q[i] + ")");
            largest = parent;
        }

        if(largest != parent){
            T aux = q[i];
            q[i] = q[parent];
            q[parent] = aux;
            MaxHeapify(q, largest);
        }
    }

    private void MinHeapify(T[] q, int i){
        int parent = ((i+1)/2)-1;
        int smaller;

        NodeH<T> p = new NodeH<>(q[parent]);

        if(p.compareTo(q[i]) > 0){
            smaller = i;
        } else{
            smaller = parent;
        }

        if(smaller != parent){
            T aux = q[i];
            q[i] = q[parent];
            q[parent] = aux;
            MinHeapify(q, smaller);
        }
    }
    
    //Poll return and remove the element
    @Override
    public T poll() {
        if(size > 0){
            T e = queue[0];
            queue[0] = queue[size-1];
            queue[size-1] = null;
            size--;
            heapify();
            return e;
        } else{
            return null;
        }
        
    }

    //Peek does not remove element
    @Override
    public T peek() {
        return queue[0];
    }

    private void grow(){
        queue = Arrays.copyOf(queue, MAX_SIZE*2);
    }

    public boolean isEmpty(){
        return (queue[0] == null)?true:false;
    }

    public String toString(){
        String s = "[";
        for (T i : queue) {
            if(i != null)
                s += i + "|";
            else
                s += "  |";
        }
        return s + "]";
    }

}
