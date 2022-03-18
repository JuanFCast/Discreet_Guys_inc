package model;

public class NodeH<K, V> {

    private K key;
    private V value;

    private NodeV<K, V> next;
    private NodeV<K, V> previous;

    public NodeH(K key, V value){
        this.key = key;
        this.value = value;
        next = null;
        previous = null;
    }

    public NodeV<K, V> getPrevious() {
        return previous;
    }

    public void setPrevious(NodeV<K, V> previous) {
        this.previous = previous;
    }

    public NodeV<K, V> getNext() {
        return next;
    }

    public void setNext(NodeV<K, V> next) {
        this.next = next;
    }

}