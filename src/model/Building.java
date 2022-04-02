package model;

import util.*;

public class Building {
    
    private String id;
    private HashTable<Integer, Floor> floors;

    public Building(String id, Queue<String> p, int f, int o){
        this.id = id;
        floors = new HashTable<>();
        int tOffices = f*o;

        for(int i = 0; i < f; i++){
            Floor fl = new Floor("Floor #" + i, o, tOffices);
            floors.put(i, fl);
            tOffices = tOffices - o;
        }
    }

    public Floor getAnyFloor(Integer k){
        return floors.get(k);
    }

    public String getId(){
        return id;
    }

}
