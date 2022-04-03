package util;

public class NodeV<T> implements Comparable<T>{

    private T value;

    private NodeV<T> up;
    private NodeV<T> down;

    //Construct
    public NodeV(T v){
        value = v;
        up = null;
        down = null;
    }

    @SuppressWarnings("unchecked")
    public int compareTo(T i) {
        return ((Comparable<T>) value).compareTo(i);
    }

    //Getters & Setters
    public T getValue(){
        return value;
    }
    public NodeV<T> getDown() {
        return down;
    }
    public void setDown(NodeV<T> d) {
        down = d;
    }
    public NodeV<T> getUp() {
        return up;
    }
    public void setUp(NodeV<T> u) {
        up = u;
    }

}