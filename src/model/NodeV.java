package model;

public class NodeV<K, V> {

    private K key;
    private V value;

    private NodeV<K, V> up;
    private NodeV<K, V> down;

    public NodeV(K key, V value){
        this.key = key;
        this.value = value;
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