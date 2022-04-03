package model;

import util.*;

public class Building {
    
    private String id;
    private HashTable<Integer, Floor> floors;
    private int totalFloors;
    private int officePerFloor;
    private int tOffices;

    public Building(String id, Queue<String> p, int f, int o){
        this.id = id;
        totalFloors = f;
        officePerFloor = o;
        tOffices = f*o;

        floors = new HashTable<>();
        
        for(int i = 1; i <= f; i++){
            Floor fl = new Floor("Floor #" + i, officePerFloor, tOffices);
            floors.put(i, fl);
            tOffices = tOffices - o;
        }
    }

    public Floor getAnyFloor(Integer k){
        return floors.get(k);
    }

    //El metodo lloron
    public Office getAnyOffice(Integer o){
        int toff = totalFloors*officePerFloor;
        int floor = (int)(((toff - o))/officePerFloor)+1;

        return floors.get(floor).getAnyOffice(o);
    }

    public String getId(){
        return id;
    }

}
