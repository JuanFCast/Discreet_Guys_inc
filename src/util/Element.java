package util;

import java.util.ArrayList;
import java.util.List;

public class Element<T> {

    private NodeH<T> head;
    private Element<T> nextElement;
    private Element<T> prevElement;
    private int size;
    private List<T> items;

    /*
    * Recibo una lista porque la idea es que cuando se define un elemento
    * este ya sea estatico y no tenga la posibilidad de modificarlo (El elemento)
    * Ej: El set: {(5,6,7), 2, (4)}
    * No es como que vaya a cambiar los items del (5, 6, 7)
    */
    public Element(List<T> it){
        this.items = it;
        head = null;
        size = 0;
        for (T i : items) {
            add(i);
            size++;
        }
    }

    private void add(T item){
       if(head == null){
            head = new NodeH<T>(item);
            head.setNext(head);
            head.setPrev(head);
       } else{
            add(item, head);
       }
    }

    private void add(T item, NodeH<T> current){
        if(current.getNext() == head){
             current.setNext(new NodeH<T>(item));
             current.getNext().setPrev(current);
             current.getNext().setNext(head);
        } else{
            add(item, current.getNext());
        }
     }

    public int size(){
        return size;
    }


    //Getters y Setters
    public Element<T> getNext(){
        return nextElement;
    }

    public Element<T> getPrev(){
        return prevElement;
    }

    public void setNext(Element<T> e){
        nextElement = e;
    }

    public void setPrev(Element<T> e){
        prevElement = e;
    }

    public boolean contains(T i){
        if(head != null){
            if(head.getNext() == head){
                if(head.compareTo(i) == 0){
                    return true;
                } else{
                    return false;
                }
            } else{
                return contains(i, head.getNext());
            }
        } else{
            return false;
        }
    }

    private boolean contains(T i, NodeH<T> current){
        if(current != head){
            if(current.compareTo(i) == 0){
                return true;
            } else{
                return contains(i, current.getNext());
            }
        } else{
            return false;
        }
    }

    public boolean equals(Element<T> e){
        List<T> list1 = new ArrayList<>(); 
        List<T> list2 = new ArrayList<>(); 

        if(e.getNodes() != null){
            list1.add(e.getNodes().getValue());
            prepareList(e.getNodes().getNext(), e.getNodes(), list1);
        }

        if(head != null){
            list2.add(head.getValue());
            prepareList(head.getNext(), head, list2);
        }

        if(list1.equals(list2)){
            return true;
        } else{
            return false;
        }
       
    }

    private void prepareList(NodeH <T> current, NodeH <T> n, List<T> l){
        if(current != n){
            l.add(current.getValue());
            prepareList(current.getNext(), n, l);
        }
    }

    public NodeH<T> getNodes(){
        return head;
    }

    public List<T> getListofElements(){
        return items;
    }

    //ToString pendiente hacer el toString
    public String toString(){
        if(head.getNext() == head){
            return head.toString();
        } else{
            String s = "(";
            s += head.toString();
            s += ", ";
            s += toString(head.getNext());
            s += ")";
            return s;
        }
    }

    private String toString(NodeH <T> current){
        String s = "";

        if(current != head){
            s += current.toString();
            if(current.getNext() != head){
                s += ", ";
            }
            s += toString(current.getNext());
        }

        return s;
    }

}