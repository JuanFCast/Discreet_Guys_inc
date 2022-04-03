package model;

import util.HashTable;

public class Floor {
    
    private String floorID;
    private HashTable<Integer, Office> offices;

    public Floor(String fID, int o, int nOff){
        floorID = fID;
        offices = new HashTable<>();
        int n = nOff;

        for(int i = 0; i < o; i++){
            Office office = new Office("Office #" + n, fID);
            offices.put(n, office);
            n--;
        }
    }

    public Office getAnyOffice(Integer k){
        return offices.get(k);
    }

    public String toString(){
        String s = floorID + "with offices: \n";

        return s;
    }

}
