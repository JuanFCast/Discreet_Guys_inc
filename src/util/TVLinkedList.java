package util;

public class TVLinkedList <K, V>{
    
    private HNode<K, V> first;
    private HNode<K, V> last;

    public TVLinkedList(){
        first = null;
        last = null;
    }

    public void add(HNode<K, V> node){
        if(first == null){
            first = node;
            last = node;
            first.setNext(last);
            first.setPrev(last);
            last.setPrev(first);
            last.setNext(first);
        } else{
            HNode<K, V> aux = last;
            aux.setPrev(last.getPrev());
            last.getPrev().setNext(aux);
            last = node;
            aux.setNext(last);
            last.setPrev(aux);
            last.setNext(first);
        }
    }

    public HNode<K, V> search(K key){
        if(first != null){
            if(first.getKey().equals(key)){
                return first;
            } else{
                return search(key, first.getNext());
            }
        } else{
            return null;
        }
    }

    private HNode<K, V> search(K key, HNode<K, V> current){
        if(current != first){
            if(current.getKey().equals(key)){
                return current;
            } else{
                return search(key, current.getNext());
            }
        } else{
            return null;
        }
    }

    public void remove(HNode<K, V> node){
        if(node.getNext() != node){
            node.getPrev().setNext(node.getNext());
        } else{
            first = null;
            last = null;
        }
    }

    public Set<HNode<K, V>> values(){
        Set<HNode<K, V>> s = new Set<>();

        return s;
    }

    /*public void print(){
        if(first != null){
            System.out.print(first.getKey() + ", ");
            print(first.getNext());
        } else{
            System.out.println("Vacio");
        }
    }

    private void print(HNode<K, V> n){
        if(n != first){
            System.out.print(n.getKey() + ", ");
            print(n.getNext());
        }
    }*/
}
