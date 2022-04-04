package model;

import util.*;

public class Elevator{

    private PriorityQueue<Integer> elevator;
    private Integer stillInFloor, maxFloor, minFloor;
    private String state;


    // por default el elevador comienta en el piso 1, por lo que crea un MIN_HEAP por default  :D
    public Elevator(int m){
        elevator = new PriorityQueue<Integer>(HeapTYPE.MIN_HEAP);
        stillInFloor = 1;
        minFloor = 1;
        maxFloor = m;
        state = "still";
    }

    private void change(String s){
        if(state.equals("up")){
            elevator.setType(HeapTYPE.MIN_HEAP);
        }else if(state.equals("down")){
            elevator.setType(HeapTYPE.MAX_HEAP);
        }
    }

    public void addInElevator(Integer f){
        if(isEmpty() == true){
            elevator.add(f);
            if(f > stillInFloor){
                state = "up";
            } else{
                state = "down";
            }
            start();
        } else{
            elevator.add(f);
        }
    }

    public void start(){
        Thread t = new Thread(){
            public void run(){
                for(;isEmpty() == false;){
                    controller();
                    if(state.equals("up")){
                        stillInFloor++;
                    } else{
                        stillInFloor--;
                    }
                    try {
                        Thread.sleep(1200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t.run();
    }
    
    private void controller(){
        if(minFloor != maxFloor){
            if(stillInFloor == maxFloor){
                change("down");
                state = "down";
            }
    
            if(stillInFloor == minFloor){
                change("up");
                state = "up";
            }
        }
    }

    private Integer leave(){
        return elevator.poll();
    }

    public Integer getFloorStill(){
        return stillInFloor;
    }

    public boolean isEmpty(){
        return elevator.isEmpty();
    }

}