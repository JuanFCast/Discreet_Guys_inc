package model;

public class Person {
    
    private String name;
    private Integer stillInFloor, stillInOffice, 
    destinationFloor, destinationOffice;

    public Person(String name, Integer f, Integer o){
        this.name = name;
        destinationFloor = f;
        destinationOffice = o;
        stillInFloor = null;
        stillInOffice = null;
    }

    public void setOffice(Integer o){
        stillInOffice = o;
    }

    public void setFloor(Integer f){
        stillInFloor = f;
    }

    public Integer getFloor(){
        return stillInFloor;
    }

    public Integer getDestination(){
        return destinationOffice;
    }

    public Integer whereIsMyOffice(){
        return destinationFloor;
    }


    public String getName(){
        return name;
    }

    public String toString(){
        if(name != null){
            return name + " is on #" + stillInFloor + " floor at the office #" + stillInOffice;
        } else{
            return "The office is Empty";
        }
    }

}
