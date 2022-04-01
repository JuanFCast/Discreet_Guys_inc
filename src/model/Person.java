package model;

public class Person {
    
    private String name;
    private Integer stillInFloor;
    private Integer stillInOffice;

    public Person(){
        name = null;
        stillInFloor = null;
        stillInOffice = null;
    }

    public Person(String n, int f, int o){
        name = n;
        stillInFloor = f;
        stillInOffice = o;
    }


    public String getName(){
        return name;
    }

    public String toString(){
        if(name != null){
            return name + " is on #" + stillInFloor + " floor at office" + stillInOffice;
        } else{
            return "The office is Empty";
        }
    }

}
