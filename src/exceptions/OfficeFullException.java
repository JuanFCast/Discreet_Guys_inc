package exceptions;

public class OfficeFullException extends Exception{

    private static final long serialVersionUID = 1L;

    public OfficeFullException(){
        super("The offices are full");
    }
}
