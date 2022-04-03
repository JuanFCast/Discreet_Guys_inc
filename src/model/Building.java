package model;

import util.HashTable;


public class Building {
    
    private String id;
    private HashTable<Integer, Floor> floors;
    private int totalFloors;
    private int officePerFloor;
    private int tOffices;

    public Building(String id, int f, int o){
        this.id = id;
        totalFloors = f;
        officePerFloor = o;
        tOffices = f*o;

        floors = new HashTable<>();
        
        for(int i = 1; i <= f; i++){
            Floor fl = new Floor(i, officePerFloor, tOffices);
            try {
				floors.put(i, fl);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
            tOffices = tOffices - o;
        }
    }

    public Floor getAnyFloor(Integer f){
        return floors.get(f);
    }

    public Floor getFloorKnowingOffice(Integer o){
        int toff = totalFloors*officePerFloor;
        int floor = (int)(((toff - o))/officePerFloor)+1;

        return floors.get(floor);
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
