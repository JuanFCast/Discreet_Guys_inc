package util;

import exceptions.HashMapOverFlow;

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
		Integer hvalue = k.hashCode();
		Integer key = 0;

		if(verify == true) {
			key = hvalue%MAX_SIZE;
		} else {
			key = (hvalue-1)%MAX_SIZE;
		}

		return key;
	}

    public void put(K key, V value) throws HashMapOverFlow{
		int c = 0;
		Integer hash = hash(key);
		
		if(table[hash] == null) {
			HNode<K,V> n = new HNode<>(key, value);
			table[hash].add(n);
		} else {
			boolean s = false;

			for(int i = 0; i < MAX_SIZE && s == false; i++){
				if(table[i] == null){
					HNode<K,V> n = new HNode<>(key, value);
					table[i].add(n);
					s = true;
				} else{
					c++;
				}
			}
		}

		if(c == MAX_SIZE){
			throw new  HashMapOverFlow();
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
