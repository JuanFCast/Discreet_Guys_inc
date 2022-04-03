package model;

public class Office {
    
    private Person person;
    private Integer officeID;
    private Integer floor;

    public Office(Integer offID, Integer f){
        officeID = offID;
        floor = f;
        person = null;
    }

    public void addPerson(Person p){
        person = p;
    } 

    public Person removePerson(){
        Person p = person;
        person = null;

        return p;
    }

    public boolean isEmpty(){
        return (person == null)?true:false;
    }

    public Integer isInFloor(){
        return floor;
    }

    public Person getPerson(){
        return person;
    }

    public String toString(){
        String s = "[ " + officeID;

        if(person != null){
            s += " = " +  person.getName();
        } else{
            s += " is Empty";
        }

        return s + " ]";
    }

}
