package model;

public class Office {
    
    private Person person;
    private String officeID;

    public Office(String offID){
        officeID = offID;
        person = null;
    }

    public void addPerson(String n){
        person = new Person(n);
    } 

    public String removePerson(){
        String s = person.getName();
        person = null;

        return s;
    }

    public boolean isEmpty(){
        return (person != null)?true:false;
    }

    public String toString(){
        String s = "[ " + officeID;

        if(person != null){
            s += "= " +  person.getName();
        } else{
            s += " is Empty";
        }

        return s + " ]";
    }

}
