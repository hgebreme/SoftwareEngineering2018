package edu.nd.se2018.homework.hwk2;

public class Main {

    public static void main( String args[] ) {
        Horse[] horseArray = new Horse[4];  //Initializing 4 Horses
        for (int i=0; i<horseArray.length; i++) {
            horseArray[i] = new Horse(i+1,5); // horses with index names and max speed 5
        }
        System.err.println( "!!!!!!!!!The Race is Starting!!!!!!!!" );
        Horse.resetRace(); 
        for (int i=0; i<horseArray.length; i++) { 
            horseArray[i].start();
        }
        
        Race horseRace = new Race(horseArray);
        horseRace.run();
    }

}
