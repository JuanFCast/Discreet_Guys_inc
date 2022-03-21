package ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {

    private BufferedReader br;

    public App(){
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public void start() throws IOException{
        logoMenu();
        startMenu();
    }

    private void logoMenu(){
        Menu m = new Menu("|   ==============================================\n"
        +                 "|   ====          ELEVATOR SIMULATOR          ====\n"
        +                 "|   ====          Discreet Guys Inc.          ====\n"
        +                 "|   ==============================================\n|\n");
        m.showMenu();
    }

    private void startMenu() throws IOException{
        Menu m = new Menu("| - ELEVATOR SIMULATOR es una app que nos permitira\n" 
        +                 "|   simular el funcionamiento de los elevadores de \n"
        +                 "|   los nuevos edificios que se planean construir...\n"
        +                 "|\n"
        +                 "| - Para empezar, debemos definir el numero de \n" 
        +                 "|   edificios que usara el simulador...\n"
        +                 "|   N° de Edificios: ");
        m.showMenu();

        String b = br.readLine();
    }

}
