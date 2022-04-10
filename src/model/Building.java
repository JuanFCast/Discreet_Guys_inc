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

        elevator = new Elevator(f, mp);
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

    public Integer getIndexFloorKnowingOffice(Integer o){
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


    public void addInElevator(Person p) throws InterruptedException{
        if(elevator.isEmpty()){
            elevator.addInElevator(getIndexFloorKnowingOffice(p.getDestination()), p);
            startElevator();
        } else{
            elevator.addInElevator(getIndexFloorKnowingOffice(p.getDestination()), p);
        }
        
    }

    //Por aca ando
    private void startElevator() throws InterruptedException{
        Thread t = new Thread() {
			public void run() {
				for(; elevator.isEmpty() == false;){
                    Queue<Person> q = elevator.leave();
                
                    if(q != null){
                        Person p = q.peek();
                        do{
                            p = q.poll();
                            int f = elevator.getFloorStill();
                            getAnyFloor(f).putAPersonInOffice(p, p.getDestination());
                            p = q.peek();
                        }while(p != null);
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {}
				}
			};
		};

		t.start();
        t.join();
    }

    public boolean elevatorIsEmpty(){
        return elevator.isEmpty();
    }


    public String getId(){
        return id;
    }

    public String toString(){
        String s = "Edificio " + id;
        s += "\nCon pisos: \n";

        for(int i = 1; i <= totalFloors; i++){
            s += floors.get(i) + "\n";
        }

        return s;
    }

}
