package model;

import util.*;

public class Elevator{

    private PriorityQueue<Integer> elevator;

    // por default el elevador comienta en el piso 1, por lo que crea un MIN_HEAP por default  :D
    public Elevator{
        elevator = new PriorityQueue<Integer>(HeapTYPE.MIN_HEAP);
    }

    private change(String s){
        if(s=="up"){
            elevator.setType(HeapTYPE.MIM_HEAP);
        }else if(s=="dowm"){
            elevator.setType(HeapTYPE.MAX_HEAP);
        }
    }

    private addfloors(Integer f){
        elevator.add(f);
    }

    private Integer leave(){
        return elevator.poll();
    }

}