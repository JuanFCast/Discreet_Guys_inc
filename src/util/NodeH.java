package util;

public class NodeH<T> {

    private T value;

    private NodeH<T> next;
    private NodeH<T> prev;

    //Construct
    public NodeH(T v){
        value = v;
        next = null;
        prev = null;
    }

    @SuppressWarnings("unchecked")
    public int compareTo(T i) {
        return ((Comparable<T>) value).compareTo(i);
    }

    //Getters & Setters
    public T getValue(){
        return value;
    }
    public NodeH<T> getNext(){
        return next;
    }
    public NodeH<T> getPrev(){
        return prev;
    }

    public void setItem(T value){
        this.value = value;
    }
    public void setNext(NodeH<T> n){
        next = n;
    }
    public void setPrev(NodeH<T> p){
        prev = p;
    }

    //ToString
    public String toString(){
        return value + "";
    }

}