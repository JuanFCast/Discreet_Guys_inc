package model;

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

    //Getters & Setters
    public T getValue(){
        return value;
    }
    public NodeH<T> getPrev() {
        return prev;
    }
    public void setPrev(NodeH<T> p) {
        prev = p;
    }
    public NodeH<T> getNext() {
        return next;
    }
    public void setNext(NodeH<T> n) {
        next = n;
    }

}