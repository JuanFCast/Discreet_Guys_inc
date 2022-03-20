package model;

public class LinkedList<T> {
    private NodeH<T> head;

    public LinkedList(){
        head = null;
    }

    public NodeH<T> getHead() {
        return head;
    }

}