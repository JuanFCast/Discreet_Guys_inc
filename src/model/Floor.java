package model;

import util.HashTable;

public class Floor {
    
    private Integer floorID;
    private HashTable<Integer, Office> offices;
    private int nOffInFloor, minOff, maxOff;

    public Floor(int fID, int o, int nOff){
        floorID = fID;
        nOffInFloor = o;
        minOff = nOff - nOffInFloor;
        maxOff = nOff;
        offices = new HashTable<>();
        int n = nOff;

        for(int i = 0; i < o; i++){
            Office office = new Office(n, fID);
            offices.put(n, office);
            n--;
        }
    }

    public Office getAnyOffice(Integer k){
        return offices.get(k);
    }

    public boolean putAPersonInOffice(Person p, Integer o){
        if(offices.get(o).isEmpty() == true){
            p.setOffice(o);
            p.setFloor(floorID);
            offices.get(o).addPerson(p);
        } else{
            for(int i = minOff+1; i <= maxOff; i++){
                if(offices.get(i).isEmpty() == true){
                    p.setOffice(i);
                    p.setFloor(floorID);
                    offices.get(i).addPerson(p);
                    return true;
                }
            }
        }

        return false;
    }

    public String toString(){
        String s = floorID + "with offices: \n";

        return s;
    }

}
