package ui;

import java.io.IOException;


public class Main {
    
    private App app;

    public Main(){
        app = new App();
    }

    public static void main(String [] team){
        Main m = new Main();
        
        try {
            m.app.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
