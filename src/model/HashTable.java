package model;

import exceptions.OfficeFullException;

public class HashTable<K, V> {
    
    private int MAX_SIZE;
	private TVLinkedList<K, V> table[]; 
	private boolean verify = false;


	@SuppressWarnings("unchecked")
	public HashTable(){
		MAX_SIZE = 23;
		verify = true;
		table = (TVLinkedList<K, V>[]) new TVLinkedList<?,?>[MAX_SIZE];
		for (int i = 0; i < MAX_SIZE; i++) {
			TVLinkedList<K, V> l = new TVLinkedList<>();
			table[i] = l;
		}
	}

	@SuppressWarnings("unchecked")
	public HashTable(int s){
		MAX_SIZE = s;
		table = (TVLinkedList<K, V>[]) new TVLinkedList<?,?>[MAX_SIZE];
		for (int i = 0; i < MAX_SIZE; i++) {
			TVLinkedList<K, V> l = new TVLinkedList<>();
			table[i] = l;
		}
	}

    public Integer hash(K k){
		int c = 0;
		Integer hvalue = k.hashCode();
		Integer key = 0;
		
		
		if(verify == true) {
			key = hvalue%MAX_SIZE;
		} else {
			if(table[hvalue-1] == null) {
				key = hvalue-1;
			} else {
				boolean b = false;
				for (int i = 0; i < MAX_SIZE && b == false; i++) {
					if(table[i] == null) {
						key = i;
						b = true;
					} else {
						c++;
					}
				}
			}
		}
		
		if(c == MAX_SIZE) {
			return null;
		} else {
			return key;
		}
	}

    public void put(K key, V value) throws OfficeFullException{
		Integer hash = hash(key);
		
		if(hash != null) {
			HNode<K,V> n = new HNode<>(key, value);

			table[hash].add(n);
		} else {
			throw new  OfficeFullException();
		}
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
