package model;

import util.*;


public class Floor {
    
    private Integer floorID;
    private HashTable<Integer, Office> offices;
    private int nOffInFloor, minOff, maxOff;
    private Queue<Person> waitingQueue;

    public Floor(int fID, int o, int nOff, int maxPeople){
        floorID = fID;
        nOffInFloor = o;
        minOff = nOff - nOffInFloor + 1;
        maxOff = nOff;
        offices = new HashTable<>();
        waitingQueue = new Queue<>(maxPeople);
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
            return true;
        } else{
            for(int i = minOff; i <= maxOff; i++){
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

    public void waitingForElevator(Person p){
        waitingQueue.add(p);
    }

    public Queue<Person> getWaitingQueue(){
        return waitingQueue;
    }

    public String toString(){
        String s = "N°" +  floorID + " with offices: |";

        for(int i = minOff; i <= maxOff; i++){
            s += offices.get(i);
        }
        

        return s + "|";
    }

}
