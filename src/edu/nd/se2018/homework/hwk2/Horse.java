package edu.nd.se2018.homework.hwk2;

public class Horse extends Thread implements Strategy {
    private static boolean raceOver = false; // boolean flag for when race is over
    private static final int raceLength = 5; // length of the race  
    private int distance; 					// distance covered
    private static String winner = ""; 		// string holding the winner horse
    private String name = ""; 			    // name of the horse 
    private String raceStrategy = ""; 		// the strategy taken by the horse
    private int maxSpeed;

 // constructor taking name and max-speed
    public Horse(int id, int speed) { 
        name = "Horse #" + id;
        maxSpeed = speed;
        distance = 0;
    }
    
    public static void resetRace() { 
        raceOver = false; 
    }
    
    public static boolean done() { 
        return raceOver; 
    }
    
    public static String getWinner() { 
        return winner; 
    }
    
    public int getDistance() { 
        return distance; 
    }
    
	@Override
	public void setStrategy(String strategy) { // 
		raceStrategy = strategy;
	}
	
    public void run() {
        while (!raceOver) {
            //try {
                //slowdown             		
                //Thread.sleep((int)(Math.random() * 500));
                if (++distance >= raceLength){
                    raceOver = true;
                }
//            } catch (InterruptedException e) {
//                System.err.println(e);
//            }
        }
        if (distance == raceLength) winner = name;
    }

}
