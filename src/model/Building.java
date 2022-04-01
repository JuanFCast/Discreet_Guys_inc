package model;

import exceptions.HashMapOverFlow;
import util.*;

public class Building {
    
    private String id;
    private HashTable<Integer, HashTable<Integer, Person>> floor;

    public Building(String i, Queue<String> p, int f, int o) throws HashMapOverFlow{
        id = i;
        floor = new HashTable<Integer, 
        HashTable<Integer, Person>>(f);

        int tOffice = f*o;

        for(int j = 0; j < f; j++){
            floor.put(j, new HashTable<Integer, Person>());
            for(int h = 0; h < o; h++){
                floor.get(j).put(tOffice, null);
                tOffice--;
            }
        }
    }

    public String getId(){
        return id;
    }

}
