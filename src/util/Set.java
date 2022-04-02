package util;

import java.util.ArrayList;
import java.util.List;

public class Set <T>{
    
    private Element<T> elements;

    public Set(){
        elements = null;
    }

    //Methods
    public void add(Element<T> e){
        if(elements == null){
            elements = e;
            elements.setNext(elements);
            elements.setPrev(elements);
        } else{
            if(contains(e) == false){
                add(e, elements);
            }
        }
    }

    private void add(Element<T> e, Element<T> current){
        if(current.getNext() == elements){
            current.setNext(e);
            current.getNext().setPrev(current);
            current.getNext().setNext(elements);
        } else{
            add(e, current.getNext());
        }
    }

    public void remove(){

    }

    public Set<T> union(Set <T> set){
        Set<T> union = new Set<>();
        if(set.isEmpty()){
            return this;
        } else if(isEmpty()){
            return union;
        } else{
            union.add(new Element<>(elements.getListofElements()));
            union(elements.getNext(), elements, union);
            union.add(new Element<>(set.getElements().getListofElements()));
            union(set.getElements().getNext(), set.getElements(), union);
            return union;
        }
    }

    private void union(Element<T> current, Element<T> head, Set<T> set){
        if(current != head){
            set.add(new Element<>(current.getListofElements()));
            union(current.getNext(), head, set);
        }
    }

    public Set<T> intersection(Set <T> set){
        Set<T> intction = new Set<>();
        if(set.isEmpty()){
            return null;
        } else if(isEmpty()){
            return null;
        } else{
            System.out.println("Aca 3");
            List<Element<T>> list = new ArrayList<>();
            list.add(new Element<>(elements.getListofElements()));
            addToList(elements.getNext(), elements, list);
            List<Element<T>> intersect = new ArrayList<>();
            if(list.contains(elements)){
                intersect.add(new Element<>(elements.getListofElements()));
            }
            getIntersection(elements.getNext(), elements, list, intersect);
            addRepeater(intersect, intction);

            return intction;
        }
    }

    private void addToList(Element<T> e, Element<T> head, List<Element<T>> l){
        if(e != head){
            l.add(new Element<>(e.getListofElements()));
            addToList(e.getNext(), head, l);
        }
    }

    private void getIntersection(Element<T> e, Element<T> head, List<Element<T>> l, List<Element<T>> inter){
        if(e != head){
            if(l.contains(e)){
                inter.add(new Element<>(e.getListofElements()));
            }
            getIntersection(e.getNext(), head, l, inter);
        }
    }

    private void addRepeater(List<Element<T>> inter, Set<T> intction){
        for (Element<T> e : inter) {
            intction.add(new Element<>(e.getListofElements()));
        }
    }

    public void symmetricDifference(){
        
    }

    public boolean belongsTo(){
        return true;
    }

    public int cardinality(){
        if(elements == null){
            return 0;
        } else{
            if(elements.getNext() == elements){
                return 1;
            } else{
                return cardinality(elements.getNext(), 1);
            }
        }
        
    }

    public int cardinality(Element<T> e, int c){
          if(e.getNext() != elements){
            return cardinality(e.getNext(), c++);
          } else{
              return c + 1;
          }
    }

    public boolean contains(Element<T> e){
        if(elements != null){
            if(elements.getNext() == elements){
                if(elements.equals(e)){
                    return true;
                } else{
                    return false;
                }
            } else{
                if(elements.equals(e)){
                    return true;
                } else{
                    return contains(e, elements.getNext());
                }
            }
        } else{
            return false;
        }
    }

    private boolean contains(Element<T> e, Element<T> current){
        if(current != elements){
            if(current.equals(e)){
                return true;
            } else{
                return contains(e, current.getNext());
            }
        } else{
            return false;
        }
    }

    public boolean isEmpty(){
        return(elements == null)?true:false;
    }

    public Element<T> getElements(){
        return elements;
    }

    //ToString
    public String toString(){
        String s = "{";
        if(elements != null){
            if(elements.getNext() == elements){
                s += elements.toString();
            } else{
                s += elements.toString();
                s += ", ";
                s += toString(elements.getNext());
            }
        }
        s+= "}";
        return s;
    }

    private String toString(Element<T> current){
        String s = "";

        if(current != elements){
            s += current.toString();
            if(current.getNext() != elements){
                s += ", ";
            }
            s += toString(current.getNext());
        }

        return s;
    }

}
