package edu.nd.se2018.homework.hwk2;

public class Main {

    public static void main( String args[] ) {
        Horse[] horseArray = new Horse[4];  //Initializing 4 Horses
        for (int i=0; i<horseArray.length; i++) {
            horseArray[i] = new Horse(i+1,i+1); // horses with index names and max speeds
            horseArray[i].setStrategy("steadyRun");
        }
        System.err.println( "!!!!!!!!!The Race is Starting!!!!!!!!" );
        Horse.resetRace(); 
        Race horseRace = new Race(horseArray);
        horseRace.race();
        
        for (int i=0; i<horseArray.length; i++) { 
            horseArray[i].run();
        }
        
    }

}
