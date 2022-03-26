package model;

public class Building {
    
    private String id;
    private HashTable<Integer, String>[] floor;

    @SuppressWarnings("unchecked")
    public Building(String i, Queue<String> p, int f, int o){
        id = i;
        floor = (HashTable<Integer, String>[]) new HashTable<?,?>[f];
        for(int j = 0; j < floor.length; j++){
            floor[j] = new HashTable<Integer, String>(o);
        }
    }

    public String getId(){
        return id;
    }

}
