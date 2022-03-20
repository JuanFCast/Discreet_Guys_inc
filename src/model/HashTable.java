package model;

public class HashTable<K, V> {
    
    private int MAX_SIZE = 23;
    private TVLinkedList<K, V> table[]; 

    public HashTable(){
       table = (TVLinkedList<K, V>[]) new TVLinkedList<?,?>[MAX_SIZE];
       for (int i = 0; i < MAX_SIZE; i++) {
           TVLinkedList<K, V> l = new TVLinkedList<>();
           table[i] = l;
       }
    }

    public int hash(K k){
        Integer key = 0;
        Integer hvalue = k.hashCode();

        key = hvalue%MAX_SIZE;

        return Math.abs(key);
    }

    public void put(K key, V value){
        int hash = hash(key);
        HNode<K,V> n = new HNode<>(key, value);

        table[hash].add(n);
    }

    public V get(K k){
        int hash = hash(k);
        HNode<K, V> n = table[hash].search(k);

        if(n != null){
            return n.getValue();
        } else{
            return null;
        }
    }

    public void remove(K k){
        int hash = hash(k);
        HNode<K, V> n = table[hash].search(k);
        table[hash].remove(n);
    }
}
