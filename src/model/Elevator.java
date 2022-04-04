package model;

import util.*;

public class Elevator{

    private PriorityQueue<Integer> elevator;
    private Queue<Person> cabin;
    private Integer stillInFloor, maxFloor, minFloor;
    private String state;


    // por default el elevador comienta en el piso 1, por lo que crea un MIN_HEAP por default  :D
    public Elevator(int m, int t){
        elevator = new PriorityQueue<Integer>(HeapTYPE.MIN_HEAP);
        cabin = new Queue<>(t);
        stillInFloor = 1;
        minFloor = 1;
        maxFloor = m;
        state = "still";
    }

    private void change(){
        if(state.equals("up")){
            elevator.setType(HeapTYPE.MIN_HEAP);
        }else if(state.equals("down")){
            elevator.setType(HeapTYPE.MAX_HEAP);
        }
    }

    public void addInElevator(Integer f, Person p){
        if(isEmpty() == true){
            elevator.add(f);
            cabin.add(p);
            if(f > stillInFloor){
                state = "up";
            } else{
                state = "down";
            }
        } else{
            elevator.add(f);
            cabin.add(p);
        }
    }

    public void start(){
        Thread t = new Thread(){
            public void run(){
                controller();
                if(state.equals("up")){
                    stillInFloor++;
                } else{
                    stillInFloor--;
                }
            }
        };
        t.run();
    }
    
    private void controller(){
        if(minFloor != maxFloor){
            if(stillInFloor == maxFloor){
                state = "down";
                change();
            }
    
            if(stillInFloor == minFloor){
                state = "up";
                change();
            }
        }
    }

    public Integer leave(){
        return elevator.poll();
    }

    public Queue<Person> getCabin(){
        return cabin;
    }

    public Integer getFloorStill(){
        return stillInFloor;
    }

    public boolean isEmpty(){
        return elevator.isEmpty();
    }

    public void putInCabin(Person p){
        cabin.add(p);
    }

}