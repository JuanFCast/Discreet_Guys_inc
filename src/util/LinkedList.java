package util;

public class LinkedList<T> {
    private NodeH<T> head;
    private int size;

    public LinkedList(){
        head = null;
        size = 0;
    }

    public NodeH<T> getHead() {
        return head;
    }
    
    public boolean isEmpty() {
        return (head == null) ? true : false;
    }
    
    public int size() {
        return size;
    }
    
    public void add(T t) {

        NodeH<T> node = new NodeH<T>(t);


        if (head==null){
            head=node;
        }else{
            NodeH<T> aux=head;
       
            while (aux.getNext()!=null) {
                aux=aux.getNext();
            }
    
            aux.setNext(node);
        }
       

        size += 1;
    }
    
    public int indexOf(T t) {
        return indexOf(t, head, 0);
    }
    
    private int indexOf(T t, NodeH<T> temp, int contador) {
        if (t.equals(temp.getValue())) {
            return contador;

        } else {
            return indexOf(t, temp.getNext(), contador + 1);

        }
    }
    
    
    public T get(int index) {

        return get(index, head);

    }
    
    
    private T get(int index, NodeH<T> temp) {

        if (index == 0) {
            return temp.getValue();

        } else {
            return get(index - 1, temp.getNext());

        }

    }
    
    
    public T remove(int index) {

        return get(index, head);

    }
    
    


}