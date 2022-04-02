package util;


public class HashTable<K, V> {
    
    private final int MAX_SIZE = 23;
	private TVLinkedList<K, V> table[]; 


	@SuppressWarnings("unchecked")
	public HashTable(){
		table = (TVLinkedList<K, V>[]) new TVLinkedList<?,?>[MAX_SIZE];
	}

    public Integer hash(K k){
		Integer hvalue = k.hashCode();
		Integer key = 0;
		key = hvalue%MAX_SIZE;

		return key;
	}

    public void put(K key, V value) {
		Integer hash = hash(key);
		
		HNode<K,V> n = new HNode<>(key, value);
		if(table[hash] != null){
			table[hash].add(n);
		} else{
			TVLinkedList<K, V> l = new TVLinkedList<>();
			table[hash] = l;
			table[hash].add(n);
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

	public void values(){
		Set<Integer> s = new Set<>();

		for (TVLinkedList<K,V> tvLinkedList : table) {
			
		}
		return ;
	}
}
