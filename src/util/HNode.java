package util;

public class HNode<K, V>{

    private K key;
    private V value;

    private HNode<K, V> next;
    private HNode<K, V> prev;

    public HNode(K key, V value){
        this.key = key;
        this.value = value;
    }


    //Getters & Setters
    public K getKey(){
        return key;
    }
    public V getValue(){
        return value;
    }
    public void setNext(HNode<K, V> n){
        next = n;
    }
    public void setPrev(HNode<K, V> p){
        prev = p;
    }
    public HNode<K, V> getNext(){
        return next;
    }
    public HNode<K, V> getPrev(){
        return prev;
    }

}