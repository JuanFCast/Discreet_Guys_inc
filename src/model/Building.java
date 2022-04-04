package model;

import util.HashTable;
import util.Queue;


public class Building {
    
    private String id;
    private HashTable<Integer, Floor> floors;
    private int totalFloors;
    private int officePerFloor;
    private int tOffices;
    private Elevator elevator;

    public Building(String id, int mp, int f, int o){
        this.id = id;
        totalFloors = f;
        officePerFloor = o;
        tOffices = f*o;

        elevator = new Elevator(f);
        floors = new HashTable<>();
        
        for(int i = 1; i <= f; i++){
            Floor fl = new Floor(i, officePerFloor, tOffices, mp);
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

    private Integer getIndexFloorKnowingOffice(Integer o){
        int toff = totalFloors*officePerFloor;
        int floor = (int)(((toff - o))/officePerFloor)+1;

        return floor;
    }

    //El metodo lloron
    public Office getAnyOffice(Integer o){
        int toff = totalFloors*officePerFloor;
        int floor = (int)(((toff - o))/officePerFloor)+1;

        return floors.get(floor).getAnyOffice(o);
    }

    public void addInElevator(Person p){
        boolean b = getAnyFloor(elevator.getFloorStill()).getWaitingQueue().isEmpty();
        if(b == true){
            if(p.getFloor() == elevator.getFloorStill()){
                int i = getIndexFloorKnowingOffice(p.getDestination());
                elevator.addInElevator(i);
            } else{
                getAnyFloor(p.getFloor()).waitingForElevator(p);
            }
        } else{
            Queue<Person> q = getAnyFloor(elevator.getFloorStill()).getWaitingQueue();

            for(int i = 0; i < q.size(); i++){
                int index = getIndexFloorKnowingOffice(q.poll().getDestination());
                elevator.addInElevator(index);
            }

            if(p.getFloor() == elevator.getFloorStill()){
                int i = getIndexFloorKnowingOffice(p.getDestination());
                elevator.addInElevator(i);
            } else{
                getAnyFloor(p.getFloor()).waitingForElevator(p);
            }
        }
    }


    public String getId(){
        return id;
    }

}
