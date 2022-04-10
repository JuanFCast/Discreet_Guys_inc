package model;

import util.*;

public class Elevator {

    private PriorityQueue<Integer> controller;
    private Queue<Person> cabin;
    private Integer stillInFloor, maxFloor, minFloor;
    private String state;
    private Timer timer;


    // por default el elevador comienta en el piso 1, por lo que crea un MIN_HEAP por default  :D
    public Elevator(int m, int t){
        controller = new PriorityQueue<Integer>(HeapTYPE.MIN_HEAP);
        cabin = new Queue<>(t);
        timer = new Timer();
        stillInFloor = 1;
        minFloor = 1;
        maxFloor = m;
        state = "still";
    }

    private void change(){
        if(state.equals("up")){
            controller.setType(HeapTYPE.MIN_HEAP);
        }else if(state.equals("down")){
            controller.setType(HeapTYPE.MAX_HEAP);
        }
    }

    public void addInElevator(Integer f, Person p) throws InterruptedException{
        if(isStill() == true){
            controller.add(f);
            cabin.add(p);
            if(f > stillInFloor){
                state = "up";
            } else{
                state = "down";
            }
            startTimer();
            return;
        } else{
            if(controller.contains(f)){
                cabin.add(p);
            } else{
                controller.add(f);
                cabin.add(p);
            }
            timer.restart(); 
        }
    }

    public void move(){
        elevatorController();
        if(stillInFloor != controller.element()){
            if(state.equals("up")){
                stillInFloor++;
            } else{
                stillInFloor--;
            }
        }
    }
    
    private void elevatorController(){
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

    public Queue<Person> leave(){
        Integer f = controller.peek();

        if(stillInFloor.equals(f)){
            Queue<Person> l = new Queue<>(cabin.size());
            controller.poll();
            int c = cabin.size();

            for(int i = 0; i < c; i++){
                if(cabin.peek() != null){
                    Person p = cabin.poll();
                    if(p.whereIsMyOffice() == f){
                        l.add(p);
                    } else{
                        cabin.add(p);
                    }
                }
            }

            timer.startTimer();
            return l;
        } else{
            move();
            return null;
        }       
    }

    private void startTimer() throws InterruptedException {

		Thread t = new Thread() {
			public void run() {
				for(; timer.timeIsOver() == false;){
					timer.startTimer();
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {}

				}
			};
		};

		t.start();
        move();
        timer.restart();
	}

    public void restart(){
        stillInFloor = 1;
        state = "up";
    }

    public int nextFloor(){
        return controller.peek();
    }

    public Queue<Person> getCabin(){
        return cabin;
    }

    public Integer getFloorStill(){
        return stillInFloor;
    }

    private boolean isStill(){
        return controller.isEmpty();
    }

    public boolean isEmpty(){
        return cabin.isEmpty();
    }

    public void putInCabin(Person p){
        cabin.add(p);
    }

}