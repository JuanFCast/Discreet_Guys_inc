package ui;

public class Menu {
    
    private String message;

    public Menu(String m){
        message = m;
    }

    public void showMenu(){
        System.out.print(message);
    }
}
