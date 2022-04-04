package ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.Hashtable;
import java.util.LinkedList;

import model.Building;
import model.Person;

public class App {

    private BufferedReader br;
    private Building[] builders;
    //private Hashtable<Integer, String> li = new Hashtable<>();

    public App(){
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public void start() throws IOException{
        logoMenu();
        startMenu();
        ConstructApp();
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
        int n = Integer.parseInt(b);
        builders = new Building[n];
        System.out.println("|===================================================");
    }

    private void ConstructApp() throws IOException{
        rulesApp();
        int s = 1;

        while(s <= builders.length){
            System.out.print("| - Construyendo el Edificio #" + s + "...\n"
            +                "|   - Cadena de valores: ");

            String c[] = br.readLine().split(" ");
            int n = Integer.parseInt(c[1]);
            builders[s-1] = new Building(c[0], Integer.parseInt(c[1]), Integer.parseInt(c[2]), Integer.parseInt(c[3]));

            System.out.println("\n|   - Ahora ingresaremos el nombre de cada\n"
            +                  "|     persona que se encuentra en el edificio (" + c[0] + "),\n"
            +                  "|     seguido del piso donde se encuentra y por\n"
            +                  "|     ultimo la oficina donde desea ir trasladarse\n"
            +                  "|     Ejemplo: Juan 1 4\n");

            for(int i = 0; i < n; i++){
                System.out.print("|   - Cadena de valores: ");
                String p[] = br.readLine().split(" ");
                
                Person person = new Person(p[0], Integer.parseInt(p[2]));
                person.setFloor(Integer.parseInt(p[1]));
                builders[s-1].addInElevator(person);;
            }

            s++;
        }
    }

    private void rulesApp(){
        Menu m = new Menu("| - Ahora ingresaremos un identificador para cada\n"
        +                 "|   edificio, seguido del numero de personas que se\n"
        +                 "|   encuentran en el edificio, el numero de pisos que\n"
        +                 "|   contiene el edificio y el numero de oficinas que\n"
        +                 "|   tendra cada piso...\n"
        +                 "| - Use este ejemplo como guia de como debe digitar\n"
        +                 "|   cada valor respectivo:\n"
        +                 "|   Ejemplo: A 5 3 2\n"
        +                 "|===================================================\n\n");
        m.showMenu();
    }
    
    

}
