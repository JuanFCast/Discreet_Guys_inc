package exceptions;

public class HashMapOverFlow extends Exception{

    private static final long serialVersionUID = 1L;

    public HashMapOverFlow(){
        super("HashMap is overflow");
    }
}
