package model;

public class NodeV<T> {

    private T name;

    public NodeV(T name){
        up = null;
        down = null;
    }

    public NodeV<K, V> getDown() {
        return down;
    }

    public void setDown(NodeV<K, V> down) {
        this.down = down;
    }

    public NodeV<K, V> getUp() {
        return up;
    }

    public void setUp(NodeV<K, V> up) {
        this.up = up;
    }

}