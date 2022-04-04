package model;

public class Person {
    
    private String name;
    private Integer stillInFloor;
    private Integer stillInOffice;
    private Integer destinationFloor;

    public Person(String name, Integer f){
        this.name = name;
        destinationFloor = f;
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
